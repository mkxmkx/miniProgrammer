import BubbleSort.BubbleSort;

import java.util.Arrays;

/**
 * @Author: makexin
 * @Date: 2019/9/2619:46
 */
public class Main {
    public static void main(String[] args)
    {
        int[] array = {2,5,5,8,1,8,0,6};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("bubble sort: "+ Arrays.toString(bubbleSort.sort(array)));
    }
}
