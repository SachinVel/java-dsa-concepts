package javapattern;

import java.util.ArrayList;

//directory and text file structure like

//Base Component interface
interface SingleFileUnit{
	void readFile();
}
class TextFile implements SingleFileUnit{
	String fileName;
	public TextFile(String fileName) {
		this.fileName = fileName;
	}
	public void readFile() {
		System.out.println("File : "+fileName+" is read");
	}
}
class Folder implements SingleFileUnit{
	ArrayList<SingleFileUnit> children = new ArrayList<SingleFileUnit>();
	
	public void addChild(SingleFileUnit singleFileUnit ) {
		children.add(singleFileUnit);
	}
	
	public void readFile() {
		for( SingleFileUnit fileUnit : children) {
			fileUnit.readFile();
		}
	}
	
}
public class CompositePattern {
	public static void main(String[] args) {
		Folder rootFolder = new Folder();
		TextFile a = new TextFile("a");
		Folder subFolder = new Folder();
		rootFolder.addChild(a);
		rootFolder.addChild(subFolder);
		TextFile b = new TextFile("b");
		TextFile c = new TextFile("c");
		subFolder.addChild(b);
		subFolder.addChild(c);
		
		rootFolder.readFile();
	}
	
}
