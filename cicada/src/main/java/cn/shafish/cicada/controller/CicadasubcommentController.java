package cn.shafish.cicada.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.shafish.cicada.service.CicadasubcommentService;
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
@RequestMapping("/subComment")
public class CicadasubcommentController {
	
	@Autowired
	CicadasubcommentService ccdSubCommentService;
	JsonResult result;
	
	@RequestMapping("showComment")
	public JsonResult<List> showComment(@RequestParam("commentId") Integer commentId) {
		List comments = ccdSubCommentService.showComment(commentId);
		result = new JsonResult<>(comments,"成功");
		return result;
	}
	
	public List showSubComment(Integer commentId) {
		List comments = ccdSubCommentService.showComment(commentId);
		//result = new JsonResult<>(comments,"成功");
		return comments;
	}

}
