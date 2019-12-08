
/**
 * @Author: makexin
 * @Date: 2019/12/811:01
 */
import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
    // 最小堆（右）
    private PriorityQueue<Integer> rHeap = new PriorityQueue<>();
    // 最大堆（左）
    private PriorityQueue<Integer> lHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    // 保证lHeap.size()>=rHeap.size()
    public void Insert(Integer num) {
        // 先按大小插入，再调整
        if(lHeap.isEmpty() || num <= lHeap.peek())
            lHeap.offer(num);
        else
            rHeap.offer(num);

        if(lHeap.size() < rHeap.size())
        {
            lHeap.offer(rHeap.peek());
            rHeap.poll();
        }
        else if(lHeap.size() - rHeap.size() == 2)
        {
            rHeap.offer(lHeap.peek());
            lHeap.poll();
        }
    }
    public Double GetMedian() {
        if(lHeap.size() > rHeap.size())
            return new Double(lHeap.peek());
        else
            return new Double(lHeap.peek() + rHeap.peek())/2;
    }
}
