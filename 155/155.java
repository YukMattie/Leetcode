class MinStack {

    Stack<Long> s = new Stack<>();
    Long min;
    public MinStack() {
        this.min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        
        if(s.isEmpty()){
            s.push(value);
            min = value;
        }
        else{
            if(value < min){
                // when new value is smallest, store min value in variable min, 
                // but stack must have an element for the min value
                // use 2 * value-min to store in the stack
                // we must multiply 2 becase value - min may bigger than min when min is nagetive number
                // this value is less than min, so we can find it when we pop this value
                s.push(2 * value - min);
                min = value;
            }
            else
            {
                s.push(value);
            }
        }
    }
    
    public void pop() {
        if(s.isEmpty()){
            return;
        }
        Long value = s.pop();
        // we pop the min number, so change the min to previous
        if(value < min){
            min = 2 * min - value;
        }
    }
    
    public int top() {
        Long value = s.peek();
        if(value < min){
            return min.intValue();
        }
        else{
            return value.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */