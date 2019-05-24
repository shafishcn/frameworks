package cn.shafish.cicada.service;

import cn.shafish.cicada.entity.CicadasavedDao;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shafish
 * @since 2019-04-14
 */
public interface CicadasavedService extends IService<CicadasavedDao> {
	CicadasavedDao isSaved(Integer contentId,Integer userId);

	Boolean saved(String contentId, String userId,String status);

	List getContentId(Integer userId);
}
