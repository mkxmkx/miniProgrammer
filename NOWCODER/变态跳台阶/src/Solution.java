/**
 * @Author: makexin
 * @Date: 2019/9/249:43
 */
public class Solution {
    public int JumpFloorII(int target)
    {
        if (target == 0 || target == 1)
            return 1;
        return 2*JumpFloorII(target - 1);
    }
}
