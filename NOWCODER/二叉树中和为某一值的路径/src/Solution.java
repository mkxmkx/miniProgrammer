import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/10/1513:07
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        FindPathStep(array, new ArrayList<Integer>(), root, target, 0);
        int i, j;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[array.size()];//标记该数组是否已经被排序使用过
        for (i=0; i<array.size(); i++)
            flag[i] = false;

        //根据数组长度排序
        for (i=0; i<array.size(); i++)
        {
            int maxLength = -1;
            int maxIndex = -1;
            for (j=0; j<array.size(); j++)
            {

                if (!flag[j] && array.get(j).size()>maxLength)
                {
                    maxIndex = j;
                    maxLength = array.get(j).size();
                }
            }
            result.add(array.get(maxIndex));//取出剩余数组中长度最大的
            flag[maxIndex] = true;
        }
        return result;
    }
    public void FindPathStep(ArrayList<ArrayList<Integer>> array, ArrayList<Integer> path, TreeNode root, int target, int sum)
    {
        if (root == null)
            return;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(path);//将当前path复制一份，保存在当前环境中，即为当前的路径，当前路径改变之后不会改变其它遍历时的值。
        //因为list实质是引用，需要注意
        temp.add(root.val);
        if (root.left == null && root.right == null) //到了叶节点
        {
            if ((sum+root.val) == target)
            {
                array.add(temp);
            }
            return;
        }
        else
        {
            if ((sum+root.val) < target)
            {
                FindPathStep(array, temp, root.left, target, sum+root.val);
                FindPathStep(array, temp, root.right, target, sum+root.val);
            }
        }
    }
}
