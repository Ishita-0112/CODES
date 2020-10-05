/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //Base Conditions
        if (obstacleGrid[0][0]==1)
            return 0;
        obstacleGrid[0][0]=1;
    //left column
    for(int i=1; i<m; i++){
        if(obstacleGrid[i][0]==1)
        obstacleGrid[i][0] = 0;
        else
        obstacleGrid[i][0] = obstacleGrid[i-1][0];
  
    }
 
    //top row
    for(int j=1; j<n; j++){
        if(obstacleGrid[0][j]==1)
        obstacleGrid[0][j] = 0;
        else
        obstacleGrid[0][j] = obstacleGrid[0][j-1];
    }
 
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            if (obstacleGrid[i][j]==0)
                obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            else if (obstacleGrid[i][j]==1)
                obstacleGrid[i][j]=0;
        }
    }
        return obstacleGrid[m-1][n-1];
    }
}

