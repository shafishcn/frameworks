package cn.shafish.cicada.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.shafish.cicada.entity.CicadasavedDao;
import cn.shafish.cicada.service.CicadasavedService;
import cn.shafish.cicada.util.JsonResult;
import cn.shafish.cicada.util.StatusCode;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shafish
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/save")
public class CicadasavedController {
	@Autowired
	CicadasavedService ccdSavedService;
	@Autowired
	CicadacontentController contentController;
	JsonResult result;
	
	@RequestMapping("isSaved")
	public JsonResult<Object> isSaved(@RequestParam("userId") Integer userId,@RequestParam("contentId") Integer contentId) {
		CicadasavedDao saved = new CicadasavedDao();
		boolean isSave = false;
		saved = ccdSavedService.isSaved(contentId,userId);
		if(saved != null) {
			isSave = true;
		}
		result = new JsonResult<>(isSave,StatusCode.CODE_SUCCESS); 
		return result;
	}
	
	@RequestMapping("saved")
	public JsonResult<Object> saved(HttpServletRequest request, HttpServletResponse response) {
		String contentId = request.getParameter("contentId");
		String userId = request.getParameter("userId");
		String star = request.getParameter("star");//设置当前内容的收藏数量
		String status = request.getParameter("status");//确认收藏/取消收藏
		//设置用户收藏当前内容
		boolean saveStatus = ccdSavedService.saved(contentId,userId,status);
		//设置当前内容收藏数量（+1）
		boolean starStatus = contentController.updateStar(Integer.parseInt(contentId), Integer.parseInt(star),status);
		if(saveStatus && starStatus) {
			result = new JsonResult<>(true,StatusCode.CODE_SUCCESS);
		}else {
			result = new JsonResult<>(false,StatusCode.CODE_ERROR); 
		}
		return result;
	}
	
	@RequestMapping("userSaved")
	public JsonResult<Object> userSaved(@RequestParam("userId") Integer userId) {
		//根据用户id获取收藏表中的所有内容
		//获取内容id
		List<Integer> ids = new ArrayList<Integer>();
		List<CicadasavedDao> savedContent = new ArrayList<CicadasavedDao>();
		ids = ccdSavedService.getContentId(userId);
		//查询并返回内容
		savedContent = contentController.getSavedContent(ids);
		
		result = new JsonResult<>(savedContent,StatusCode.CODE_ERROR); 
		
		return result;
	}
	
}
