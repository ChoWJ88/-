package com.game.review.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.game.review.command.GameFileModifyCommand;
import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;

public interface GameModifyDAO {

	public GamesDTO modifyGameList(Long gNum);

	public SpecDTO modifySpecList(Long gNum);

	public List<GenreDTO> modifyGenreList(Long gNum);

	public List<GameFilesDTO> modifyGameFilesList(Long gNum);

	public List<Map<String, Object>> selectGenreAll();

	public List<GameFilesDTO> selectsfn(Long gNum, String gfCode);

	public GameFilesDTO selectGfSavedName(Long gfNum);

	public void upinsertSpec(SpecDTO specDTO);

	public void updateGame(GamesDTO gamesDTO);

	public void updateSpec(SpecDTO specDTO);

	public void updateGenre(GenreDTO genreDTO);

	public void deleteGenre(MyGenreDTO myGenreDTO);

	public void deleteMainFile(GameFilesDTO gameFilesDTO);

	public void updateMainFile(GameFilesDTO gamefilesDTO);

	public void updateSlideFile(GameFilesDTO gamefilesDTO);

	public void deleteSlideFile(GameFilesDTO gameFilesDTO);



}
