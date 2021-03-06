## 剑指offer——删除链表中重复的节点
### 【题目描述】
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

### 【解题思路】
设置三个指针节点，pre_p, p, q。分别指向当前节点的前驱节点，当前节点，当前节点的下一个节点。
每次判断当前节点p不为空，且下一个节点也不为空，则判断当前节点与下一个节点是否重复。
当判断出重复时，pre_p节点不动，删除当前节点，直到与当前节点重复的节点全部删完。全部删除完之后，更前pre_p的next节点。
当没有重复时，则所有指针依次向后移。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/11/2912:25
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return pHead;
        ListNode p, q, pre_p = new ListNode(1), head;
        p = pHead;//当前节点指针
        pre_p.next = pHead;//前驱节点
        head = pre_p;
        while (p!=null && p.next!=null) //当前节点不为空且下一个节点不为空
        {
            q = p.next;//后继结点
            if (p.val == q.val)//有重复节点
            {
                int val = p.val;
                while (p!=null && p.val == val)//删除完所有重复节点
                {
                    p = p.next;
                }
                pre_p.next = p;//更新
            }
            else
            {
                pre_p = pre_p.next;
                p = p.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args)
    {
        ListNode s = new ListNode(3);
        s.next = new ListNode(4);
        s.next.next = new ListNode(4);
        s.next.next.next = new ListNode(5);
        Solution so = new Solution();
        System.out.println(so.deleteDuplication(s).val);
    }
}

```
