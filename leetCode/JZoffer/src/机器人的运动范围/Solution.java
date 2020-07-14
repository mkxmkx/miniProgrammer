package 机器人的运动范围;

/**
 * @Author: makexin
 * @Date: 2020/7/1319:43
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<=0 || rows==0 || cols == 0)
            return 0;
        boolean[] flags = new boolean[rows*cols];
        int res = movingCountCore(threshold, rows, cols, 0, 0, flags);
        return res;
    }
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] flags)
    {
        int count = 0;
        if(row < rows && col< cols && !flags[row*cols+col] && getNum(row, col) <= threshold)
        {
            flags[row*cols+col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row, col+1, flags)
                    + movingCountCore(threshold,rows, cols, row+1, col, flags);
        }
        return count;
    }
    public int getNum(int row, int col)
    {
        int res = 0;
        while (row>0)
        {
            res += row%10;
            row = row/10;
        }
        while(col>0)
        {
            res += col%10;
            col = col/10;
        }
        return res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.movingCount(18, 36, 36));
    }
}
