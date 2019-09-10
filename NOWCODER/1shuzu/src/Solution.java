/**
 * @Author: makexin
 * @Date: 2019/9/1010:17
 */
public class Solution {
    public boolean Find(int target, int [][] array)
    {
        int i = 0;
        int j = array[0].length - 1;
        while (i<array.length && j>=0)
        {
            if (target == array[i][j])
                break;
            if (target > array[i][j])
            {
                i++;
            }
            else
                j--;
        }

        if (i>=array.length || j<0)
            return false;
        else
            return true;

    }
}
