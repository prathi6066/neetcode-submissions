class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = matrix.size
        var col = matrix[0].size

        var left = 0
        var right = (row * col) - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val r = mid / col
            val c = mid % col
            val curr = matrix[r][c]

            if (curr == target) {
                return true
            } else if (curr > target) {
                right = mid -1
            } else {
                left = mid + 1
            }
        }

        return false

    }
}
