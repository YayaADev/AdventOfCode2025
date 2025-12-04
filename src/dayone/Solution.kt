package dayone

import java.io.File

var sumOfZeros = 0

fun main() {
    var previousDial = 50
    val inputFile = File("src/dayone/input.txt")
    val leftOrRightDial = inputFile.readLines().map { line ->
        line[0] to line.substring(1).toInt()
    }

    leftOrRightDial.forEach { (rotation, amount) ->
        if (rotation == 'L') {
            previousDial = calculateLeftDial(previousDial, amount)
        } else if (rotation == 'R') {
            previousDial = calculateRightDial(previousDial, amount)
        }

    }
    print(sumOfZeros)
}

fun calculateLeftDial(startingPosition: Int, leftRotation: Int): Int {
    val laps = leftRotation / 100
    val leftover = leftRotation.mod(100)
    val newDial = startingPosition - leftover

    sumOfZeros += laps

    if (startingPosition > 0 && newDial <= 0) {
        sumOfZeros++
    }

    return newDial.mod(100)
}

fun calculateRightDial(startingPosition: Int, rightRotation: Int): Int {
    val laps = rightRotation / 100
    val leftover = rightRotation.mod(100)
    val newDial = startingPosition + leftover

    sumOfZeros += laps

    if (newDial >= 100) {
        sumOfZeros++
    }

    return newDial.mod(100)
}
