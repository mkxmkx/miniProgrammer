题目：
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

思路：
  要求两个数相加等于target，对数组进行排序。排序之后的数组两边各有一个指针，即指向大元素j和小元素i。两个指针所指元素相加。
  若result大于target，则说明大元素需要减小，则j--。若result小于target，则说明小元素需要增大，则i++。即可寻找出结果。
  需要注意：题目要求返回原数组两个数的索引，上面对数组进行排序之后的索引改变了，
  所以需要一个另外的数组来保存排序之后的数组每一个元素所对应初始数组的索引位置。
