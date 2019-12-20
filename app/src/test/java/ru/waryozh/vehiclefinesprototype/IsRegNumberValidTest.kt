package ru.waryozh.vehiclefinesprototype

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.waryozh.vehiclefinesprototype.util.isValidRegNumber

// See Wikipedia for all allowed reg number formats
class IsRegNumberValidTest {
    @Test
    fun emptyString() {
        assertEquals(false, "".isValidRegNumber())
    }

    @Test
    fun type1A() {
        assertEquals(true,  "С227НА69".isValidRegNumber())
        assertEquals(true,  "С227НА690".isValidRegNumber())
        assertEquals(true,  "Y123AT90".isValidRegNumber())
        assertEquals(false, "123AT90".isValidRegNumber())
    }

    @Test
    fun type1B() {
        assertEquals(true, "АО36578".isValidRegNumber())
        assertEquals(true, "АО365780".isValidRegNumber())
    }

    @Test
    fun type2() {
        assertEquals(true, "АН733147".isValidRegNumber())
        assertEquals(true, "АН7331470".isValidRegNumber())
    }

    @Test
    fun type3() {
        assertEquals(true, "3733ММ55".isValidRegNumber())
        assertEquals(true, "3733ММ550".isValidRegNumber())
    }

    @Test
    fun typesDiplomatic() {
        // Types 9, 10, 11
        assertEquals(true,  "002CD178".isValidRegNumber())
        assertEquals(true,  "002CD1780".isValidRegNumber())

        assertEquals(true,  "002D04078".isValidRegNumber())
        assertEquals(true,  "002T04078".isValidRegNumber())
        assertEquals(true,  "002D040780".isValidRegNumber())
        assertEquals(false, "002F04078".isValidRegNumber())

        assertEquals(true,  "D8762377".isValidRegNumber())
        assertEquals(true,  "D87623770".isValidRegNumber())
        assertEquals(false, "A87623770".isValidRegNumber())
    }

    @Test
    fun type20() {
        assertEquals(true, "А123478".isValidRegNumber())
        assertEquals(true, "А1234780".isValidRegNumber())
    }

    @Test
    fun type21() {
        assertEquals(true, "012А36".isValidRegNumber())
        assertEquals(true, "012А360".isValidRegNumber())
    }

    @Test
    fun type22() {
        assertEquals(true, "5537А99".isValidRegNumber())
        assertEquals(true, "5537А990".isValidRegNumber())
    }
}
