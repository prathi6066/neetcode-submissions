class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { i, num ->
            val s = target - num
            print(s)
            if (map.containsKey(s)) {
                result[0] = map[s] ?: 0
                result[1] = i
                return result
            } else {
                 map[num] = i
            }

        }
        return result

    }
}
