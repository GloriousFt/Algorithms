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
