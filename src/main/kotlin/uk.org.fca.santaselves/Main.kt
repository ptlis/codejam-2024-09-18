package uk.org.fca.santaselves

import java.io.File

fun main() {
    val dimensions = readDimensions("data/presents")

    val paperRequired = dimensions.sumOf { calculatePaperRequired(it) }

    val ribbonRequired = dimensions.sumOf { calculateRibbonRequired(it) }

    println("Total paper required: ${java.text.NumberFormat.getIntegerInstance().format(paperRequired)}")
    println("Total ribbon required: ${java.text.NumberFormat.getIntegerInstance().format(ribbonRequired)}")
}

fun readDimensions(fileName: String): List<List<Int>> {
    return File(fileName)
        .useLines { it.toList() }
        .map { it.split('x').map { it.toInt()} }
}

fun calculatePaperRequired(d: List<Int>): Int {
    val sides = listOf(d[0] * d[1], d[1] * d[2], d[2] * d[0])

    return sides.sumOf { it * 2 } + sides.min()
}

fun calculateRibbonRequired(d: List<Int>): Int {
    return d.sorted()
        .slice(0..1).sumOf { it * 2 } + (d[0] * d[1] * d[2])
}