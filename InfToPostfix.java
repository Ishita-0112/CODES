import java.util.*;
  import java.io.*;
  
  public class Main {
    
    static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
          return 1;
        case '-':
            return 2;
       
        case '*':
          return 3;
        case '/':
            return 4;
       
        case '^':
            return 5;
        }
        return -1;
    }
    
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z=0;z<t;z++){
        String str = sc.next();
        
        String result = new String("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<str.length(); ++i)
        {
            char c = str.charAt(i);
              
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
               
            // If the scanned character is an '(', 
            // push it to the stack.
            else if (c == '(')
                stack.push(c);
              
            //  If the scanned character is an ')', 
            // pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && 
                        stack.peek() != '(')
                    result += stack.pop();
                  
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) 
                         <= Prec(stack.peek())){
                    
                    result += stack.pop();
             }
                stack.push(c);
            }
       
        }
       
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            result += stack.pop();
         }
        System.out.println(result);
      }
    }
  }
