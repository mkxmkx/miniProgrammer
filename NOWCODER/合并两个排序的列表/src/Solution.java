

/**
 * @Author: makexin
 * @Date: 2019/10/815:39
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2)
    {
        ListNode newList = new ListNode(0);
        ListNode p = list1, q = list2, head = newList;
        while (p!=null && q!=null)//循环停止条件，至少有1个链表已经循环完了
        {
            if (p.val == q.val)
            {
                newList.next = p;
                p = p.next;
                newList.next.next = q;
                q = q.next;
                newList = newList.next.next;
            }
            else {
                if (p.val > q.val)//q的值较小，将q付给newList
                {
                    newList.next = q;
                    newList = newList.next;
                    q = q.next;
                }
                else //p的值较小，将p付给newList
                {
                    newList.next = p;
                    newList = newList.next;
                    p = p.next;
                }
            }
        }

        //剩余部分统一拼到最后
        if (p!=null)
            newList.next = p;
        if (q!=null)
            newList.next = q;
        return head.next;
    }

    public ListNode merge_digui(ListNode list1, ListNode list2)
    {
        //首先判断是否为null
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode newList = null;
        if(list1.val <= list2.val)
        {
            newList = list1;
            newList.next = merge_digui(list1.next, list2);
        }
        else
        {
            newList = list2;
            newList.next = merge_digui(list1, list2.next);
        }
        return newList;
    }
}
