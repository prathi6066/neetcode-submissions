class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    val max = piles.maxOrNull()
    var result = -1

    if (max == null)
        return -1

    var right = max!!

    while (left <= right) {
        val mid = left + (right - left) / 2

        val hours = getHours(piles, mid)
        if (hours <= h) {
            result = mid
            right = mid - 1
        } else {
            left= mid +1
        } 
    }
    return result

}

fun getHours(piles: IntArray, maxSpeed: Int): Long {
    var speed = 0L
    for(pile in piles) {
        speed += (pile + maxSpeed - 1) / maxSpeed
    }
    return speed
}
}
