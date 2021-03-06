/**
 * @Author: makexin
 * @Date: 2019/9/2420:02
 */
public class Solution {
    public int RectCover(int target)
    {
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("result: " + s.RectCover(5));
    }
}
