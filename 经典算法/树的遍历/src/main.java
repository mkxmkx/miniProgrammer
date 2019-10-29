import binaryTree.TreeNode;
import binaryTree.middleOrder;
import binaryTree.preOrder;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:13
 */
public class main {
    public static void main(String[] args)
    {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(9);
//        preOrder pre = new preOrder();
//        pre.preOrderTraversal(tree);
        middleOrder mid = new middleOrder();
        mid.middleOrderTraversal(tree);

    }
}
