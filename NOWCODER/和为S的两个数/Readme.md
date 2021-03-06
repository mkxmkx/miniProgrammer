## 剑指offer——和为S的两个数
### 【题目描述】
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。

### 【解题思路】
#### 解题思路1
要求两个数的和是否为S，可以用S减去一个较小的值，看另外一个元素是否在数组中。
因此，遍历一遍数组，将所有元素存到map，或者set中，可以直接搜索某个值是否存在。
由于数组是递增排序的，所以从最小值开始，判断另一个总和为S的数是否存在。
寻找结果时，当发现当前较小值已经比sum的一半大，则不需要再继续找下去，因为后面的元素不可能存在解。

#### 解题思路2
由于数组是递增排序的，设置两个数组，分别指向最小值和最大值。每次判断两个指针所指元素之和是否等于结果。如果等于，则与保存的上次结果相比较谁的积小。若小于sum，则较小元素增大。若大于sum，则较大元素减小。

### 【代码实现】
解题思路1：

```java
public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2)
            return result;
        int left, right;
        left = right = array[array.length-1];//初始为最大值
        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int i=0; i<array.length; i++)
        {
            arrayMap.put(array[i], 1);
        }
        for (int i = 0; array[i] < sum/2; i++)
        {
            int another = sum - array[i];
            if (arrayMap.containsKey(another))
            {
                int last = left * right;
                int current = another * array[i];
                if (current < last)
                {
                    left = array[i];
                    right = another;
                }
            }
        }
        if (left==right)//即不存在正确解
            return result;
        result.add(left);
        result.add(right);
        return result;
    }
```

解题思路2

```java
public ArrayList<Integer> FindNumbersWithSum_v2(int [] array, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length<2)
            return result;
        int left = 0, right = array.length-1;
        int bestLeft, bestRight;
        bestLeft = bestRight = array.length-1;
        while (left<right)
        {
            if (array[left] + array[right] == sum)
            {
                int last = array[bestLeft] * array[bestRight];
                int current = array[left] * array[right];
                if (current < last)
                {
                    bestLeft = left;
                    bestRight = right;
                }
                left++;
                right--;
            }
            else
            {
                if (array[left] + array[right] < sum)
                {
                    left++;
                }
                else
                    right--;
            }
        }
        if (bestLeft == bestRight && bestLeft == array.length-1)
            return result;
        result.add(array[bestLeft]);
        result.add(array[bestRight]);
        return result;
    }
```
