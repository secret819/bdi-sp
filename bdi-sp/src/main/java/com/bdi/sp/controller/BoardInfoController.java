package com.bdi.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.dao.BoardInfoDAO;
import com.bdi.sp.vo.BoardInfo;

@Controller
public class BoardInfoController {
	@Autowired
	private BoardInfoDAO bidao;
	
	@RequestMapping(value = "/boardInfo", method = RequestMethod.GET)
	public @ResponseBody List<BoardInfo> BoardInfoList(@ModelAttribute BoardInfo bi){
		return bidao.getBoardInfoList(bi);
	}
	
	@RequestMapping(value = "/boardInfo/{binum}", method = RequestMethod.GET)
	public @ResponseBody BoardInfo boardinfo(@PathVariable int binum) {
		return bidao.getBoardInfo(binum);
	}
	
	@RequestMapping(value = "/boardInfo", method = RequestMethod.PUT)
	public @ResponseBody String updateBoardInfo(@RequestBody BoardInfo bi) {
		return bidao.updateBoardInfo(bi) + "";
	}
	
	@RequestMapping(value = "/boardInfo", method = RequestMethod.POST)
	public @ResponseBody String insertBoardInfo(@RequestBody BoardInfo bi) {
		return bidao.insertBoardInfo(bi) + "";
	}
	
	@RequestMapping(value = "/boardInfo/{binum}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteBoardInfo(@PathVariable int binum) {
		return bidao.deleteBoardInfo(binum) + "";
	}
}
