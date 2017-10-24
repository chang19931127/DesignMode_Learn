package me.modedesign.create.factorysimple.demo1;

import java.util.Scanner;

import me.modedesign.create.factorysimple.demo1.clacluate.AddOperation;
import me.modedesign.create.factorysimple.demo1.clacluate.DelOperation;
import me.modedesign.create.factorysimple.demo1.clacluate.DivOperation;
import me.modedesign.create.factorysimple.demo1.clacluate.MulOperation;
import me.modedesign.create.factorysimple.demo1.clacluate.Operation;

/*
 * 不是面向对象版的计算器
 */
public class Program {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		Operation operation = new Operation();
		System.out.println("请选择运算符(+,-,*,/)：");
		char strOperation = scan.next().charAt(0);
		double result = 0;
		switch (strOperation) {
		case '+':
			operation = new AddOperation();
			result = ((AddOperation) operation).getResult();
			break;
		case '-':
			operation = new DelOperation();
			result = ((DelOperation) operation).getResult();
			break;
		case '*':
			operation = new MulOperation();
			result = ((MulOperation) operation).getResult();
			break;
		case '/':
			operation = new DivOperation();
			result = ((AddOperation) operation).getResult();
			break;
		default:
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(""+operation.getNum1() + strOperation + operation.getNum2() + "=" + result);
		// tranational();
	}

	/**
	 * @param strNumA
	 * @param strNumB
	 * @param strOperation
	 * @param result
	 * @author 43994897 传统的方式计算，没有面向对象的感觉，我们需要使用面向对象的编程方式 而不是面向过程的编程方式
	 */
	private static void tranational() {
		scan = new Scanner(System.in);
		System.out.println("请输入数字A：");
		String strNumA = scan.next();
		System.out.println("请选择运算符(+,-,*,/)：");
		char strOperation = scan.next().charAt(0);
		System.out.println("请输入数字B：");
		String strNumB = scan.next();
		double result = 0;
		switch (strOperation) {
		case '+':
			result = (new Double(strNumA) + new Double(strNumB));
			break;
		case '-':
			result = (new Double(strNumA) + new Double(strNumB));
			break;
		case '*':
			result = (new Double(strNumA) + new Double(strNumB));
			break;
		case '/':
			result = (new Double(strNumA) + new Double(strNumB));
			break;
		default:
			result = 0;
		}
		System.out.println(strNumA + strOperation + strNumB + "=" + result);
	}
}
