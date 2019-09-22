剑指offer——旋转数组的最小数字

【题目描述】
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

## 【解题思路】
首先需要注意到题目的特点：**非递减排序**的数组。将数组旋转之后，最小值即成为分界点。最小值之前的部分为非递减顺序，最小值之后的部分也为非递减部分。
### 方法1：遍历
首先判断数组的长度，当数组为空时，返回0。
以array[0]初始化min最小值。从array第一个元素与min进行比较，当发现比array小的元素时，即为最小值。更新最小值，退出循环。

此方法的时间复杂度为O(n)

### 方法2：二分法
首先仍未判断数组的长度，当数组为空时，返回0。
设置两个指针index1,、index2，初始化时分别指向前半部分非递减数组的第一个元素array[index1]，以及后半部分非递减数组的最后一个元素array[index2]。将min初始化为array[0]，即array[index1]。将最小值初始化为第一个值是因为当元素顺序没有变时，即整体仍未非递减顺序，则通过判断第一个值比最后一个值小退出循环，直接得出最小值。

循环判断条件为array[index1] >= array[index2]。即分别指向了前半部分与后半部分（前半部分元素一定比后半部分元素大）。
循环内判断：
1、首先判断是否到达停止条件，index2 - index1 == 1，即分别指向了前半部分最后一个值，和后半部分第一个值。此时最小值为array[index2]。
2、获得中间值mid。
3、特殊情况判断。当index1、index2、mid三个指向的元素值相等时，无法缩小判断范围，只能通过顺序遍历获得最小值。此时通过另外一个函数顺序遍历，遍历的范围是缩小后的index1到index2的范围。
4、缩小范围。当mid大于index1指向元素时，则说明最小值在mid之后的元素，缩小范围index1=mid。当mid小于index2指向元素，则说明最小值为mid或mid之前的元素，缩小范围index2=mid。
## 【代码实现】
### 方法1：遍历法

```
public int minNumberInRotateArray(int[] array)
    {
        //最小值是两部分递增序列的转折点
        if (array.length == 0)
            return 0;
        int min = array[0];//将最小值初始化为最开始的值
        int i = 0;
        while (i < array.length)
        {
            if (array[i] < min)//一旦发现小于min的值，则说明指向了递增顺序的第一个元素，即最小元素，退出。
            {
                min = array[i];
                break;
            }
            i++;
        }
        return min;
    }
```
### 方法2：二分法

```
public int minNumberInRotateArray_v2(int[] array)
    {
        //二分法
        if (array == null || array.length == 0)
            return 0;
        int index1 = 0, index2 = array.length-1;//index1指向前半部分递增第一个值，index2指向后半部分递增最后一个值
        //最后的结果是index1指向前半部分最后一个值，即最大的值。index2指向后半部分第一个值，即最小的值
        //array[index2]即答案。
        int min = array[0];
        while (array[index1] >= array[index2])
        {
            if (index2 - index1 == 1)
            {
                min = array[index2];//最终结果
                break;
            }
            int mid = (index1 + index2) / 2;
            if (array[index1] == array[mid] && array[index2] == array[mid])
            {//特殊情况，index1、index2、mid三个的值是一样的，无法判断min是属于前部分递增，还是后部分递增
                //只能顺序寻找最小值。此时在已经缩小范围后的array中寻找最小值。
                min = getMinInOrder(array, index1, index2);
                break;
            }
            if (array[mid] >= array[index1])//非递减数组，所以要加上等于的情况
            {
                index1 = mid;
            }
            else if(array[mid] <= array[index2])
            {
                index2 = mid;
            }
        }
        return min;

    }
    public int getMinInOrder(int[] array, int index1, int index2)
    {
        int min = array[index1];
        for (int i = index1; i<=index2; i++)
        {
            if (array[i] < min)
            {
                min = array[i];
                break;
            }
        }
        return min;
    }
```
