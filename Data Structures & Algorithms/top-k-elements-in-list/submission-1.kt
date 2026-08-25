class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val buckets = Array(nums.size + 1) { mutableListOf<Int>() }

    for (entry in map.entries) {
        buckets[entry.value].add(entry.key)
    }

    val result = IntArray(k)

    var index =0
    for (i in buckets.lastIndex downTo 0) {
        for (bucket in buckets[i]) {
            result[index++] = bucket
            if (index == k) {
                return result
            }
        }
        
    }
    
    return result
}
}
