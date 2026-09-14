class Solution {
    fun isValid(s: String): Boolean {
        val stack =  ArrayDeque<Char>()
        val map = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        
        for(ch in s) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.removeLast() != map[ch]) {
                    return false
                }
            } else {
                stack.addLast(ch)
            }
        }

        return stack.isEmpty()
    }
}
