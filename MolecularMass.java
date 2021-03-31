import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      String formula = sc.next();
      Stack<Integer> stk = new Stack<>();
      for (int i=0;i<formula.length();i++){
        if (formula.charAt(i)=='(')
        stk.push(-1);
        else if (formula.charAt(i)==')'){
          int z = 0;
          while (stk.peek()!=-1 && !stk.empty()){
            z += stk.peek();
            stk.pop();
          }
          
          stk.pop();
          stk.push(z);
        }
        else if (Character.isDigit(formula.charAt(i))){
          int n = Character.getNumericValue(formula.charAt(i));
          int z = stk.peek();
          stk.pop();
          stk.push(z*n);
        }
        else{
          if (formula.charAt(i) =='C')
            stk.push(12);
          else if (formula.charAt(i) =='O')
            stk.push(16);
          else
            stk.push(1);
        }
        
      }
      int sum = 0;
      while (!stk.empty()){
        sum+= stk.pop();
        
      }
      System.out.println(sum);
    }
  }
