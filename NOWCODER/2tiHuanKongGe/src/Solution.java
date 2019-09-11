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
            //replace(start, end, str)函数，start：起始索引（包括），end：结束索引（不包括）
        }
        return str.toString();
    }
}
