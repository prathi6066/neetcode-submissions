class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        strs.forEach { str ->
            sb.append(str.length).append("#").append(str)
        }

        return sb.toString()
    }

    fun decode(str: String): List<String> { 

        val result = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            val numIndex = str.indexOf("#", i) //(#, 17) -> 19
            val num = str.substring(i, numIndex).toInt() // (17, 19) -> 10
            val start = numIndex + 1
            val end = start + num
            val currStr = str.substring(start, end)
            i = end
            result.add(currStr)
        }

        return result

    }
}
