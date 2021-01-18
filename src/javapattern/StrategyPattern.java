package javapattern;

interface MathOperation{
	int doOperation(int num1,int num2);
}

class AddOperation implements MathOperation{
	@Override
	public int doOperation(int num1,int num2) {
		return num1+num2;
	}
}

class SubtractOperation implements MathOperation{
	@Override
	public int doOperation(int num1, int num2) {
		return num1-num2;
	}
}

class Context{
	MathOperation mathOperation;
	
	public Context(MathOperation mathOperation) {
		this.mathOperation = mathOperation;
	}
	
	public int doOperation(int num1,int num2) {
		return mathOperation.doOperation(num1, num2);
	}
}

public class StrategyPattern {
	public static void main(String[] args) {
		Context addContext = new Context(new AddOperation());
		Context subtractContext = new Context(new SubtractOperation());
		
		System.out.println("add operation : "+addContext.doOperation(2, 2));
		System.out.println("subtract operation : "+subtractContext.doOperation(2, 2));
	}
}
