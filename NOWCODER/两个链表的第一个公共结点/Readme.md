## 剑指offer——两个链表的第一个公共结点

## 【题目描述】
输入两个链表，找出它们的第一个公共结点。

## 【解题思路】
找到公共结点，即就是一个链表中的节点在另一个链表中出现了。如果采用暴力搜索的方法，对于链表p1, p2。每次在p1中遍历到一个结点，就在p2中遍历一整遍判断有没有出现。这样的方法复杂度太高，且每个结点都遍历了好多遍，做了很多多余的工作。
### 优化的方法：
遍历一遍p1，将p1中所有结点都存在一个map中，节点作为键值。然后再遍历p2，在遍历的时候，每得到一个结点，就判断该节点有没有在map中出现过。若没有出现，则说明没有与p1链表重合；若出现了，则说明该结点与p1链表结点重合了，即找到了结果。
这种方法只遍历两边即可得到结果。

## 【代码实现】

```java
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/2719:46
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        Map<ListNode, Integer> nodeMap = new HashMap<>();
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = pHead1;
        p2.next = pHead2;
        ListNode result = null;
        while (p1.next!=null)
        {
            nodeMap.put(p1.next, 1);
            p1 = p1.next;
        }
        while (p2.next!=null)
        {
            if (nodeMap.containsKey(p2.next))
            {
                result = p2.next;
                break;
            }
            p2 = p2.next;
        }
        return result;
    }
}

```
