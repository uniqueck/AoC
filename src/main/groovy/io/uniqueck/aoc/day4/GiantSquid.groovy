package io.uniqueck.aoc.day4

class GiantSquid {


    static void main(String[] args) {
        println "GianSquid plays bingo : ${initGame(new File("src/main/resources/day4/input.txt")).playBingoAndReturnFinalScoreFromWinningBoard()}"
        println "GianSquid plays bingo and wins : ${initGame(new File("src/main/resources/day4/input.txt")).playBingoAndLetGiantSquidWins()}"
    }

    static GiantSquid initGame(File puzzleInputFile) {
        def allLines = puzzleInputFile.readLines().findAll { String it -> it?.trim() }
        int[] randomNumbers = allLines.remove(0).split(",").collect{it as int}
        def boards = allLines.collate(5).collect { it.join(" " ) }.collect { BingoBoard.init(it) }
        return new GiantSquid(boards, randomNumbers)
    }

    List<BingoBoard> boards
    int[] randomNumbers

    GiantSquid(def boards, def randomNumbers) {
        this.boards = boards
        this.randomNumbers = randomNumbers
    }

    int playBingoAndReturnFinalScoreFromWinningBoard() {
        int finalScore = -1
        int randomNumbersIndex = 0
        do {
            for (int j = 0; j < boards.size(); j++) {
                if (boards[j].markNumber(randomNumbers[randomNumbersIndex])) {
                    finalScore = randomNumbers[randomNumbersIndex] * boards[j].sumOfAllUnmarkedNumbers()
                    break
                }
            }
            randomNumbersIndex++
        } while (finalScore == -1 && randomNumbersIndex < randomNumbers.size())
        return finalScore
    }

    int playBingoAndLetGiantSquidWins() {
        int finalScore = -1
        int randomNumbersIndex = 0
        int lastNumber = -1
        BingoBoard lastBoard = null
        do {
            lastNumber = randomNumbers[randomNumbersIndex]
            boards.each {it.markNumber(lastNumber)}
            lastBoard = boards.find {it.wins}
            boards.removeAll {it.wins }
            randomNumbersIndex++
        } while (boards.size() > 0 && randomNumbersIndex < randomNumbers.size())
        return lastBoard.sumOfAllUnmarkedNumbers() * lastNumber
    }



}
