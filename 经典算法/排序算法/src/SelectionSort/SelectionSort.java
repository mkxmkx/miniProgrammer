package SelectionSort;

/**
 * @Author: makexin
 * @Date: 2019/9/2620:12
 */
public class SelectionSort {
    public int[] sort(int[] array)
    {
        for (int i = 0; i < array.length-1; i++)
        {
            int minIndex = i;
            for(int j = i+1; j < array.length; j++)
            {
                if (array[j] < array[minIndex])
                {
                    minIndex = j;
                }
            }
            if (minIndex != i)
            {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
}
