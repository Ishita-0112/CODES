
class Solution {

    int search(String ptr, String s) {
        // code here
        int k = ptr.length();
		
		int i=0,j=0;
		
		HashMap<Character,Integer> mp = new HashMap<>();
		
		for(int m=0;m<k;m++)
		{
		    char c = ptr.charAt(m);
		    
		    if(mp.containsKey(c))
		    {
		        mp.put(c,mp.get(c)+1);
		    }
		    else{
		    mp.put(c,1);
		    }
		}
		int count = mp.size();
	    int ans = 0;
	    while(j<s.length())
	    {
	        char sc = s.charAt(j);
	        if(mp.containsKey(sc))
	        {
	            mp.put(sc,mp.get(sc)-1);
	            
	            if(mp.get(sc) == 0)
	            {
	                count--;
	            }
	        }
	        
	        if(j-i+1<k)
	        {
	            j++;
	        }
	        else if(j-i+1==k)
	        {
	            if(count==0)
	            {
	                ans++;
	                //System.out.println(s.substring(i,j+1));
	            }
	            
	            if(mp.containsKey(s.charAt(i)))
	            {
	                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
	                
	                if(mp.get(s.charAt(i))==1)
	                {
	                    count++;
	                }
	            }
	            i++;
	            j++;
	        }
	       
	        
	        
	    }
	    
	    return ans;
    }
}
