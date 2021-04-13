package javapattern;

interface Computer{
	String getRAM();
}
class Desktop implements Computer{
	@Override
	public String getRAM() {
		return "8GB";
	}
}

class Laptop implements Computer{
	@Override
	public String getRAM() {
		return "4GB";
	}
}

//abstract factory memebers
interface AbstractFactory {
	Computer newComputerInstance();
	
}
class DesktopFactory implements AbstractFactory{
	@Override
	public Computer newComputerInstance() {
		return new Desktop();
	}
}

class LaptopFactory implements AbstractFactory{
	@Override
	public Computer newComputerInstance() {
		return new Laptop();
	}
}



public class FactoryPattern {
	//Factory method
	public static Computer getComuputerInstance(String type) {
		if( type.equalsIgnoreCase("desktop")) {
			return new Desktop();
		}else {
			return new Laptop();
		}
	}
	
	//abstract factory method
	public static Computer getAbstractComuputerInstance(AbstractFactory factory) {
		return factory.newComputerInstance();
	}
	
	public static void main(String[] args) {
		System.out.println("Factory pattern ");
		//factory pattern
		Computer desktopObj = getComuputerInstance("desktop");
		Computer laptopObj = getComuputerInstance("laptop");
		System.out.println("Desktop RAM : "+desktopObj.getRAM());
		System.out.println("Laptop RAM : "+laptopObj.getRAM());
		
		System.out.println();
		System.out.println("Abstract Factory pattern ");
		//abstract factory pattern
		Computer abstractDesktopObj = getAbstractComuputerInstance(new DesktopFactory());
		Computer abstractLaptopObj = getAbstractComuputerInstance(new LaptopFactory());
		System.out.println("Desktop RAM : "+abstractDesktopObj.getRAM());
		System.out.println("Laptop RAM : "+abstractLaptopObj.getRAM());
	}
}
