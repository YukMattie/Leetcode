class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(dis(a), dis(b)));
        for(int[] point: points){
            pq.add(point);
        }

        int[][] result = new int[k][2];
        while(!pq.isEmpty() && k > 0){
            result[--k] = pq.poll();

        }
        return result;

    }

    public int dis(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }

}