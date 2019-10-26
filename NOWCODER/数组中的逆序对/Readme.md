## 剑指offer——数组中的逆序对

## 【题目描述】
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5

示例1
输入1,2,3,4,5,6,7,0
输出7

## 【解题思路】
### 暴力求解法
最直接的方法就是两重循环。第一层循环是遍历数组，每次取一个数字，然后第二重循环，寻找后面的元素中有多少个比它小的。
算法复杂度：O(n^2)
当数组元素很多时，时间复杂度太高。

### 类似归并排序算法——分治法
使用类似归并排序的算法。
总的逆序对数量  等于  拆分成两个数组之后，两个数组分别的逆序对数量  加上两个数组合并之后的逆序对数量。
分的过程与归并排序算法相同。
merge结束之后的数组需要排好序，按从小到大的顺序。
在merge时，在两个数组的尾部分别设置指针。然后比较两个指针的大小。若前面的元素比较大，则说明后面指针之前的元素都可构成逆序对，可得出该元素的逆序对数量。若后面的指针元素比较大，则说明后面的指针元素大于前面的所有元素，该元素不存在逆序对。在比较之后，依次将大的元素放到temp数组中，存放排好序的数组。
比较结束之后，将原数组中剩下的元素（即为比较小的元素）全部挪到temp数组中，然后将temp中数组元素全部复制回原array数组。并返回逆序对的数量。

需要注意的一点：每增加一个逆序对数量，需要判断一下是否大于1000000007，如果大于就需要取模。我刚开始因为只在return中取模，结果一直不能通过全部案例。在循环中也加上判断之后就可以通过了，所以需要再所有的地方都加上判断。

## 【代码实现】
分治法：

```java
/**
 * @Author: makexin
 * @Date: 2019/10/2621:17
 */
public class Solution {
    public int InversePairs(int [] array)
    {
        if (array == null || array.length == 0)
            return 0;
        int result = divid(array, 0, array.length-1);
        return result%1000000007;
    }
    public int divid(int[] array, int left, int right)
    {
        if (left<right)
        {
            int mid = (left + right)/2;
            int leftResult = divid(array, left, mid);
            int rightResult = divid(array, mid+1, right);
            int mergeResult = merge(array, left, mid, right);
            return (leftResult + rightResult + mergeResult)%1000000007;
        }
        return 0;
    }
    public int merge(int[] array, int left, int mid, int right)
    {
        int i=mid, j = right;
        int mergeResult = 0;
        int[] temp = new int[right-left+1];
        int k = right-left;
        while (i>=left && j>mid)
        {
            if (array[i] > array[j])
            {
                mergeResult += (j-mid);
                temp[k] = array[i];
                k--;
                i--;
                if (mergeResult>1000000007)
                    mergeResult %= 1000000007;
            }
            else
            {
                temp[k] = array[j];
                k--;
                j--;
            }
        }
        if (j>mid)//说明后面的数组还有剩余的元素，这些元素全都是比较小的元素。
        {
            while (j>mid)
            {
                temp[k] = array[j];
                k--;
                j--;
            }
        }
        if (i>=left)//说明前面的数组还剩一些比较小的元素
        {
            while (i>=left)
            {
                temp[k] = array[i];
                k--;
                i--;
            }
        }
        k = 0;
        for (i=left; i<=right; i++, k++)
            array[i] = temp[k];
        return mergeResult%1000000007;
    }

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,0};
        System.out.println(new Solution().InversePairs(array));
    }
}

```
