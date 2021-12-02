package io.uniqueck.aoc.day2

class Navigation {

    static void main(String[] args) {
        def lines = new File("src/main/resources/day2/input.txt").readLines()
        println "Day2 part 1 solution: ${calculateFinalPositionValue(lines)}"
        println "Day2 part 2 solution: ${calculateFinalPositionValueWithAIM(lines)}"
    }

    enum Course {
        DOWN, FORWARD, UP
    }

    static int calculateFinalPositionValue(def plannedCourse = String[]) {
        int horizontalPosition = 0
        int depth = 0

        plannedCourse.each { String plannedStep ->
            def (direction, sValue) = plannedStep.tokenize(" ")
            int speed = Integer.valueOf(sValue)
            switch (Course.valueOf(direction.toUpperCase())) {
                case Course.FORWARD: {
                    horizontalPosition += speed
                    break
                }
                case Course.UP: {
                    depth -= speed
                    break
                }
                    case Course.DOWN: {
                    depth += speed
                }
            }
        }
        return horizontalPosition * depth
    }

    static int calculateFinalPositionValueWithAIM(def plannedCourse = String[]) {
        int horizontalPosition = 0
        int depth = 0
        int aim = 0

        plannedCourse.each { String plannedStep ->
            def (direction, sValue) = plannedStep.tokenize(" ")
            int speed = Integer.valueOf(sValue)
            switch (Course.valueOf(direction.toUpperCase())) {
                case Course.FORWARD: {
                    horizontalPosition += speed
                    depth += (aim * speed)
                    break
                }
                case Course.UP: {
                    aim -= speed
                    break
                }
                case Course.DOWN: {
                    aim += speed
                }
            }
        }

        println "${horizontalPosition}, ${depth}, ${aim}"


        return horizontalPosition * depth

    }
}
