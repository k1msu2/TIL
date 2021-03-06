package com.semicolon.h2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AptDaoImpl;
import vo.AptVo;
import vo.CafeVo;

@Controller
public class AptController {
	
	@Autowired
	AptDaoImpl dao;
	
	@RequestMapping("/apt")
	public ModelAndView apt(AptVo vo) {
		ModelAndView mav = new ModelAndView();
		List<AptVo> list = new ArrayList<>();
		list = dao.listAll();
		mav.addObject("aptListAll", list);
		mav.setViewName("map");
		System.out.println(list);
		return mav;
	}
	
	@RequestMapping("/apt/{gu}")
	public ModelAndView cafe(AptVo vo, @PathVariable String gu) {
		System.out.println(gu);
		ModelAndView mav = new ModelAndView();
		List<AptVo> list = new ArrayList<>();
		list = dao.listGu(gu);
		mav.addObject("aptListAll", list);
		mav.setViewName("map");
		System.out.println(list);
		return mav;
	}
}
