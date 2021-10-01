import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String res = simplifyPath(str);
        System.out.println(res);
    }
 
     public static String simplifyPath(String A) {
         
    // Stack to store the file's names.
        Stack<String> st = new Stack<String>();
 
        // temporary String which stores the extracted
        // directory name or commands("." / "..")
        // Eg. "/a/b/../."
         
        // contains resultant simplifies String.
        String res = "";
 
        // every String starts from root directory.
        res += "/";
 
        // stores length of input String.
        int len_A = A.length();
 
        for (int i = 0; i < len_A; i++)
        {
 
            // we will clear the temporary String
            // every time to accomodate new directory
            // name or command.
            // dir will contain "a", "b", "..", ".";
            String dir = "";
 
            // skip all the multiple '/' Eg. "/////""
            while (i < len_A && A.charAt(i) == '/')
                i++;
 
            // stores directory's name("a", "b" etc.)
            // or commands("."/"..") into dir
            while (i < len_A && A.charAt(i) != '/')
            {
                dir += A.charAt(i);
                i++;
            }
 
            // if dir has ".." just pop the topmost
            // element if the Stack is not empty
            // otherwise ignore.
            if (dir.equals("..") == true)
            {
                if (!st.empty())
                    st.pop();    
            }
 
            // if dir has "." then simply continue
            // with the process.
            else if (dir.equals(".") == true)
                continue;
             
            // pushes if it encounters directory's
            // name("a", "b").
            else if (dir.length() != 0)
                st.push(dir);
        }
 
        // a temporary Stack (st1) which will contain
        // the reverse of original Stack(st).
        Stack<String> st1 = new Stack<String>();
        while (!st.empty())
        {
             
            st1.push(st.pop());
            // st.pop();
        }
         
 
        // the st1 will contain the actual res.
        while (!st1.empty())
        {
             
            // if it's the last element no need
            // to append "/"
            if (st1.size() != 1)
                res += (st1.pop() + "/");
            else
                res += st1.pop();
 
            // st1.pop();
        }
        return res; 
 
    }
    }
  
