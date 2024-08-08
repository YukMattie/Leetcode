class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(true){
            int position = partition(nums, left, right);
            if(position + 1 == k){
                return nums[position];
            } else if (position + 1 > k){
                right = position - 1;
            } else{
                left = position + 1;
            }   
        }               
    }
    
    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
            
        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                swap(nums, l++, r--);
            } 
            if (nums[l] >= pivot){
                l++;
            }
            if (nums[r] <= pivot){
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}