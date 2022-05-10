package com.game.review.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.dao.GameDAO;
import com.game.review.dto.GamesDTO;

@Service
public class DeleteService {
	@Autowired
	private GameDAO gameDAO;

	public void deleteGame(Long gNum, String gName) {
		GamesDTO deleteGame = new GamesDTO();

		deleteGame.setgNum(gNum);
		String directoryPath = "C:\\test\\upload\\" + gName;
		File deleteFolder = new File(directoryPath);
		Path directoryPath1 = Paths.get("C:\\test\\upload\\" + gName);

		System.out.println("파일삭제" + directoryPath);

		if (deleteFolder.exists()) {
			File[] deleteFolderList = deleteFolder.listFiles();

			for (int j = 0; j < deleteFolderList.length; j++) {
				deleteFolderList[j].delete();
				System.out.println("파일삭제성공");


			}
			try {
				Files.deleteIfExists(directoryPath1);
				System.out.println("디렉토리삭제성공");
			} catch (DirectoryNotEmptyException e) {
				System.out.println("디렉토리가 비어있지 않습니다");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		gameDAO.deleteGame(deleteGame);
	}

}