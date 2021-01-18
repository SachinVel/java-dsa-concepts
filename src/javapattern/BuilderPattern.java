package javapattern;


class PC{
	
	//required parameters
	private String HDD;
	private String RAM;
	
	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	private PC(PCBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	@Override
	 public String toString() {
		 return "HDD : "+this.HDD+" RAM : "+this.RAM;
	 }
	
	
	//Builder Class
	public static class PCBuilder{

		// required parameters
		private String HDD;
		private String RAM;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		public PCBuilder(String hdd, String ram){
			this.HDD=hdd;
			this.RAM=ram;
		}

		public PCBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public PCBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public PC build(){
			return new PC(this);
		}

	}

}

public class BuilderPattern {
	public static void main(String[] args) {
		PC pcObj = new PC.PCBuilder("500GB","6GB").setGraphicsCardEnabled(true).build();
		System.out.println("Computer details : "+pcObj);
	}
}
