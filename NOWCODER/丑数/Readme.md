## 剑指offer——丑数
## 【题目描述】
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

## 【解题思路】
每个位置上的丑数都是某个丑数乘上2或3或5的结果，看如下示例：

第1个丑数是 1,
第2个丑数是 1 * 2 = 2, 第1个丑数*2
第3个丑数是 1 * 3 = 3, 第1个丑数*3
第4个丑数是 2 * 2 = 4, 第2个丑数*2
第5个丑数是 1 * 5 = 5, 第1个丑数*5
第6个丑数是 2 * 3 = 6, 第2个丑数*3

所以设置三个数，分别记录乘2、 3、 5的丑数

## 【代码实现】

```java
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

```
