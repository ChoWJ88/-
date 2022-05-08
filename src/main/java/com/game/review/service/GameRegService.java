package com.game.review.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.game.review.command.GameRegCommand;
import com.game.review.command.GameSpecCommand;
import com.game.review.dao.GameDAO;
import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.SpecDTO;

@Service
public class GameRegService {
	@Autowired
	private GameDAO gameDAO;

	public List<Map<String, Object>> selectGenre() {
		return gameDAO.selectGenre();
	}

	public void register(GameRegCommand grc) {

		UUID uuid = UUID.randomUUID();
		MultipartFile imgFile = grc.getImgFile();
		String orifile = imgFile.getOriginalFilename();
		String savedfile = uuid + "_" + orifile;
		String path = "C:\\test\\upload\\" + grc.getgName() + "\\" + savedfile;
		File fileInfo = new File(path);
		System.out.println("ddddddddd");
		if (!fileInfo.exists()) {
			fileInfo.mkdirs();
		}
		try {
			imgFile.transferTo(fileInfo);

			GamesDTO newGame = new GamesDTO();
			GameFilesDTO newGamefile = new GameFilesDTO();
			GenreDTO newGameGr = new GenreDTO();

			newGame.setgName(grc.getgName());
			newGame.setgDev(grc.getgDev());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = date.parse(grc.getgDate());
			long time = date1.getTime();
			Timestamp ts = new Timestamp(time);
			newGame.setgDate(ts);
			newGame.setgPrice(grc.getgPrice());
			newGame.setgContent(grc.getgContent());
			newGame.setgCode(grc.getgCode());
			newGamefile.setGfFilename(orifile);
			newGamefile.setGfSavedfilename(savedfile);
			newGamefile.setgName(grc.getgName());
			newGamefile.setGfCode("1");
			gameDAO.insert(newGame);
			gameDAO.insertMainFile(newGamefile);

			for (int i = 0; i < grc.getGenNum().size(); i++) {
				newGameGr.setGenNum(Long.parseLong(grc.getGenNum().get(i)));
				newGameGr.setgName(grc.getgName());
				gameDAO.insertGr(newGameGr);
			}

		} catch (IOException e) {
			// TODO: handle exception
		} catch (ParseException e) {

		}
	}

	public void specRegist(GameSpecCommand gsc) {

		SpecDTO newSpec = new SpecDTO();

		newSpec.setSpecMinCpu(gsc.getSpecMinCpu());
		newSpec.setSpecMinRam(gsc.getSpecMinRam());
		newSpec.setSpecMinGpu(gsc.getSpecMinGpu());
		newSpec.setSpecMinDx(gsc.getSpecMinDx());
		newSpec.setSpecProCpu(gsc.getSpecProCpu());
		newSpec.setSpecProRam(gsc.getSpecProRam());
		newSpec.setSpecProGpu(gsc.getSpecProGpu());
		newSpec.setSpecProDx(gsc.getSpecProDx());
		newSpec.setgName(gsc.getgName());
		System.out.println("newspec" + newSpec);
		gameDAO.insertSpec(newSpec);

		for (int i = 0; i < gsc.getSlideImgFile().size(); i++) {
			UUID uuid = UUID.randomUUID();
			MultipartFile imgFile = gsc.getSlideImgFile().get(i);
			String orifile = imgFile.getOriginalFilename();
			System.out.println("ddddfff" + orifile);
			String savedfile = uuid + "_" + orifile;
			String path = "C:\\test\\upload\\" + gsc.getgName() + "\\" + savedfile;

			File fileInfo = new File(path);

			if (!fileInfo.exists()) {
				fileInfo.mkdirs();
			}
			try {
				imgFile.transferTo(fileInfo);

				GameFilesDTO newGamefile = new GameFilesDTO();

				newGamefile.setGfFilename(orifile);
				newGamefile.setGfSavedfilename(savedfile);
				newGamefile.setgName(gsc.getgName());
				newGamefile.setGfCode("2");

				gameDAO.insertSlideFile(newGamefile);

			} catch (IOException e) {

			}
		}

	}

}
