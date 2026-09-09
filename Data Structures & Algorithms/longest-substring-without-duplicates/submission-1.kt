class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = mutableMapOf<Char,Int>()

        var left = 0
        var maxLen = 0

        for (right in s.indices) {
            if (seen.containsKey(s[right])) {
                left = maxOf(seen.getOrDefault(s[right], 0)+1, left)
            }

            seen[s[right]] = right
            maxLen = maxOf(maxLen, (right - left) + 1)
        }

        return maxLen
    }
}
