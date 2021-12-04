package io.uniqueck.aoc.day4

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class GiantSquidTest {

    @Test
    void playBingoAndWins() {
        assertEquals(4512, GiantSquid.initGame(new File("src/test/resources/day4/example.txt")).playBingoAndReturnFinalScoreFromWinningBoard())
    }

    @Test
    void playBingoAndLetGiantSquidWins() {
        assertEquals(1924, GiantSquid.initGame(new File("src/test/resources/day4/example.txt")).playBingoAndLetGiantSquidWins())
    }


}
