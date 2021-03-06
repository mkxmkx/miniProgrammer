## 剑指offer——扑克牌顺子
### 【题目描述】
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

### 【解题思路】
值得取值范围确定：1--13，除了大小王取值为0.
遍历数组，统计除大小王之外的数字取值范围。因为一共只有五个数，若存在重复数字的牌，则说明一定不存在顺子。若剩下的数的牌值最大最小值差小于等于4，则说明存在顺子，因为中间没有重复，且空缺的值可以由大小王补。若最大最小值差大于4，则说明不存在五个连着的顺子。

### 【代码实现】

```java
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: makexin
 * @Date: 2019/11/1219:00
 */
public class Solution {
    public boolean isContinuous(int [] numbers)
    {
        boolean result = false;
        if (numbers==null || numbers.length ==0)
            return result;
        Set set = new HashSet();
        int maxNum=0, minNum = 13;//因为扑克牌的取值范围为1--13.所以初始最大值设为0，所有扑克牌数值都比该值大
        //最小值设为最大，所有扑克牌数值都比该值小。
        boolean flag = true;
        for (int i = 0; i<numbers.length; i++)
        {
            if (numbers[i]!=0)
            {
                if (set.contains(numbers[i]))
                {
                    flag = false;
                    break;
                }
                set.add(numbers[i]);
                if (numbers[i] > maxNum)
                    maxNum = numbers[i];
                if (numbers[i] < minNum)
                    minNum = numbers[i];
            }
        }
        if (!flag)
            result = false;
        else
        {
            int diff = maxNum - minNum;
            if (diff>4)
                result = false;
            else
                result = true;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] num = {0, 2, 3, 4, 6};
        Solution s = new Solution();
        System.out.println(s.isContinuous(num));
    }
}

```
