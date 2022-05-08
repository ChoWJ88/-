package com.game.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;
import com.game.review.service.GameDetailService;

@Controller
public class GameDetailController {

	@Autowired
	GameDetailService gameDetailService;

	@RequestMapping(value = "/read/{gNum}", method = RequestMethod.GET)
	public String read(@PathVariable("gNum") Long gNum, Model model) {

		GamesDTO gameList = (GamesDTO) gameDetailService.detailGameList(gNum);
		List<MyGenreDTO> genrelist = gameDetailService.detailGenreList(gNum);
		List<GameFilesDTO> gameFileslist = gameDetailService.detailGameFilesList(gNum);
		SpecDTO gameSpecList = (SpecDTO) gameDetailService.detailSpecList(gNum);

		model.addAttribute("genreList", genrelist);
		model.addAttribute("gameFilesList", gameFileslist);
		model.addAttribute("gameList", gameList);
		model.addAttribute("gameSpecList", gameSpecList);

	

		return "gameDetail";

	}


}
