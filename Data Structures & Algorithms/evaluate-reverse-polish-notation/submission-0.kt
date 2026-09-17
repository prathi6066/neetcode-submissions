class Solution {
   fun evalRPN(tokens: Array<String>): Int {

    val stack = ArrayDeque<String>()
    val operator = setOf("+", "-", "/", "*")

    for (token in tokens) {
        if (operator.contains(token)) {
            val op1 = stack.removeLast()
            val op2 = stack.removeLast()
            val op = getResult(token, op2, op1)
            stack.addLast(op)
        } else {
            stack.addLast(token)
        }
    }
    
    return if (stack.isEmpty()) -1 else stack.removeLast().toInt()
}

private fun getResult(token: String, op1: String, op2: String): String {
    val result: Int = when(token) {
        "+" -> op1.toInt() + op2.toInt()
        "-" -> op1.toInt() - op2.toInt()
        "*" -> op1.toInt() * op2.toInt()
        "/" -> op1.toInt() / op2.toInt()
        else  -> -1
    }
    return result.toString()
}
}
