package cn.shafish.cicada.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import cn.shafish.cicada.entity.CicadacommentDao;
import cn.shafish.cicada.service.CicadacommentService;
import cn.shafish.cicada.util.JsonResult;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shafish
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/comment")
public class CicadacommentController {
	
	@Autowired
	private CicadacommentService ccdCommentService;
	@Autowired
	CicadasubcommentController ccdSubCommentController;
	JsonResult result;
	
	@RequestMapping("showComment")
	public JsonResult<Boolean> showComment(@RequestParam("contentId") Integer contentId) {
		List commentResult = new ArrayList<CicadacommentDao>();
		List comments = ccdCommentService.showComment(contentId);
		//组装子评论,循环list获取每个commentId
		for(int i=0;i<comments.size();i++) {
			CicadacommentDao commentDao = (CicadacommentDao) comments.get(i);
			int commentId = commentDao.getId();
			List subResult = ccdSubCommentController.showSubComment(commentId);
			JSONArray jsonArray = new JSONArray(subResult);
			commentDao.setSubcomment(jsonArray.toString());
			commentResult.add(i, commentDao);
		}
		result = new JsonResult<>(commentResult,"成功");
		return result;
	}

	@RequestMapping("addComment")
	public JsonResult<Boolean> addComment(HttpServletRequest request, HttpServletResponse response) {
		String contentId =request.getParameter("contentId");
		String comment =request.getParameter("comment");
		String userId =request.getParameter("userId");
		CicadacommentDao ccdCommentDao = new CicadacommentDao();
		ccdCommentDao.setContentId(Integer.parseInt(contentId));
		ccdCommentDao.setComment(comment);
		Boolean status = ccdCommentService.addComment(ccdCommentDao);
		result = new JsonResult<>(status,"成功");
		return result;
	}
}
