package com.cn.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cn.Entity.UserEntity;
import com.cn.ServiceImpl.UserServiceImpl;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/checkLogin.do", method = RequestMethod.POST)
	public ModelAndView checkLogin(String userName, String password, HttpSession session, ModelAndView mv)
			throws ParseException, ServletException, IOException {
		UserEntity user = userServiceImpl.selectName(userName);
		if ((user != null) && (user.getGustId() == 1) && (user.getPassword().equals(password))) {
			session.setAttribute("user", user);
			mv.setViewName("admin");
		} else if (user != null && user.getGustId() == 2 && user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			mv.setViewName("redirect:/message/checkMain.htm");// 重定向
		} else {
			mv.addObject("message", "用户名或密码错误，请重新输入!");
			mv.setViewName("login");
		}
		return mv;
	}

	// 销毁session
	@RequestMapping(value = "/exit.do")
	public String exit(HttpSession session, HttpServletRequest request, HttpServletRequest response) {
		session = request.getSession(false);
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			return "redirect:/page/login.jsp";
		}
		if (session != null && user.getGustId() == 1) {
			session.invalidate();
			return "redirect:/page/admin.jsp";
		}
		if (session != null && user.getGustId() == 2) {
			session.invalidate();
			return "redirect:/message/checkMain.htm";
		}
		return null;
	}

	// 判断是否登录进入个人中心
	@RequestMapping(value = "/go.do")
	public String go(HttpSession session) {

		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			return "redirect:/page/login.jsp";
		} else
			return "redirect:/page/personalCenter.jsp";
	}
}
