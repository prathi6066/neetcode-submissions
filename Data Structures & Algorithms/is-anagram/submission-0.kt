class Solution {
    fun isAnagram(s: String, t: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    s.toCharArray().forEach { i ->
        map[i] = map.getOrElse(i, {0}) + 1
    }
    t.toCharArray().forEach { i ->
        map[i] = map.getOrElse(i, {0}) - 1
    }

    return map.all { it.value == 0 }
}
}
