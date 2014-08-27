package com.chuhan.privatecalc.calculator;

import java.util.Stack;
/**
 * ������ģ��
 * @author lifen
 *
 */
public class CalModel implements ICalculator{
	
	/**
	 * �������㷨
	 * @param stack
	 * @return
	 */
	public static double popOpOffStack(Stack<String> stack){
		
		double result = 0;
		double operand = Double.valueOf(stack.pop());
		//��ջ�л�ȡԪ�ؼ���ջ�ѿգ���ֱ�ӷ���operand
		if(stack.isEmpty()){
			return operand;
		}
		
		//������ջ�л�ȡ�����������ݲ��������ͼ����ݹ����
		String operate = stack.pop();
		if(operate.equals("+")){
			result = CalModel.popOpOffStack(stack)+operand;
		}
		else if(operate.equals("-")){
			result = CalModel.popOpOffStack(stack)-operand;
		}
		else if(operate.equals("x")){
			result = CalModel.popOpOffStack(stack)*operand;
		}
		else if(operate.equals("��")){
			result = CalModel.popOpOffStack(stack)/operand;
		}
		
		return result;
	}
	
	//��¼������������Ͳ�������ջ
	private Stack<String> dataStack = new Stack<String>();
	//�Ƿ������������������������������������Ϊ���������滻
	private boolean isOperate = false;

	@Override
	public void pushOperand(String operand) {
		//������������ʱֱ��ѹ��stack�����ᴥ������
		dataStack.add(operand);
		isOperate = false;
	}

	@Override
	public double pushOperate(String operate) {
		//���������ǡ�+��-��X���¡�ʱ���������
		//����copyһ�ݵ�ǰջ��������Ϊ����������м��㲢����
		//���������ǡ�=����ʱ����ֱ��ʹ�õ�ǰջ��Ϊ���� 
		//��Ϊ��=������ζ֮����Ҫ��������
		double result = 0;
		if(isOperate){
			//�����ǰ��һ���������������滻
			dataStack.pop();
		}
		if(operate.equals("=")){
			result = CalModel.popOpOffStack(dataStack);
		}
		else{
			Stack<String> tmpStack = (Stack<String>)dataStack.clone();
			result = CalModel.popOpOffStack(tmpStack);
			//������ǰ����������������ѹ��ջ
			dataStack.add(operate);
			isOperate = true;
		}
		return result;
	}

	@Override
	public void reset() {
		dataStack.removeAllElements();
		isOperate = false;
		
	}

}
