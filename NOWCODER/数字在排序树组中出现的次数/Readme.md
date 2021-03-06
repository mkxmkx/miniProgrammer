## 剑指offer——数字在排序数组中出现的次数
## 【题目描述】
统计一个数字在排序数组中出现的次数。

## 【解题思路】
这个题目的前提是在排序数组中，因此可以利用二分法减小寻找的范围。

题目中没有说该数组是升序排序还是降序排序，因此需要先判断数组是升序还是降序。
判断完是升序还是降序数组之后，每次寻找利用二分法缩小一半范围。以升序排序为例，当中间元素大于k时，说明目标元素一定在后半段；当中间元素小于k时，说明目标元素一定在前半段。
当找到中间元素等于k时，此时并没有结束，因为需要判断该元素出现了多少次。

方法1：继续利用二分法，找到k的第一个元素。然后再找到最后一个元素。两个元素索引位置知道了，相减就知道了总个数。
方法2：知道了一个元素的位置，只需从该索引位置向前和向后传开统计出现的次数。依次统计前面出现了多少个；依次统计后面出现了多少个。然后就知道总个数了。

## 【代码实现】
方法2：

```java
/**
 * @Author: makexin
 * @Date: 2019/10/2819:51
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k)
    {
        int result = 0;
        if (array == null || array.length ==0)
            return result;
        boolean ascend = true;//数组是升序还是降序
        if (array[0] > array[array.length-1])
            ascend = false;
        int i=0, j=array.length-1;
        int mid = 0;
        while (i<=j)
        {
            mid = (i+j)/2;
            if (array[mid] == k)
                break;
            if (ascend)
            {
                if (array[mid] > k)
                    j=mid-1;
                else
                    i = mid+1;
            }
            else
            {
                if (array[mid] > k)
                    i = mid+1;
                else
                    j = mid-1;
            }
        }
        if (array[mid]!=k)
            return result;
        else {
            result++;
            i = mid-1;
            while (i>=0)//要先判断是否越界
            {
                if (array[i] == k)
                {
                    result++;
                    i--;
                }
                else
                    break;
            }
            j=mid+1;
            while (j<array.length)//要先判断是否越界
            {
                if (array[j] == k) {
                    result++;
                    j++;
                }
                else
                    break;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {3,3,3,3,4,5};
        System.out.println(new Solution().GetNumberOfK(array, 3));
    }
}

```
