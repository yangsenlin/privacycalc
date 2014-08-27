package com.chuhan.privatecalc.model;

import java.util.Date;

/**
 * 加密文件信息
 * @author lifen
 *
 */
public class CryptInfo {
	
	private String filename;
	
	private String filepath;
	
	/**
	 * 默认是移动文件move=true
	 * 如果不需要移动文件则将其设为false
	 */
	private Boolean move=true;
	
	private String destpath;
	
	private int filesize;
	
	private String filetype;
	
	private String cryptdate = new Date().toString();
	
	public CryptInfo(int hashid, String filename, String filepath, int filesize, String filetype){
		
		this.hashid = hashid;
		this.filename = filename;
		this.filepath = filepath;
		this.filesize = filesize;
		this.filetype = filetype;
	}
	
	public CryptInfo(){
		
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Boolean getMove() {
		return move;
	}

	public void setMove(Boolean move) {
		this.move = move;
	}

	public String getDestpath() {
		return destpath;
	}

	public void setDestpath(String destpath) {
		this.destpath = destpath;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getCryptdate() {
		return cryptdate;
	}

	public void setCryptdate(String cryptdate) {
		this.cryptdate = cryptdate;
	}

	/**
	 * hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值
	 * 把hashCode的返回值作为唯一标识加密文件的hashid
	 */
	private int hashid = hashCode();

	public int getHashid() {
		return hashid;
	}
	
	public void setHashid(int hashid) {
		this.hashid = hashid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result
//				+ ((cryptdate == null) ? 0 : cryptdate.hashCode());
		result = prime * result
				+ ((destpath == null) ? 0 : destpath.hashCode());
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
		result = prime * result
				+ ((filepath == null) ? 0 : filepath.hashCode());
		result = prime * result + filesize;
		result = prime * result
				+ ((filetype == null) ? 0 : filetype.hashCode());
		result = prime * result + hashid;
		result = prime * result + ((move == null) ? 0 : move.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CryptInfo other = (CryptInfo) obj;
//		if (cryptdate == null) {
//			if (other.cryptdate != null)
//				return false;
//		} else if (!cryptdate.equals(other.cryptdate))
//			return false;
		if (destpath == null) {
			if (other.destpath != null)
				return false;
		} else if (!destpath.equals(other.destpath))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (filepath == null) {
			if (other.filepath != null)
				return false;
		} else if (!filepath.equals(other.filepath))
			return false;
		if (filesize != other.filesize)
			return false;
		if (filetype == null) {
			if (other.filetype != null)
				return false;
		} else if (!filetype.equals(other.filetype))
			return false;
		if (hashid != other.hashid)
			return false;
		if (move == null) {
			if (other.move != null)
				return false;
		} else if (!move.equals(other.move))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CryptInfo [filename=" + filename + ", filepath=" + filepath
				+ ", move=" + move + ", destpath=" + destpath + ", filesize="
				+ filesize + ", filetype=" + filetype + ", cryptdate="
				+ ", hashid=" + hashid + "]";
//		+ cryptdate + ", hashid=" + hashid + "]";
	}
	

}
