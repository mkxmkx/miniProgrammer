import java.util.HashSet;
import java.util.Set;

/**
 * @Author: makexin
 * @Date: 2019/11/2719:37
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null)
            return null;
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode p = pHead;
        ListNode result = null;
        while (p!=null)
        {
            if (nodeSet.contains(p))
            {
                result = p;
                break;
            }
            nodeSet.add(p);
            p = p.next;
        }
        return result;
    }
}
