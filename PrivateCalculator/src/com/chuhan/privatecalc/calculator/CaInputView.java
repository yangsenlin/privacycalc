package com.chuhan.privatecalc.calculator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * ��ȡ�������������ֻ������
 * @author lifen
 *
 */
public class CaInputView {

	/**
	 * ����ӿ�
	 * @author lifen
	 *
	 */
	public interface InputHappend {
		/**
		 * ���û�����������ʱ��֪ͨ�������롰openrand���������
		 * @param operand
		 */
		public void operandIn(String operand);
		/**
		 * ���û����������ʱ��֪ͨ�������롰openrate�����������
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
		//ͨ��Resource���getIdentifier������ȡ��Ӧ��Դ
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
		//Ϊ�����û�����¼������û�����ʱ��֪ͨdlg������operandIn
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
		//Ϊ�����û�����¼������û�����ʱ��֪ͨdlg������operateIn
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
