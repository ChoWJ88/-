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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.game.review.command.GameFileModifyCommand;
import com.game.review.command.GameModifyCommand;
import com.game.review.command.GenreModifyCommand;
import com.game.review.command.SpecModifyCommand;
import com.game.review.dao.GameModifyDAO;
import com.game.review.dto.GameFilesDTO;
import com.game.review.dto.GamesDTO;
import com.game.review.dto.GenreDTO;
import com.game.review.dto.MyGenreDTO;
import com.game.review.dto.SpecDTO;
import com.game.review.error.NoCheckFileException;
import com.game.review.error.NoCheckGenreException;
import com.game.review.error.NoFileException;

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

		if (ddd != null) {
			gameModifyDAO.updateSpec(updateSpec);

		} else {
			gameModifyDAO.upinsertSpec(updateSpec);

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
		if (gc.getGenNum() != null) {
			gameModifyDAO.deleteGenre(deleteGenre);
		} else {
			throw new NoCheckGenreException();
		}
	}

	public void deleteMainFile(GameFileModifyCommand gmf) {
		GameFilesDTO mainFileDelete = new GameFilesDTO();

		mainFileDelete.setgNum(gmf.getgNum());
		mainFileDelete.setGfCode("1");
		List<GameFilesDTO> result = gameModifyDAO.selectsfn(gmf.getgNum(), mainFileDelete.getGfCode());
		GameFilesDTO i = new GameFilesDTO();
		for (GameFilesDTO asdf : result) {
			i.setGfSavedfilename(asdf.getGfSavedfilename());

		}

		String directoryPath = "C:\\test\\upload\\" + gmf.getgName() + "\\" + i.getGfSavedfilename();
		File deleteFolder = new File(directoryPath);

		System.out.println("파일경로" + directoryPath);

		if (deleteFolder.exists()) {
			gameModifyDAO.deleteMainFile(mainFileDelete);
			deleteFolder.delete();

			System.out.println("메인파일삭제성공");

		}

	}

	public void deleteSlideFile(GameFileModifyCommand gmf) {

		if (gmf.getGfNum() == null) {
			throw new NoCheckFileException();
		}
		for (int i = 0; i < gmf.getGfNum().size(); i++) {
			GameFilesDTO ordDTO = gameModifyDAO.selectGfSavedName(Long.parseLong(gmf.getGfNum().get(i)));
			String directoryPath = "C:\\test\\upload\\" + gmf.getgName() + "\\" + ordDTO.getGfSavedfilename();
			System.out.println(directoryPath);
			File file = new File(directoryPath);
			if (file.exists()) {
				System.out.println("파일 존재함?");
				if (file.delete()) {
					System.out.println("정상삭제!");
					gameModifyDAO.deleteSlideFile(ordDTO);
				} else {
					System.out.println("삭제실패!");
				}
			} else {
				System.out.println("파일 존재안함");
			}

		}

	}

	public void updateMainFile(GameFileModifyCommand gmf) {

		System.out.println("파일왜없어씨발" + gmf.getImgFile().getOriginalFilename());
		if (gmf.getImgFile().isEmpty()) {
			throw new NoFileException();

		}

		UUID uuid = UUID.randomUUID();
		MultipartFile imgFile = gmf.getImgFile();
		String orifile = imgFile.getOriginalFilename();
		String savedfile = uuid + "_" + orifile;
		String path = "C:\\test\\upload\\" + gmf.getgName() + "\\" + savedfile;
		File fileInfo = new File(path);
		if (!fileInfo.exists()) {
			fileInfo.mkdirs();
		}

		try {
			imgFile.transferTo(fileInfo);

			GameFilesDTO updateMainFile = new GameFilesDTO();

			updateMainFile.setGfFilename(orifile);
			updateMainFile.setGfSavedfilename(savedfile);
			updateMainFile.setgName(gmf.getgName());
			updateMainFile.setGfCode("1");
			updateMainFile.setgNum(gmf.getgNum());
			List<GameFilesDTO> result = gameModifyDAO.selectsfn(gmf.getgNum(), updateMainFile.getGfCode());
			GameFilesDTO i = new GameFilesDTO();
			for (GameFilesDTO asdf : result) {
				i.setGfSavedfilename(asdf.getGfSavedfilename());

			}
			if (i != null) {
				GameModifyService.this.deleteMainFile(gmf);
			}

			gameModifyDAO.updateMainFile(updateMainFile);

		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void updateSlideFile(GameFileModifyCommand gmf) {

		System.out.println("넌또왜" + gmf.getSlideImgFile());

		for (int i = 0; i < gmf.getSlideImgFile().size(); i++) {

			if (gmf.getSlideImgFile().isEmpty()) {
				throw new NoFileException();
			}

			UUID uuid = UUID.randomUUID();
			MultipartFile imgFile = gmf.getSlideImgFile().get(i);
			String orifile = imgFile.getOriginalFilename();
			System.out.println("아좀" + orifile);
			if (orifile.isEmpty()) {
				throw new NoFileException();
			}

			String savedfile = uuid + "_" + orifile;
			String path = "C:\\test\\upload\\" + gmf.getgName() + "\\" + savedfile;

			File fileInfo = new File(path);

			if (!fileInfo.exists()) {
				fileInfo.mkdirs();
			}
			try {
				imgFile.transferTo(fileInfo);

				GameFilesDTO updateSlideFile = new GameFilesDTO();

				updateSlideFile.setGfFilename(orifile);
				updateSlideFile.setGfSavedfilename(savedfile);
				updateSlideFile.setgName(gmf.getgName());
				updateSlideFile.setGfCode("2");
				updateSlideFile.setgNum(gmf.getgNum());

				gameModifyDAO.updateSlideFile(updateSlideFile);

			} catch (IOException e) {

			}
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
