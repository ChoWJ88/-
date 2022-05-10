package com.game.review.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GameFileModifyCommand {

	private Long gNum;
	private ArrayList<String> gfNum;
	private String gfFilename;
	private String gfSavedfilename;
	private String gName;
	private String gfCode;
	private MultipartFile imgFile;
	private List<MultipartFile> slideImgFile;

	public ArrayList<String> getGfNum() {
		return gfNum;
	}

	public void setGfNum(ArrayList<String> gfNum) {
		this.gfNum = gfNum;
	}

	public Long getgNum() {
		return gNum;
	}

	public void setgNum(Long gNum) {
		this.gNum = gNum;
	}

	public String getGfFilename() {
		return gfFilename;
	}

	public void setGfFilename(String gfFilename) {
		this.gfFilename = gfFilename;
	}

	public String getGfSavedfilename() {
		return gfSavedfilename;
	}

	public void setGfSavedfilename(String gfSavedfilename) {
		this.gfSavedfilename = gfSavedfilename;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getGfCode() {
		return gfCode;
	}

	public void setGfCode(String gfCode) {
		this.gfCode = gfCode;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public List<MultipartFile> getSlideImgFile() {
		return slideImgFile;
	}

	public void setSlideImgFile(List<MultipartFile> slideImgFile) {
		this.slideImgFile = slideImgFile;
	}

}
