package com.game.review.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("gamesDTO")
public class GamesDTO {
	private Long gNum;
	private String gCode;
	private String gName;
	private String gDev;
	private Timestamp gDate;
	private Long gPrice;
	private String gAvgscore;
	private String gContent;
	private Long adNum;

	public Long getAdNum() {
		return adNum;
	}

	public void setAdNum(Long adNum) {
		this.adNum = adNum;
	}

	public Long getgNum() {
		return gNum;
	}

	public void setgNum(Long gNum) {
		this.gNum = gNum;
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

	public Timestamp getgDate() {
		return gDate;
	}

	public void setgDate(Timestamp gDate) {
		this.gDate = gDate;
	}

	public Long getgPrice() {
		return gPrice;
	}

	public void setgPrice(Long gPrice) {
		this.gPrice = gPrice;
	}

	public String getgAvgscore() {
		return gAvgscore;
	}

	public void setgAvgscore(String gAvgscore) {
		this.gAvgscore = gAvgscore;
	}

	public String getgContent() {
		return gContent;
	}

	public void setgContent(String gContent) {
		this.gContent = gContent;
	}

}