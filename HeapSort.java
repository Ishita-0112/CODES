import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z=0;z<t;z++){
        int n = sc.nextInt();
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for (int i=0;i<n;i++){
          int p = sc.nextInt();
          pQueue.add(p);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            {
              int x = pQueue.peek();
              arr.add(x);
              pQueue.remove();
            }
            Collections.reverse(arr);
        for (int o : arr) {
      System.out.print(o+" ");
    }
        System.out.println();
      }
    }
  }
