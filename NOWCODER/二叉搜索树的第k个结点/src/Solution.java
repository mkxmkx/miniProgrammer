
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/12/720:56
 */
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        LinkedList<TreeNode> orderList = new LinkedList<>();
        int p = 0;
        TreeNode node = pRoot;
        while (node!=null || !orderList.isEmpty())
        {
            while (node!=null)//左节点入栈
            {
                orderList.push(node);
                node = node.left;
            }
            if (!orderList.isEmpty())
            {
                node = orderList.pop();
                p++;
                if (p == k)
                    break;
                node = node.right;
            }
        }
        if (p == k)
            return node;
        else
            return null;
    }

    public static void main(String[] args)
    {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        Solution s = new Solution();
        s.KthNode(tree, 3);
    }

}
