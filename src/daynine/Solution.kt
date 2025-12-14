package daynine

import java.io.File
import java.util.PriorityQueue
import java.util.TreeMap
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val input = File("src/daynine/day9input.txt").readLines()
        .map { line -> line.split(",").map { it.toInt() } }

    var maxArea = 0L

    for (i in 0 until input.size) {
        val x = input[i].first()
        val y = input[i].last()
        for (j in 1 until input.size) {
            val secondx = input[j].first()
            val secondy = input[j].last()
            val area = (abs(x - secondx) + 1) * (abs(y - secondy) + 1).toLong()
            maxArea = max(maxArea, area)
        }
    }
    println(maxArea)
}

// 2147429490 too low  2147308956