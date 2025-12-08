package dayfive

import java.io.File


fun main() {
    partTwo()

}

fun partOne() {
    val input = File("src/dayfive/example.txt").readLines()
    val seperator = input.indexOf("")

    val ranges = input.subList(0, seperator).map { line ->
        line.split("-").map { it.toLong() }
    }
    val validIds = input.subList(seperator + 1, input.size).map { line -> line.toLong() }

    var availableIngredients = 0


    for (id in validIds) {
        for (range in ranges) {
            val leftRange = range[0]
            val rightRange = range[1]
            if (id in leftRange..rightRange) {
                availableIngredients++
                println("ID $id in range $leftRange $rightRange")
                break
            }
        }
    }
}


fun partTwo() {
    val input = File("src/dayfive/dayfiveinput.txt").readLines()
    val seperator = input.indexOf("")
    var ranges = input.subList(0, seperator).map { line ->
        line.split("-").map { it.toLong() }
    }
    ranges = ranges.sortedBy { it[0] }.toMutableList()

    val newList = mutableListOf<List<Long>>()

    var current = ranges.first()

    for (i in 1 until ranges.size) {
        val nextRange = ranges[i]
        val start = current[0]
        val end = current[1]

        val start2 = nextRange[0]
        val end2 = nextRange[1]

        if (start2 in start..end && end2 in start..end) continue

        if (end in start2..end2 || end + 1 == start2) {
            current = listOf(start, end2)

        } else {
            newList.add(current)
            current = ranges[i]

        }
    }
    newList.add(current)

    var setOfFreshIngredients = 0L

    newList.forEach { list ->
        setOfFreshIngredients += (list[1] - list[0]) + 1
    }
    println(setOfFreshIngredients)

}
// 371902520936274 was too high