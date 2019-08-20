package twosum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] flag = new int[nums.length];  //辅助记录每个数字的原始数组索引
        for(int i = 0; i<nums.length; i++)
            flag[i] = i;
        //冒泡排序
        for(int i=0; i<nums.length; i++)
        {
            for(int j=1; j<nums.length-i; j++)
            {
                System.out.println(nums[j] + " " + nums[j-1]);
                if(nums[j]<nums[j-1])
                {
                    int temp;
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    temp = flag[j-1];
                    flag[j-1] = flag[j];
                    flag[j] = temp;
                }
            }
        }
        for (int x: nums) {
            System.out.print(x + " ");
        }

        int[] final_result = new int[2];
        for(int i=0, j=nums.length-1; i<=j; )
        {
            int result = nums[i] + nums[j];
            if(result == target)
            {
                final_result[0] = flag[i];
                final_result[1] = flag[j];
                break;
            }
            else
            {
                if(result > target)
                {
                    j--;
                }
                else
                {
                    i++;
                }
            }
        }

        return final_result;
    }
}