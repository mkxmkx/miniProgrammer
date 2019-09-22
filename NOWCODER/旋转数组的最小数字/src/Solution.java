import java.util.Iterator;

/**
 * @Author: makexin
 * @Date: 2019/9/2220:04
 */
public class Solution {
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
}
