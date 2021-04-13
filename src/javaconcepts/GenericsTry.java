package javaconcepts;

import java.util.ArrayList;
import java.util.List;

class Container<T> 
{
	T obj;
	public Container(T obj) {
		this.obj = obj;
	}
	public T getObject() {
		return this.obj;
	}
}

public class GenericsTry {
	
	//generic function 
	public static <T extends Number> void genericDisplay(T obj) {
		System.out.println("generic object value : "+obj);
	}
	
	public static void main(String[] args) {
		//generic class
		Integer num = 2;
		Container<? extends Number> container = new Container(num);
		num = (Integer)container.getObject();
		Class<String> stringClassName = String.class;
		
		
		List<? extends Object> list = new ArrayList<String>();
		String str = "sachin";
		list.get(0);
		
		//generic method
//		genericDisplay("sachin");
		genericDisplay(11);
		genericDisplay(12.01);
		
		
		
	}
}
