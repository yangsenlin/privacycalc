package com.chuhan.privatecalc.calculator;

import android.app.Activity;
import android.widget.TextView;

import com.chuhan.privatecalc.R;

/**
 * ʵ�ּ��������
 * @author lifen
 *
 */
public class CaOutputView {
	
	private TextView tv;
	/**
	 * ��CaOutputView�У�����Ҫ֪ͨActivity������ʲô����ʾ�������
	 * ����ֻ��ҪActivity�ṩ��������ȡTextView����������ʾ�������
	 * @param ac
	 */
	public CaOutputView(Activity ac){
		tv = (TextView)ac.findViewById(R.id.tv_output);
	}
	/**
	 * ����ʾ������д���
	 * @param str
	 */
	public void OutputData(String str){
		tv.setText(str);
	}

}
