package io.uniqueck.aoc.day9

import org.junit.jupiter.api.Test

class SmokeBasinTest {


    @Test
    void process() {
        assert 15 == new SmokeBasin().solve(new File("src/test/resources/day9/example.txt")).star1
        assert 1134 == new SmokeBasin().solve(new File("src/test/resources/day9/example.txt")).star2
    }
}
