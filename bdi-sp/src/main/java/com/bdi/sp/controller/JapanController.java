package com.bdi.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JapanController {

	@RequestMapping(value="/japan",method=RequestMethod.GET)
	public ModelAndView japanList() {
		ModelAndView mav = new ModelAndView("japan/list");
		mav.addObject("hello","안녕하세요~");
		return mav;
	}
}
