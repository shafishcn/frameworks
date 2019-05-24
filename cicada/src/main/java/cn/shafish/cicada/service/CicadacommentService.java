package cn.shafish.cicada.service;

import cn.shafish.cicada.entity.CicadacommentDao;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shafish
 * @since 2019-04-26
 */
public interface CicadacommentService extends IService<CicadacommentDao> {

	List showComment(Integer contentId);

	Boolean addComment(CicadacommentDao ccdCommentDao);

}
