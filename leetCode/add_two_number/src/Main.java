import listNode.ListNode;
import listNode.Solution;

public class Main {

    public static void main(String[] args)
    {
        ListNode p1 = new ListNode(2);
        p1.next = new ListNode(3);
        ListNode p2 = new ListNode(1);
        Solution s = new Solution();
        ListNode r = s.addTwoNumbers(p1, p2);
        while (r!=null)
        {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
