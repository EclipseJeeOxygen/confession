package com.cn.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	@RequestMapping(value = "/{formName}")
	public String formName(@PathVariable String formName) {
		return formName;
	}
}
