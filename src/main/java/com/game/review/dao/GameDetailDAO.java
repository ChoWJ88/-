package com.game.review.dao;

import java.util.List;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;

public interface GameDetailDAO {
	public GamesDTO detailGameList(Long gNum);

	public SpecDTO detailSpecList(Long gNum);

	public List<MyGenreDTO> detailGenreList(Long gNum);

	public List<GameFilesDTO> detailGameFilesList(Long gNum);

}
