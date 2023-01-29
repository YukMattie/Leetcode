class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i < length && j < length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                // compare the answer with the existing substing between j and i
                ans = Math.max(ans, j - i);
            }
            else{
                // remove element from the first, until remove the dupulicate one with s[j]
                set.remove(s.charAt(i));
                i++;
            }

        }
        return ans;
    }
}