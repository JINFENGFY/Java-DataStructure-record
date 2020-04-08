//Ӧ��ջ�Ա��ʽ��ֵ

package ���ݽṹ;

import java.util.Stack;
import java.util.Scanner;

public class EvaluateExpression {

	public static void main(String[] args) {
		// ����ַ���
		Scanner input = new Scanner(System.in);
		System.out.print("������һ�����ʽ�� ");
		String expression = input.nextLine();
		try {
			System.out.println(evaluateExpression(expression));
		} catch (Exception ex) {
			System.out.println("Wrong expression: "+expression);
		}
	}
	
	//���ʽ�ķ���
	public static int evaluateExpression(String expression) {
		//������������ջ�Դ洢������
		Stack<Integer> operandStack = new Stack<>();
		
		//�����������ջ�Դ洢�����
		Stack<Character> operatorStack = new Stack<>();
		
		//Ϊ������������֮����ӿո�(Ϊsplit�Կո���ȡ�����ַ�����׼��)
		expression = insertBlanks(expression);
		
		//��ȡ���ո�����Ĳ������������������ţ��Կո���Ϊ�ָ�����
		String[] tokens = expression.split(" ");
		
		//����tokens����
		for (String token: tokens) {
			
			//������Ϊ�գ�����������ѭ��
			if (token.length() == 0) {
				continue;
			}
			
			//��������һ��"+"��"-"������������operatorStackջ�������в�����
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				while (!operatorStack.isEmpty()&&
						(operatorStack.peek() == '+'||
						 operatorStack.peek() == '-'||
						 operatorStack.peek() == '*'||
						 operatorStack.peek() == '/')) {
					processAnOperator(operandStack,operatorStack);
				}
				//������ɺ�"+"��"-"������ѹ��operatorStackջ��
				operatorStack.push(token.charAt(0));
			}
			
			//��������һ��"("���ţ�����ѹ��operatorStackջ��
			else if (token.trim().charAt(0) == '(') {
				operatorStack.push('(');
			}
			
			/*��������һ��")"���ţ�����operatorStackջ�еĲ�������ֱ������")"Ϊֹ
			����"("����ջ*/
			else if (token.trim().charAt(0) == ')') {
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop();
			}
			
			//��������һ��"*"��"/"������������operatorStackջ��������"*"��"/"������
			else if (token.charAt(0) == '*'||token.charAt(0) == '/') {
				while (!operatorStack.isEmpty() && (
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
			
			//��������һ��������������ѹ��operandStackջ��
			else {
				operandStack.push(new Integer(token));
			}
		}
		
		//�ڿ��������������еĲ������󣬴���operatorStackջʣ��Ĳ�����
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		
		//���ؼ�����
		return operandStack.pop();
	}
	
	/*��������������ķ������÷�����operatorStack��ȡ��һ��������������operandStackȡ��
	�������������������㣬�������ѹ��operandStack��*/
	private static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		
		if (op == '+') 
			operandStack.push(op1+op2);
		else if (op == '-')
			operandStack.push(op2-op1);
		else if (op == '*')
			operandStack.push(op2*op1);
		else if (op == '/')
			operandStack.push(op2/op1);
	}
	
    //�������ַ�������ӿո�
	private static String insertBlanks(String expression) {
		String result = "";
		
		for (int i=0;i<expression.length();i++) {
			if (expression.charAt(i) == '(' ||
				expression.charAt(i) == ')' ||
				expression.charAt(i) == '+' ||
				expression.charAt(i) == '-' ||
				expression.charAt(i) == '*' ||
				expression.charAt(i) == '/')
				result += " "+expression.charAt(i)+" ";
			else 
				result += expression.charAt(i);
		}
		return result;
	}
}
