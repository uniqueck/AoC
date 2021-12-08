package io.uniqueck.aoc.day8

import org.junit.jupiter.api.Test

class SevenSegmentSearchTest {

    @Test
    void process() {
        assert 26 == SevenSegmentSearch.star1(new File("src/test/resources/day8/example.txt"))
        assert 61229 == SevenSegmentSearch.star2(new File("src/test/resources/day8/example.txt"))
    }
}
