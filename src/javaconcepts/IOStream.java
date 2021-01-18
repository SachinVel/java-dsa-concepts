package javaconcepts;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class IOStream {
	private static String FileLocation = "resources/sample.txt";
	private static String FileLocation2 = "resources/sample2.txt";
	
	public static void main(String[] args) throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream(FileLocation);
		FileOutputStream fileOutputStream = new FileOutputStream(FileLocation2);
		
		FileReader fileInputCharStream = new FileReader(FileLocation);
		FileWriter fileOutputCharStream = new FileWriter(FileLocation2);
		
		RandomAccessFile raf = new RandomAccessFile(FileLocation, "rw");
		try {
			
			int c;
			
//			while( (c=fileInputStream.read())!=-1 ) {
//				fileOutputStream.write(c);
//				System.out.print(c); //prints bytes instead of original characters
//				System.out.print((char)c); //prints original characters
//			}
			
//			while( (c=fileInputCharStream.read())!=-1 ) {
//				fileOutputCharStream.write(c);
//				System.out.print(c); //prints bytes instead of original characters
//				System.out.print((char)c); //prints original characters
//			}
			
			
			raf.seek(1);//measured in bytes
			raf.write("Data".getBytes());
			
		}finally {
			if( fileInputStream!=null ) {
				fileInputStream.close();
			}
			if( fileOutputStream!=null ) {
				fileOutputStream.close();
			}
			if( fileInputCharStream!=null ) {
				fileInputCharStream.close();
			}
			if( fileOutputCharStream!=null ) {
				fileOutputCharStream.close();
			}
			if( raf!=null ) {
				raf.close();
			}
		}
		
		
	}
}
