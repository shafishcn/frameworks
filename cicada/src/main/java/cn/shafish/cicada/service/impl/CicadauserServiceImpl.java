package cn.shafish.cicada.service.impl;

import cn.shafish.cicada.entity.CcduserDao;
import cn.shafish.cicada.entity.CicadauserDao;
import cn.shafish.cicada.mapper.CcduserMapper;
import cn.shafish.cicada.mapper.CicadauserMapper;
import cn.shafish.cicada.service.CicadauserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shafish
 * @since 2019-03-25
 */
@Service
public class CicadauserServiceImpl extends ServiceImpl<CicadauserMapper, CicadauserDao> implements CicadauserService {

	@Autowired
	CicadauserMapper ccduserMapper;
	@Override
	public int addUser(CicadauserDao ccdUserDao) {
		int result = 0;
		result = ccduserMapper.insert(ccdUserDao);
		return result;
	}

	@Override
	public CicadauserDao getUser(Map<String, Object> params) {
		return ccduserMapper.selectByparams(params);
	}

	@Override
	public CicadauserDao getUserById(Integer id) {
		return ccduserMapper.selectById(id);
	}

	@Override
	public Integer insertUser(CicadauserDao user) {
		int reslut = ccduserMapper.insert(user);
		return reslut;
	}

	@Override
	public Integer updateUser(CicadauserDao user) {
		int reslut = ccduserMapper.updateById(user);
		return reslut;
	}

}
