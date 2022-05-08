package com.game.review.dao;

import java.util.List;
import java.util.Map;

import com.game.review.dto.GenreDTO;

public interface AddGenreDAO {

	public void addGenre(GenreDTO genreDTO);
	
	public void delGenre(GenreDTO genreDTO);
	
	
	public List<Map<String, Object>> viewGenreAll();
}
