package dayseven

import java.io.File
var globalTracker = 0L
var cache = mutableMapOf<Pair<Int, Int>, Long>()
fun main() {
    var input = File("src/dayseven/day7input.txt").readLines().map { line -> line.toCharArray()}
    val startingS = input.first().indexOf('S')

    val totla = placePipes(input, Pair(1, startingS))
    println(totla)


}

fun placePipes(input: List<CharArray>, startingCoord: Pair<Int, Int>) : Long {
    if (cache.containsKey(startingCoord)) return cache[startingCoord]!!

    if (startingCoord.first >= input.size) return 1


    if (input[startingCoord.first][startingCoord.second] == '.') {
        return placePipes(input, Pair(startingCoord.first + 1, startingCoord.second))
    }
    if (input[startingCoord.first][startingCoord.second] == '^') {
        val leftOfUp = Pair(startingCoord.first, startingCoord.second-1)
        val rightOfUp = Pair(startingCoord.first, startingCoord.second+1)
        val leftCount = placePipes(input, leftOfUp)
        val rightCount = placePipes(input, rightOfUp)
        cache[startingCoord] =  leftCount + rightCount
        return leftCount + rightCount
    }
    return 0
}


/**
 * I got this my first try im so happy bro
 */