package io.uniqueck.aoc.day10


import java.util.regex.Pattern

class SyntaxScoring {

    static void main(String[] args) {
        println "Star1 : ${star1(new File("src/main/resources/day10/input.txt"))}"
        println "Star2 : ${star2(new File("src/main/resources/day10/input.txt"))}"
    }


    static long star2(File inputFile) {
        def scores = [] as List<Long>
        inputFile.readLines().collect { String inputLine  ->

            String line = returnRemainingOpenSignsIfIncompleteLine(inputLine)
            if (line) {
                String missingSigns = ""
                line.reverse().each {sign ->
                    missingSigns += getClosingSignBasedOnOpeningSign(sign)
                }
                scores << calculateScore(missingSigns)
                println "${inputLine} -> ${line} -> ${missingSigns} : ${scores.last()}"
            }
        }
        scores.sort()[scores.size() / 2]
    }

    static long calculateScore(String missingSigns) {
        def score4sign = ['}': 3, '>': 4, ']': 2, ')': 1]
        long sum = 0
        missingSigns.each {
            sum *= 5
            sum += score4sign.(it)
        }
        sum
    }

    static int star1(File inputFile) {
        def score4Sign = ['}': 1197, ')': 3, '>': 25137, ']': 57]
        inputFile.readLines().collect{findFirstNonMatchingSign(it)}.findAll {it != ""}.collect {score4Sign.(it) as int }.sum() as int
    }

    static String returnRemainingOpenSignsIfIncompleteLine(String line) {
        def pattern = Pattern.compile("(\\(\\)|\\[]|\\{}|<>)+")
        def onlyOpeningSigns = Pattern.compile("^([\\[({<])+\$")
        def matcher = pattern.matcher(line)
        while (matcher.find()) {
            line = matcher.replaceAll("")
            matcher = pattern.matcher(line)
        }
        // remove all opening signs
        if (onlyOpeningSigns.matcher(line).find()) {
            return line
        } else {
            return ""
        }
    }


    static String findFirstNonMatchingSign(String line) {
        def pattern = Pattern.compile("(\\(\\)|\\[]|\\{}|<>)+")
        def onlyOpeningSigns = Pattern.compile("^([\\[({<])+\$")
        def closingSigns = Pattern.compile("([])}>])")
        def matcher = pattern.matcher(line)
        while (matcher.find()) {
            line = matcher.replaceAll("")
            matcher = pattern.matcher(line)
        }
        // remove all opening signs
        if (onlyOpeningSigns.matcher(line).find()) {
            return ""
        } else {
            matcher = closingSigns.matcher(line)
            return matcher.find() ? matcher.group(1) : ""
        }
    }

    static String getClosingSignBasedOnOpeningSign(String sign) {
        switch (sign) {
            case "[": return "]"
            case "(": return ")"
            case "{": return "}"
            case "<": return ">"
        }
    }


}
