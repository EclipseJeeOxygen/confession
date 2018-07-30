package com.cn.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class WeChatController {
	//微信练习
		@ResponseBody
		@RequestMapping(value="/vc.do")
		public Object vc(HttpServletRequest request,HttpServletResponse response) {
		
			
			return null;
			
			}
}
