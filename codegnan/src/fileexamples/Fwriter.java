package fileexamples;

import java.io.FileWriter;
import java.io.IOException;

public class Fwriter {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\LENOVO\\Desktop\\fileexamples\\exp1.txt");
		fw.write("I'm Chandrasekhar\n");
		fw.write("I'm Chandrasekhar\n");
		fw.write("I'm Chandrasekhar\n");
		fw.close();
		System.out.println("dun...");
	}
}
