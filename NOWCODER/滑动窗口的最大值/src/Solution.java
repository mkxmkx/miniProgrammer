import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/12/911:15
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size==0)
            return res;
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i<size-1; i++)
        {
            while (!queue.isEmpty() && queue.getLast()<=num[i])
            {
                queue.removeLast();
                index.removeLast();
            }
            queue.addLast(num[i]);
            index.addLast(i);
        }
        for (int i = size-1; i<num.length; i++)
        {
            if (!index.isEmpty() && index.getFirst() <= i-size)
            {
                queue.removeFirst();
                index.removeFirst();
            }

            while (!queue.isEmpty() && queue.getLast()<=num[i])
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
