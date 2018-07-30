package com.cn.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.Entity.CommentEntity;
import com.cn.Entity.UserEntity;
import com.cn.ServiceImpl.CommentServiceImpl;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
@RequestMapping("/comment")
public class commentController {
	
	@Autowired
	@Qualifier("commentServiceImpl")
	private CommentServiceImpl commentServiceImpl;

	// @Qualifier("messageServiceImpl")
	// private MessageServiceImpl messageServiceImpl;
	// 增加评论
	@RequestMapping(value = "/addConmment.do", method = RequestMethod.POST)
	public String addComment(@RequestParam(value = "comment") String comment,
			@RequestParam(value = "messageId") Integer messageId, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws ParseException, ServletException, IOException {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null && comment != null) {
			commentServiceImpl.addComment(comment, user.getAndName(),user.getUserName(), messageId);
			// messageServiceImpl.updateCommentNum(messageId);
			return "redirect:/";
		} else {
			return "redirect:/page/login.jsp";
		}
	}

	// 用户查看评论
	@RequestMapping(value = "/selectComment.htm")
	public String selectComment(Model mv, @RequestParam(value = "messageId") Integer messageId)
			throws ParseException, ServletException, IOException {
		List<CommentEntity> list = new ArrayList<CommentEntity>();
		list = commentServiceImpl.selectComment(messageId);
		mv.addAttribute("list", list);
		return "comment";
	}

}
