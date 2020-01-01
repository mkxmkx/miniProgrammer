/**
 * @Author: makexin
 * @Date: 2019/12/3110:33
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (nums1 == null || nums1.length == 0)
            return nums2[nums2.length/2];
        if (nums2 == null || nums2.length == 0)
            return nums1[nums1.length/2];

        int firstL, firstR, secondL, secondR;
        firstL = 0;
        firstR = nums1.length-1;
        secondL = 0;
        secondR = nums2.length - 1;
        while (firstL<=firstR || secondL<=secondR)
        {
            int fmid, smid;
            fmid = smid = -1;
            if (firstL<=firstR)
            {
                fmid = (firstL + firstR)/2;
            }
            if (secondL<=secondR)
                smid = (secondL + secondR)/2;
            if ()

        }

    }
}
