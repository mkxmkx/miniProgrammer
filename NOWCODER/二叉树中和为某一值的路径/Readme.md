## 剑指offer——二叉树中和为某一值的路径
## 【题目描述】
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到**叶结点**所经过的结点形成一条路径。(**注意: 在返回值的list中，数组长度大的数组靠前**)

## 【解题思路】
使用树的先序遍历，从根节点依次向下，到叶节点的时候判断一下是否符合题目条件。为了减少不必要的计算，在遍历过程中，当到一个节点值和比target大时，就不再继续向下遍历了。

题目中说， 返回的list中需要按照数组长度排序，因此在最终的结果中需要按照数组长度排序，才符合题目要求。

## 【代码实现】

```java
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

```

## 【改进】
我对数组的排序是借助于一个布尔型数组记录每个path数组是否被排序过。
看了网上别人的代码，有一种更简洁的代码，使用Collections.sort函数，然后override 一下compare函数。即可实现数组的排序。

```java


public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();
 
        helper(root,target,cur,res);
        
        //自定义比较函数
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()<o2.size()){
                    return 1;
                }else return -1;
            }
        });
        return res;
    }
    public void helper(TreeNode root,int target,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> res){
        if (root==null) return;
        int value=root.val;
        cur.add(value);
        if (target==value&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(cur));
        }else {
            helper(root.left,target-value,cur,res);
            helper(root.right,target-value,cur,res);
        }
 
        cur.remove(cur.size()-1);
    }
```
