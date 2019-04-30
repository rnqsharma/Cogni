package p1;

public class FileDetails {
	
	static String str="";
	static String ext="";
	public static void setContent(String str1){
		str = str1;
	}
	
	public static String getContent(){
		return str;
	}
	public static void setExtension(String str1){
		ext = str1;
	}
	
	public static String getExtension(){
		return ext;
	}

}
