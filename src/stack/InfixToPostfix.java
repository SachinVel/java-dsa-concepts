package stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class InfixToPostfix {
	public static boolean isLetterOrDigit(char c) {
		Pattern alphaNumericRegex = Pattern.compile("[a-zA-Z0-9]?");
		return alphaNumericRegex.matcher(String.valueOf(c)).matches();
	}
	public static int findPrecedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '/':
		case '*':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}
	public static String infixToPostfix(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuffer result = new StringBuffer();
		for( char c : str.toCharArray() ) {
			if( isLetterOrDigit(c) ) {
				result.append(c);
			}else if( c==')' ) {
				while( !stack.isEmpty() && stack.peek()!='('  ) {
					result.append(stack.pop());
				}
				stack.pop();
			}else if( c=='(' ) {
				stack.push(c);
			}else{
				while (!stack.isEmpty() && findPrecedence(c)<=findPrecedence(stack.peek())) {
					result.append(stack.pop());
				}
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result.append(stack.pop()); 
         } 
		return result.toString();
	}
	public static void main(String[] args) {
 		String infix = "a+b*(c^d-e)^(f+g*h)-i";
 		System.out.println(infixToPostfix(infix));
	}
}
