import java.util.*;
  import java.io.*;
  
  public class Main {
    public static boolean isNumeric(String str) {
      return str.matches("-?\\d+(\\.\\d+)?"); 
    }
    
    static int evaluatePostfix(String[] arr)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();
          
        // Scan all characters one by one
        for(int i=0;i<arr.length;i++)
        {
            String c=arr[i];
              
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(isNumeric(c))
            stack.push(Integer.parseInt(c));
              
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                  
                switch(c)
                {
                    case "+":
                    stack.push(val2+val1);
                    break;
                      
                    case "-":
                    stack.push(val2- val1);
                    break;
                      
                    case "/":
                    stack.push(val2/val1);
                    break;
                      
                    case "*":
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop();    
    }
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String[] arr = new String[n];
      for (int i=0;i<n;i++){
        arr[i] = sc.next();
      }
      //System.out.println(str);
      System.out.println(evaluatePostfix(arr));
    }
  }
