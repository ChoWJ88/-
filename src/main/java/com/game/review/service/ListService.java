package com.game.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.dao.GameDAO;

@Service
public class ListService {
	@Autowired
	private GameDAO gameDAO;

	public List<Map<String, Object>> selectList() {
		return gameDAO.selectList();
	}
}
