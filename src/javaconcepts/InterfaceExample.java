package javaconcepts;

interface DefaultMethodInterface{
	void square(int sideLen);
	default void circle(int radius) {
		System.out.println("circleArea : "+Math.PI*radius*radius); 
	}
	public static void triangle(int height,int breadth) {
		System.out.println("triangleArea : "+0.5*height*breadth);
	}
}

interface functionalInterface{
	int squareArea(int sideLen);
}

class MethodReferenceClass{
	public static int someMethod(int sideLen) {
		return sideLen*sideLen;
	}
}
public class InterfaceExample {
	public static void main(String[] args) {
		
		//lambda expression
		functionalInterface funImpl = (sideLen)->{
			return sideLen*sideLen;
		};
		

		//Method reference
		functionalInterface funImpl2 = MethodReferenceClass::someMethod;
		
		System.out.println("lambda : "+funImpl.squareArea(10));
		
		System.out.println("method reference : "+funImpl.squareArea(10));
	}
}
