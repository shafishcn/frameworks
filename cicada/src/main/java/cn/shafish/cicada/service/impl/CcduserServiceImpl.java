package cn.shafish.cicada.service.impl;

import cn.shafish.cicada.entity.CcduserDao;
import cn.shafish.cicada.mapper.CcduserMapper;
import cn.shafish.cicada.service.CcduserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shafish
 * @since 2019-03-06
 */
@Service
public class CcduserServiceImpl extends ServiceImpl<CcduserMapper, CcduserDao> implements CcduserService {

	@Autowired
	CcduserMapper ccduserMapper;

	public int addUser(CcduserDao uCcduserDao) {
		int result = 0;
		result = ccduserMapper.insert(uCcduserDao);
		return result;
	}

	@Override
	public CcduserDao getUser() {
		return ccduserMapper.selectById(3);
	}
	
}
