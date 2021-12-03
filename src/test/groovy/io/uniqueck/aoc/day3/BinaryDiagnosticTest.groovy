package io.uniqueck.aoc.day3

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class BinaryDiagnosticTest {

    @Test
    void calculatePowerConsumption() {
        assertEquals(198, BinaryDiagnostic.calculatePowerConsumption(["00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"]))
    }

    @Test
    void calculateLifeSupportRating() {
        assertEquals(230, BinaryDiagnostic.calculateLifeSupportRating(["00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"]))
    }

}
