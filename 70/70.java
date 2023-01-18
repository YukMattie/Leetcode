
class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        else{
            int one = 1;
            int two = 2;
            

            for(int i = 3; i <= n ;i++){
                int temp = one;                
                one = two;
                two = temp + two;
                
            }
            return two;

        }
    }
}