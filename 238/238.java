class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int cur = 1;

        // multiply all element before this element
        for(int i = 0; i < nums.length; i++){
            result[i] *= cur;
            // cur is the product of all element before this element
            cur *= nums[i];
        }

        cur = 1;

        // multiply all element after this element
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= cur;
            cur *= nums[i];
        }
        return result;

    }
}