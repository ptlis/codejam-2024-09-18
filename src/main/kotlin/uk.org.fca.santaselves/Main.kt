package uk.org.fca.santaselves

import java.io.File

fun main() {

    val dimensions = readDimensions("data/presents")

    println("Hello world")
}


fun readDimensions(fileName: String): List<List<String>> {
    return File(fileName)
        .useLines { it.toList() }
        .map { it.split('x') }
}

fun calculatePaperUsed(d: List<Int>): Int {
    val sides = listOf(d[0] * d[1], d[1] * d[2], d[2] * d[0])

    return sides.map { it * 2 }.sum() + sides.min()
}
