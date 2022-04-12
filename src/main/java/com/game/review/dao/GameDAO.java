package com.game.review.dao;

import java.util.List;
import java.util.Map;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.SpecDTO;

public interface GameDAO {
	public void insert(GamesDTO gamesDTO);

	public void insertGr(GenreDTO genreDTO);

	public void insertMainFile(GameFilesDTO gamefilesDTO);

	public void insertSpec(SpecDTO specDTO);

	public void insertSlideFile(GameFilesDTO gamefilesDTO);

	public List<Map<String, Object>> selectGenre();

	public List<Map<String, Object>> selectList();

}
