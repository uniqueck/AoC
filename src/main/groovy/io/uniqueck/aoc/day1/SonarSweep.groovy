package io.uniqueck.aoc.day1

class SonarSweep {

    static void main(String[] args) {
        def collect = new File('src/main/resources/day1/input.txt').text.split('\n').collect { Integer::valueOf(it) }
        println "Part1 solution: ${countIfNextMeasurementIncreased(collect)}"
        println "Part2 solution: ${countThreeMeasurementSlidingWindow(collect)}"
    }

    static int countIfNextMeasurementIncreased(List<Integer> input) {
        int counter = 0
        for (int i = 0; i < input.size() - 1; i++) {
            counter += count(input[i], input[i+1])
        }
        counter
    }

    static int countThreeMeasurementSlidingWindow(List<Integer> input) {
        int counter = 0
        for (int i = 0; i < input.size() - 3; i++) {
            int sum1 = input.subList(i, i +3).sum(0) as int
            int sum2 = input.subList(i+1, i +4).sum(0) as int
            counter += count(sum1, sum2)
        }
        counter
    }

    static int count(int a, b) {
        b > a ? 1 : 0
    }

}
