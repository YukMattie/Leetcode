class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        helper(result, new ArrayList<>(), nums);
        return result;
        
    }
    
    private void helper(List<List<Integer>> result, List<Integer> temp, int[] nums){
                
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int num: nums){
            if(temp.contains(num)){
                continue;
            }
            else{
                temp.add(num);
            }
            
            helper(result, temp, nums);
            
            // remove element from the full temp list
            // or it will only return one result
            temp.remove(temp.size() - 1);
            
        }
          

    }
}