## 剑指offer——最小的k个数
## 【题目描述】
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

## 【解题思路】
要获得最小的几个数，就是需要对数组进行排序。不过不需要对整体排序，仅需排除k个最小的就行。
冒泡排序，插入排序，选择排序都可以。

## 【代码实现】
此处使用的是冒泡排序

```java
import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/10/2016:44
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length<k)
            return result;

        int i, j;
        for (i=0; i<k; i++)
        {
            for (j=input.length-1; j-i>0; j--)
            {
                if (input[j] < input[j-1])
                {
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }

        for (i=0; i<k; i++)
        {
            result.add(input[i]);
        }
        return result;
    }
}

```
