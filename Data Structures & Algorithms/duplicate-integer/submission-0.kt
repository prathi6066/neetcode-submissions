class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            if (map.containsKey(num)) {
                return true
            } else {
                map[num] = 1
            }
        }

        return false

    }
}
