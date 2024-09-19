package uk.org.fca.santaselves

import java.io.File

fun main() {
    val used = readDimensions("data/presents")
        .map { calculatePaperUsed(it) }
        .sum()

    println("Total paper used: ${java.text.NumberFormat.getIntegerInstance().format(used)}")
}

fun readDimensions(fileName: String): List<List<Int>> {
    return File(fileName)
        .useLines { it.toList() }
        .map { it.split('x').map { it.toInt()} }
}

fun calculatePaperUsed(d: List<Int>): Int {
    val sides = listOf(d[0] * d[1], d[1] * d[2], d[2] * d[0])

    return sides.map { it * 2 }.sum() + sides.min()
}
