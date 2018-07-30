package com.cn.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.Entity.MessageEntity;
import com.cn.Entity.UserEntity;
import com.cn.ServiceImpl.MessageServiceImpl;
import com.cn.ServiceImpl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Resource(name = "messageServiceImpl")
	private MessageServiceImpl messageServiceImpl;
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/main.do", method = RequestMethod.POST)
	public String main(@RequestParam(value = "leaveMessage") String leaveMessage, HttpSession session,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException, IOException {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (leaveMessage != null && user != null) {
			messageServiceImpl.add(user.getAndName(),user.getUserName() ,leaveMessage, user.getId());
			return "redirect:/";
		} else {
			return "redirect:/page/login.jsp";
		}
	}

	@RequestMapping(value = "/checkMain.htm")
	public String checkMain(Model mv, MessageEntity messageEntity, HttpServletRequest Request,
			HttpServletResponse Response) throws ParseException {
		List<MessageEntity> list = new ArrayList<MessageEntity>();
		list = messageServiceImpl.select();
		String p = Request.getParameter("page");
		int page;
		try {
			// 当前页数
			page = Integer.valueOf(p);
		} catch (NumberFormatException e) {
			page = 1;
		}
		// 留言总数
		int totalMessage = list.size();
		// 每页留言数
		int MessagePerPage = 11;
		// 总页数
		int totalPages = totalMessage % MessagePerPage == 0 ? totalMessage / MessagePerPage
				: totalMessage / MessagePerPage + 1;
		// 本页起始留言序号
		int beginIndex = (page - 1) * MessagePerPage;
		// 本页末尾留言序号的下一个
		int endIndex = beginIndex + MessagePerPage - 1;
		if (endIndex > totalMessage)
			endIndex = totalMessage;
		mv.addAttribute("totalMessage", totalMessage);
		mv.addAttribute("MessagePerPage", MessagePerPage);
		mv.addAttribute("totalPages", totalPages);
		mv.addAttribute("beginIndex", beginIndex);
		mv.addAttribute("endIndex", endIndex);
		mv.addAttribute("page", page);
		mv.addAttribute("list", list);
		return "Main";
	}

	// 热门
	@RequestMapping(value = "/checkHot.htm")
	public String checkHot(Model mv, HttpSession session, HttpServletRequest Request, HttpServletResponse Response)
			throws ParseException {
		List<MessageEntity> list = new ArrayList<MessageEntity>();
		list = messageServiceImpl.checkHot();
		mv.addAttribute("list", list);
		return "hot";
	}
	//管理员查看所有表白语
	@RequestMapping(value = "/checkAdmin.htm")
	public void checkAdmin(ObjectMapper mapper,HttpServletRequest Request, HttpServletResponse Response)
			throws ParseException, IOException {
		List<MessageEntity> list = new ArrayList<MessageEntity>();
		list = messageServiceImpl.checkHot();
		String json = mapper.writeValueAsString(list);
		Response.getWriter().print(json);
		Response.getWriter().flush();
		Response.getWriter().close();
	}
	//管理员删除表白语
	@RequestMapping(value = "/deleteMessage.htm")
	public String deleteMessage(Model mv, HttpSession session,@RequestParam("id") int id, HttpServletRequest Request, HttpServletResponse Response)
			throws ParseException {
		messageServiceImpl.deleteMessage(id);
		return "speech";
	}
}
