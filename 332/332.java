class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0 || coins.length == 0){
            return 0;
        }

        // create dynamic programming array, the length is element plus 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // loop each coins 
        for(int i = 0; i < coins.length; i++){

            // loop element in dp array, start from this coin value
            for(int j = coins[i]; j < dp.length; j++){
                
                // this if condition is important, or dp[j - coins[i]] + 1 will out of int bound
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    
                    // update the value according to the value of last element of dp array
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
                
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
        
    }
}
