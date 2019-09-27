剑指offer——调整数组顺序使奇数位于偶数前面
##  【题目描述】
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

## 【解题思路】
要保持相对位置不变，即排序算法中的稳定性。

**常用稳定的排序算法：冒泡排序、插入排序。**

此处使用了冒泡排序的思想。与冒泡排序不同的是，冒泡排序要找出最大最小值，然后冒泡最最后一个位置，而此处只需将奇数与偶数分开，不存在最大最小值的比较。

思路：
冒泡排序遍历n-1次，每次遍历范围都在减小（只在未排序数组中比较，已经冒泡到最后的元素不参与比较）。而此处遍历n-1次，每次遍历整个数组。
遍历n-1次，每次设置标志位记录此次遍历是否进行过数据交换操作，若一次排序未进行过数据交换，则算法结束。

## 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/9/2714:52
 */
public class Solution {
    public void reOrderArray(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            boolean flag = false;  //标志位
            for (int j = 0; j < array.length - 1; j++)
            {
                if (array[j]%2==0 && array[j+1]%2!=0)//交换奇数偶数位置
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,7};
        Solution solution = new Solution();
        solution.reOrderArray(array);
    }
}

```

```
