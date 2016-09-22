###N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example, there exists two distinct solutions to the 4-queens puzzle:

[
 [".Q..",
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",
  "Q...",
  "...Q",
  ".Q.."]
]

[LeetCode N-Queens](https://leetcode.com/problems/n-queens/)

```java
public List<List<String>> solveNQueens(int n) {
    char[][] chessboard = new char[n][n];
    for (int i = 0;i < n;i++) {
        for (int j = 0;j < n;j++) {
            chessboard[i][j] = '.';
        }
    }
    List<List<String>> result = new ArrayList<List<String>>();
    backtracking(result, chessboard, 0);
    return result;
}

private void backtracking(List<List<String>> result, char[][] chessboard, int col) {
    if (col == chessboard.length) {
        result.add(buildChessboardString(chessboard));
        return;
    }
    for (int i = 0;i < chessboard.length;i++) {
        if (availableAt(chessboard, i, col)) {
            chessboard[i][col] = 'Q';
            backtracking(result, chessboard, col + 1);
            chessboard[i][col] = '.';
        }
    }
}

private List<String> buildChessboardString(char[][] chessboard) {
    List<String> result = new ArrayList<String>();
    for (int i = 0;i < chessboard.length;i++) {
        String rowStr = String.valueOf(chessboard[i]);
        result.add(rowStr);
    }
    return result;
}

private boolean availableAt(char[][] chessboard, int x, int y) {
    for (int i = 0;i < chessboard.length;i++) {
        for (int j = 0;j < y;j++) {
            if (chessboard[i][j] == 'Q' && (x == i || x - y == i - j || x + y == i + j)) {
                return false;
            }
        }
    }
    return true;
}
```

N-Queens基本思路是,按照列来进行遍历,每列只放一个,当列号与N相等时,则满足条件,存储结果。

其算法思路与排列等一样,就是回溯算法,只是麻烦在了判断当前棋盘格子能否放皇后和存储结果的地方,其余都是一样的。

```java
if (chessboard[i][j] == 'Q' && (x == i || x - y == i - j || x + y == i + j))
```

这段代码是判断棋盘已有的皇后是否允许当前位置再放置一个皇后。

`x == i`是判断是否在同一行,`x - y == i - j`是判断是否处于正对角线上,`x + y == i + j`是判断是否处于反对角线上。