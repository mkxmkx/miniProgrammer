import java.util.Arrays;

/**
 * @Author: makexin
 * @Date: 2020/5/149:20
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i, j;
        i=1;
        for(j=2; j<nums.length; j++)
        {
            if(nums[j]!=nums[i-1])
            {
                nums[++i] = nums[j];
            }

        }
        int len = i+1;
        return len;
    }
    public static void main(String[] args)
    {
        int[] nums = {1,1,1,2,2,3};
        new Solution().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
