package com.game.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.game.review.command.GameRegCommand;
import com.game.review.command.GameSpecCommand;
import com.game.review.dao.GameDAO;
import com.game.review.service.GameRegService;

@Controller
public class GameRegController {

	@Autowired
	GameRegService gameRegService;

	@RequestMapping(value = "/gameReg", method = RequestMethod.GET)
	public String goGameRegForm(@ModelAttribute("regForm") GameRegCommand gameRegCommand,Model model) {
		model.addAttribute("genreList", gameRegService.selectGenre());
		return "gameRegForm";
	}

	@RequestMapping(value = "/gameReg", method = RequestMethod.POST)
	public String register(@ModelAttribute("regForm") GameRegCommand gameRegCommand,RedirectAttributes redirect) {

		gameRegService.register(gameRegCommand);
		redirect.addAttribute("gName",gameRegCommand.getgName());
		return "redirect:/specReg";
	}

	@RequestMapping(value = "/specReg", method = RequestMethod.GET)
	public String gospecForm(@ModelAttribute("regForm1") GameSpecCommand gameSpecCommand,@RequestParam("gName") String gName, Model model) {
		model.addAttribute("gName" , gName);
		System.out.println("gameSpecCommand>>>>" + gameSpecCommand.toString());
		return "specRegForm";
	}

	@RequestMapping(value = "/specReg", method = RequestMethod.POST)
	public String register1(@ModelAttribute("regForm1") GameSpecCommand gameSpecCommand) {
		System.out.println(gameSpecCommand.toString()+"ddffasdf");
		gameRegService.specRegist(gameSpecCommand);
		return "list";
	}

}
