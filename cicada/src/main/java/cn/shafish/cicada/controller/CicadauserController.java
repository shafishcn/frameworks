package cn.shafish.cicada.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.shafish.cicada.entity.CicadauserDao;
import cn.shafish.cicada.service.CicadauserService;
import cn.shafish.cicada.sms.AliSMS;
import cn.shafish.cicada.util.JsonResult;
import cn.shafish.cicada.util.StatusCode;
import lombok.NonNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shafish
 * @since 2019-03-25
 */
@RestController
@RequestMapping("/user")
public class CicadauserController {
	@Autowired
	private CicadauserService ccdUserService;
	JsonResult result;
	String code = "";//记录验证码
	String message = "";
	
	@RequestMapping("add")
	public int addUser() {
		int result = 0;
		CicadauserDao user = new CicadauserDao();
		//ccduserDao.setCcdPasswd("123");
		//ccduserDao.setCcdName("力士xx");
		//result = ccduserService.addUser(ccduserDao);
		return result;
	}
	
	@RequestMapping("getUserById")
	public JsonResult<Object> getUserById(@RequestParam("id") @NonNull Integer userId) { 
		CicadauserDao user = ccdUserService.getUserById(userId);
		if(user != null) {
			result = new JsonResult<>(user,"成功");
		} else {
			result = new JsonResult<>("用户不存在",StatusCode.CODE_ERROR_PARAMETER);
		}
		return result;
	}
	
	@RequestMapping("sendCode")
	public JsonResult<Object> userLogin(@RequestParam("phone") @NonNull String phone,@RequestParam("vcode") @NonNull String vcode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", phone);
		System.out.println(phone+" xx "+vcode);
		if (vcode.equals("abc")) {//发送验证码
			message = AliSMS.getSMS(phone); 
			code = message.split(",")[1];
		} else { //点击登录
			//比较验证码是否正确
			if(code.equals(vcode)) {
				//查询该用户信息
				CicadauserDao user = ccdUserService.getUser(params);
				//params.clear();
				if(user != null) {//如果用户存在-登录（返回用户登录信息/uid、type）
					result = new JsonResult<>(user,StatusCode.CODE_SUCCESS);
				}else {//如果用户不存在-注册（插入手机号并返回登录信息/uid、type）
					CicadauserDao userInser = new CicadauserDao();
					userInser.setIdentifier(phone);
					userInser.setIdentitytype("手机号");
					ccdUserService.insertUser(userInser);
					result = new JsonResult<>(userInser,StatusCode.CODE_SUCCESS);
				}
				
			} else {
				result = new JsonResult<>("验证码错误",StatusCode.CODE_ERROR_PARAMETER,"error");
			}
		}
		return result;
	}
	
	@RequestMapping("update")
	public JsonResult<Object> sendCode(@RequestParam("result") String results,@RequestParam("userId") Integer id) {
		//results = results.substring(0,results.length() - 1);
		String[] resultArray = results.split(",");
		CicadauserDao user = new CicadauserDao();
		String name = resultArray[0];
		String email = resultArray[1];
		String gender = resultArray[2];
		user.setId(id);
		user.setCcdname(name);
		user.setEmail(email);
		user.setGender(gender);
		int update = ccdUserService.updateUser(user);
		result = new JsonResult<Integer>(update, StatusCode.CODE_SUCCESS);
		return result;
	}
}
