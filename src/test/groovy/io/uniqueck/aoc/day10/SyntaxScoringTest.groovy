package io.uniqueck.aoc.day10

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SyntaxScoringTest {

    @Test
    void star1() {
        assert 26397 == SyntaxScoring.star1(new File("src/test/resources/day10/example.txt"))
    }

    @Test
    void star2() {
        assert 288957 == SyntaxScoring.star2(new File("src/test/resources/day10/example.txt"))
    }

    @ParameterizedTest
    @CsvSource(value = [
            "[({(<(())[]>[[{[]{<()<>>,''",
            "[(()[<>])]({[<{<<[]>>(,''",
            "{([(<{}[<>[]}>{[]{[(<()>,}",
            "(((({<>}<{<{<>}{[]{[]{},''",
            "[[<[([]))<([[{}[[()]]],)"
    ], emptyValue = "")
    void findFirstNonMatchingSign(String line, String expectedSign) {
        assert expectedSign == SyntaxScoring.findFirstNonMatchingSign(line)
    }

}
