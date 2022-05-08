package com.game.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.dao.GameDAO;
import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.MyGenreDTO;

@Service
public class ListService {
	@Autowired
	private GameDAO gameDAO;

	public List<MyGenreDTO> selectGenreList() {
		return gameDAO.selectGenreList();
	}

	public List<GameFilesDTO> selectGameFilesList() {

		return gameDAO.selectGameFilesList();
	}

	public List<GamesDTO> selectGameList() {
		return gameDAO.selectGameList();
	}



}
