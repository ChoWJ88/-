package com.game.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.dao.GameDetailDAO;
import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;

@Service
public class GameDetailService {
	@Autowired
	private GameDetailDAO gameDetailDAO;

	public List<MyGenreDTO> detailGenreList(Long gNum) {

		return gameDetailDAO.detailGenreList(gNum);
	}

	public List<GameFilesDTO> detailGameFilesList(Long gNum) {

		return gameDetailDAO.detailGameFilesList(gNum);
	}

	public Object detailGameList(Long gNum) {

		Object view = gameDetailDAO.detailGameList(gNum);
		return view;
	}

	public Object detailSpecList(Long gNum) {

		Object spec = gameDetailDAO.detailSpecList(gNum);
		return spec;
	}
}
