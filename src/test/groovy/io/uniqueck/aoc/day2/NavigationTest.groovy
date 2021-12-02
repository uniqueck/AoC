package io.uniqueck.aoc.day2

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class NavigationTest {

    @Test
    void part1() {
        assertEquals(150, Navigation.calculateFinalPositionValue(["forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"]))
    }

    @Test
    void part2() {
        assertEquals(900, Navigation.calculateFinalPositionValueWithAIM(["forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"]))
    }

}
