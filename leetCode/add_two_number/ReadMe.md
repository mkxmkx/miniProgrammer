题目：You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

思路：
给出了定义的ListNode类：
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x)
    {
        val = x;
    }
}
首先定义一个用于保存进位结果的变量carry，初始化为0。初始化一个ListNode result，值为0. ListNode r = result.
根据链表特点，循环判断ListNode是否为null，直到两个都为null退出循环。该循环的含义为从个位开始计算，直到两个数都计算完毕。
将相同位的数字相加，同时加上进位数字carry。
将计算的结果取模赋予result.next的值，同时carry除10，得到进位的数字并传递到下次计算。
当循环结束，判断carry是否仍需进位，若carry不为零，则说明需进位，将进位结果赋予result.next的值。
注意：此时result并不是最终的结果，result的指针已经指到了结尾。
      因此，在最初定义result的时候，应同时定义一个指到result头的变量。且由于result的正确结果是从第二个值开始（第一个值赋初值为0）。
      因此最终结果为r.next。
