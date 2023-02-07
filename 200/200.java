class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // in the next time the if condition is true, it must be a new island
                if(grid[i][j] == '1'){
                    // assume all four edges of the grid are all surrounded by water
                    count++;
                    // put all linked island to water
                    clearLand(grid, i, j);
                }
                
            }
        }
        return count;
    }

    public void clearLand(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        clearLand(grid, i + 1, j);
        clearLand(grid, i - 1, j);
        clearLand(grid, i, j + 1);
        clearLand(grid, i, j - 1);

    }
    
}