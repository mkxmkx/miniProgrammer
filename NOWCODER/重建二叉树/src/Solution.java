/**
 * @Author: makexin
 * @Date: 2019/9/1719:21
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in)
    {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;
        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public TreeNode construct(int[] pre, int p_start, int p_end, int[] in, int i_start, int i_end)
    {
        if (p_start > p_end)
            return null;
        if (i_start > i_end)
            return null;

        int val = pre[p_start];
        int index = 0;
        boolean index_flag = false;
        TreeNode node = new TreeNode(val);
        for (int i = i_start; i<=i_end; i++)
        {
            if(in[i] == val)
            {
                index = i;
                index_flag = true;
                break;
            }
        }
        if (index_flag == true)
        {
            node.left = construct(pre, p_start+1, p_start+index-i_start, in, i_start, index-1);
            node.right = construct(pre, p_start+index-i_start+1, p_end, in, index+1, i_end);
        }

        return node;
    }
}
