package javapattern;

class Socket {
	public String give12Volt() {
		return "12";
	}
}

interface SocketAdapter{
	String give6Volt();
	String give3Volt();
}

class SocketClassAdapterImpl extends Socket implements SocketAdapter{
	@Override
	public String give6Volt(){
		Integer volt = Integer.parseInt(give12Volt());
		volt -= 6;
		return volt.toString();
	}
	
	@Override
	public String give3Volt() {
		Integer volt = Integer.parseInt(give12Volt());
		volt -= 9;
		return volt.toString();
	}
}

class SocketObjectAdapterImpl {
	Socket socket;
	public SocketObjectAdapterImpl() {
		socket = new Socket();
	}
	
	public String give6Volt(){
		Integer volt = Integer.parseInt(socket.give12Volt());
		volt -= 6;
		return volt.toString();
	}
	
	public String give3Volt() {
		Integer volt = Integer.parseInt(socket.give12Volt());
		volt -= 9;
		return volt.toString();
	}
	
}
public class AdapterPattern {
	public static void main(String[] args) {
		SocketClassAdapterImpl classAdapter = new SocketClassAdapterImpl();
		SocketObjectAdapterImpl objectAdapter = new SocketObjectAdapterImpl();
		System.out.println(" class adapter : "+classAdapter.give3Volt()+" volt");
		System.out.println(" object adapter : "+objectAdapter.give3Volt()+" volt");
	}
}
