package io.uniqueck.aoc.day9

class SmokeBasin {

    static final int ALREADY_VISIT = -1
    static final int NINE_ISNT_PART_OF_BASIN_SIZE = -1

    static class LowPointCoord {
        int x, y, value

        LowPointCoord(int x, int y, int value) {
            this.x = x
            this.y = y
            this.value = value
        }
    }

    static class Solution {
        int star1 = 0, star2 = 0
    }

    static void main(String[] args) {

        def solution = new SmokeBasin().solve(new File("src/main/resources/day9/input.txt"))
        println "Smoke Basin - Star1: ${solution.star1}"
        println "Smoke Basin - Star2: ${solution.star2}"
    }

    @SuppressWarnings('GrMethodMayBeStatic')
    Solution solve(File inputFile) {
        Solution solution = new Solution()
        def lines = inputFile.readLines()
        def points = []

        def allEntriesInOneLine = lines.collect { it.split("").collect { it as int } }

        allEntriesInOneLine.eachWithIndex { def eachList, int listIdx ->

            eachList.eachWithIndex { def eachEntry, int entryIdx ->

                int entryToTheRight = 10, entryBelow = 10, entryAbove = 10, entryToTheLeft = 10

                if (listIdx == 0) {
                    entryBelow = allEntriesInOneLine[listIdx + 1][entryIdx]
                } else if (listIdx > 0 && listIdx < allEntriesInOneLine.size() - 1) {
                    entryAbove = allEntriesInOneLine[listIdx - 1][entryIdx]
                    entryBelow = allEntriesInOneLine[listIdx + 1][entryIdx]
                } else {
                    entryAbove = allEntriesInOneLine[listIdx - 1][entryIdx]
                }

                if (entryIdx == 0) {
                    entryToTheRight = eachList[entryIdx + 1]
                } else if (entryIdx > 0 && entryIdx < eachList.size() - 1) {
                    entryToTheRight = eachList[entryIdx + 1]
                    entryToTheLeft = eachList[entryIdx - 1]
                } else {
                    entryToTheLeft = eachList[entryIdx - 1]
                }

                if (eachEntry < entryAbove && eachEntry < entryBelow && eachEntry < entryToTheLeft && eachEntry < entryToTheRight) {
                    points << new LowPointCoord(entryIdx, listIdx, eachEntry)
                    solution.star1 += eachEntry + 1
                }
            }
        }

        List<Integer> basinSize = []
        points.each { it ->
            basinSize << calculateBasinSize(allEntriesInOneLine, it)
        }
        // reverse sort split list up to list with 3 elements and multiply elements
        solution.star2 = (basinSize.sort().reverse().collate(3)[0] as int[]).inject(1) {prod, val -> prod * val}

        solution
    }

    int calculateBasinSize(def inputMap, LowPointCoord point) {
        return calculateBasinSize(inputMap, point.y, point.x)
    }

    int calculateBasinSize(def inputMap = [[]], int y, int x) {
        int size = 1
        int width = inputMap[0].size()
        int height = inputMap.size()

        // mark position as already visited
        inputMap[y][x] = ALREADY_VISIT

        // look around point(x,y) if possible
        if (y>0) {
            if (inputMap[y - 1][x] != ALREADY_VISIT && inputMap[y - 1][x] != NINE_ISNT_PART_OF_BASIN_SIZE) {
                size += calculateBasinSize(inputMap, y - 1, x)
            }
        }
        if (y<height-1) {
            if (inputMap[y + 1][x] != ALREADY_VISIT && inputMap[y + 1][x] != NINE_ISNT_PART_OF_BASIN_SIZE) {
                size += calculateBasinSize(inputMap, y + 1, x)
            }
        }
        if (x>0) {
            if (inputMap[y][x - 1] != ALREADY_VISIT && inputMap[y][x - 1] != NINE_ISNT_PART_OF_BASIN_SIZE) {
                size += calculateBasinSize(inputMap, y, x - 1)
            }
        }
        if (x<width-1) {
            if (inputMap[y][x + 1] != ALREADY_VISIT && inputMap[y][x + 1] != NINE_ISNT_PART_OF_BASIN_SIZE) {
                size += calculateBasinSize(inputMap, y, x + 1)
            }
        }
        return size
    }


}
