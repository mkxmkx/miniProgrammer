import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/1613:15
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode result = null, head = new RandomListNode(0), p = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p!=null)
        {
             RandomListNode newNode = new RandomListNode(p.label);
             if (result==null)
             {
                 result = newNode;
                 head.next = result;
             }
             else
             {
                 //给上一个节点的next赋值，然后将result向后移一个，保持与p位置相同。
                 result.next = newNode;
                 result = result.next;
             }

            if (p.random!=null)
                //若p有random节点，则保存相对位置的result节点为键值，复制的新节点为value
                map.put(result, new RandomListNode(p.random.label));

            p = p.next;
        }
        result = head.next;
        while (result!=null)
        {
            if (map.containsKey(result))
            {
                result.random = map.get(result);
            }
            result = result.next;
        }
        return head.next;
    }
    public static void main(String[] args)
    {
        RandomListNode randomListNode = new RandomListNode(5);
        randomListNode.next = new RandomListNode(7);
        randomListNode.random = new RandomListNode(0);
        Solution s = new Solution();
        s.Clone(randomListNode);
    }
}
