package com.game.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.review.service.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	DeleteService deleteService;

	@RequestMapping(value = "/read/deleteGame/{gNum}/{gName}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("gNum") Long gNum,@PathVariable("gName") String gName) {

		deleteService.deleteGame(gNum, gName);
		return "redirect:/list";
	}

}
