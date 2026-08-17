class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            val res = map.getOrPut(num) { 0 }
            map[num] = res + 1
        }

        return map.entries
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }.toIntArray()
    
    }
}
