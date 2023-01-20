class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length();
        int j = b.length();

        // either String have digt
        while(i > 0 || j > 0){

            // the digt first should add carry from last digt
            int digt = carry;
            if(i > 0){
                i--;
                digt += a.charAt(i) - '0';
                
            }
            if(j > 0){
                j--;
                digt += b.charAt(j) - '0';                
            }
            sb.append(digt % 2);
            carry = digt / 2;
        }
        // result longer than both string
        if(carry > 0){           
            sb.append(carry);           
        }
        
        return sb.reverse().toString();
        
    }
}