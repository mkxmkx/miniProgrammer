## 剑指offer——数据流中的中位数
### 【题目描述】
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
### 【解题思路】
一道很经典的题目就是在1亿个数中找到最大的前100个数，这是一道堆应用题，找最大的前100个数，那么我们就创建一个大小为100的最小化堆，每来一个元素就与堆顶元素比较，因为堆顶元素是目前前100大数中的最小数，前来的元素如果比该元素大，那么就把原来的堆顶替换掉。

那么对于这一道题呢？如果单纯的把所有元素放到一个数组里，每次查找中位数最快也要O(n)，综合下来是O(n^2)的复杂度。我们可以利用上面例子中的想法，用一个最大堆来维护当前前n/2小的元素，那么每次找中位数只到取出堆顶就可以了。但是，有一个问题，数据要动态增长，有可能之前被替换掉的元素随着元素的增加又跑回来了，所以我们不能单纯得向上题一样把元素丢掉，我们可以再用一个最小化堆来存前n/2大的元素。

可以用最大堆和最小堆来装载这些数据：

最大堆装左边的数据，取出堆顶（最大的数）的时间复杂度是O(1)
最小堆装右边的数据，同样，取出堆顶（最小的数）的时间复杂度是O(1)
从数据流中拿到一个数后，先按顺序插入堆中：如果左边的最大堆是否为空或者该数小于等于最大堆顶的数，则把它插入最大堆，否则插入最小堆。然后，我们要保证左边的最大堆的size等于右边的最小堆的size或者最大堆的size比最小堆的size大1。
要获取中位数的话，直接判断最大堆和最小堆的size，如果相等，则分别取出两个堆的堆顶除以2得到中位数，不然，就是最大堆的size要比最小堆的size大，这时直接取出最大堆的堆顶就是我们要的中位数。

### 【代码实现】

```java

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

```
