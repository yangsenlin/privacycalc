package com.chuhan.privatecalc.utils;

import java.util.List;

import com.chuhan.privatecalc.model.CallBack_cry;
import com.chuhan.privatecalc.model.CallBack_decry;
import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.model.DecryptInfo;


/**
 * ���ܽ��ܽӿ�
 * @author lifen
 *
 */
public interface ICrypt {
	
	/**
	 * ����
	 * @param filepath �ļ�·�����������ļ�����λ��
	 * @param destpath Ŀ��·�������ܺ��ƶ��ĵ������ļ���
	 * @param cryptInfo �����ļ���Ϣ
	 * @param callback �ӿڻص���Ϣ
	 */
	public CallBack_cry encrypt(String[] filePath, String[] destPath, List<CryptInfo> cryptInfo)throws Exception;
	
	/**
	 * ����
	 * @param cryptPath �����ļ��������ļ����е�λ��
	 * @param decryptPath �ļ����ܺ��ļ��ƶ���ԭ����λ��
	 * @param decryptInfo �����ļ���Ϣ
	 * @param callback �ӿڻص���Ϣ
	 */
	public CallBack_decry decrypt(String[] cryptPath, String[] decryptPath, List<DecryptInfo> decryptInfo)throws Exception;

	
}
