class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> h = new HashSet<Character>();
        int length = 0;
        for(char ch : s.toCharArray()){
            if(h.contains(ch)){
                length = length + 2;
                h.remove(ch);
            }
            else{
                h.add(ch);
            }
        }
        if(h.size() > 0){
            length++;
        }
        return length;
    }
}