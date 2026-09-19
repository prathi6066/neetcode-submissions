class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        val pos = position.zip(speed).sortedByDescending {
            it.first
        }
        val stack = ArrayDeque<Double>()

        for ((p, s) in pos) {
            val time = (target - p).toDouble() / s
            if (stack.isEmpty() || time > stack.last()) {
               stack.addLast(time)
            }
        }

        return stack.size

    }
}
