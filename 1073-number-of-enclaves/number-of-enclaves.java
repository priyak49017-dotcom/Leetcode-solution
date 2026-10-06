class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(row == 0 || col == 0 || row==grid.length-1 || col == grid[0].length-1 ){
                    if(grid[row][col] == 1){
                    dfs(grid,row,col);
                    }
                }
            }
        }
        for(int row=0;row<grid.length;row++){
            for(int col =0 ;col <grid[0].length;col++){
                if(grid[row][col] == 1){
                    count++;
                }
            }
        }
        return count;
        
    }
    void dfs(int[][] grid,int row,int col){
        if(row < 0 || col < 0 || row >= grid.length||col >= grid[0].length||grid[row][col]==0){
            return;

        }
        grid[row][col]=0;
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}