package cn.shafish.cicada.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.shafish.cicada.entity.CicadacontentDao;
import cn.shafish.cicada.service.CicadacontentService;
import cn.shafish.cicada.util.JsonResult;
import cn.shafish.cicada.util.StatusCode;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shafish
 * @since 2019-03-09
 */
@RestController
@RequestMapping("/content")
public class CicadacontentController {
	@Autowired
	private CicadacontentService ccdContentService;
	JsonResult result;
	
	@RequestMapping("page")
	public List<CicadacontentDao> getContentByPage(@RequestParam("pageIndex") Integer currentPage,
												   @RequestParam("pageSize") Integer pageSize){
		Page<CicadacontentDao> page = new Page<CicadacontentDao>(currentPage,pageSize);
		List<CicadacontentDao>  list = ccdContentService.getContentByPage(page).getRecords();
		return list;
	}
	
	@RequestMapping("user")
	public List<CicadacontentDao> getContentByUser(@RequestParam("userId") Integer userId){
		List<CicadacontentDao> list;
		list = ccdContentService.getContentByUser(userId);
		return list;
	}
	
	@RequestMapping("all")
	public JsonResult<Map<String, Object>> getAllContent(){
		List<CicadacontentDao> list;
		list = ccdContentService.getAllContent();
		Map<String, Object> map = new HashMap<>();
		map.put("news", list);
		//map.put("total", list.size());
		if(list.size() != 0) {
			result = new JsonResult<>(map,"成功");
		}else {
			result = new JsonResult<>("失败",StatusCode.CODE_ERROR);
		}
		return result;
	}
	
	@RequestMapping("public")
	public JsonResult<Boolean> addContent(HttpServletRequest request, HttpServletResponse response) {
		String content =request.getParameter("content");
		String title =request.getParameter("title");
		String userId =request.getParameter("userId");
		System.out.println(content+ " xxxx "+ userId+" xxxxxx "+title);
		CicadacontentDao contentDao = new CicadacontentDao();
		contentDao.setContents(content);
		contentDao.setUserid(Integer.parseInt(userId));
		contentDao.setTitle(title);
		boolean isPublic = ccdContentService.addContent(contentDao);
		result = new JsonResult<>(isPublic,"成功");
		return result;
	}
	
	@RequestMapping("view")
	public JsonResult<Boolean> addV(@RequestParam("contentId") Integer contentId,@RequestParam("view") Integer view) {
		boolean addView = ccdContentService.addView(contentId,view);
		result = new JsonResult<>(addView,"成功");
		return result;
	}
	
	public Boolean updateStar(Integer contentId,Integer star,String status) {
		boolean starStatus = ccdContentService.updateStar(contentId,star,status);
		return starStatus;
	}

	public List getSavedContent(List<Integer> ids) {
		List list = new ArrayList();
		list = ccdContentService.getSavedContent(ids);
		return list;
	}
}	

