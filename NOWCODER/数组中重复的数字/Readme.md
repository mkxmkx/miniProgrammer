## 剑指offer——数组中重复的数字
### 【题目描述】
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

### 【解题思路】
首先判断输入不符合的情况。
使用一个set数组，用来检测重复数字。遍历原数组，一旦检测到重复数字，就返回结果。

### 【代码实现】

```java
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/11/1821:23
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication)
    {
        if (numbers == null || numbers.length == 0 )
            return false;
        List<Integer> numSet = new ArrayList<>();
        boolean result = false;
        for (int i = 0; i<length; i++)
        {
            if (numSet.contains(numbers[i]))
            {
                duplication[0] = numbers[i];
                result = true;
                break;
            }
            else
            {
                numSet.add(numbers[i]);
            }
        }
        return result;
    }
}

```
