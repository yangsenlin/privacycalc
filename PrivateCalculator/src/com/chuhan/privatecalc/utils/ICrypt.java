package com.chuhan.privatecalc.utils;

import java.util.List;

import com.chuhan.privatecalc.model.CallBack_cry;
import com.chuhan.privatecalc.model.CallBack_decry;
import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.model.DecryptInfo;


/**
 * 加密解密接口
 * @author lifen
 *
 */
public interface ICrypt {
	
	/**
	 * 加密
	 * @param filepath 文件路径：被加密文件所在位置
	 * @param destpath 目的路径：加密后移动的到隐藏文件夹
	 * @param cryptInfo 加密文件信息
	 * @param callback 接口回调信息
	 */
	public CallBack_cry encrypt(String[] filePath, String[] destPath, List<CryptInfo> cryptInfo)throws Exception;
	
	/**
	 * 解密
	 * @param cryptPath 解密文件在隐藏文件夹中的位置
	 * @param decryptPath 文件解密后文件移动回原来的位置
	 * @param decryptInfo 解密文件信息
	 * @param callback 接口回调信息
	 */
	public CallBack_decry decrypt(String[] cryptPath, String[] decryptPath, List<DecryptInfo> decryptInfo)throws Exception;

	
}
