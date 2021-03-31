import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z=0;z<t;z++){
        int n = sc.nextInt();
        String str = sc.next();
        Stack<Integer> stack  = new Stack<>();
        // initialize the stack by -1
        stack.push(-1);
 
        // stores the length of the longest balanced parenthesis
        int len = 0;
 
        // iterate over the characters of the string
        for (int i = 0; i < str.length(); i++)
        {
            // if the current character is an opening parenthesis,
            // push its index in the stack
            if (str.charAt(i) == '<') {
                stack.push(i);
            }
 
            // if the current character is a closing parenthesis
            else {
                // pop the top index from the stack
                stack.pop();
 
                // if the stack becomes empty, push the current index into the stack
                if (stack.empty())
                {
                    stack.push(i);
                    continue;
                }
 
                // get length of the longest balanced parenthesis ending at the
                // current character
                int curr_len = i - stack.peek();
 
                // update the length of the longest balanced parenthesis
                if (len < curr_len) {
                    len = curr_len;
                }
            }
        }
        System.out.println(len);
      }
    }
  }
