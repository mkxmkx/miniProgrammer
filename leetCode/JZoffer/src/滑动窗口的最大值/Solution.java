package 滑动窗口的最大值;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2020/7/1410:01
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0 || size>num.length)
            return res;
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        for(int i = 0; i<size-1; i++)
        {
            while (!queue.isEmpty() && queue.getLast()<num[i])
            {
                queue.removeLast();
                index.removeLast();
            }
            queue.addLast(num[i]);
            index.addLast(i);
        }
        for(int i = size-1; i<num.length; i++)
        {
            while (!index.isEmpty() && index.getFirst()<=i-size)
            {
                queue.removeFirst();
                index.removeFirst();
            }
            while (!queue.isEmpty() && queue.getLast()<num[i])
            {
                queue.removeLast();
                index.removeLast();
            }
            queue.addLast(num[i]);
            index.addLast(i);
            res.add(queue.getFirst());
        }
        return res;
    }
}
