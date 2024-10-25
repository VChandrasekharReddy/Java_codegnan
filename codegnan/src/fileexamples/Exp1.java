package fileexamples;

import java.io.File;
import java.io.IOException;

public class Exp1 {
	public static void main(String[] args) {
		File fo = new File("C:\\Users\\LENOVO\\Desktop\\fileexamples\\exp1.txt");
		try {
			if(fo.createNewFile()) {
				System.out.println("created ....");
			}
			else System.out.println("already exist...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
