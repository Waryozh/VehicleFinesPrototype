package ru.waryozh.vehiclefinesprototype.util

private const val VALID_LETTERS = "[АВЕКМНОРСТУХ]"

private val engToRusLettersMap = mapOf(
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

fun String.transliterate() = this.map { engToRusLettersMap[it] ?: it }.joinToString("")

fun String.isValidRegNumber(): Boolean =
    Regex("^(?:$VALID_LETTERS\\d{3}$VALID_LETTERS{2}\\d{2,3})|" + // type 1A
            "(?:$VALID_LETTERS{2}\\d{5,7})|" +                            // types 1B, 2, 6
            "(?:\\d{4}$VALID_LETTERS{2}\\d{2,3})|" +                      // types 3, 4, 5, 7, 8
            "(?:\\d{3}СD\\d{3,4})|" +
            "(?:\\d{3}[DТ]\\d{5,6})|" +
            "(?:D\\d{7,8})\$"
    ).matches(this.transliterate())
