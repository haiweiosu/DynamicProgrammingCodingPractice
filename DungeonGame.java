public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] grid = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                //final stage
                if (i == m - 1 && j == n - 1){
                    grid[i][j] = Math.max(1, 1 - dungeon[i][j]);
                }
                else if (i == m - 1 && j != n - 1){
                    grid[i][j] = Math.max(1, grid[i][j+1] - dungeon[i][j]);
                }
                else if (i != m - 1 && j == n - 1){
                    grid[i][j] = Math.max(1, grid[i+1][j] - dungeon[i][j]);
                }
                else{
                    grid[i][j] = Math.max(1, Math.min(grid[i+1][j], grid[i][j+1]) - dungeon[i][j]);
                }
            }
        }
        
        return grid[0][0];
        
    }
}