import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		while(t-- >0){
		    
		    int m = s.nextInt();
		    int n = s.nextInt();
		    System.out.println(paths(m,n));
		    
		}
		
	}
	
	
	static int paths(int m, int n){
	        
	        if(m==1 || n==1){
	            
	            return 1;
	        }
	        return paths(m-1,n)+paths(m,n-1);
	        
	        
	        
	        
	    }
		
}
