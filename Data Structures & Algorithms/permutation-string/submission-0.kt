class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {

        if ( s1.length > s2.length) return false

    val s1map = IntArray(26) { 0 }
    val s2map = IntArray(26) { 0 }

    for (i in s1.indices) {
        s1map[s1[i] - 'a'] = s1map[s1[i] - 'a'] + 1
        s2map[s2[i] - 'a'] = s2map[s2[i] - 'a'] + 1
    }

    var matches = s1map.zip(s2map).count { (a, b) -> a == b }
    if (matches == 26 ) return true

    for (right in s1.length until s2.length) {
        if (matches == 26) return true

        // Add character coming into window
        val rc = s2[right] - 'a'
        s2map[rc]++
        if (s1map[rc] == s2map[rc]) {
            matches++
        } else if (s1map[rc] == s2map[rc] - 1) {
            matches--
        }

        // Remove character leaving window
        val lc = s2[right - s1.length] - 'a'
        if (s1map[lc] == s2map[lc]) {
            matches--
        }
        s2map[lc]--
        if (s1map[lc] == s2map[lc]) {
            matches++
        }
    }

    return matches == 26
    }
}
