class Solution {
    fun characterReplacement(s: String, k: Int): Int {

        val seen = mutableMapOf<Char, Int>()

        var left = 0
        var maxFreq = 0
        var res = 0
        for (right in s.indices) {
            seen[s[right]] = seen.getOrDefault(s[right], 0)+1
            maxFreq = maxOf(maxFreq, seen[s[right]]!!)

            if(((right - left+1)-maxFreq) > k) {
                seen[s[left]] = seen[s[left]]!! - 1
                left++
            }

            res = maxOf(res, right-left + 1)
        }

        return res

    }
}
