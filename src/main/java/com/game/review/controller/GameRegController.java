package com.game.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.command.GameRegCommand;
import com.game.review.command.GameSpecCommand;
import com.game.review.service.GameRegService;
import com.game.review.validate.RegValiDate;

@Controller
public class GameRegController {

	@Autowired
	GameRegService gameRegService;

	@RequestMapping(value = "/gameReg", method = RequestMethod.GET)
	public String goGameRegForm(@ModelAttribute("regForm") GameRegCommand gameRegCommand, Model model) {
		model.addAttribute("genreList", gameRegService.selectGenre());
		
		return "gameRegForm";
	}

	@RequestMapping(value = "/gameReg", method = RequestMethod.POST)
	public String register(@ModelAttribute("regForm") GameRegCommand gameRegCommand, HttpServletRequest request,
			Model model, Errors errors) {
		model.addAttribute("genreList", gameRegService.selectGenre());
		
		new RegValiDate().validate(gameRegCommand, errors);
		if (errors.hasErrors()) {
			return "gameRegForm";
		}
		try {
			HttpSession session = request.getSession();
			session.setAttribute("gameregi", gameRegCommand);
			return "redirect:/specReg";
		} catch (Exception e) {
			return "gameRegForm";
		}

	}

	@RequestMapping(value = "/specReg", method = RequestMethod.GET)
	public String gospecForm(@ModelAttribute("regForm1") GameSpecCommand gameSpecCommand, Model model,
			HttpServletRequest request) {
		GameRegCommand dd = (GameRegCommand) request.getSession().getAttribute("gameregi");
		model.addAttribute("gName", dd.getgName());

		System.out.println("gameSpecCommand>>>>" + gameSpecCommand.toString());
		return "specRegForm";
	}

	@RequestMapping(value = "/specReg", method = RequestMethod.POST)
	public String register1(@ModelAttribute("regForm1") GameSpecCommand gameSpecCommand, HttpServletRequest request,Errors errors) {

		GameRegCommand dd = (GameRegCommand) request.getSession().getAttribute("gameregi");

		gameRegService.register(dd);
		gameRegService.specRegist(gameSpecCommand);
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/list";
	}

//	@RequestMapping(value = "/gameReg", method = RequestMethod.GET)
//	public String goGameRegForm(@ModelAttribute("regForm") GameRegCommand gameRegCommand,Model model) {
//		model.addAttribute("genreList", gameRegService.selectGenre());
//		return "gameRegForm";
//	}
//
//	@RequestMapping(value = "/gameReg", method = RequestMethod.POST)
//	public String register(@ModelAttribute("regForm") GameRegCommand gameRegCommand,RedirectAttributes redirect) {
//
//		gameRegService.register(gameRegCommand);
//		redirect.addAttribute("gName",gameRegCommand.getgName());
//		return "redirect:/specReg";
//	}
//
//	@RequestMapping(value = "/specReg", method = RequestMethod.GET)
//	public String gospecForm(@ModelAttribute("regForm1") GameSpecCommand gameSpecCommand,@RequestParam("gName") String gName, Model model) {
//		model.addAttribute("gName" , gName);
//		System.out.println("gameSpecCommand>>>>" + gameSpecCommand.toString());
//		return "specRegForm";
//	}
//
//	@RequestMapping(value = "/specReg", method = RequestMethod.POST)
//	public String register1(@ModelAttribute("regForm1") GameSpecCommand gameSpecCommand) {
//		System.out.println(gameSpecCommand.toString()+"ddffasdf");
//		gameRegService.specRegist(gameSpecCommand);
//		return "list";
//	}

}
