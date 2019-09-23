/**
 * @Author: makexin
 * @Date: 2019/9/2322:08
 */
public class Solution {
    public int JumpFloor(int target)
    {
        int result = step(0, target);
        return result;
    }

    public int step(int jump, int target)
    {
        if ((target - jump) == 0)
            return 1;
        int jump_1 = 0;
        int jump_2 = 0;
        if ((target - jump) >= 1)
            jump_1 = step(jump + 1, target);
        if ((target - jump) >= 2)
            jump_2 = step(jump + 2, target);
        return jump_1+jump_2;

    }
}
