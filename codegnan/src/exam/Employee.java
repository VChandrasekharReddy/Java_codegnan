package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		Map<Integer,String>emp = new HashMap<>();
		for(int i =0;i<3;i++) {
			int empid = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			emp.put(empid,name);
		}
		System.out.print("enter the id of the emp : -");
		int id = sc.nextInt();
		if(emp.containsKey(id)) {
			System.out.println(emp.get(id));
		}
		else System.out.println("not in the map");
	}
	
}
