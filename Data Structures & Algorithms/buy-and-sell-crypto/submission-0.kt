class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var min = Int.MAX_VALUE
        var result = 0

        for (price in prices) {
            result = maxOf(result, (price - min))
            min = minOf(price, min)
        }
        
        return result

    }
}
