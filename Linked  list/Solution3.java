class Solution {

    int rows;
    int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        rows = image.length;
        cols = image[0].length;

        int originalColor = image[sr][sc];

        if(originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }


    private void dfs(int[][] image, int r, int c, int originalColor, int color) {

        if(r < 0 || c < 0 || r >= rows || c >= cols 
           || image[r][c] != originalColor) {
            return;
        }

        image[r][c] = color;

        dfs(image, r+1, c, originalColor, color);
        dfs(image, r-1, c, originalColor, color);
        dfs(image, r, c+1, originalColor, color);
        dfs(image, r, c-1, originalColor, color);
    }
}