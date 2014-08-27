package com.chuhan.privatecalc.calculator;

/**
 * 定义计算器模型的接口约束
 * @author lifen
 *
 */
public interface ICalculator {
	
	/**
	 * 接受操作符输入
	 * @param operand
	 */
	public void pushOperand(String operand);
	
	/**
	 * 接受运算符输入
	 * @param operate
	 * @return
	 */
	public double pushOperate(String operate);
	
	/**
	 * 重置清零
	 */
	public void reset();
	
	
}
