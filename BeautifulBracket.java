import java.util.*;
  import java.io.*;
  
  public class Main {
    public static int findMinInversions(String exp)
    {
        // if the expression has an odd length, it cannot be balanced
        if (exp.length() % 2 == 1) {
            return Integer.MAX_VALUE;
        }
 
        int inversions = 0;         // stores total inversions needed
        int open = 0;               // stores the total number of opening braces
 
        // traverse the expression
        for (char c: exp.toCharArray())
        {
            // if the current character is an opening brace
            if (c == '{') {
                open++;
            }
 
            // if the current character is a closing brace
            else {
                // if an opening brace is found before, close it
                if (open != 0) {
                    open = open - 1;    // decrement opening brace count
                }
                // invert the closing brace, i.e., change `}` to `{`
                else {
                    inversions++;       // increment total inversions needed by 1
                    open = 1;           // increment opening brace count
                }
            }
        }
 
        // for `n` opened braces, exactly `n/2` inversions are needed
        return inversions + open / 2;
    }
 
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      
      ArrayList<String> arr = new ArrayList<>();
      
      v:
      while (true){
        String s = sc.next();
        if (s.charAt(0)=='-'){
          break v;
        }
        arr.add(s);
      }
      for (int i=0;i<arr.size();i++){
        String s = arr.get(i);
        System.out.println((i+1)+". "+findMinInversions(s));
      }
      
        
      }
    }
  
