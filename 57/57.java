class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        int index = 0;

        // add the intervals element which have no gap with newInterval
        while(index < intervals.length){
             
            if(intervals[index][0] < newInterval[0]){
                result.add(intervals[index]);
                index++;
                 
            }
            else{
                break;
            }            
        }

        // add the new interval
        if(result.size() == 0 || newInterval[0] > result.get(result.size() - 1)[1]){
            result.add(newInterval);
            
                                              
        }
        else{
            int [] last = result.get(result.size() - 1);
            last[0] = Math.min(newInterval[0],last[0]);
            last[1] = Math.max(newInterval[1],last[1]);     
            // last[1] = Math.max(intervals[index][1],last[1]);       
            // result.add(last);
        }

        // add other interval elements
        while(index < intervals.length){

            int[] last = result.get(result.size() - 1);
            
            if(last[1] < intervals[index][0]){
                result.add(intervals[index]);
                
            }
            else{
                last[1] = Math.max(intervals[index][1],last[1]);
            }
            index++;
        }
        return result.toArray(new int [result.size()][]);
    }
}