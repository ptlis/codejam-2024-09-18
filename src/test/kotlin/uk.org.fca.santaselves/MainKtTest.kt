package uk.org.fca.santaselves

import kotlin.test.assertEquals
import kotlin.test.Test

class MainKtTest {
    @Test
    fun testExample1() {
        val expected = 58
        assertEquals(expected, calculatePaperUsed(listOf(2, 3, 4)))
    }

    @Test
    fun testExample2() {
        val expected = 43
        assertEquals(expected, calculatePaperUsed(listOf(1, 1, 10)))
    }
}