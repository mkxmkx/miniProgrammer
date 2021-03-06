## 剑指offer——顺时针打印矩阵

## 【题目描述】
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

## 【解题思路】
需要记录是否访问过元素，然后按照顺时针访问就可以。

按照向右，向下，向左，向上的顺序，每次向右（其它方向同理）到头之后，（停止条件为超出数组范围或该位置访问过），开始下一个方向访问。
需要注意的是，由于上一个方向是到了停止条件的，所以在开始下一个方向的访问之前，需要把当前指向的位置退回到上一个方向的最后一步，然后判断是否可进行下一个方向的访问，判断方式是通过判断下一个方向是否被访问过（flag标志），可以的话就直接走一步。

## 【代码实现】

```java
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

```
