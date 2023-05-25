class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }

            // rotated less than half numbers
            if(nums[start] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            // rotated more than half numbers
            else{
                if(target <= nums[end] && target >= nums[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            
        }
        return -1;
    }
}