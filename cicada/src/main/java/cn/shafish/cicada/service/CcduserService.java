package cn.shafish.cicada.service;

import cn.shafish.cicada.entity.CcduserDao;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shafish
 * @since 2019-03-06
 */
public interface CcduserService extends IService<CcduserDao> {
	public int addUser(CcduserDao uCcduserDao);
	public CcduserDao getUser();
}
