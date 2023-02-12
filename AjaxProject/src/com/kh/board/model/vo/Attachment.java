package com.kh.board.model.vo;

import java.sql.Date;

public class Attachment {
	private int fileNo;
	private int refNo;
	private String orignName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int filelevel;
	private String status;
	
	public Attachment() {
		super();
	}

	public Attachment(int fileNo, int refNo, String orignName, String changeName, String filePath, Date uploadDate,
			int filelevel, String status) {
		super();
		this.fileNo = fileNo;
		this.refNo = refNo;
		this.orignName = orignName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.filelevel = filelevel;
		this.status = status;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public String getOrignName() {
		return orignName;
	}

	public void setOrignName(String orignName) {
		this.orignName = orignName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFilelevel() {
		return filelevel;
	}

	public void setFilelevel(int filelevel) {
		this.filelevel = filelevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refNo=" + refNo + ", orignName=" + orignName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", filelevel=" + filelevel
				+ ", status=" + status + "]";
	}
	
}
