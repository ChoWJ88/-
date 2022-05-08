package com.game.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.dao.GameDAO;
import com.game.review.dto.GamesDTO;

@Service
public class DeleteService {
	@Autowired
	private GameDAO gameDAO;

	public void deleteGame(Long gNum) {
		GamesDTO deleteGame = new GamesDTO();

		deleteGame.setgNum(gNum);

		gameDAO.deleteGame(deleteGame);

	}
}