import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/1713:15
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree)
    {
        if (pRootOfTree == null)
            return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        midDFS(queue, pRootOfTree);
        TreeNode pre = queue.pop();
        TreeNode next, head = pre;
        while (!queue.isEmpty())
        {
            next = queue.pop();
            pre.right = next;
            next.left = pre;
            pre = next;
        }
        return head;
    }
    public void midDFS(LinkedList<TreeNode> queue, TreeNode root)
    {
        if (root!=null)
        {
            midDFS(queue, root.left);
            queue.add(root);
            midDFS(queue, root.right);
        }

    }
}
