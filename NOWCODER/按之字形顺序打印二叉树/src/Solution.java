import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/12/216:02
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot==null)
            return result;
        LinkedList<TreeNode> p = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        p.push(pRoot);
        int flag = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!p.isEmpty() || !q.isEmpty())
        {
            if (flag%2 != 0)//从左到右，访问p，然后按从右到左
            {
                while (!p.isEmpty())
                {
                    TreeNode node = p.pop();//弹出栈顶元素
                    temp.add(node.val);
                    //栈，后进先出，所以按照反的顺序存到栈里
                    if (node.left!=null)
                        q.push(node.left);
                    if (node.right!=null)
                        q.push(node.right);
                }
            }
            if (flag%2 == 0)
            {
                while (!q.isEmpty())
                {
                    TreeNode node = q.pop();
                    temp.add(node.val);
                    if (node.right!=null)
                        p.push(node.right);
                    if (node.left!=null)
                        p.push(node.left);
                }
            }
            result.add(new ArrayList<Integer>(temp));
            temp.clear();
            flag++;
        }
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(2);
        t.right = new TreeNode(4);
        Solution s = new Solution();
        s.Print(t);

    }
}
