package com.game.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.service.ListService;

@Controller
public class ListController {
	@Autowired
	private ListService listService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(Model model) {
		List<MyGenreDTO> genrelist = listService.selectGenreList();
		List<GameFilesDTO> gameFileslist = listService.selectGameFilesList();
		List<GamesDTO> gameList = listService.selectGameList();
		

		
		model.addAttribute("genreList", genrelist);
		model.addAttribute("gameFilesList", gameFileslist);
		model.addAttribute("gameList", gameList);

		return "gameList";
	}
}
