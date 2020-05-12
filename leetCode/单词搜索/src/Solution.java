/**
 * @Author: makexin
 * @Date: 2020/5/1222:19
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                boolean res = dfs(board, word, 0, flag, i, j);
                if(res)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, boolean[][] flag, int i, int j)
    {
        boolean res = false;
        if(index == word.length())
            return true;
        if(i == board.length || i<0 || j==board[0].length || j<0 || flag[i][j])
            return false;
        if(board[i][j] == word.charAt(index))
        {
            flag[i][j] = true;
            res = dfs(board, word, index+1, flag, i+1, j) ||
                    dfs(board, word, index+1, flag, i-1, j) ||
                    dfs(board, word, index+1, flag, i, j+1) ||
                    dfs(board, word, index+1, flag, i, j-1);
            flag[i][j] = false;
        }
        return res;
    }
}
