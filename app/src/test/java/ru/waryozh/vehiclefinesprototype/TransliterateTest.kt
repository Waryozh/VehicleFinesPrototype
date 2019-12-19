package ru.waryozh.vehiclefinesprototype

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.waryozh.vehiclefinesprototype.util.transliterate

class TransliterateTest {
    @Test
    fun emptyString() {
        assertEquals("", "".transliterate())
    }

    @Test
    fun singleSymbol() {
        val lettersToTransliterate =
            setOf('A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X')

        val engToRusLettersMap = mapOf(
            'A' to 'А',
            'B' to 'В',
            'E' to 'Е',
            'K' to 'К',
            'M' to 'М',
            'H' to 'Н',
            'O' to 'О',
            'P' to 'Р',
            'C' to 'С',
            'T' to 'Т',
            'Y' to 'У',
            'X' to 'Х'
        )

        for (c in '0'..'я') {
            val expected = if (c in lettersToTransliterate) engToRusLettersMap[c] else c
            assertEquals(expected.toString(), c.toString().transliterate())
        }
    }

    @Test
    fun normalString() {
        assertEquals("У12", "Y12".transliterate())
    }
}
