class Solution {
    public String reverseStr(String s, int k) {
        int i=0;
        int n=s.length();
        char[] str=s.toCharArray();
        if(k>n)
        {
            reverse(str,i,n-1);
            return new String(str);
        }
        while(i<n)
        {
            if(n-i+1<k)
            {
                reverse(str,i,n-1);
                break;
                
            }
            else
            {
                reverse(str,i,i+k-1);
                i=i+2*k;
                
                
            }
            
        }
        return new String(str);
        
    }
    void reverse(char[] str,int i,int j)
    {
        while(i<=j)
        {
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            ++i;
            --j;
        }
    }
}
