## 剑指offer——字符串的排列

## 【题目描述】

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
### 输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

## 【解题思路】
先将字符串中每个字符按照字典序排序。然后可以按照深度优先遍历DFS的思想，从第一个字符开始排列，每当到一个叶节点，就把当前排列顺序加进去。
在递归的时候，需要借助数组标志位来记录该元素是否被访问过。在访问并递归访问之后的元素之后，需要把当前标志位复原，以准备下一个排列顺序的访问。

对于去除重复排列的问题，使用一个set来保证。同时为了保持元素顺序不变，要用LinkedHashSet.
## 【代码实现】

```java
import java.util.*;

/**
 * @Author: makexin
 * @Date: 2019/10/1813:03
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str==null || str.equals(""))
        {
            return result;
        }

        Set<String> set = new LinkedHashSet<>();//保证元素不重复。因为要保持元素的顺序，所以需为linkedHashSet
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] temp = new char[chars.length];
        boolean[] flag = new boolean[str.length()];
        for (int i=0; i<str.length(); i++)
            flag[i] = false;
        dfs(set, chars, temp, flag, 0);
        result.addAll(set);
        return result;

    }

    public void dfs(Set<String> set, char[] chars, char[] temp, boolean[] flag, int index)
    {
        if (index == chars.length)
        {
            set.add(new String(temp));
            return;
        }
        for (int i = 0; i<chars.length; i++)
        {
            if (!flag[i])
            {
                temp[index] = chars[i];
                flag[i] = true;
                dfs(set, chars, temp, flag, index+1);
                flag[i] = false;//将标志位复原，以准备下一次使用
            }
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        s.Permutation("aba");
    }
}

```
## 补充
还有一种解题思路就是动态规划，将当前问题分解为固定一个元素，剩余元素全排列。之后对剩余元素又进行同样的处理。

实现方法：
参考https://juejin.im/post/5b52994fe51d45198855fd32
```java
    public static void permutation2(int index, char[] chars, Set<String> set) {
        if(index == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        for(int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutation2(index + 1, chars, set);
            swap(chars, index, i);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

```