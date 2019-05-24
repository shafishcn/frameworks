package cn.shafish.cicada.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.shafish.cicada.entity.CcduserDao;
import cn.shafish.cicada.service.CcduserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shafish
 * @since 2019-03-06
 */
@RestController
@RequestMapping("/xuser")
public class CcduserController{
	
	@Autowired
	private CcduserService ccduserService;
	
	@RequestMapping("add")
	public int addUser() {
		int result = 0;
		CcduserDao ccduserDao = new CcduserDao();
		ccduserDao.setCcdPasswd("123");
		ccduserDao.setCcdName("力士xx");
		result = ccduserService.addUser(ccduserDao);
		return result;
	}
	
	@RequestMapping("get")
	public CcduserDao getUser() { 
		return ccduserService.getUser();
	}
	
}
