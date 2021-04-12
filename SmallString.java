/** Tina's grandfather gifted her a tressure box which can only be opened by entering a string say S formed by another string say str written on top of the box with an integer q. Tina can get the required string S by performing following operations on the string str

    Take any character from the first q

 characters of str and append it to S
.
Remove the chosen character from str
.
Repeat the above steps while there are characters left in str

    .

Tressure box will open only if the string S

 formed is lexicographically smallest possible.
Help Tina in forming such a string.

Note - Use heap concepts to solve the problem.
Input Format

The first line contains an integer T
 denoting the number of test cases.
For each test case a string str and an integer q

 is provided.
Output Format

For each test case print the string S

 formed.
Constraints

1<=T<=10

1<=q<=str.length<=26

Time Limit

0.5

 second
Example
Sample Input

2
jktfc 2
trnqf 3
Sample Output

jkfct
nqfrt
Sample test case explanation

For test case one:
q=2

jktfc

 , we can select only the first two elements and the final string should be lexicographically smallest possible.

S = j		and	str = ktfc
S = jk		and	str = tfc
S = jkf	and	str = tc
S = jkfc	and	str = t

S=jkfct
 **/

import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z=0;z<t;z++){
        String str = sc.next();
        int k = sc.nextInt();
        PriorityQueue<Character> pQueue = new PriorityQueue<Character>();
        String S = "";
        int i;
        int n = str.length();
        int min = Math.min(k, n);
  
        for (i=0;i<min;i++)
            pQueue.add(str.charAt(i));
  
        while (!pQueue.isEmpty()) 
        {
            S += pQueue.peek();
            pQueue.remove();
  
            if (i<str.length())
                pQueue.add(str.charAt(i));
                  
            i++;
        }
        System.out.println(S);
      }
  }
  }


