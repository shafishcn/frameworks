package cn.shafish.cicada.service.impl;

import cn.shafish.cicada.entity.CicadacommentDao;
import cn.shafish.cicada.mapper.CicadacommentMapper;
import cn.shafish.cicada.service.CicadacommentService;

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
public class CicadacommentServiceImpl extends ServiceImpl<CicadacommentMapper, CicadacommentDao> implements CicadacommentService {

	@Autowired
	CicadacommentMapper ccdCommentMapper;
	
	@Override
	public List showComment(Integer contentId) {
		QueryWrapper<CicadacommentDao> queryWrapper = new QueryWrapper<>();
		queryWrapper
			.eq("contentId", contentId);
		List result = ccdCommentMapper.selectList(queryWrapper);
		
		return result;
	}

	@Override
	public Boolean addComment(CicadacommentDao ccdCommentDao) {
		boolean status = ccdCommentDao.insert();
		return status;
	}

}
