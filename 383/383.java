class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[] = new int[26];

        // for each loop
        for(char ch : magazine.toCharArray()){
            count[ch - 'a']++;
        }
        for(char ch : ransomNote.toCharArray()){
            
            if( count[ch - 'a'] == 0){
                return false;
            }
            else{
                count[ch - 'a']--;
            }
        }
        return true;
    }
}