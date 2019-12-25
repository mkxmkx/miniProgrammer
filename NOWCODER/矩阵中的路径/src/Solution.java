/**
 * @Author: makexin
 * @Date: 2019/12/2520:42
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null ||matrix.length != rows*cols || str == null || str.length < 1)
            return false;
        boolean[] visited = new boolean[rows*cols];
        for (int i = 0; i<rows*cols; i++)
            visited[i] = false;
        int pathLength = 0;
        //以每个点为起点进行搜索
        for (int i = 0; i<rows; i++)
        {
            for (int j = 0; j<cols; j++)
            {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength))
                    return true;
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                               int row, int col, int pathLength)
    {
        if (pathLength == str.length)
            return true;
        boolean hasPath = false;
        //判断位置是否合法
        if (row >= 0 && row < rows && col>=0 && col<cols && matrix[row*cols + col]==str[pathLength] && !visited[row*cols+col])
        {
            visited[row*cols + col] = true;
            pathLength++;

            //四个方向进行搜索
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col-1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col+1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row-1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row+1, col, pathLength);
            if (!hasPath)
            {
                pathLength--;
                visited[row*cols+col] = false;
            }
        }
        return hasPath;
    }
}
