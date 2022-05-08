package com.game.review.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;

@Repository
public class GameModifyDAOImpl implements GameModifyDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public GamesDTO modifyGameList(Long gNum) {
		return sqlSessionTemplate.selectOne("modifyGameList", gNum);
	}

	@Override
	public SpecDTO modifySpecList(Long gNum) {
		return sqlSessionTemplate.selectOne("modifySpecList", gNum);
	}

	@Override
	public List<GenreDTO> modifyGenreList(Long gNum) {

		return sqlSessionTemplate.selectList("modifyGenreList", gNum);
	}

	@Override
	public List<GameFilesDTO> modifyGameFilesList(Long gNum) {

		return sqlSessionTemplate.selectList("modifyGameFilesList", gNum);
	}

	@Override
	public List<Map<String, Object>> selectGenreAll() {
		return sqlSessionTemplate.selectList("selectGenreAll");
	}

	@Override
	public void updateGame(GamesDTO gamesDTO) {
		sqlSessionTemplate.update("updateGame", gamesDTO);

	}

	@Override
	public void updateSpec(SpecDTO specDTO) {
		sqlSessionTemplate.update("updateSpec", specDTO);

	}

	@Override
	public void updateGenre(GenreDTO genreDTO) {
		sqlSessionTemplate.update("updateGenre", genreDTO);

	}

	@Override
	public void deleteGenre(MyGenreDTO myGenreDTO) {
		sqlSessionTemplate.delete("deleteGenre", myGenreDTO);

	}

	@Override
	public void upinsertSpec(SpecDTO specDTO) {
		sqlSessionTemplate.insert("upinsertSpec", specDTO);
		
	}
}
