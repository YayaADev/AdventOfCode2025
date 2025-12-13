package daysix

import java.io.File

fun main() {
    partOne()

}

fun partOne() {
    val input = File("src/daysix/daysixinput.txt").readLines()
    val values = input.subList(0, input.size - 1).map { it -> it.split(" ").filter { it.isNotEmpty() }.map { it.toLong() } }
    val operations = input.last().filter { it != ' ' }.toCharArray()
    var total = 0L

    var listOfNumbers = mutableListOf<Long>()
    values.forEachIndexed { index, value ->
        listOfNumbers.add(value[index])
    }


    for (i in 0 until values.first().size) {
        val listOfNumbers = mutableListOf<Long>()
        for (j in 0 until values.size) {
            listOfNumbers.add(values[j][i])
        }
        if (operations[i] == '+') {
            total += listOfNumbers.sum()
        }
        if (operations[i] == '*') {
            var x = 1L
            listOfNumbers.forEach { number ->
                x *= number
            }
            total += x
        }

    }
    println(total)

}

// 352509891817881 too high