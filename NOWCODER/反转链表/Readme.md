## 剑指offer——反钻链表

### 【题目描述】
输入一个链表，反转链表后，输出新链表的表头

## 【解题思路】
因为是单链表，所以只能从前向后遍历链表。
新设置一个链表头。每遍历一个原链表元素，就插入到新链表的最头的部分。即先保存之前已反转的链表，然后将新元素插到链表头，再将保存的之前已反转的链表插入到新元素的后面。即完成了反转。

## 【代码实现】
链表结构：

```java
/**
 * @Author: makexin
 * @Date: 2019/10/813:32
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}

```

```java
/**
 * @Author: makexin
 * @Date: 2019/10/813:32
 */
public class Solution {
    public ListNode ReverseList(ListNode head)
    {
        ListNode newHead = new ListNode(0);
        ListNode p = newHead, q = head;
        if (head == null)
            return null;

        do {
            //临时保存之前已经反转的链表
            ListNode temp = p.next;
            p.next = new ListNode(q.val);
            p.next.next = temp;//将之前反转的链表连接到最新的元素后
            q = q.next;
        }while (q!=null);
        return newHead.next;
    }
}

```
