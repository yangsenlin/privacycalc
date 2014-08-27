package com.chuhan.privatecalc.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.content.Context;

import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.model.DecryptInfo;

/**
 * �����װ�ļ�����
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
	 * ��ȡ�����ļ�,�����Ƶ�files�ļ�����
	 * @param sourceFile
	 * @param destFile
	 * @return
	 * @throws Exception
	 */
	public CryptInfo getCryptFile(String sourceFile, String destFile)throws Exception{
		CryptInfo cryInfo = new CryptInfo();
		//Դ�ļ�
		File sf = new File(sourceFile);	
		cryInfo.setFilename(sf.getName());		
		//Ŀ���ļ�
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
	 * ��ȡ�ļ�����
	 * @param filename �ļ�����
	 * @return �ļ�����
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
	 * ��ȡͼƬ��Ϣ
	 * @param filePath �ļ�·��
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
	 * ��ȡ�Ѿ������ܵ��ļ������ƶ��أ���ʱ�Ǹ��ƣ��ļ�ԭ����λ��
	 * @param sourceFile
	 * @param destFile
	 * @return
	 * @throws Exception
	 */
	public DecryptInfo getCryptedFile(String cryptPath, String decryptPath)throws Exception{
		DecryptInfo decryInfo = new DecryptInfo();
		//Դ�ļ�
		File cp = readFile(cryptPath);	
		decryInfo.setFilename(cp.getName());		
		//Ŀ���ļ�
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
