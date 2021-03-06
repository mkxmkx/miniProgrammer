## 剑指offer——矩阵中的路径
### 【题目描述】
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

### 【解题思路】
回溯法
以每一个格子为起点，判断当前格子元素是否符合字符串当前位置，符合则继续往下判断，不符合则回溯。
因此，需要一个额外的数组用来记录元素是否被访问过。

值得注意的是，若当前元素不符合，则需要回溯，将标志位恢复至false。

在java中，基本类型数据是值传递，如如int、long和char等。而其它的是引用传递，改变的是实际参数的值，因此需要回溯。

### 【代码实现】

```java﻿
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

```
