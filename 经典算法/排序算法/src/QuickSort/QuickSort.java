package QuickSort;

/**
 * @Author: makexin
 * @Date: 2019/10/716:22
 */
public class QuickSort {
    public void Sort(int[] array)
    {
        Sort(array, 0, array.length-1);
    }
    public void Sort(int[] array, int left, int right)
    {
        if (left >= right)
            return;
        int pivot = partition(array, left, right);
        Sort(array, left, pivot-1);
        Sort(array, pivot+1, right);
    }
    public int partition(int[] array, int left, int right)
    {
        int pivot = array[left];//记录pivot
        int i = left, j = right;
        while (i<j)
        {
            //顺序很重要，需要先从右边开始找。
            // 因为快速排序可理解为挖坑填坑法，最开始pivot位置挖个坑，然后需要从右边开始找小的元素填这个坑。
            // 但是将右边小的元素填到坑里以后，右边的元素原本位置又是一个坑，然后需要从左边开始找大的元素填坑。
            // 所以顺序很重要，需要从右边开始找。若从左边开始找小的元素，找到一个较大元素后，左边相当于两个坑了。
            //j递减寻找比pivot小的元素（小于等于）
            while (array[j] > pivot && i<j)
            {
                j--;
            }
            //交换不比pivot大的元素到基准位置（i指向的位置）
            if (i<j)
            {
                array[i] = array[j];
                i++;//然后将i++,i指向比pivot小的元素位置
            }

            //同理，i递增寻找比pivot大的元素，即下一个需要交换位置的元素。交换到上一个j交换之后的空缺位置
            while (array[i] < pivot && i<j)
            {
                i++;
            }
            if (i<j)
            {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = pivot;
        return i;
    }

    public void quickSort(int[] array)
    {
        //方法二，直接将递归的部分写进partition
        quickSort(array, 0, array.length-1);
    }
    public void quickSort(int[] array, int left, int right)
    {
        if (left >= right)
            return;

        int pivot = array[left];
        int i = left, j = right;
        while (i<j)
        {

            while (array[j] > pivot && i<j)
                j--;
            if (i<j)
            {
                array[i] = array[j];
                i++;
            }

            while (array[i] < pivot && i<j)
                i++;
            if (i<j)
            {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = pivot;
        quickSort(array, left, i-1);
        quickSort(array, i+1, right);
    }
}
