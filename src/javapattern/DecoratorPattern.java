package javapattern;


interface Shape{
	void draw();
}
class Circle implements Shape{
	public void draw() {
		System.out.println("circle is drawn");
	}
}
abstract class ShapeDecorator implements Shape{
	Shape shape;
	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}
}

class CircleDecorator extends ShapeDecorator{
	String fillColour;
	public CircleDecorator(Shape shape,String fillColour) {
		super(shape);
		this.fillColour = fillColour;
	}
	
	@Override
	public void draw() {
		System.out.println("Circle is drawn");
		System.out.println("circle is filled with "+fillColour+" colour");
	}
}
public class DecoratorPattern {
	public static void main(String[] args) {
		CircleDecorator circle = new CircleDecorator(new Circle(), "green");
		circle.draw();
	}
}
