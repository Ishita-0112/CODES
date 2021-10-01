class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> prevMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (prevMap.containsKey(diff)) {
                return new int[]{ prevMap.get(diff), i };
            }
            prevMap.put(nums[i], i);
        }
        return new int[0];
       
    }
}
