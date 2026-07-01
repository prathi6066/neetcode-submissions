class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numset = HashSet<Int>()

        nums.forEach { num ->
            if(!numset.add(num)) return true
        }

        return false

    }
}
