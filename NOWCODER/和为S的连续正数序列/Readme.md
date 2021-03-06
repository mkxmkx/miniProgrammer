## 剑指offer——和为S的连续正数序列
### 【题目描述】
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

### 【解题思路】
**滑动窗口法**：
设置一个窗口，从正序序列头开始往后滑动，最开始窗口长度为最小值。每次判断滑动窗口内的和是否与S相等。若相等，则把窗口内的序列添加到结果中，然后窗口往后滑动一个数，开始下一次计算。若窗口内序列和小于S，则扩大窗口，即end++。若窗口内序列和大于S，则缩小窗口，即start--。

### 【代码实现】

```c
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/11/219:14
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum<3)
            return result;
        int start = 1, end = 1, mid = sum/2;
        int sumResult = 1;
        while (start<=mid || end<mid)
        {
            if (sumResult == sum)
            {
                result.add(saveList(start, end));
                end++;
                sumResult = sumResult - start + end;
                start++;
            }
            else
            {
                if (sumResult < sum)
                {
                    end++;
                    sumResult+=end;
                }
                else
                {
                    sumResult -= start;
                    start++;
                }

            }
        }
        return result;
    }
    public ArrayList<Integer> saveList(int start, int end)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i<=end; i++)
            result.add(i);
        return result;
    }
}

```
