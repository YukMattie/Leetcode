class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;

    }

    private void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start){
        if(target < 0)
            return;
        else if(target == 0){

            // result is address, the change will effect each level of stack
            result.add(new ArrayList<>(temp));
            return;
        }
        else{
            for (int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                helper(result, temp, nums, target - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
}