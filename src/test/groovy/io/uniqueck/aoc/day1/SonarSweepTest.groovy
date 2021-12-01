package io.uniqueck.aoc.day1

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class SonarSweepTest {

    @Test
    void countIfNextMeasurementIncreased() {
        assertEquals(7, SonarSweep.countIfNextMeasurementIncreased([199, 200,208,210,200,207,240,269,260,263]))
    }

    @Test
    void countThreeMeasurementSlidingWindow() {
        assertEquals(5, SonarSweep.countThreeMeasurementSlidingWindow([199, 200,208,210,200,207,240,269,260,263]))
    }

}
