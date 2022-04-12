package com.game.review.dto;

import org.apache.ibatis.type.Alias;

@Alias("genreDTO")
public class GenreDTO {
	private Long grNum;
	private int genKey;
	private String gName;

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Long getGrNum() {
		return grNum;
	}

	public void setGrNum(Long grNum) {
		this.grNum = grNum;
	}

	public int getGenKey() {
		return genKey;
	}

	public void setGenKey(int genKey) {
		this.genKey = genKey;
	}



}
