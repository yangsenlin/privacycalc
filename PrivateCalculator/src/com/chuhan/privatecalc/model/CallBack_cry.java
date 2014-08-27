package com.chuhan.privatecalc.model;

import java.util.List;
/**
 * 加密回调信息
 * @author lifen
 *
 */
public class CallBack_cry {
	
	private String msg;
	
	private List<CryptInfo> crypt;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<CryptInfo> getCrypt() {
		return crypt;
	}

	public void setCrypt(List<CryptInfo> crypt) {
		this.crypt = crypt;
	}

	@Override
	public String toString() {
		return "CallBack_cry [msg=" + msg + ", crypt=" + crypt + "]";
	}


}
