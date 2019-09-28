/**
 * @Author: makexin
 * @Date: 2019/9/2819:03
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k)
    {
        if (head == null)
            return head;

        ListNode p = head;
        int length = 0;
        do {
            p = p.next;
            length++;
        }while (p!=null);

        if (k > length)
            return null;

        int i = 0;
        p = head;
        while (i != length - k)
        {
            p = p.next;
            i++;
        }
        return p;
    }

    public ListNode FindKthToTail_v2(ListNode head, int k)
    {
        if (head == null || k==0)  //特殊情况判断
            return null;

        ListNode pAhead = head;
        ListNode pBehind = null;

        for (int i = 0; i < k-1; i++) //先后k-1步，且next！=null
        {
            if (pAhead.next == null) // 当链表结点个数不足k个时，提前返回null
                return null;
            else
                pAhead = pAhead.next;
        }
        pBehind = head;
        while (pAhead.next!=null)
        {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }
}
