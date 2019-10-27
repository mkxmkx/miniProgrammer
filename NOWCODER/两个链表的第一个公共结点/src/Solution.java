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
