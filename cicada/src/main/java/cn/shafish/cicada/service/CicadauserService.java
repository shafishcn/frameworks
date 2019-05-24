package cn.shafish.cicada.service;

import cn.shafish.cicada.entity.CcduserDao;
import cn.shafish.cicada.entity.CicadauserDao;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shafish
 * @since 2019-03-25
 */
public interface CicadauserService extends IService<CicadauserDao> {
	public int addUser(CicadauserDao cserDao);
	public CicadauserDao getUser(Map<String, Object> params);
	public CicadauserDao getUserById(Integer id);
	public Integer insertUser(CicadauserDao cserDao);
	public Integer updateUser(CicadauserDao cserDao);
}
