import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/1413:17
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> tree = new LinkedList<>();  // 队列
        if (root == null)
            return result;
        tree.add(root);
        while (!tree.isEmpty())
        {
            TreeNode temp = tree.pop();
            result.add(temp.val);
            if (temp.left != null)
            {
                tree.add(temp.left);
            }
            if (temp.right != null)
            {
                tree.add(temp.right);
            }
        }
        return result;
    }
}
