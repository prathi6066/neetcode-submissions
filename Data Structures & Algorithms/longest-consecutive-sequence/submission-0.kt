class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        val map = mutableMapOf<Int, Int>()

        var res = 0
        nums.forEach { num ->
            if (map[num] == null) {
                val left = map.getOrDefault(num - 1, 0)
                val right = map.getOrDefault(num + 1, 0)

                val length = left + right + 1

                map[num] = length
                res = maxOf(res, length)

                map[num - left] = length
                map[num + right] = length
            }
        }
        return res

    }
}
