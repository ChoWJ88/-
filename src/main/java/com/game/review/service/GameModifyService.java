package com.game.review.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.command.GameModifyCommand;
import com.game.review.command.GenreModifyCommand;
import com.game.review.command.SpecModifyCommand;
import com.game.review.dao.GameModifyDAO;
import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;
import com.game.review.error.NoCheckGenreException;

@Service
public class GameModifyService {
	@Autowired
	private GameModifyDAO gameModifyDAO;

	public void updateGame(GameModifyCommand mc) {
		GamesDTO updateGame = new GamesDTO();
		try {
			updateGame.setgNum(mc.getgNum());
			updateGame.setgName(mc.getgName());
			updateGame.setgCode(mc.getgCode());
			updateGame.setgDev(mc.getgDev());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = date.parse(mc.getgDate());
			long time = date1.getTime();
			Timestamp ts = new Timestamp(time);
			updateGame.setgDate(ts);
			updateGame.setgPrice(mc.getgPrice());
			updateGame.setgContent(mc.getgContent());

			gameModifyDAO.updateGame(updateGame);

		} catch (ParseException e) {

		}

	}

	public void updateSpec(SpecModifyCommand sc) {
		
		SpecDTO ddd = gameModifyDAO.modifySpecList(sc.getgNum());
		SpecDTO updateSpec = new SpecDTO();
		updateSpec.setgNum(sc.getgNum());
		updateSpec.setSpecMinCpu(sc.getSpecMinCpu());
		updateSpec.setSpecMinRam(sc.getSpecMinRam());
		updateSpec.setSpecMinGpu(sc.getSpecMinGpu());
		updateSpec.setSpecMinDx(sc.getSpecMinDx());
		updateSpec.setSpecProCpu(sc.getSpecProCpu());
		updateSpec.setSpecProRam(sc.getSpecProRam());
		updateSpec.setSpecProGpu(sc.getSpecProGpu());
		updateSpec.setSpecProDx(sc.getSpecProDx());
	
		if(ddd != null) {
		gameModifyDAO.updateSpec(updateSpec);
		
		}else {gameModifyDAO.upinsertSpec(updateSpec);
			
		}
	}

	public void updateGenre(GenreModifyCommand gc) {

		GenreDTO updateGenre = new GenreDTO();
		for (int i = 0; i < gc.getGenNum().size(); i++) {
			updateGenre.setGenNum(Long.parseLong(gc.getGenNum().get(i)));
			updateGenre.setgNum(gc.getgNum());
		
			gameModifyDAO.updateGenre(updateGenre);
		}

	}

	public void deleteGenre(GenreModifyCommand gc) {
		MyGenreDTO deleteGenre = new MyGenreDTO();
		
		deleteGenre.setgNum(gc.getgNum());
		if(gc.getGenNum() != null) {
		gameModifyDAO.deleteGenre(deleteGenre);
		}else {
			throw new NoCheckGenreException();
		}
	}

	public List<GenreDTO> modifyGenreList(Long gNum) {

		return gameModifyDAO.modifyGenreList(gNum);
	}

	public List<GameFilesDTO> modifyGameFilesList(Long gNum) {

		return gameModifyDAO.modifyGameFilesList(gNum);
	}

	public Object modifyGameList(Long gNum) {

		Object view = gameModifyDAO.modifyGameList(gNum);
		return view;
	}

	public Object modifySpecList(Long gNum) {

		Object spec = gameModifyDAO.modifySpecList(gNum);
		return spec;
	}

	public List<Map<String, Object>> selectGenreAll() {
		return gameModifyDAO.selectGenreAll();
	}

}
