package com.game.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.command.GameFileModifyCommand;
import com.game.review.error.NoFileException;
import com.game.review.service.GameModifyService;

@Controller
public class GameFileModifyController {
	@Autowired
	GameModifyService gameModifyService;

	@RequestMapping(value = "/read/gameFileModify/{gNum}", method = RequestMethod.GET)
	public String goGameFileModify(@ModelAttribute("modifyGameFile") GameFileModifyCommand gameFileModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameFilesList", gameModifyService.modifyGameFilesList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		return "gameFileModify";
	}

	@RequestMapping(value = "/read/mainFileUpdate/{gNum}", method = RequestMethod.POST)
	public String mainFileUpdate(@ModelAttribute("modifyGameFile") GameFileModifyCommand gameFileModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameFilesList", gameModifyService.modifyGameFilesList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		System.out.println("아오좀 " + gameFileModifyCommand.getImgFile());

		try {
			gameModifyService.updateMainFile(gameFileModifyCommand);
		} catch (NoFileException e) {
			return "exceptions/noCheckAddFile";
		}

		return "redirect:/read/gameFileModify/" + gNum;
	}

	@RequestMapping(value = "/read/mainFileDelete/{gNum}", method = RequestMethod.POST)
	public String mainFileDelete(@ModelAttribute("modifyGameFile") GameFileModifyCommand gameFileModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {
		System.out.println("들어와");

		model.addAttribute("gameFilesList", gameModifyService.modifyGameFilesList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		gameModifyService.deleteMainFile(gameFileModifyCommand);

		return "redirect:/read/gameFileModify/" + gNum;
	}

	@RequestMapping(value = "/read/slideFileUpdate/{gNum}", method = RequestMethod.POST)
	public String slideFileUpdate(@ModelAttribute("modifyGameFile") GameFileModifyCommand gameFileModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameFilesList", gameModifyService.modifyGameFilesList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));

		try {
			gameModifyService.updateSlideFile(gameFileModifyCommand);
		} catch (NoFileException e) {
			return "exceptions/noCheckAddFile";
		}

		return "redirect:/read/gameFileModify/" + gNum;
	}

	@RequestMapping(value = "/read/slideFileDelete/{gNum}", method = RequestMethod.POST)
	public String slideFileDelete(@ModelAttribute("modifyGameFile") GameFileModifyCommand gameFileModifyCommand,
			@PathVariable("gNum") Long gNum, Model model) {

		model.addAttribute("gameFilesList", gameModifyService.modifyGameFilesList(gNum));
		model.addAttribute("gameList", gameModifyService.modifyGameList(gNum));
		System.out.println("파일번호" + gameFileModifyCommand.getGfCode());
		try {
			gameModifyService.deleteSlideFile(gameFileModifyCommand);
		} catch (Exception e) {
			return "exceptions/NoCheckFile";
		}

		return "redirect:/read/gameFileModify/" + gNum;
	}

}
