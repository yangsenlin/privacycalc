package com.chuhan.privatecalc.calculator;

/**
 * ���������ģ�͵Ľӿ�Լ��
 * @author lifen
 *
 */
public interface ICalculator {
	
	/**
	 * ���ܲ���������
	 * @param operand
	 */
	public void pushOperand(String operand);
	
	/**
	 * �������������
	 * @param operate
	 * @return
	 */
	public double pushOperate(String operate);
	
	/**
	 * ��������
	 */
	public void reset();
	
	
}
