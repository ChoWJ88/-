package com.game.review.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;

@Repository
public class GameDetailDAOImpl implements GameDetailDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<MyGenreDTO> detailGenreList(Long gNum) {

		return sqlSessionTemplate.selectList("detailGenreList",gNum);
	}

	@Override
	public List<GameFilesDTO> detailGameFilesList(Long gNum) {

		return sqlSessionTemplate.selectList("detailGameFilesList",gNum);
	}

	@Override
	public GamesDTO detailGameList(Long gNum) {

		return sqlSessionTemplate.selectOne("detailGameList", gNum);
	}

	@Override
	public SpecDTO detailSpecList(Long gNum) {

		return sqlSessionTemplate.selectOne("detailSpecList",gNum);
	}

}
