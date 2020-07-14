package 数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: makexin
 * @Date: 2020/7/14 10:12
 */
public class Solution {

    //最小堆（右）
    private PriorityQueue<Integer> rHeap = new PriorityQueue<>();

    //最大堆（左）
    private PriorityQueue<Integer> lHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void Insert(Integer num)
    {
        if(lHeap.isEmpty() || lHeap.peek()>=num)
            lHeap.offer(num);
        else
            rHeap.offer(num);
        if(lHeap.size()<rHeap.size())
        {
            lHeap.offer(rHeap.peek());
            rHeap.poll();
        }
        else if(lHeap.size()-rHeap.size()==2)
        {
            rHeap.offer(lHeap.peek());
            lHeap.poll();
        }

    }

    public Double GetMedian()
    {
        if(lHeap.size()>rHeap.size())
            return new Double(lHeap.peek());
        else
            return new Double(lHeap.peek()+rHeap.peek())/2;
    }
}
