package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraylsitExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> names = new ArrayList<>();
		int n = 5;
		for (int i=0 ; i<n ; i++)
		{
			names.add(sc.nextLine());
			}
		for(int j =4;j>=0;j--) {
			System.out.print(names.get(j)+","); 
		}
		}

}
