class Solution {
    public int evalRPN(String[] tokens) {
    
        int result = 0;
        Stack<String> s = new Stack<>(); 
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                
                int second = Integer.parseInt(s.pop());
                int first = Integer.parseInt(s.pop());
                char[] arr = tokens[i].toCharArray();
                char symbol = arr[0];
                if(symbol == '+'){
                    result = first + second;
                }
                else if (symbol == '-'){
                    result = first - second;
                }
                else if (symbol == '*'){
                    result = first * second;
                }
                else if (symbol == '/'){
                    result = first / second;
                }
                s.push(Integer.toString(result));
            }
            else{
                s.push(tokens[i]);
            }
        } 
        return Integer.parseInt(s.pop()); 
    }
}