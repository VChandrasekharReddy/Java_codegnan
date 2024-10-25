package fileexamples;

import java.io.File;

public class GetInfo {
	public static void main(String[] args) {
		File fo = new File("C:\\Users\\LENOVO\\Desktop\\fileexamples\\exp1.txt");
		if(fo.exists()) {
			//getting the name
			System.out.println(fo.getName());
			//get path
			System.out.println(fo.getAbsolutePath());
			//get id readable
			System.out.println(fo.canRead());
			//id writeable
			System.out.println(fo.canWrite());
			System.out.println(fo.length());
		}else System.out.println("not exist");
	}
}
