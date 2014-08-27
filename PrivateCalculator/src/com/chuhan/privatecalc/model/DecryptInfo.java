package com.chuhan.privatecalc.model;

import java.util.Date;

/**
 * 解密文件信息
 * @author lifen
 *
 */
public class DecryptInfo {
	
	/**
	 * 加密时通过hashcode函数为每一个加密文件创建了一个唯一的标识hashid
	 * 解密时需要通过这个hashid获取该文件。
	 */
	private int hashid;
	
	private String filename;
	
	private String cryptpath;
	
	/**
	 * 默认是移动文件move=true
	 * 如果不需要移动文件则将其设为false
	 */
	private Boolean move;
	
	private String decryptpath;
	
	private String filesize;
	
	private String filetype;
	
	private Date decryptdate;
	
	public DecryptInfo(int hashid, String filename, String cryptpath, String filesize, String filetype){
		
		this.hashid = hashid;
		this.filename = filename;
		this.cryptpath = cryptpath;
		this.filesize = filesize;
		this.filetype = filetype;
	}
	
	public DecryptInfo(){
		
	}

	public int getHashid() {
		return hashid;
	}

	public void setHashid(int hashid) {
		this.hashid = hashid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCryptpath() {
		return cryptpath;
	}

	public void setCryptpath(String cryptpath) {
		this.cryptpath = cryptpath;
	}

	public Boolean getMove() {
		return move;
	}

	public void setMove(Boolean move) {
		this.move = move;
	}

	public String getDecryptpath() {
		return decryptpath;
	}

	public void setDecryptpath(String decryptpath) {
		this.decryptpath = decryptpath;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public Date getDecryptdate() {
		return decryptdate;
	}

	public void setDecryptdate(Date decryptdate) {
		this.decryptdate = decryptdate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DecryptInfo other = (DecryptInfo) obj;
		if (cryptpath == null) {
			if (other.cryptpath != null)
				return false;
		} else if (!cryptpath.equals(other.cryptpath))
			return false;
		if (decryptdate == null) {
			if (other.decryptdate != null)
				return false;
		} else if (!decryptdate.equals(other.decryptdate))
			return false;
		if (decryptpath == null) {
			if (other.decryptpath != null)
				return false;
		} else if (!decryptpath.equals(other.decryptpath))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (filesize == null) {
			if (other.filesize != null)
				return false;
		} else if (!filesize.equals(other.filesize))
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
		return "DecryptInfo [hashid=" + hashid + ", filename=" + filename
				+ ", cryptpath=" + cryptpath + ", move=" + move
				+ ", decryptpath=" + decryptpath + ", filesize=" + filesize
				+ ", filetype=" + filetype + ", decryptdate=" + decryptdate
				+ "]";
	}
	
	

}
