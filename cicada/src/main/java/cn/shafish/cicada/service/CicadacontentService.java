package cn.shafish.cicada.service;

import cn.shafish.cicada.entity.CicadacontentDao;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shafish
 * @since 2019-03-09
 */
public interface CicadacontentService extends IService<CicadacontentDao> {
	public IPage<CicadacontentDao> getContentByPage(Page<CicadacontentDao> page);//, Integer state
	public List<CicadacontentDao> getContentByUser(int userId);
	public List<CicadacontentDao> getAllContent();
	public Boolean addContent(CicadacontentDao cicadacontentDao);
	public Boolean addView(Integer contentId,Integer view);
	public Boolean updateStar(Integer contentId,Integer star,String status);
	public List getSavedContent(List<Integer> ids);
}
