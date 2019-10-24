/**
 * @Author: makexin
 * @Date: 2019/10/2422:23
 */
public class Solution {
    public int GetUglyNumber_Solution(int index)
    {
        if (index == 0)
            return 0;
        int[] x = new int[1500];
        x[0] = 1;
        int m = 0, n = 0, q = 0;
        for (int i=1, j=1; i<index; i++)
        {
            int temp2 = x[m] * 2;
            int temp3 = x[n] * 3;
            int temp5 = x[q] * 5;
            int minNum = min(temp2, min(temp3, temp5));
            if (minNum == temp2)
                m++;
            if (minNum == temp3)
                n++;
            if (minNum == temp5)
                q++;
            x[i] = minNum;
        }
        return x[index-1];
    }
    public int min(int x1, int x2)
    {
        if (x1 < x2)
            return x1;
        else
            return x2;
    }
}
