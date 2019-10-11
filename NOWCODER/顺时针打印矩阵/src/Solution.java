import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/10/1121:22
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix)
    {
        int row, column;
        row = matrix.length;
        column = matrix[0].length;

        boolean[][] flag = new boolean[row][column];//记录数组该位置是否为访问过，初始化为false
        int i, j;
        for (i=0; i<row; i++)
        {
            for (j=0; j<column; j++)
            {
                flag[i][j] = false;
            }
        }

        i = 0;
        j = 0;
        boolean existFlag = false;
        ArrayList<Integer> result = new ArrayList<>();
        while (!existFlag)
        {
            existFlag = true;
            boolean right, left, up, down;
            right = left = up = down = false;
            //横着向右
            while (j<column && flag[i][j]==false)
            {
                result.add(matrix[i][j]);
                flag[i][j] = true;
                j++;
                existFlag = false;
                right = true;
            }


            if (right)//返回到上一步最后一个位置
            {
                j--;
            }


            //竖着向下
            if (i+1 < row)
                if (flag[i+1][j] == false)
                    i++;//若可向下走，则向下
            while (i<row && flag[i][j]==false)
            {
                result.add(matrix[i][j]);
                flag[i][j] = true;
                i++;
                existFlag = false;
                down = true;
            }
            if (down)
            {
                i--;
            }


            //横着向左
            if (j-1 >= 0)
                if (flag[i][j-1] == false)
                    j--;
            while (j >= 0 && flag[i][j] == false)
            {
                result.add(matrix[i][j]);
                flag[i][j] = true;
                j--;
                existFlag = false;
                left = true;
            }
            if (left)
            {
                j++;
            }


            //竖着向上
            if (i-1 >= 0)
                if (flag[i-1][j] == false)
                    i--;
            while (i>0 && flag[i][j] == false)
            {
                result.add(matrix[i][j]);
                flag[i][j] = true;
                i--;
                existFlag = false;
                up = true;
            }
            if (up)
            {
                i++;
            }

            if (j+1 < column)
                if (flag[i][j+1] == false )
                    j++;//判断是否可开始下一轮顺时针访问，可以的话则走一步

        }
        return result;

    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[][] array = {{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        s.printMatrix(array);
    }
}
