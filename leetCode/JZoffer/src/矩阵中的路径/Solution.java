package 矩阵中的路径;

/**
 * @Author: makexin
 * @Date: 2020/7/13 22:12
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || rows == 0 || cols == 0 || str.length == 0)
            return false;
        boolean[] visited = new boolean[rows*cols];
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                boolean res = hasPathCore(matrix, rows, cols, i, j, str, 0, visited);
                if(res)
                    return true;
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int index, boolean[] visited)
    {
        if(index == str.length)
            return true;
        boolean res = false;
        if(row>=0 && row<rows && col>=0 && col<cols && !visited[row*cols+col] && matrix[row*cols+col]==str[index])
        {
            visited[row*cols+col] = true;
            res = hasPathCore(matrix, rows, cols, row+1, col, str, index+1, visited)
                    || hasPathCore(matrix, rows, cols, row-1, col, str, index+1, visited)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, index+1, visited)
                    || hasPathCore(matrix, rows, cols, row, col-1, str, index+1, visited);
            if(!res)
            {
                visited[row*cols+col] = false;
            }
        }
        return res;
    }
}
