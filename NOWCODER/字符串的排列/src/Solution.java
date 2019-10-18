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
