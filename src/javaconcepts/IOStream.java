package javaconcepts;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOStream {
	private static String FileLocation = "resources/sample.txt";
	private static String FileLocation2 = "resources/sample2.txt";
	
	public static int readByteStreamInt() {
		return -1;
	}
	
	public static void fileOutputStream(String content) {
		
		byte bytes[] = content.getBytes();
		try (FileOutputStream fileOutputStream = new FileOutputStream(FileLocation)){
			//has option to specific area of buffer
			fileOutputStream.write(bytes);
		}catch (Exception e) {
			System.out.println("Error in FileOutputStream : "+e);
		}
		
	}
	
	public static void fileInputStream() {
		try (FileInputStream fileInputStream = new FileInputStream(FileLocation)){
			int b;
			while( (b=fileInputStream.read())!=-1 ) {
				System.out.print((char)b);
			}
		}catch (IOException e) {
			System.out.println("Error in FileInputStream : "+e);
		}	
	}
	
	public static void fileWriter(String content) {
		try (FileWriter fileWriter = new FileWriter(FileLocation)){
			fileWriter.write(content);
		}catch (IOException e) {
			System.out.println("Error in fileWriter : "+e);
		}	
	}
	
	public static void fileReader(){
		try(FileReader fileReader = new FileReader(FileLocation) ){
			//does not have read(buffer) option
			int b;
			while( (b=fileReader.read())!=-1 ) {
				System.out.print((char)b);
			}
		}catch (IOException e) {
			System.out.println("Error in fileReader : "+e);
		}
	}
	
	public static void bufferedOutputStream(String content) {
		byte bytes[] = content.getBytes();
		try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FileLocation))){
			bufferedOutputStream.write(bytes);
		}catch (Exception e) {
			System.out.println("Error in FileOutputStream : "+e);
		}	
	}
	
	public static void bufferedInputStream() {
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FileLocation))){
			int b;
			while( (b=bufferedInputStream.read())!=-1 ) {
				System.out.print((char)b);
			}
		}catch (IOException e) {
			System.out.println("Error in FileInputStream : "+e);
		}	
	}
	
	public static void bufferedWriter(String content) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileLocation))){
			bufferedWriter.write(content);
		}catch (Exception e) {
			System.out.println("Error in FileOutputStream : "+e);
		}	
	}
	
	public static void bufferedReader() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FileLocation))){
			int b;
			while( (b=bufferedReader.read())!=-1 ) {
				System.out.print((char)b);
			}
		}catch (IOException e) {
			System.out.println("Error in FileInputStream : "+e);
		}	
	}
	
	static class Dog implements Serializable{
		String name;
		int weight;
		transient static int legs;
		public String toString() {
			return "name : "+name+" weight : "+weight+" legs : "+legs;
		}
		Dog(String name, int weight){
			this.name = name;
			this.weight = weight;
			legs = 4;
		}
	}
	
	public static void objectInputStream() {
		try( ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(FileLocation))){
			Dog dog = (Dog)objInputStream.readObject();
			System.out.println(dog);
		}catch (Exception e) {
			System.out.println("Error in objectInputStream : "+e);
		}	
	}
	
	public static void objectOutputStream() {
		try( ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(FileLocation))){
			Dog dog = new Dog("rot-weiler", 100);
			objOutputStream.writeObject(dog);
		}catch (Exception e) {
			System.out.println("Error in objectInputStream : "+e);
		}	
	}
	
	public static void main(String[] args) throws IOException{
		
		FileReader fileInputCharStream = new FileReader(FileLocation);
		FileWriter fileOutputCharStream = new FileWriter(FileLocation2);
		
		RandomAccessFile raf = new RandomAccessFile(FileLocation, "rw");
		
		FileChannel fileChannel = raf.getChannel();
		
		try {
		
			objectOutputStream();
			objectInputStream();
			
			
//			raf.seek(1);//measured in bytes
//			raf.write("Data".getBytes());
			
			/* using fileChannel to write at end position and read from it */ 

//			fileSize = fileChannel.size();
//			String anotherMsg = "message at end\n";
//			ByteBuffer byteBuffer = ByteBuffer.allocate(40);
//			byteBuffer.clear();
//			byteBuffer.put(anotherMsg.getBytes());
//			byteBuffer.flip();
//			fileChannel.position(fileSize+1);
//			fileChannel.write(byteBuffer);
//			while( byteBuffer.hasRemaining() ) {
//				fileChannel.write(byteBuffer);
//			}
//			fileChannel.force(false);
//			byteBuffer.clear();
//			fileChannel.position(0);
//			while ( fileChannel.read(byteBuffer)>0 ) {
//				byteBuffer.flip();
//				for (int i = 0; i < byteBuffer.limit(); i++)
//	            {
//	                System.out.print((char) byteBuffer.get());
//	            }
//				byteBuffer.clear();
//			}
			
			
		}finally {
			
			if( fileInputCharStream!=null ) {
				fileInputCharStream.close();
			}
			if( fileOutputCharStream!=null ) {
				fileOutputCharStream.close();
			}
			if( raf!=null ) {
				raf.close();
			}
			fileChannel.close();
		}
		
		
	}
}
