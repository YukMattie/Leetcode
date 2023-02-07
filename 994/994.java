class Solution {

    public int orangesRotting(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rotting(grid, i, j, 2);
                }
            }
        }

        int minutes = 2;
        for(int[] row : grid){
            for(int cell : row){
                System.out.println(cell);
                if(cell == 1){
                    return -1;
                }
                // find the biggest minutes
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes - 2;
    }

    public void rotting(int[][] grid, int i, int j, int minutes){
        // the start rotten orange cell is 2
        // the cell which fresh orange come to rotten is bigger than 2 
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < minutes)){
            return;
        }
        else {
            // update each rottened orange cell to the rotten minutes
            grid[i][j] = minutes;
            rotting(grid, i + 1, j, minutes + 1);
            rotting(grid, i - 1, j, minutes + 1);
            rotting(grid, i, j + 1, minutes + 1);
            rotting(grid, i, j - 1, minutes + 1);

        }
        
    }
    
}