# 剑指offer——替换空格
## 【题目描述】
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

## 【解题思路】
因为我是用java写的，选择了语言以后给出了输入数据的类型，我看是StringBuffer类型的。因为StringBuffer有replace函数，所以就写了个循环，判断字符串中是否有空格，若有空格，则将那个空格替换为“%20”。继续循环判断，直到替换完所有的空格。这个思路提交了代码，通过了。

【java代码如下】

```
/**
 * @Author: makexin
 * @Date: 2019/9/1119:25
 */
public class Solution {
    public String replaceSpace(StringBuffer str)
    {
        while (str.indexOf(" ") != -1)
        {
            int index = str.indexOf(" ");
            str.replace(index, index+1, "%20");
        }
        return str.toString();
    }
}
```

本来以为好简单一个题，然后去网上看了一下别人的解析，才发现是我想的太简单。虽然代码通过了，但是复杂度高O(n2)。因为从头到尾一次检测空格，每检测一个空格替换为“%20”，由于是将1个空格替换为3个字符，因此每次替换，后面n个字符都会被往后挪两个位置。若有n个空格，则该代码复杂度为O(n2)。

## 【解题思路优化】
若可以减少字符移动次数，则复杂度就降低了。
先遍历一遍字符串，判断出一共有多少个空格，则可知道最终字符串的长度，然后从后往前一次判断。则总的时间复杂度为O(2n）。
