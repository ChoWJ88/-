package com.game.review.command;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class GameRegCommand {

	private String gCode;
	private String gName;
	private String gDev;
	private String gDate;
	private Long gPrice;
	private String gContent;
	private ArrayList<String> genKey;
	private MultipartFile imgFile;
	
	public ArrayList<String> getGenKey() {
		return genKey;
	}

	public void setGenKey(ArrayList<String> genKey) {
		this.genKey = genKey;
	}


	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgDev() {
		return gDev;
	}

	public void setgDev(String gDev) {
		this.gDev = gDev;
	}

	public String getgDate() {
		return gDate;
	}

	public void setgDate(String gDate) {
		this.gDate = gDate;
	}

	public Long getgPrice() {
		return gPrice;
	}

	public void setgPrice(Long gPrice) {
		this.gPrice = gPrice;
	}

	public String getgContent() {
		return gContent;
	}

	public void setgContent(String gContent) {
		this.gContent = gContent;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}


}
