//应用栈对表达式求值

package 数据结构;

import java.util.Stack;
import java.util.Scanner;

public class EvaluateExpression {

	public static void main(String[] args) {
		// 检查字符串
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一个表达式： ");
		String expression = input.nextLine();
		try {
			System.out.println(evaluateExpression(expression));
		} catch (Exception ex) {
			System.out.println("Wrong expression: "+expression);
		}
	}
	
	//表达式的分析
	public static int evaluateExpression(String expression) {
		//创建操作数堆栈以存储操作数
		Stack<Integer> operandStack = new Stack<>();
		
		//创建运算符堆栈以存储运算符
		Stack<Character> operatorStack = new Stack<>();
		
		//为操作符几括号之间添加空格(为split以空格提取单个字符做出准备)
		expression = insertBlanks(expression);
		
		//提取被空格隔开的操作符、操作数及括号（以空格作为分隔符）
		String[] tokens = expression.split(" ");
		
		//遍历tokens数组
		for (String token: tokens) {
			
			//如果标记为空，就跳过这轮循环
			if (token.length() == 0) {
				continue;
			}
			
			//如果标记是一个"+"或"-"操作符，处理operatorStack栈顶的所有操作符
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				while (!operatorStack.isEmpty()&&
						(operatorStack.peek() == '+'||
						 operatorStack.peek() == '-'||
						 operatorStack.peek() == '*'||
						 operatorStack.peek() == '/')) {
					processAnOperator(operandStack,operatorStack);
				}
				//处理完成后将"+"或"-"操作符压入operatorStack栈中
				operatorStack.push(token.charAt(0));
			}
			
			//如果标记是一个"("括号，将其压入operatorStack栈中
			else if (token.trim().charAt(0) == '(') {
				operatorStack.push('(');
			}
			
			/*如果标记是一个")"括号，处理operatorStack栈中的操作符，直到遇见")"为止
			并将"("弹出栈*/
			else if (token.trim().charAt(0) == ')') {
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop();
			}
			
			//如果标记是一个"*"或"/"操作符，处理operatorStack栈顶的所有"*"或"/"操作符
			else if (token.charAt(0) == '*'||token.charAt(0) == '/') {
				while (!operatorStack.isEmpty() && (
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
			
			//如果标记是一个操作数，则将其压入operandStack栈中
			else {
				operandStack.push(new Integer(token));
			}
		}
		
		//在考虑完所有完所有的操作数后，处理operatorStack栈剩余的操作数
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		
		//返回计算结果
		return operandStack.pop();
	}
	
	/*用来处理操作数的方法，该方法从operatorStack中取出一个操作符，并从operandStack取出
	两个操作数来进行运算，并将结果压入operandStack中*/
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
	
    //用来给字符串中添加空格
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
