package dayfour

import java.io.File

fun main() {
    mainPt2()
    val grid = File("src/dayfour/dayfourinput.txt").readLines().map { line ->
        line.toCharArray()
    }
    var totalRolls = 0
    val rollsToCheck = '@'

    grid.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, char ->
            if (char != rollsToCheck) return@forEachIndexed
            var adjacentRolls = 0
            for (rowOffset in intArrayOf(-1, 0, 1)) {
                for (colOffset in intArrayOf(-1, 0, 1)) {
                    val leftCheck = rowIndex + rowOffset
                    val rightCheck = colIndex + colOffset

                    if (rowOffset == 0 && colOffset == 0) continue
                    if (!(leftCheck >= 0 && leftCheck < grid.size)) continue
                    if (!(rightCheck >= 0 && rightCheck < row.size)) continue
                    val adjacent = grid[leftCheck][rightCheck]
                    if (adjacent == rollsToCheck) adjacentRolls++

                }
        }
            if (adjacentRolls < 4) {
                totalRolls++
            }
        }
    }

}

fun mainPt2() {
    val grid = File("src/dayfour/dayfourinput.txt").readLines().map { line ->
        line.toCharArray()
    }

    var totalRolls = 0
    val rollsToCheck = '@'

    while (true) {
        var removedRollsThisRun = 0
        grid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, char ->
                if (char != rollsToCheck) return@forEachIndexed
                var adjacentRolls = 0
                for (rowOffset in intArrayOf(-1, 0, 1)) {
                    for (colOffset in intArrayOf(-1, 0, 1)) {
                        val leftCheck = rowIndex + rowOffset
                        val rightCheck = colIndex + colOffset

                        if (rowOffset == 0 && colOffset == 0) continue
                        if (!(leftCheck >= 0 && leftCheck < grid.size)) continue
                        if (!(rightCheck >= 0 && rightCheck < row.size)) continue
                        val adjacent = grid[leftCheck][rightCheck]
                        if (adjacent == rollsToCheck) adjacentRolls++

                    }
                }
                if (adjacentRolls < 4) {
                    grid[rowIndex][colIndex] = 'x'
                    removedRollsThisRun++
                }
            }
        }
        totalRolls += removedRollsThisRun
        if (removedRollsThisRun == 0) break

    }
    println(totalRolls)

}

/**
 * once it can be removed repalce with a X.
 * If something got repl;aced with an X set Keep moving to true. If nothing got repl;aced set it to false
 * Keep incrementing totalRolls.
 */