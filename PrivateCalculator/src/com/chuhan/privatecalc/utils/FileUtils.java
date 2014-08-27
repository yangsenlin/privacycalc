package com.chuhan.privatecalc.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.content.Context;

import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.model.DecryptInfo;

/**
 * 负责封装文件操作
 * @author lifen
 *
 */
public class FileUtils{
	
	private Context context;
	public FileUtils(Context context) {
		this.context = context;
	}
	
	public FileUtils() {
		
	}
	
	/**
	 * 获取加密文件,并复制到files文件夹下
	 * @param sourceFile
	 * @param destFile
	 * @return
	 * @throws Exception
	 */
	public CryptInfo getCryptFile(String sourceFile, String destFile)throws Exception{
		CryptInfo cryInfo = new CryptInfo();
		//源文件
		File sf = new File(sourceFile);	
		cryInfo.setFilename(sf.getName());		
		//目的文件
		File df = new File(destFile);
		FileInputStream in = null;
		FileOutputStream out = null;
		byte[] buf = new byte[1024];
		int len = 0;
		in = new FileInputStream(sf);
		out = new FileOutputStream(df,true);
		while( (len = in.read(buf)) != -1 ){
			out.write(buf,0,len);
		}
		out.close();	
		return cryInfo;
		
	}
	
	/**
	 * 读取文件内容
	 * @param filename 文件名称
	 * @return 文件内容
	 * @throws Exception
	 */
	public String read(String filename) throws Exception {
		FileInputStream inStream = context.openFileInput(filename);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inStream.read(buffer)) != -1){
			outStream.write(buffer, 0, len);
		}
		byte[] data = outStream.toByteArray();
		return new String(data);
	}
	
	/**
	 * 读取图片信息
	 * @param filePath 文件路径
	 * @return 
	 * @throws Exception
	 */
	public File readFile(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream inStream = context.openFileInput(filePath);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inStream.read(buffer)) != -1){
			outStream.write(buffer, 0, len);
		}
//		byte[] data = outStream.toByteArray();
		
		return file;
	}

	/**
	 * 获取已经被加密的文件，并移动回（暂时是复制）文件原来的位置
	 * @param sourceFile
	 * @param destFile
	 * @return
	 * @throws Exception
	 */
	public DecryptInfo getCryptedFile(String cryptPath, String decryptPath)throws Exception{
		DecryptInfo decryInfo = new DecryptInfo();
		//源文件
		File cp = readFile(cryptPath);	
		decryInfo.setFilename(cp.getName());		
		//目的文件
		File dp = new File(decryptPath);
		FileInputStream in = null;
		FileOutputStream out = null;
		byte[] buf = new byte[1024];
		int len = 0;
		in = new FileInputStream(cp);
		out = new FileOutputStream(dp,true);
		while( (len = in.read(buf)) != -1 ){
			out.write(buf,0,len);
		}
		out.close();	
		return decryInfo;
		
	}
	
}
