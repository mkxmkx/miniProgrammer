剑指offer——二进制中1的个数

## 【题目描述】
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

## 【解题思路】
总共有32位，算符号位。
负数的补码：符号位不变，其余各位取反再加一。

## 【代码实现】

```
public int NumberOf1(int n)
    {
        int m = n;
        if (n<0)
            m = -n;

        int[] result = new int[32];
        int j = 0;
        do{
            int x = m % 2;
            m = m / 2;
            result[j] = x;
            j++;
        }while (m!=0);

        if (n<0)
        {
            for (int i = 0; i<result.length; i++) //反码
            {
                if (result[i] == 1)
                    result[i] = 0;
                else
                    result[i] = 1;
            }

            for (int i = 0; i<result.length; i++)//反码加1
            {
                result[i] = result[i] + 1;
                if (result[i] == 1)
                    break;
                else
                    result[i] = 0;
            }
            result[31] = 1;  //符号位。符号位不变
        }

        int count = 0;
        for (Integer i: result)
        {
            if (i == 1)
                count++;
        }
        return count;
    }
```

做完了以后，在网上也看了一下别人的解法，用到了位运算，不太懂。

