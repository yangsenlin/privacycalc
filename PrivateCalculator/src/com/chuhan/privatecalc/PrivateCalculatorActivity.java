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
 * 私密计算器的入口
 * @author lifen
 *
 */
public class PrivateCalculatorActivity extends Activity implements InputHappend{

	private CaOutputView cov;
	private ICalculator calModel;
	//通过一个字符串在连续输入数字时将数字连在一起 eg."8"+"8"="88"
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
		//对首位为“0”作处理
		number = number.equals("0")?operand:number+operand;
		//当回调函数执行时，在CaOutputView中显示,输入运算数时只需要显示
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
		//输入操作符时先将“累计”的number压入栈再将自己压入
		calModel.pushOperand(number);
		double result = calModel.pushOperate(operate);
		//如果是整数则消除小数点 8.0 -> 8
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
