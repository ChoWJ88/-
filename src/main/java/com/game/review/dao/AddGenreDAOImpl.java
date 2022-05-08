package com.game.review.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.review.dto.GenreDTO;

@Repository
public class AddGenreDAOImpl implements AddGenreDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void addGenre(GenreDTO genreDTO) {
		sqlSessionTemplate.insert("addGenre", genreDTO);

	}

	@Override
	public void delGenre(GenreDTO genreDTO) {
		sqlSessionTemplate.delete("delGenre", genreDTO);

	}

	@Override
	public List<Map<String, Object>> viewGenreAll() {

		return sqlSessionTemplate.selectList("viewGenreAll");
	}

}
