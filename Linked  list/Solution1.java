class Solution1 {

    int rows;
    int cols;

    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int maxArea = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }




    


    private int dfs(int[][] grid, int r, int c) {

        if(r < 0 || c < 0 || r >= rows || c >= cols 
           || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int area = 1;

        area += dfs(grid, r+1, c);
        area += dfs(grid, r-1, c);
        area += dfs(grid, r, c+1);
        area += dfs(grid, r, c-1);

        return area;
    }
}