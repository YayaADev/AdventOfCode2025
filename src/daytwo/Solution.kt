package daytwo

import java.io.File

fun main() {
    val inputFile = File("src/daytwo/daytwo_input.txt").readText()
    val splitByCommas = inputFile.split(",")

    val pairsOfNumbers = splitByCommas.map { pair ->
        pair.split("-").let { (first, second) ->
            first.trim().toLong() to second.trim().toLong()
        }
    }
    val listOfNumbers = mutableListOf<Long>()
    pairsOfNumbers.forEach { pair ->
        listOfNumbers += addUpAllBetween(pair)
    }
    val sumOfInvalidIdsPartOne = findInvalidIds(listOfNumbers).sum()
    val sumOfInvalidIdsPartTwo = findInvalidIdsWhereRepeatedSequence(listOfNumbers).sum()
}

/**
 * creates a list of values from first to second number in the Pair */
fun addUpAllBetween(pairToLoop: Pair<Long, Long>): MutableList<Long> {
    val list = mutableListOf<Long>()
    for (i in pairToLoop.first..pairToLoop.second) {
        list.add(i)
    }
    return list
}


fun findInvalidIds(listOfIds: MutableList<Long>): MutableList<Long> {
    val invalidIds = mutableListOf<Long>()
    listOfIds.map { id ->
        val stringOfId = id.toString()
        if (stringOfId.length % 2 != 0) return@map // filter odds cuz it cant be repeated twice neatly
        val halfwayPoint = stringOfId.length / 2
        val leftSplit = stringOfId.take(halfwayPoint)
        val rightSplit = stringOfId.takeLast(halfwayPoint)
        if (leftSplit == rightSplit) {
            invalidIds.add(id)
        }
    }
    return invalidIds
}

fun findInvalidIdsWhereRepeatedSequence(listOfIds: MutableList<Long>): MutableList<Long> {
    val listOfInvalidPartTwo = mutableListOf<Long>()
    listOfIds.forEach { id ->
        val patterns = getValidPatternLengths(id.toString().length)
        val isInvalid = findInvalidPatterns(patterns, id.toString())
        if (isInvalid) {
            listOfInvalidPartTwo.add(id)
        }
    }
    return listOfInvalidPartTwo

}

/**
 * gets the division of a number. Ex 6 gives [1,2,3] * get range of half cuz pattern repeats at least twice. * then filter out numbers that arent a divisor of the original * goal is check repeats by divisors */
fun getValidPatternLengths(totalLength: Int): List<Int> {
    return (1..totalLength / 2).filter { totalLength % it == 0 }
}

/**
 * check repeats of char for length uing list of divisors found earlier. * if one has a fully matching pattern then exit * this must be so slow */
fun findInvalidPatterns(validLengths: List<Int>, num: String): Boolean {
    for (patternLength in validLengths) {
        val pattern = num.take(patternLength)
        if (pattern.repeat(num.length / patternLength) == num) {
            return true
        }
    }
    return false
}