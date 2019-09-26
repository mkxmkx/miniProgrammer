package InsertionSort;

/**
 * @Author: makexin
 * @Date: 2019/9/2622:15
 */
public class InsertationSort {
    public int[] sort(int[] array)
    {
        for (int i = 1; i<array.length; i++)
        {
            int current = array[i];
            int j = i - 1;  //j为排序好序列的索引
            for (; j>=0; j--)
            {
                if (array[j] > current)
                {
                    array[j+1] = array[j];
                }
                else
                {
                    break;
                }
            }
            array[j+1] = current;
        }
        return array;
    }
}
