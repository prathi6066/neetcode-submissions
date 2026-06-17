class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1

        var maxSum = 0

        while (left < right) {
            val sum = (right - left) * Math.min(heights[left], heights[right])
            maxSum = Math.max(sum, maxSum)
            if (heights[left] <= heights[right]) {
                left++
            } else {
                right--
            }
        }

        return maxSum

    }
}
