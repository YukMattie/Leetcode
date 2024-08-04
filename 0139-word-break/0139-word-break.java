class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        
        dp[0] = true;
        
        for(int low = 0; low < n; low++){
            if (dp[low] == false) continue;
            for (String word : wordDict){
                int high = low + word.length();
                if (high <= n && s.substring(low, high).equals(word)){
                    dp[high] = true;
                }                
            }
        }   
        return dp[n];
    }
}

