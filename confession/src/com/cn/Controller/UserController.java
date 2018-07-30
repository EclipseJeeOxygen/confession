package com.cn.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.Entity.UserEntity;
import com.cn.Service.UserService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;

	// 增加用户
	@RequestMapping(value = "/addUser.do", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException, IOException {

		System.out.println("来到了");
		request.setCharacterEncoding("utf-8");
//		userServiceImpl.adduser("D:\\userinfo.xlsx");
		userServiceImpl.adduser(System.getProperties().getProperty("user.home")+File.separator+" .xlsx");
		
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('导入成功')");
		out.println("</script>");
		return null;
	}

	// 修改昵称
	@RequestMapping(value = "/updateName.htm", method = RequestMethod.POST)
	public String updateName(HttpSession session, @RequestParam("andName") String andName, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, ServletException, IOException {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null && andName != null) {
			userServiceImpl.updateName(user.getId(), andName);
			return null;
		} else {
			return "redirect:/page/login.jsp";
		}
	}

	// 修改密码
	@RequestMapping(value = "/updatePassword.htm", method = RequestMethod.POST)
	public String updatePassword(HttpSession session, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException, IOException {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null && password != null) {
			userServiceImpl.updatePassword(user.getId(), password);
			return null;
		} else {
			return "redirect:/page/login.jsp";
		}
	}
}
