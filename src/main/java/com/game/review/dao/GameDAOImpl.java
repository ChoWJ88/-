package com.game.review.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.SpecDTO;

@Repository
public class GameDAOImpl implements GameDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(GamesDTO gamesDTO) {
		sqlSessionTemplate.insert("insert", gamesDTO);

	}

	@Override
	public void insertMainFile(GameFilesDTO gamefilesDTO) {
		sqlSessionTemplate.insert("insertMainFile", gamefilesDTO);

	}

	@Override
	public void insertGr(GenreDTO genreDTO) {
		sqlSessionTemplate.insert("insertGr", genreDTO);

	}

	@Override
	public void insertSpec(SpecDTO specDTO) {
		sqlSessionTemplate.insert("insertSpec", specDTO);

	}

	@Override
	public void insertSlideFile(GameFilesDTO gamefilesDTO) {
		sqlSessionTemplate.insert("insertSlideFile", gamefilesDTO);

	}

	@Override
	public List<Map<String, Object>> selectGenre() {

		return sqlSessionTemplate.selectList("selectGenre");
	}

	@Override
	public List<Map<String, Object>> selectList() {
		
		return sqlSessionTemplate.selectList("selectList");
	}

}
