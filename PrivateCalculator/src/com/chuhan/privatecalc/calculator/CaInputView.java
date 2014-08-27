package com.chuhan.privatecalc.calculator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 获取计算器输入数字或运算符
 * @author lifen
 *
 */
public class CaInputView {

	/**
	 * 输入接口
	 * @author lifen
	 *
	 */
	public interface InputHappend {
		/**
		 * 当用户输入运算数时，通知你它输入“openrand”这个数字
		 * @param operand
		 */
		public void operandIn(String operand);
		/**
		 * 当用户输入操作符时，通知你它输入“openrate”这个操作符
		 * @param operate
		 */
		public void operateIn(String operate);
	}

	private List<Button> operands;
	private List<Button> operates;

	private CaInputView.InputHappend dlg;

	public CaInputView(Activity ac, CaInputView.InputHappend delegate) {
		dlg = delegate;
		operands = new ArrayList<Button>();
		operates = new ArrayList<Button>();
		//通过Resource类的getIdentifier方法获取相应资源
		Resources res = ac.getResources();
		for (int i = 0; i <= 9; i++) {
			if (i <= 5) {
				int id_operate = res.getIdentifier("Operate" + i, "id",
						ac.getPackageName());
				Button btn_operate = (Button) ac.findViewById(id_operate);
				Log.d("CalculatorActivity:", btn_operate.getText().toString());
				operates.add(btn_operate);

			}
			int id_operand = res.getIdentifier("Operand" + i, "id",
					ac.getPackageName());
			Button btn_operand = (Button) ac.findViewById(id_operand);
			Log.d("CalculatorActivity:", btn_operand.getText().toString());
			operands.add(btn_operand);
		}
		//为操作用户添加事件，当用户触发时，通知dlg，发生operandIn
		for (Button btn : operands) {
			btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Button cli_btn = (Button) v;
					String text = cli_btn.getText().toString();
					dlg.operandIn(text);

				}
			});
		}
		//为操作用户添加事件，当用户触发时，通知dlg，发生operateIn
		for (Button btn : operates) {
			btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Button cli_btn = (Button) v;
					String text = cli_btn.getText().toString();
					dlg.operateIn(text);

				}
			});
		}
	}

}
