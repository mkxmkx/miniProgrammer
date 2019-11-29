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
