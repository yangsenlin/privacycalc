package com.chuhan.privatecalc.utils;

import java.util.List;

import com.chuhan.privatecalc.model.CallBack_cry;
import com.chuhan.privatecalc.model.CallBack_decry;
import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.model.DecryptInfo;

/**
 * 加密解密管理类
 * @author lifen
 *
 */
public class PrivacyCalcManager implements ICrypt{

	FileUtils fu = new FileUtils();
	@Override
	public CallBack_cry encrypt(String[] filePath, String[] destPath,
			List<CryptInfo> cryptInfo) throws Exception{
		CallBack_cry cbc = new CallBack_cry();
		CryptInfo cryInfo = new CryptInfo();
//		String filePath = "/sdcard/2.jpg";
//		String destPath = "/data/data/com.chuhan.privatecalc/files/test.jpg";
		for(int i=0; i<filePath.length; i++){
			cryInfo = fu.getCryptFile(filePath[i], destPath[i]);
			cryptInfo.add(cryInfo);
		}
		cbc.setMsg("success");
		cbc.setCrypt(cryptInfo);
		return cbc;
	}

	@Override
	public CallBack_decry decrypt(String[] cryptPath, String[] decryptPath,
			List<DecryptInfo> decryptInfo) throws Exception{
		CallBack_decry cbc = new CallBack_decry();
		DecryptInfo decryInfo = new DecryptInfo();
//		String filePath = "/data/data/com.chuhan.privatecalc/files/test.jpg";
//		String destPath = "/sdcard/2.jpg";
		for(int i=0; i<cryptPath.length; i++){
			decryInfo = fu.getCryptedFile(cryptPath[i], decryptPath[i]);
		    decryptInfo.add(decryInfo);
		}
		cbc.setMsg("success");
		cbc.setDecrypt(decryptInfo);
		return cbc;
	}



	



}
