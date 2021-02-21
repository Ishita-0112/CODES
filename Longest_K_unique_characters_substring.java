/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int z=0;z<t;z++){
		    String str = sc.next();
		    int k = sc.nextInt();
		    char[] arr = str.toCharArray(); 
		    int i=0; int j=0; int max=Integer.MIN_VALUE;
		    Map<Character,Integer> map = new HashMap<>();
		    
		    while (j<arr.length){
		        if(map.containsKey(arr[j])){
                    map.put(arr[j],map.get(arr[j])+1);
                }
                else{
                    map.put(arr[j],1);
                }
                if (map.size()<k){
                    j++;
                }
                else if (map.size()==k){
                    max = Math.max(max,j-i+1);
                    j++;
                }
                else if (map.size()>k){
                    while (map.size()>k){
                        map.put(arr[i],map.get(arr[i])-1);
                        if ((int)map.get(arr[i]) == 0){
                            map.remove(arr[i],map.get(arr[i]));
                         }
                         i++;
                    }
                    j++;
                }
                

		    }
		    if (max<=0)
		    System.out.println(-1);
		    else
		    System.out.println(max);
		    
		}
	}
}
