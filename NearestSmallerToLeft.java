import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i=0;i<n;i++){
        arr[i] = sc.nextInt();
      }
      Stack<Integer> stk = new Stack<>();
      ArrayList<Integer> result = new ArrayList<>();
      for (int i=0;i<n;i++){
        if(stk.size()==0){
          result.add(-1);
        }
        else if (stk.size()>0 && stk.peek()<arr[i]){
          result.add(stk.peek());
        }
        else if (stk.size()>0 && stk.peek()>=arr[i]){
          while (stk.size()>0 && stk.peek()>=arr[i]){
            stk.pop();
          }
            if(stk.size()==0){
              result.add(-1);
            }
            else{
              result.add(stk.peek());
            }
        }
        stk.push(arr[i]);
      }
      for (int i = 0; i < result.size(); i++) {
        System.out.print(result.get(i)+" ");
      }
    }
  }
