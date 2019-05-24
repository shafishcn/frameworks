package cn.shafish.cicada.service.impl;

import cn.shafish.cicada.entity.CicadasavedDao;
import cn.shafish.cicada.mapper.CicadasavedMapper;
import cn.shafish.cicada.service.CicadasavedService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
 * @since 2019-04-14
 */
@Service
public class CicadasavedServiceImpl extends ServiceImpl<CicadasavedMapper, CicadasavedDao> implements CicadasavedService {

	@Autowired
	CicadasavedMapper saveMapper;

	@Override
	public CicadasavedDao isSaved(Integer contentId, Integer userId) {
		CicadasavedDao savedDao = saveMapper.isSaved(contentId, userId);
		return savedDao;
	}

	@Override
	public Boolean saved(String contentId, String userId, String status) {
		boolean savedStatus = false;
		if(status.equals("0")) {//保存收藏
			CicadasavedDao saved = new CicadasavedDao();
			saved.setContentId(Integer.parseInt(contentId));
			saved.setUserId(Integer.parseInt(userId));
			savedStatus = saved.insert();
		}else if(status.equals("1")) {//取消收藏
			QueryWrapper<CicadasavedDao> queryWrapper = new QueryWrapper<>();
			queryWrapper
				.eq("contentId", Integer.parseInt(contentId))
				.eq("userId", Integer.parseInt(userId));
			int sstatus = saveMapper.delete(queryWrapper);
			if(sstatus > 0) {
				savedStatus = true;
			}
		}
		return savedStatus;
	}

	@Override
	public List getContentId(Integer userId) {
		List list = saveMapper.getContentId(userId);
		return list;
	}
	
}
