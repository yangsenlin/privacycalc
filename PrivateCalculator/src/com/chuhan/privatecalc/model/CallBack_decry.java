package com.chuhan.privatecalc.model;

import java.util.List;
/**
 * 解密回调信息
 * @author lifen
 *
 */
public class CallBack_decry {
	
	private String msg;
	
	private List<DecryptInfo> decrypt;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<DecryptInfo> getDecrypt() {
		return decrypt;
	}

	public void setDecrypt(List<DecryptInfo> decrypt) {
		this.decrypt = decrypt;
	}

	@Override
	public String toString() {
		return "CallBack_decry [msg=" + msg + ", decrypt=" + decrypt + "]";
	}
	
	

}
