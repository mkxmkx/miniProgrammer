package listNode;

/**
 * @Author: makexin
 * @Date: 2019/8/2021:07
 */
public class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        //carry用来计算相同位两个数字相加的结果，carry初始值为进位的结果。
        // 将计算结果模10则为next的结果，然后将carry除10则得进位的结果。
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode p1 = l1, p2 = l2, r = result;
        while (p1!=null || p2!=null)
        {
            if (p1!=null)
            {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2!=null)
            {
                carry += p2.val;
                p2 = p2.next;
            }
            r.next = new ListNode(carry % 10);
            r = r.next;
            carry /= 10;
        }
        //当两个数都计算完之后，若还有进位，则把进位加上去
        if (carry == 1)
            r.next = new ListNode(1);
        return result.next;
    }
}