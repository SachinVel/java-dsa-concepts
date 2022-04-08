package string;

public class RegexHandler {
	public static void main(String args[]) {
		String str = "assd;';;;,asd";
		System.out.println("asd : "+str.replaceAll("\\p{Punct}", ""));
	}
}
