import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/9/1614:29
 */
public class main {

    public static void main(String args[])
    {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(6);
        listNode.next = new ListNode(7);

        Solution s = new Solution();
        ArrayList<Integer> arrayList = s.printListFromTailToHead(listNode);
        System.out.println(arrayList);
    }
}
