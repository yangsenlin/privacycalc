package com.chuhan.privatecalc.test;

import java.io.File;
import java.util.Date;

import android.test.AndroidTestCase;
import android.util.Log;

import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.model.DecryptInfo;
import com.chuhan.privatecalc.utils.FileUtils;

public class TestCryptInfo extends AndroidTestCase {
	String tag = "TestCryptInfo";
	
	public void cryptInfoTest(){
		CryptInfo ci = new CryptInfo();
		ci.setFilename("test.jpg");
		ci.setFilepath("C:\\test");
		ci.setFilesize(15);
		ci.setMove(false);
		ci.setFiletype("jpg");
		ci.setDestpath("");
//		ci.setCryptdate(new Date().toString());
		Log.i(tag,ci.getFilename()+" "+ci.getHashid());
	}
	public void decryptInfoTest(){
		DecryptInfo ci = new DecryptInfo();
		ci.setFilename("test.jpg");
		ci.setCryptpath("C:\\test");
		ci.setFilesize("15K");
		ci.setMove(false);
		ci.setFiletype("jpg");
		ci.setDecryptpath("");
		ci.setDecryptdate(new Date());
		Log.i(tag,ci.getFilename()+" "+ci.getHashid());
	}
	
	public void fileUtilsTest() throws Exception{
		FileUtils fu = new FileUtils();
		CryptInfo ci = new CryptInfo();
		//‘› ±”√”⁄≤‚ ‘
		String sourceFile = "/sdcard/2.jpg";
		String destFile = "/data/data/com.chuhan.privatecalc/files/test.jpg";
//		new File("/data/data/com.chuhan.privatecalc/files");
//		String destFile = "/data/data/com.chuhan.privatecalc/files/test/test.jpg";
		ci = fu.getCryptFile(sourceFile, destFile);
		Log.i(tag,ci.getFilename()+" ");
	}

	public void testRead() throws Throwable{
		FileUtils service = new FileUtils(this.getContext());
		String result = service.read("test.jpg");
		Log.i(tag, result);
	}
}
