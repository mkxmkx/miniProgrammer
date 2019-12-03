import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/12/314:36
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        LinkedList<TreeNode> p = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        p.add(pRoot);
        ArrayList<Integer> temp = new ArrayList<>();
        int flag = 1;
        while (!p.isEmpty() || !q.isEmpty())
        {
            if (flag%2 != 0)
            {
                while (!p.isEmpty())
                {
                    TreeNode node = p.poll();//取队列第一个元素，并从队列中删除
                    temp.add(node.val);
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right!= null)
                        q.add(node.right);
                }
            }
            if (flag%2 == 0)
            {
                while (!q.isEmpty())
                {
                    TreeNode node = q.poll();
                    temp.add(node.val);
                    if (node.left!=null)
                        p.add(node.left);
                    if (node.right!=null)
                        p.add(node.right);
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            flag++;
        }
        return res;
    }
}
