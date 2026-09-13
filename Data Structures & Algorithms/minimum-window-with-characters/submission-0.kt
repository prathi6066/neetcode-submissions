class Solution {
    fun minWindow(s: String, t: String): String {

    val tMap = mutableMapOf<Char, Int>()
    val sMap = mutableMapOf<Char, Int>()

    for (c in t) {
        tMap[c] = tMap.getOrDefault(c, 0) + 1
    }

    var resIndex = Pair(-1, -1)
    var minLen = Int.MAX_VALUE
    var left = 0
    val needed = tMap.keys.size
    var current = 0

    for (right in s.indices) {
        val rc = s[right]
        sMap[rc] = sMap.getOrDefault(rc ,0) + 1
        if (tMap.containsKey(rc) && sMap[rc] == tMap[rc] ) {
            current++
        }

        while (current == needed) {
            if (minLen > (right - left + 1)) {
                minLen = right - left + 1
                resIndex = Pair(left, right)
            }

            val lc = s[left]
            sMap[lc] = sMap.getOrDefault(lc, 0) - 1
            if(tMap.containsKey(lc) && sMap[lc]!! < tMap[lc]!!) {
                current--
            }
            left++
        }
    }

    return if(minLen == Int.MAX_VALUE) "" else s.substring(resIndex.first, resIndex.second+1)
}
}
