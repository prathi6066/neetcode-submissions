class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val seen = HashSet<String>()

        for (r in 0 until board.lastIndex+1) {
            for (c in 0 until board.lastIndex+1) {
                val char = board[r][c]
                if (char != '.') {
                    val rKey = "$char in r$r"
                    val cKey = "$char in c$c"
                    val boxKey = "$char in b(${r/3}-${c/3})"

                    if(!seen.add(rKey) || !seen.add(cKey) || !seen.add(boxKey)) {
                        return false
                    }
                }
            }
        }
        return true
    }
}
