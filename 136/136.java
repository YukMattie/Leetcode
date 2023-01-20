class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(h.contains(nums[i])){
                h.remove(nums[i]);
            }
            else{
                h.add(nums[i]);
            }
        }

        int result;

        result = h.iterator().next();

        return result;
        
    }
}