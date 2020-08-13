/* Print a sequence of numbers starting with N, without using loop, in which  A[i+1] = A[i] - 5,  if  A[i]>0, else A[i+1]=A[i] + 5  repeat it until A[i]=N.

Input:
The first line contains an integer T, number of test cases. Then following T lines contains an integer N.

Output:
For each test case, print the pattern in newline with space separated integers.

Constraints:
0< N < 10000

Example:
Input:
2
16
10
Output:
16 11 6 1 -4 1 6 11 16
10 5 0 5 10

Explanation:
We basically first reduce 5 one by one until we reach a negative or 0. After we reach 0 or negative, we one by one add 5 until we reach N. */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
     static void printPattern(int n) 
    { 
          
        // Base case (When n becomes 0 or  
        // negative) 
        if (n == 0 || n < 0) { 
              
            System.out.print(n + " "); 
              
            return; 
        } 
  
        // First print decreasing order 
        System.out.print(n + " "); 
          
        printPattern(n - 5); 
  
        // Then print increasing order 
        System.out.print(n + " "); 
    } 
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0;i<n;i++){
		    int t = sc.nextInt();
		    printPattern(t);
		    System.out.println();
		}
	}
}
