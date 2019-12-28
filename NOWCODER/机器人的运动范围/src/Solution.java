/**
 * @Author: makexin
 * @Date: 2019/12/2814:50
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold<=0 || rows==0 || cols==0)
            return 0;
        boolean[] visitFlags = new boolean[rows*cols];
        int res = movingCountCore(threshold, rows, cols, 0, 0, visitFlags);
        return res;
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visitFlags)
    {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visitFlags))
        {
            int index = row * cols + col;
            visitFlags[index] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row, col+1, visitFlags) +
                    movingCountCore(threshold, rows, cols, row, col-1, visitFlags) +
                    movingCountCore(threshold, rows, cols, row+1, col, visitFlags) +
                    movingCountCore(threshold, rows, cols, row-1, col, visitFlags);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visitFlags)
    {
        int index = row * cols + col;
        // 索引值在有效范围内、元素尚未访问、各位数和小于等于阈值
        if (row>=0 && row<rows && col>=0 && col<cols && !visitFlags[index] && (getDigitsSum(row) + getDigitsSum(col) <=threshold))
            return true;
        return false;
    }

    public int getDigitsSum(int num)
    {
        if (num<0)
            return 0;
        int sum = 0;
        while (num>0)
        {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
