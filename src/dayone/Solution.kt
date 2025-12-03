package dayone

import java.io.File

fun main() {
    var sumOfZeros = 0
    var previousDial = 50
    val inputFile = File("src/dayone/input.txt")
    val leftOrRightDial = inputFile.readLines().map { line ->
        line[0] to line.substring(1).toInt()
    }

    leftOrRightDial.forEach { (first, second) ->
        if (first == 'L') {
            previousDial = (previousDial - second) % 100
            println("Moving Left new dial is $previousDial")
        } else if (first == 'R') {
            previousDial = (previousDial + second) % 100
            println("Moving Right new dial is $previousDial")
        }
        if (previousDial == 0) {
            sumOfZeros++
        }
    }
    print(sumOfZeros)
}

