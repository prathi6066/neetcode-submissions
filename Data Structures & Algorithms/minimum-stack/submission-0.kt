class MinStack() {

    val stack = ArrayDeque<Int>()
    val minValStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val minSoFar = minOf(`val`, minValStack.lastOrNull() ?: Int.MAX_VALUE)
        minValStack.addLast(minSoFar)
    }

    fun pop() {
        stack.removeLast()
        minValStack.removeLast()
    }

    fun top(): Int {
        return stack.last()

    }

    fun getMin(): Int {
        return minValStack.last()

    }
}
