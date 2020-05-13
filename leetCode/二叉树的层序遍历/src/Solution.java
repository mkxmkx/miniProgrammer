import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: makexin
 * @Date: 2020/5/139:26
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        int flag = 0;
        first.addLast(root);
        while (!first.isEmpty() || !second.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if(flag%2 == 0)
            {
                for(TreeNode node: first)
                {
                    temp.add(node.val);
                    if (node.left != null)
                        second.addLast(node.left);
                    if (node.right!=null)
                        second.addLast(node.right);
                }
                first.clear();

            }
            else
            {
                for (TreeNode node: second)
                {
                    temp.add(node.val);
                    if (node.left != null)
                        first.addLast(node.left);
                    if (node.right != null)
                        first.addLast(node.right);
                }
                second.clear();
            }
            flag++;
            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        return res;
    }
}
