## 剑指offer——数组中出现次数超过一半的数字
## 【题目描述】
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0

## 【解题思路】
使用一个额外空间来保存每个数字出现的次数。本来想的是用一个数组，然后对应位置每出现一次就加一，但是也不知道数字范围。所以改用map保存，key就是数组中出现过的数字，value就是对应出现过的次数，这样也不会额外申请很多空余的空间。

## 【代码实现】

```java
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/1921:21
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array)
    {
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        for (i=0; i<len; i++)
        {
            if (map.containsKey(array[i]))
            {
                int value = map.get(array[i]);
                map.put(array[i], value+1);
            }
            else
                map.put(array[i], 1);
        }

        int result = 0;
        for (Integer key : map.keySet())
        {
            if (map.get(key) > (len/2))
                result = key;
        }
        return result;
    }

}

```
