package MergeSort;

/**
 * @Author: makexin
 * @Date: 2019/9/2919:41
 */
public class MergeSort {
    public void sort(int[] array)
    {
        int[] temp = new int[array.length]; //提前申请数组空间，避免递归中频繁开辟空间
        sort(array, 0, array.length - 1, temp);
    }
    public void sort(int[] array, int left, int right, int[] temp)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp); // 左边归并排序，使得左子序列有序
            sort(array, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(array, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }
    public void merge(int[] array, int left, int mid, int right, int[] temp)
    {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right)
        {
            if (array[i] <= array[j])
            {
                temp[k] = array[i];
                i++;
            }
            else
            {
                temp[k] = array[j];
                j++;
            }

            k++;
        }
        if (i <= mid)
        {
            while (i<=mid)
            {
                temp[k] = array[i];
                k++;
                i++;
            }
        }

        if (j <= right)
        {
            while (j<=right)
            {
                temp[k] = array[j];
                k++;
                j++;
            }
        }
        //将temp中的元素全部拷贝到原数组中
        i = left;
        while (i<=right)
        {
            array[i] = temp[i];
            i++;
        }
    }
}
