## 剑指offer——数组中只出现一次的数字
## 【题目描述】
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

## 【解题思路】
### hashMap方法
遍历一遍数组，然后将数组中数字出现的次数保存在hashMap中，key为数字，value为出现的次数。然后再判断hashMap中出现一次的数字。

### 异或方法
两个相同数字的异或结果为0.因此将数组遍历一遍，异或的结果肯定就是只出现一次的两个数。由于这两个数字不一样，所以异或的结果至少有一位为1，我们在结果数字中找到第一个为1的位置，记为index位，现在我们以第index位是不是1为标准把原数组拆分成两个子数组，第一个子数组中的数组第index位都为1，第二个子数组中的数组第index位都为0，那么只出现一次的数字将被分配到两个子数组中去，于是每个子数组中只包含一个出现一次的数字，而其他数字都出现两次。每个子数组分别异或就可以得到两个结果。

## 【代码实现】
### hashMap法

```java
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/3114:38
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[])
    {
        Map<Integer, Integer> numOfArray = new HashMap<>();
        if (array==null || array.length == 0)
            return;

        for (int i = 0; i<array.length; i++)
        {
            if (numOfArray.containsKey(array[i]))
            {
                int num = numOfArray.get(array[i]);
                numOfArray.put(array[i], num+1);
            }
            else
                numOfArray.put(array[i], 1);
        }
        boolean flag = false;//num1是否填数字
        for (int x: numOfArray.keySet())
        {
            if (numOfArray.get(x)==1)
            {
                if (!flag)
                {
                    num1[0] = x;
                    flag = true;
                }
                else
                {
                    num2[0] = x;
                    break;
                }
            }

        }
    }
    public static void main(String[] args)
    {
        int[] array = {2,4,3,6,3,2,5,5};
        Solution s = new Solution();
        int[] num1 = {0}, num2 = {0};
        s.FindNumsAppearOnce(array, num1, num2);
    }
}

```
