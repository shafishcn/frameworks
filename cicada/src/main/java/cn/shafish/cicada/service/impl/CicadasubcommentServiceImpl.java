package cn.shafish.cicada.service.impl;

import cn.shafish.cicada.entity.CicadacommentDao;
import cn.shafish.cicada.entity.CicadasubcommentDao;
import cn.shafish.cicada.mapper.CicadasubcommentMapper;
import cn.shafish.cicada.service.CicadasubcommentService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shafish
 * @since 2019-04-26
 */
@Service
public class CicadasubcommentServiceImpl extends ServiceImpl<CicadasubcommentMapper, CicadasubcommentDao> implements CicadasubcommentService {

	@Autowired
	CicadasubcommentMapper ccdSubCommentMapper;
	@Override
	public List showComment(Integer commentId) {
		QueryWrapper<CicadasubcommentDao> queryWrapper = new QueryWrapper<>();
		queryWrapper
			.eq("commentid", commentId);
		List result = ccdSubCommentMapper.selectList(queryWrapper);
		return result;
	}

}
