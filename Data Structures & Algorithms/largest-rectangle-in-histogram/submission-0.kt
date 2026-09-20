class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Pair<Int, Int>>()
        var maxArea = 0
        for (i in heights.indices) {
            var start = i
            while(!stack.isEmpty() && stack.last().second > heights[i]) {
                val curr = stack.removeLast()
                maxArea = maxOf(maxArea, curr.second * (i - curr.first))
                start = curr.first
            }
            stack.addLast(Pair(start, heights[i]))
        }

        while(!stack.isEmpty()) {
            val curr = stack.removeLast()
            val len = heights.size
            maxArea = maxOf(maxArea, curr.second * (len - curr.first))
        }

        return maxArea

    }
}
