import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z=0;z<t;z++){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for (int i=0;i<n;i++){
          pQueue.add(arr[i]);
          if (pQueue.size()>k){
            pQueue.remove();
          }
        }

        System.out.println(pQueue.peek());
      }
    }
  }
