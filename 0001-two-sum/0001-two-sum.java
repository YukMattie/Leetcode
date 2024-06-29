class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                return new int[]{i, numMap.get(complement)};
            } else{
                numMap.put(nums[i], i);
            }
        }
        
        return null;
        
        
    }
}