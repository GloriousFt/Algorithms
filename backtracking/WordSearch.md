###Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
```java
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
```

[Leetcode Word Search](https://leetcode.com/problems/word-search/)

```java
public class Solution {
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int[][] map = new int[board.length][board[0].length];
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (backtracking(board, map, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtracking (char[][] board, int[][] map, int m, int n, int index, String word) {
        if (word.charAt(index) != board[m][n]) {
            return false;
        }
        if (index == word.length() - 1) {
        	return true;
        }
        map[m][n] = 1;
        if (m - 1 >= 0 && map[m - 1][n] == 0 && backtracking(board, map, m - 1, n, index + 1, word)) {
            return true;
        }
        if (m + 1 < map.length && map[m + 1][n] == 0 && backtracking(board, map, m + 1, n, index + 1, word)) {
            return true;
        }
        if (n - 1 >= 0 && map[m][n - 1] == 0 && backtracking(board, map, m, n - 1, index + 1, word)) {
            return true;
        }
        if (n + 1 < map[0].length && map[m][n + 1] == 0 && backtracking(board, map, m, n + 1, index + 1, word)) {
            return true;
        }
        map[m][n] = 0;
        return false;
    }
}
```