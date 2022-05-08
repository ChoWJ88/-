package com.game.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.command.GameFileModifyCommand;
import com.game.review.command.GameModifyCommand;
import com.game.review.command.GenreModifyCommand;
import com.game.review.command.SpecModifyCommand;
import com.game.review.error.NoCheckGenreException;
import com.game.review.service.GameModifyService;

@Controller
public class GameModifyController {
	@Autowired
	GameModifyService gameModifyService;

//게임 정보수정
	@RequestMapping(value = "/read/gameModify/{gNum}", method = RequestMethod.GET)
	public String goGameModify(@ModelAttribute("modifyGame") GameModifyCommand gameModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		return "gameModify";
	}

	@RequestMapping(value = "/read/gameModify/{gNum}", method = RequestMethod.POST)
	public String gameModify(@ModelAttribute("modifyGame") GameModifyCommand gameModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		gameModifyService.updateGame(gameModifyCommand);
		return "redirect:/read/{gNum}";

	}

//게임 사양 수정
	@RequestMapping(value = "/read/specModify/{gNum}", method = RequestMethod.GET)
	public String goSpecModify(@ModelAttribute("modifySpec") SpecModifyCommand specModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));
		model.addAttribute("gameSpecList", gameModifyService.modifySpecList(gNum));

		return "specModify";
	}

	@RequestMapping(value = "/read/specModify/{gNum}", method = RequestMethod.POST)
	public String specModify(@ModelAttribute("modifySpec") SpecModifyCommand specModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		gameModifyService.updateSpec(specModifyCommand);
		return "redirect:/read/{gNum}";

	}

//게임 장르 수정
	@RequestMapping(value = "/read/genreModify/{gNum}", method = RequestMethod.GET)
	public String goGenreModify(@ModelAttribute("modifyGenre") GenreModifyCommand genreModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {
		model.addAttribute("genreListAll", gameModifyService.selectGenreAll());
		model.addAttribute("genreList", gameModifyService.modifyGenreList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		return "genreModify";
	}

	@RequestMapping(value = "/read/genreModify/{gNum}", method = RequestMethod.POST)
	public String genreModify(@ModelAttribute("modifyGenre") GenreModifyCommand genreModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		try {
			gameModifyService.deleteGenre(genreModifyCommand);
			gameModifyService.updateGenre(genreModifyCommand);
		} catch (Exception e) {

			return "exceptions/noCheckGenre";
		}

		return "redirect:/read/{gNum}";

	}

	@RequestMapping(value = "/read/gameFileModify/{gNum}", method = RequestMethod.GET)
	public String goGameFileModify(@ModelAttribute("modifyGenre") GameFileModifyCommand gameFileModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameFilesList", gameModifyService.modifyGameFilesList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		return "gameFileModify";
	}

	@ExceptionHandler(NoCheckGenreException.class)
	public String noChexckGenre() {
		return "exceptions/noCheckGenre";
	}

}
