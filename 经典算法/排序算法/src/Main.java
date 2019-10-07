import BubbleSort.BubbleSort;
import InsertionSort.InsertationSort;
import MergeSort.MergeSort;
import QuickSort.QuickSort;
import SelectionSort.SelectionSort;

import java.util.Arrays;

/**
 * @Author: makexin
 * @Date: 2019/9/2619:46
 */
public class Main {
    public static void main(String[] args)
    {
        int[] array = {2,5,5,8,1,8,0,6};
//        BubbleSort bubbleSort = new BubbleSort();
//        System.out.println("bubble sort: "+ Arrays.toString(bubbleSort.sort(array)));
//        SelectionSort selectionSort = new SelectionSort();
//        System.out.println("selection sort: " + Arrays.toString(selectionSort.sort(array)));
//        InsertationSort insertationSort = new InsertationSort();
//        System.out.println("Insertation sort: " + Arrays.toString(insertationSort.sort(array)));
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(array);
//        System.out.println(Arrays.toString(array));
        QuickSort quickSort = new QuickSort();
//        quickSort.Sort(array);
        quickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
