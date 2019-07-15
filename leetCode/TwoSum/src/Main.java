import twosum.Solution;

public class Main {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        Solution s = new Solution();
        int[] result = s.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
