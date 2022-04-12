package com.game.review.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.service.ListService;

@Controller
public class ListController {
	@Autowired
	private ListService listService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(Model model) {
		List<Map<String, Object>> list = listService.selectList();

		model.addAttribute("gameList", list);

		return "gameList";
	}
}
