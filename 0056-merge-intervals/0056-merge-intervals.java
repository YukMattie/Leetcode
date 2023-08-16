class Solution {
    public int[][] merge(int[][] intervals) {
        
        // use lambda expression(actually it's a method)
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        
        int[] newInterval = intervals[0];
        
        // have to add first interval here, or can't add the last one
        result.add(newInterval);
        for(int[] interval : intervals){
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}