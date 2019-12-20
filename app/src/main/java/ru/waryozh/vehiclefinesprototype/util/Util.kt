package ru.waryozh.vehiclefinesprototype.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

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
    Regex(
        "^(?:$VALID_LETTERS\\d{3}$VALID_LETTERS{2}\\d{2,3})|" + // types 1A, 25, 28
                "(?:$VALID_LETTERS{2}\\d{5,7})|" +                      // types 1B, 2, 6
                "(?:\\d{4}$VALID_LETTERS{1,2}\\d{2,3})|" +              // types 3, 4, 5, 7, 8, 22
                "(?:\\d{3}СD\\d{3,4})|" +                               // type 9
                "(?:\\d{3}[DТ]\\d{5,6})|" +                             // type 10
                "(?:D\\d{7,8})|" +                                      // type 11
                "(?:$VALID_LETTERS\\d{6,7})|" +                         // type 20
                "(?:\\d{3}$VALID_LETTERS\\d{2,3})\$"                    // type 21
    ).matches(this.transliterate())

fun String.isValidVehiclePassportOrLicenceNumber(): Boolean =
    Regex("^\\d{2}(?:$VALID_LETTERS{2}|\\d{2})\\d{6}\$").matches(this.transliterate())

fun View.showSoftKeyboard() {
    post {
        if (this.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}
