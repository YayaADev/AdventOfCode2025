package daythree

import java.io.File

/**
 * read from file each line is entry in an array so an array of strings
 *
 * keep varaible called max which will be char to int
 * can add int to char and it will append like '9 + 5 == 95.toInt
 * max is index 0 & 1 then move
 * when second value is greater than first left pointer is on second right pointer is on +1
 */

fun main() {
    val input = File("src/daythree/daythreeinput.txt").readLines()
    val batteryPacks = mutableListOf<List<Int>>()
    input.forEach { batteryPack ->
        batteryPacks.add(batteryPack.map { it.digitToInt() })
    }
    var totalSum = 0

    batteryPacks.forEach { batteryPack ->

        totalSum+= findMaximumBatteryInPack(batteryPack)
    }
    println(totalSum)

}

fun findMaximumBatteryInPack(batteryPack: List<Int>): Int {
    var leftjoltage = batteryPack[0]
    var rightJoltage = batteryPack[1]
    var maximumJoltage = "$leftjoltage$rightJoltage".toInt()
    for (i in 1 until batteryPack.size) {
        if ((i+1 < batteryPack.size) && batteryPack[i] > leftjoltage) {
            leftjoltage = batteryPack[i]
            rightJoltage = batteryPack[i + 1]
        } else if (batteryPack[i] > rightJoltage) {
            rightJoltage = batteryPack[i]
        }

        if ("$leftjoltage$rightJoltage".toInt() > maximumJoltage)
            maximumJoltage = "$leftjoltage$rightJoltage".toInt()
    }
    return maximumJoltage
}
