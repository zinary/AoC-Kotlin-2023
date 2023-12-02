fun main() {

    val digitMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )

    /*
    * Normalizes the input such as abcone2three4sss into `abco1et2ot3ef4rsss`*/
    fun normalizeInput(calibrationText: String): String {
        var normalizedText = calibrationText
        digitMap.forEach { digit ->
            normalizedText = normalizedText.replace(
                oldValue = digit.key,
                newValue = digit.key.first() + digit.value.toString() + digit.key.last(),
                ignoreCase = true
            )
        }

        return normalizedText
    }

    fun getCalibrationDigitFromString(calibrationText: String): Int {
        normalizeInput(calibrationText)
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
        return input.map { normalizeInput(it) }.sumOf(::getCalibrationDigitFromString)
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    part1(testInput).println()
//    part2(testInput).println()

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
