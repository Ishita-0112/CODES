class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if(k<=0||nums==null||nums.length==0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i=0,j=0,p=0;
        while(j<nums.length){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[j]){
                deque.removeLast();
            }
            deque.addLast(j);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(!deque.isEmpty()&&deque.peekFirst()<i)
                    deque.removeFirst();
                result[p++]=nums[deque.peekFirst()];
                j++;
                i++;
            }
        }
        return result;
    }
}
