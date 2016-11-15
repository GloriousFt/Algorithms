# Algorithms
Category of practical algorithms in Java

Each branch of this repository represents an algorithm. Clone one branch as you needed.

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