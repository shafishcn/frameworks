package cn.shafish.cicada.service.impl;

import cn.shafish.cicada.entity.CicadacontentDao;
import cn.shafish.cicada.mapper.CicadacontentMapper;
import cn.shafish.cicada.service.CicadacontentService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shafish
 * @since 2019-03-09
 */
@Service
public class CicadacontentServiceImpl extends ServiceImpl<CicadacontentMapper, CicadacontentDao> implements CicadacontentService {

	@Autowired
	CicadacontentMapper ccdContentMapper;
	
	@Override
	public IPage<CicadacontentDao> getContentByPage(Page<CicadacontentDao> page) {//, Integer state
		return ccdContentMapper.selectContentByPage(page);//, state
	}

	@Override
	public List<CicadacontentDao> getContentByUser(int userId) {
		List<CicadacontentDao> list = ccdContentMapper.selectByUserId(userId);
		return list;
	}

	@Override
	public List<CicadacontentDao> getAllContent() {
		List<CicadacontentDao> list = ccdContentMapper.selectAll();
		return list;
	}

	@Override
	public Boolean addContent(CicadacontentDao content) {
		content.setCreatetime(LocalDateTime.now());
		boolean result = content.insert();
		return result;
	}

	@Override
	public Boolean addView(Integer contentId,Integer view) {
		CicadacontentDao content = new CicadacontentDao();
		content.setId(contentId);
		content.setReadtimes(view+1);
		boolean result = content.updateById();
		return result;
	}

	@Override
	public Boolean updateStar(Integer contentId,Integer star,String status) {
		CicadacontentDao content = new CicadacontentDao();
		if(status.equals("0")) {//保存收藏
			if (star <= 0) {
				star = 1;
			}
			content.setStart(star);
		}else if(status.equals("1")) {//取消收藏
			if (star <= 1) {
				star = 2;
			}
			content.setStart(star-1);
		}
		content.setId(contentId);
		boolean starStatus = content.updateById();
		return starStatus;
	}

	@Override
	public List getSavedContent(List<Integer> ids) {
		List list = ccdContentMapper.getSavedContent(ids);
		return list;
	}

}
