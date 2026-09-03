class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val prefix = IntArray(nums.size)
        val suffix = IntArray(nums.size)
        nums.forEachIndexed { i, num ->
            if (i == 0) {
                prefix[0] = 1
            } else {
                prefix[i] = prefix[i-1] * nums[i-1]
            }
        }

        for (i in nums.lastIndex downTo 0) {
            if (i == nums.lastIndex) {
                suffix[i] = 1
            } else {
                suffix[i] = suffix[i+1] * nums[i+1]
            }
        }

        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            result[i] = suffix[i] * prefix[i]
        }

        return result

    }
}
