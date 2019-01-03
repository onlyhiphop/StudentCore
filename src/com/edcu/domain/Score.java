package com.edcu.domain;

public class Score {
	private String stuNo;
	private String stuName;
	private String type;
	private String core;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}
	
	public Score(String stuNo, String stuName, String type, String core) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.type = type;
		this.core = core;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}
	
	
	
	
}
