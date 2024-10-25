package jacaclass.day1;

public class Test {

	public static void main(String[] args) {
		int[] arr= {1,2,3,2,2,3,4};
		for( int i=0;i<arr.length;i++) {
			int c=0;
			for( int j=0;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					c++;
				}
			}
			if(c>1) {
				boolean b =true;
				for(int k=i+1;k<arr.length;k++) {
					if(arr[i]==arr[k]) {
						b=false;
						break;
					}
				}
				if(b)System.out.println(arr[i]);
			}
		}
	}
}
