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
