package cn.shafish.cicada.service;

import cn.shafish.cicada.entity.CicadasubcommentDao;

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
public interface CicadasubcommentService extends IService<CicadasubcommentDao> {

	List showComment(Integer commentId);

}
