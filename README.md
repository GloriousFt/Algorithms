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