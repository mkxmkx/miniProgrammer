/**
 * @Author: makexin
 * @Date: 2019/12/514:46
 */
public class Solution {
    public static int deSerIndex = 0;
    String Serialize(TreeNode root)
    {
        String res = new String();
        if (root == null)
            return res;
        res = preOreder(root, res);
        return res;
    }
    String preOreder(TreeNode root, String s)
    {
        String temp = s;
        if (root!=null)
        {
            temp = temp + String.valueOf(root.val) + "!";
            temp = preOreder(root.left, temp);
            temp = preOreder(root.right, temp);
        }
        else
            temp += "#";
        return temp;
    }
    TreeNode Deserialize(String str)
    {
        if (str.length() == 0 || str == "")
            return null;
        deSerIndex = 0;
        TreeNode tree = DeSer(str);
        return tree;
    }
    TreeNode DeSer(String str)
    {
        TreeNode tree = null;
        if (deSerIndex<=str.length() && str.charAt(deSerIndex)!='#')
        {
            int val = 0;
            while (str.charAt(deSerIndex)!='!')
            {
                val = val*10 + str.charAt(deSerIndex) - 48;
                deSerIndex++;
            }
            deSerIndex++;
            tree = new TreeNode(val);
            tree.left = DeSer(str);
            tree.right = DeSer(str);
        }
        else
            deSerIndex++;
        return tree;
    }

    public static void main(String[] args)
    {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(5);
        Solution s = new Solution();
        String ser = s.Serialize(tree);
        System.out.println(ser);
        TreeNode temp = s.Deserialize(ser);
        System.out.println(s.Serialize(temp));
    }
}
