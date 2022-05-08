package com.game.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.command.AddGenreCommnad;
import com.game.review.error.NoCheckGenreException;
import com.game.review.service.AddGenreService;
import com.game.review.validate.AddGenreValiDate;

@Controller
public class AddGenreController {
	@Autowired
	AddGenreService addGenreService;

	@RequestMapping(value = "/addGenre", method = RequestMethod.GET)
	public String goAddGenre(@ModelAttribute("addGenre") AddGenreCommnad addgenreCommand, Model model) {
		model.addAttribute("genreList", addGenreService.viewGenreAll());

		return "addGenre";
	}

	@RequestMapping(value = "/addGenre", method = RequestMethod.POST)
	public String addGenre(@ModelAttribute("addGenre") AddGenreCommnad addgenreCommand, Model model, Errors errors) {
		model.addAttribute("genreList", addGenreService.viewGenreAll());
		new AddGenreValiDate().validate(addgenreCommand, errors);
		if (errors.hasErrors()) {
			return "addGenre";
		}

		addGenreService.addGenre(addgenreCommand);
		return "redirect:/addGenre";

	}

	@RequestMapping(value = "/delGenre", method = RequestMethod.GET)
	public String godelGenre(@ModelAttribute("delGenre") AddGenreCommnad addgenreCommand, Model model) {
		model.addAttribute("genreList", addGenreService.viewGenreAll());

		return "delGenre";
	}

	@RequestMapping(value = "/delGenre", method = RequestMethod.POST)
	public String delGenre(@ModelAttribute("delGenre") AddGenreCommnad addgenreCommand, Model model) throws NoCheckGenreException {
		model.addAttribute("genreList", addGenreService.viewGenreAll());
		try {
			addGenreService.delGenre(addgenreCommand);
		} catch (Exception e) {
			
			return "exceptions/noCheckDelGenre";
		}
		return "redirect:/delGenre";
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public String dupName() {
		return "exceptions/dupNameError";
	}


}
