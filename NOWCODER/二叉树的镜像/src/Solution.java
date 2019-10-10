import java.util.LinkedList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/10/1011:04
 */
public class Solution {
    public void Mirror(TreeNode root)
    {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode temp = queue.pop();
            //交换左右子树
            TreeNode left = temp.right;
            temp.right = temp.left;
            temp.left = left;

            //层序遍历
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }

    }

    public void mirror_v2(TreeNode root)
    {
        if (root == null)
            return;
        else
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror_v2(root.left);
            mirror_v2(root.right);
        }
    }

    public static void main(String[] args)
    {
        TreeNode tree = new TreeNode(9);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        Solution s = new Solution();
        s.Mirror(tree);
    }
}
