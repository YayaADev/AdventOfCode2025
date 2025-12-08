package dayfive

import java.io.File


fun main() {
    val input = File("src/dayfive/dayfiveinput.txt").readLines()
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
    println(availableIngredients)
}
