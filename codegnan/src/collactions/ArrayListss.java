package collactions;

public class ArrayListss {
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 3, 4};
        for( int i=0 ; i<arr.length;i++) {
        	boolean d=false;
        	for(int j =i+1;j<arr.length;j++) {
        		if(arr[i]==arr[j]) {
        			d=true;
        			break;
        		}
        	}
        	if(d && i>0) {
        		boolean dd = true;
        		for(int k=i-1;k>0;k--) {
        			if(arr[i]==arr[k]) {
        				dd=false;
        				break;
        			}
        			if(dd) {
        				System.out.println(arr[i]);
        			}
        		}
        	}
        	else System.out.println(arr[i]);
        }
	}
}
