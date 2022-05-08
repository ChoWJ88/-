package com.game.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.game.review.command.AddGenreCommnad;
import com.game.review.dao.AddGenreDAO;
import com.game.review.dto.GenreDTO;
import com.game.review.error.NoCheckGenreException;

@Service
public class AddGenreService {
	@Autowired
	private AddGenreDAO addGenreDAO;

	public List<Map<String, Object>> viewGenreAll() {
		return addGenreDAO.viewGenreAll();
	}

	public void addGenre(AddGenreCommnad ac) {

		List<Map<String, Object>> list = addGenreDAO.viewGenreAll();
		boolean isDup = false;
		for (Map<String, Object> dup : list) {
			isDup = ac.getGenName().equals(dup.get("genNum"));

		}

		if (!isDup) {

			GenreDTO addGenre = new GenreDTO();
			addGenre.setGenName(ac.getGenName());
			addGenreDAO.addGenre(addGenre);
		} else {
			throw new DuplicateKeyException(null);

		}

	}

	public void delGenre(AddGenreCommnad ac) throws Exception {
		GenreDTO delGenre = new GenreDTO();

		for (int i = 0; i < ac.getGenNum().size(); i++) {
			delGenre.setGenNum(Long.parseLong(ac.getGenNum().get(i)));
			if (delGenre != null) {
				addGenreDAO.delGenre(delGenre);
			}

		}

	}
}
