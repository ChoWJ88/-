package com.game.review.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GameFileModifyCommand {
	private Long gNum;
	private Long gfNum;
	private String gfFilename;
	private String gfSavedfilename;
	private String gName;
	private String gfCode;
	private MultipartFile imgFile;
	private List<MultipartFile> slideImgFile;

}
