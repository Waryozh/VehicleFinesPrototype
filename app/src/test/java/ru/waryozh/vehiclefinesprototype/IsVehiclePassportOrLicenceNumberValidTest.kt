package ru.waryozh.vehiclefinesprototype

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.waryozh.vehiclefinesprototype.util.isValidVehiclePassportOrLicenceNumber

class IsVehiclePassportOrLicenceNumberValidTest {
    @Test
    fun emptyString() {
        assertEquals(false, "".isValidVehiclePassportOrLicenceNumber())
    }

    @Test
    fun type1() {
        assertEquals(true,  "00AA000000".isValidVehiclePassportOrLicenceNumber())
        assertEquals(true,  "00АЕ123456".isValidVehiclePassportOrLicenceNumber())
        assertEquals(false, "0АЕ123456".isValidVehiclePassportOrLicenceNumber())
        assertEquals(false, "00А123456".isValidVehiclePassportOrLicenceNumber())
        assertEquals(false, "00АЕ12345".isValidVehiclePassportOrLicenceNumber())
        assertEquals(false, "00А1234560".isValidVehiclePassportOrLicenceNumber())
    }

    @Test
    fun type2() {
        assertEquals(true,  "0098123456".isValidVehiclePassportOrLicenceNumber())
        assertEquals(false, "00981234561".isValidVehiclePassportOrLicenceNumber())

        var testString = ""
        for (i in 1..9) {
            testString += "1"
            assertEquals(false, testString.isValidVehiclePassportOrLicenceNumber())
        }
    }
}
