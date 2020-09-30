package LCS;

public class LCS {
	/* Solution By Jayit Saha
	   LCS stands for longest common subsequence. It's a beginner dynamic programming problem. 
	 * In order to understand this problem, one must understand how does the dynamic
	 * programming work. One way to learn this is to use a table to represent this problem. 
	 * This will be further explained later in the text. The purpose of dynamic programming 
	 * problem is to divide problem into subproblems and work from the bottom up. For instance, 
	 * the fibonacci number problem is a very common recurrsion problem where previously
	 * computed data is being used to calculate the current data. For instance,
	 * 
	 *  //This is a fibonacci method using recursion.
	 *  public int fibonacci (int  n){
	 *  	if(n == 0) return 0;
	 *  	else if (n == 1) return 1;
	 *  	else return fibonacci(n-1) + fibonacci(n+2);
	 *  } 
	 *  
	 *  Since this is a recursive function, a lot of data are being computed over and over again
	 *  during each recursive call, which is very redundant. We might be better off using a for loop.
	 *  
	 *  public int fibonacci(int n){
	 *  	int a=0 ,b=1;
	 *  	for(int i = 2; i < n; i++){
	 * 			b = a + b; 
	 * 			a = b-a;
	 *  	}
	 *  
	 *  }
	 *  
	 *  Now for the Least Common Subsequence problem, we will be using a lot of the previously computed
	 *  data to compute the current value and the way to keep track of all the data is to use a table.
	 *  For instance, we want to find the longest common subsequence of the following strings.
	 *  str1 = "ABCBDAB"
	 *  str2 = "BDCABA"
	 *  
	 *  Then we use the following table to help us calculate the answer:
	 *  
	 *  		A	B	C	B	D	A	B
	 *		
	 *		0	0	0	0	0	0	0	
	 *  
	 *  B	0	0	1*	1	1	1	1	1	
	 *  
	 *  D	0	0	1	1	1	2	2	2		
	 *  
	 *  C	0	0	1	2	2*	2	2	2	
	 *  	
	 *  A	0	1	1	2	2	2	3	3	
	 *  
	 *  B	0	1	2	2	3	3	3*	4	
	 *  
	 *  A	0	1	2	2	3	3	4	4*	
	 *  
	 *  
	 *  To fill out this table, follow these three steps
	 *  1) Fill out the first row and the first column with zeros.
	 *  2) For each cell, check if the character on the left and the character above are the same
	 *  	a. If they are the same, grab the number on the above left cell and add 1 to it.
	 *  	b. If they are not the same, compare two numbers from the cell to the left and the
	 *  	   cell above, then record the maximum number. 
	 *  3) The number in the last cell will be the maximum longest common subsequence.
	 *  
	 *  As we can check the answer by looking at the strings. The answers are
	 *  "BDAB", "BCAB", "BCBA"<-answer from the table, but they may be multiple answers.
	 *  
	 *  Now how do we code this? As we can see that to determine the number for each cell, we have to
	 *  refer back to the number of the previous cells, namely the cell to the left, the above cell,
	 *  and the above-left cell. We also have to follow the three steps above to determine the number 
	 *  to put in the cell. If we break it down, we'll see that we can use the recursion to represent
	 *  this three steps. 
	 *  1) If the length of either string is zero then return zero.
	 *  2) If the last character of both strings are the same, then determine the LCS of the (str1[:-1] and the str2[:-1]) + 1
	 *  3) If the last character of both strings are not the same, then pick the maximum LCS of both strings.
	 *  
	 *  The "*" in the table indicates the longest common subsequence string. To determine the location of the "*",
	 *  we look at the pivot point of the above-left cell. So starting from the last cell, it has a "*" because its above-left
	 *  cell has a differnt number as its cell and therefore it's a pivot point. so we put a "*" there. After we determine all the "*" in
	 *  the table, we can now read in it vertically starting from the top to bottom. So in answer in the table is "BCAB"
	 *  based on the string to the left.
	 *  
	 *  Below is the code for recursive function.
	 */
	public static void main(String [] args){
	
		System.out.println(LCS("ABCBDAB", "BDCABA"));
	
	}
	
	public static int LCS(String str1, String str2){
		//fill in the zeros
		if(str1.length() == 0 || str2.length() == 0)
			return 0;
		
		//Compare characters of the left cell and the above cell, if equals check the above-left cell and add 1
		else if (str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1))
			return LCS(str1.substring(0,str1.length()-1), str2.substring(0,str2.length()-1)) + 1;
		
		//Compare the left cell and the above cell and take the maximum
		else
			return Math.max(LCS(str1.substring(0,str1.length()-1), str2), LCS(str1, str2.substring(0,str2.length()-1)));
		
	}

	//return string instead of a number
	public static String LCS2(String str1, String str2){
		String s = "";
		if(str1.length() == 0 || str2.length() == 0)
			return "";
		
		else if (str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1)){
			return	s = LCS(str1.substring(0,str1.length()-1), str2.substring(0,str2.length()-1))+ (str1.charAt(str1.length()-1) +"");
		}
		
		else{
			String a = LCS(str1.substring(0,str1.length()-1), str2);
			String b = LCS(str1, str2.substring(0,str2.length()-1));
			return s = a.length() > b.length() ? a : b ;
		}
	}
	
	//output = 4
	
}
