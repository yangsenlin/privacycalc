package com.chuhan.privatecalc.calculator;

import android.app.Activity;
import android.widget.TextView;

import com.chuhan.privatecalc.R;

/**
 * 实现计算结果输出
 * @author lifen
 *
 */
public class CaOutputView {
	
	private TextView tv;
	/**
	 * 在CaOutputView中，不需要通知Activity发生了什么，显示结果即可
	 * 所以只需要Activity提供方法，获取TextView对象用于显示结果即可
	 * @param ac
	 */
	public CaOutputView(Activity ac){
		tv = (TextView)ac.findViewById(R.id.tv_output);
	}
	/**
	 * 对显示结果进行处理
	 * @param str
	 */
	public void OutputData(String str){
		tv.setText(str);
	}

}
