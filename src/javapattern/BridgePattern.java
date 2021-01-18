package javapattern;
//Device is implementation classes
interface Device{
	void switchOn();
	void switchOff();
	boolean isDeviceOn();
}
class TV implements Device{
	boolean isDeviceOn = false;
	
	public void switchOn() {
		isDeviceOn = true;
		System.out.println("TV is switched on");
	}
	public void switchOff() {
		isDeviceOn = false;
		System.out.println("TV is switched off");
	}
	public boolean isDeviceOn() {
		return isDeviceOn;
	}
}

//Remote has abstraction of Device thus separating abstraction from implementation
class Remote{
	Device device;
	public Remote(Device device) {
		this.device = device;
	}
	
	public void pressPowerBtn() {
		if( device.isDeviceOn() ) {
			device.switchOff();
		}else {
			device.switchOn();
		}
	}
}
public class BridgePattern {
	public static void main(String[] args) {
		Remote tvRemote = new Remote(new TV());
		tvRemote.pressPowerBtn();
		tvRemote.pressPowerBtn();
		tvRemote.pressPowerBtn();
	}
}
