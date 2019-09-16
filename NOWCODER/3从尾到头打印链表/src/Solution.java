import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/9/1614:33
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (listNode == null)
            return result;
        while (true)
        {
            temp.add(listNode.val);
            if (listNode.next == null)
                break;
            listNode = listNode.next;
        }
        Integer length = temp.size();
        for(int i = length-1; i >= 0; i--)
        {
            result.add(temp.get(i));
        }
        return result;
    }
}
