/**
 * @Author: makexin
 * @Date: 2019/9/2619:42
 */
public class BubbleSort {
    public int[] sort(int[] array)//从小到大排序
    {
        for (int i = 0; i < array.length - 1; i++) //总共循环length-1次，因为数组是从0开始的，所以此处是<
        {
            for (int j = 0; j < array.length - 1 - i; j++)  //同理，因为是从0开始计数，所以是<
            {
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
