package dayseven

import java.io.File
var globalTracker = 0L
fun main() {
    var input = File("src/dayseven/day7input.txt").readLines().map { line -> line.toCharArray()}
    val startingS = input.first().indexOf('S')

    placePipes(input, Pair(1, startingS))
    println(globalTracker)


}

fun placePipes(input: List<CharArray>, startingCoord: Pair<Int, Int>) {
    println(startingCoord)
    if (startingCoord.first >= input.size) return

    if (input[startingCoord.first][startingCoord.second] == '.') {
        input[startingCoord.first][startingCoord.second] = '|'
        placePipes(input, Pair(startingCoord.first + 1, startingCoord.second))
    }
    if (input[startingCoord.first][startingCoord.second] == '^') {
        globalTracker++
        val leftOfUp = Pair(startingCoord.first, startingCoord.second-1)
        val rightOfUp = Pair(startingCoord.first, startingCoord.second+1)
        placePipes(input, leftOfUp)
        placePipes(input, rightOfUp)
    }
}


/**
 * I got this my first try im so happy bro
 */