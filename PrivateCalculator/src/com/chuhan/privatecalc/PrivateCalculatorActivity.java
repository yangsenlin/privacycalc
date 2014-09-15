package com.chuhan.privatecalc;

import java.io.UTFDataFormatException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.chuhan.privatecalc.calculator.CaInputView;
import com.chuhan.privatecalc.calculator.CaInputView.InputHappend;
import com.chuhan.privatecalc.calculator.CaOutputView;
import com.chuhan.privatecalc.calculator.CalModel;
import com.chuhan.privatecalc.calculator.ICalculator;
import com.chuhan.privatecalc.model.watcher.DemoCryptWatcher;
import com.chuhan.privatecalc.model.watcher.WatcherCenter;

/**
 * ˽�ܼ����������
 * @author lifen
 *
 */
public class PrivateCalculatorActivity extends Activity implements InputHappend{
	
	public final static String TAG = PrivateCalculatorActivity.class.getSimpleName();
	private CaOutputView cov;
	private ICalculator calModel;
	//ͨ��һ���ַ���������������ʱ����������һ�� eg."8"+"8"="88"
	private String number = "0";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		new CaInputView(this, this);
		cov = new CaOutputView(this);
		calModel = new CalModel();
		
		Button btn = (Button) findViewById(R.id.Operand0);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				WatcherCenter.triggerDemoCryptProgress("yahuang", 123456, 17, 100);
				WatcherCenter.triggerDemoCryptSuccess("yahuang", "Oh! Success");
			}
		});
	}

	@Override
	public void operandIn(String operand) {
		//����λΪ��0��������
		number = number.equals("0")?operand:number+operand;
		//���ص�����ִ��ʱ����CaOutputView����ʾ,����������ʱֻ��Ҫ��ʾ
		cov.OutputData(number);
	}

	@Override
	public void operateIn(String operate) {
		if(operate.equals("c")){
			calModel.reset();
			number = "0";
			cov.OutputData(number);
			return;
		}
		//���������ʱ�Ƚ����ۼơ���numberѹ��ջ�ٽ��Լ�ѹ��
		calModel.pushOperand(number);
		double result = calModel.pushOperate(operate);
		//��������������С��� 8.0 -> 8
		if(result % 1d == 0d){
			int tmp = Double.valueOf(result).intValue();
			cov.OutputData(String.valueOf(tmp));
		}
		else{
			cov.OutputData(String.valueOf(result));
		}
		number = "0";
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private DemoCryptWatcher mDemoCryptWatcher = new DemoCryptWatcher() {
		
		@Override
		public void onSuccess(String uin, Object result) {
			Log.d(TAG, "On success called, result: " + (String) result);
		}
		
		@Override
		public void onProgress(String uin, long fid, long current, long total) {
			Log.d(TAG, "On progress called, uin: " + uin + " fid: " + fid + " current: " + current + " total: " + total);
		}
		
		@Override
		public void onError(String uin, long fid, Object error) {}
		
		@Override
		public void onComplete() {}
	};

	@Override
	protected void onPause() {
		super.onPause();
		WatcherCenter.bindDemoCryptListener(mDemoCryptWatcher, false);
	}

	@Override
	protected void onResume() {
		super.onResume();
		WatcherCenter.bindDemoCryptListener(mDemoCryptWatcher, true);
	}
	
	

}
