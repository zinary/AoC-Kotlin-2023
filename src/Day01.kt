fun main() {

    fun getCalibrationDigitFromString(calibrationText: String): Int {
        var firstDigit = 0
        var lastDigit = 0

        for (it in calibrationText) {
            if (it.isDigit()) {
                val digit = it.digitToInt()
                if (firstDigit == 0) {
                    firstDigit = digit
                } else {
                    lastDigit = digit
                }

                if (lastDigit == 0) {
                    lastDigit = firstDigit
                }
            }
        }

        return "$firstDigit$lastDigit".toInt()
    }


    fun part1(input: List<String>): Int {
        return input.sumOf(::getCalibrationDigitFromString)
    }


    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    part1(testInput).println()

    val input = readInput("Day01")
    part1(input).println()
//    part2(input).println()
}
