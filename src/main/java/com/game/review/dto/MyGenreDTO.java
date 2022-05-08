package com.game.review.dto;

import org.apache.ibatis.type.Alias;

@Alias("myGenreDTO")
public class MyGenreDTO {
	private Long gNum;
	private String genName;
	private Long genNum;

	public Long getGenNum() {
		return genNum;
	}

	public void setGenNum(Long genNum) {
		this.genNum = genNum;
	}

	public Long getgNum() {
		return gNum;
	}

	public void setgNum(Long gNum) {
		this.gNum = gNum;
	}

	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}

	@Override
	public String toString() {
		return "MyGenreDTO [gNum=" + gNum + ", genName=" + genName + "]";
	}

}
