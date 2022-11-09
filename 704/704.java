class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }


    private int binarySearch(int[] nums, int target, int first, int last){

        int mid = (last + first) / 2;
        if (last < first){
            return -1;
        }
        else{
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                return binarySearch(nums, target, first, mid - 1);
            }
            else{
                return binarySearch(nums, target, mid + 1, last);
            }       
        }
    }
}