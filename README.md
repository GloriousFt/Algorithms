# Algorithms
Category of practical algorithms in Java

Each branch of this repository represents an algorithm. Clone one branch as you needed.

每个分支都有相应算法具体的问题分析和讲解。

## Backtracking(回溯算法)
回溯算法其实就是利用深度优先遍历算法的一种"暴力破解"的算法。说它暴力,是因为它找出了每一个可能解,然后根据要求来进行筛选,适当的剪枝能对其性能提升很多。

最坏的情况下,它的时间复杂度是指数计算的。

它的思想就是:对每一步进行试验,check当前是否不存在解,如果存在就继续向下找,如果不存在则退出当前状态,回到之前的状态进行跳过当前状态的下一步搜索。一直找出所有解(可能没有解)。

> 根据这个思想,**递归**是其最好的实现方法。

常见的问题:

* 全排列问题 (Permutations)
* 集合中查找和为目标值的组合 (Combination Sum)
* N皇后问题 (N-Queens)
* 矩阵word搜索 (Word Search)
* 集合值组合问题 (Combinations)

##Binary Search(二分查找)

Binary Search 是查找的算法中非常常用的一种,本身算法实现并不难,但是难在如何应用到各种实际问题中去,往往想到要用binary search是难点。

**集合一般是有序的才会用到二分查找**

基本思想是:

* 先确定问题集合,排序集合
* 在有序集合中进行左起始标记,右起始标记
* 循环查找集合,对中间值赋值,每次用集合中间位的值与target进行比较,直到左边大于右边的标记
* 根据比较结果确定下次循环中左右标记的值

Binary Search比较简单,应用是难点。

常见问题:

* 有序2D矩阵搜索(Search a 2D Matrix)

## Linklist(链表相关算法)

链表是非常常用的一种数据结构,涉及链表操作的算法非常多,一些特殊的链表操作算法能让效率提高很多。

常见的问题:

* 链表去重 (Remove Duplicates)
* 链表分割 (Partition List)
* 链表转置 (Reverse Linked)
