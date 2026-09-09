class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = mutableSetOf<Char>()

        if (s.isEmpty())
            return 0

        var left = 0
        var maxLen = 0

        for (right in s.indices) {

            while(seen.contains(s[right])) {
                seen.remove(s[left])
                left++
            }


            seen.add(s[right])
            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    
    
    }
}
