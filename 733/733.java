class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        // if the new color and old color are the same, don't change anything
        if (image[sr][sc] == color){
            return image;
        }

        color(image, sr, sc, color, image[sr][sc]);
        return image; 

    }

    public void color(int[][] image, int sr, int sc, int color, int cur){
        // if the location out of the border
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length){
            return;
        }
        // if the pixel have different color with the start pixel then skip it 
        if(cur != image[sr][sc]) {
            return;
        }
        image[sr][sc] = color;

        // recursive
        color(image, sr-1, sc, color, cur);
        color(image, sr+1, sc, color, cur);
        color(image, sr, sc-1, color, cur);
        color(image, sr, sc+1, color, cur);
    }
    
}