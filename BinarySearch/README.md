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

* [Search a 2D Matrix]()


###Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

```java
Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
```
Given `target` = `3`, return `true`.

```java
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    int m = matrix.length, n = matrix[0].length ;
    int left = 0, right = m * n - 1, mid, x, y;
    while (left <= right) {
        mid = left + (right - left) / 2;
        x = mid / n;
        y = mid % n;
        if (matrix[x][y] == target) {
            return true;
        } else if (matrix[x][y] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}
```