class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val result = IntArray(temperatures.size) { 0 }

        val stack = ArrayDeque<Int>()

        temperatures.forEachIndexed { i, temp ->
            while (stack.isNotEmpty() &&  temp > temperatures[stack.last()]) {
                val op = stack.removeLast()
                result[op] =  i -  op
            }
            stack.addLast(i)
        }

        return result

    }
}
