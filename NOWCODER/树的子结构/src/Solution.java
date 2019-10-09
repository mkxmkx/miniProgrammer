import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/919:17
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2)
    {
        if (root2 == null)
            return false;
        boolean flag;
        boolean leftFlag = false, rightFlag = false;
        if (root1 != null)
        {
            if (root1.val == root2.val)
            {
                flag = JudaeSubtree(root1, root2, true);  //判断root1从该节点开始的子树是否与root2相同，若相同，则返回true。否则，继续遍历root1
                if (flag)
                    return true;
            }
            leftFlag = HasSubtree(root1.left, root2);  //root1左子树中是否存在root2子结构
            rightFlag = HasSubtree(root1.right, root2);  //root1右子树中是否存在root2子结构
        }
        if (leftFlag || rightFlag) // 左右子树中只要存在子结构，则判定为存在子结构
            return true;
        else
            return false;
    }
    public boolean JudaeSubtree(TreeNode root1, TreeNode root2, boolean flag)
    {
        //遍历判断子结构，判断root1中每一个节点是否与root2相同
        if (!flag) // flag为false，则说明上一步判断root1和root2节点元素不同，为false
            return false;
        if (root2 == null)//root2遍历结束，存在子结构
            return true;
        if (root1 == null)//若root1为null，则说明root1元素没有root2多，肯定不存在子结构
            return false;
        if (root1.val == root2.val)
        {
            boolean leftFlag = JudaeSubtree(root1.left, root2.left, flag); // 判断两个树的左子树是否相同
            boolean rightFlag = JudaeSubtree(root1.right, root2.right, flag); // 判断两个树的右子树是否相同
            if (leftFlag && rightFlag)  //当左子树和右子树同时相同时，说明相等
                flag = true;
            else
                flag = false;
            return flag;
        }
        return false;  //两个元素不相等
    }

    public static void main(String[] args)
    {
        TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(7);
        TreeNode tree2 = new TreeNode(9);
        Solution s = new Solution();
        boolean flag = s.HasSubtree(tree1,tree2);
        System.out.println(flag);
    }
}
