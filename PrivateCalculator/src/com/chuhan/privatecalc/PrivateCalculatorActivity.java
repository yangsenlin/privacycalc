package com.chuhan.privatecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.chuhan.privatecalc.calculator.CaInputView;
import com.chuhan.privatecalc.calculator.CaInputView.InputHappend;
import com.chuhan.privatecalc.calculator.CaOutputView;
import com.chuhan.privatecalc.calculator.CalModel;
import com.chuhan.privatecalc.calculator.ICalculator;

/**
 * ˽�ܼ����������
 * @author lifen
 *
 */
public class PrivateCalculatorActivity extends Activity implements InputHappend{

	private CaOutputView cov;
	private ICalculator calModel;
	//ͨ��һ���ַ�����������������ʱ����������һ�� eg."8"+"8"="88"
	private String number = "0";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		new CaInputView(this, this);
		cov = new CaOutputView(this);
		calModel = new CalModel();
		
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
		//���������������С���� 8.0 -> 8
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

}
