package com.bbrakenhoff.adventofcode.day04

class Passport(private val batchLine: String) {

    fun isValid(): Boolean {
        return allFieldsPresent() && isBirthYearValid() && isIssueYearValid() && isExpirationYearValid() && isHeightValid() && isHairColorValid() && isEyeColorValid() && isPassportIdValid()
    }

    fun allFieldsPresent(): Boolean =
        batchLine.contains(BIRTH_YEAR_KEY) && batchLine.contains(ISSUE_YEAR_KEY) && batchLine.contains(EXPIRATION_YEAR_KEY) && batchLine.contains(
            HEIGHT_KEY) && batchLine.contains(HAIR_COLOR_KEY) && batchLine.contains(EYE_COLOR_KEY) && batchLine.contains(PASSPORT_ID_KEY)

    private fun isBirthYearValid(): Boolean {
        val birthYearRegex: Regex = Regex("($BIRTH_YEAR_KEY)$VALUE_PATTERN")
        val birthYear: Int = birthYearRegex.find(batchLine)?.groupValues?.get(2)?.toInt() ?: 0
        return birthYear in 1920..2002
    }

    private fun isIssueYearValid(): Boolean {
        val issueYearRegex: Regex = Regex("($ISSUE_YEAR_KEY)$VALUE_PATTERN")
        val issueYear: Int = issueYearRegex.find(batchLine)?.groupValues?.get(2)?.toInt() ?: 0
        return issueYear in 2010..2020
    }

    private fun isExpirationYearValid(): Boolean {
        val expirationYearRegex: Regex = Regex("($EXPIRATION_YEAR_KEY)$VALUE_PATTERN")
        val expirationYear: Int = expirationYearRegex.find(batchLine)?.groupValues?.get(2)?.toInt() ?: 0
        return expirationYear in 2020..2030
    }

    private fun isHeightValid(): Boolean {
        val heightRegex: Regex = Regex("($HEIGHT_KEY):(\\d*)(cm|in)")
        val heightMatchValues: List<String>? = heightRegex.find(batchLine)?.groupValues
        val measurement: String? = heightMatchValues?.get(3)
        val height: Int = heightMatchValues?.get(2)?.toInt() ?: 0

        return when (measurement) {
            "cm" -> isHeightInCmValid(height)
            "in" -> isHeightInInchValid(height)
            else -> false
        }
    }

    private fun isHeightInCmValid(height: Int) = height in 150..193

    private fun isHeightInInchValid(height: Int) = height in 59..76

    private fun isHairColorValid(): Boolean {
        val hairColorRegex: Regex = Regex("($HAIR_COLOR_KEY):(#[0-9a-f]{6})")
        return hairColorRegex.containsMatchIn(batchLine)
    }

    private fun isEyeColorValid(): Boolean {
        val eyeColorRegex: Regex = Regex("($EYE_COLOR_KEY):(amb|blu|brn|gry|grn|hzl|oth)")
        return eyeColorRegex.containsMatchIn(batchLine)
    }

    private fun isPassportIdValid(): Boolean {
        val passportIdRegex: Regex = Regex("($PASSPORT_ID_KEY):(\\d{9})(?=\\s|\$)")
        return passportIdRegex.containsMatchIn(batchLine)
    }

    companion object {
        private const val BIRTH_YEAR_KEY: String = "byr"
        private const val ISSUE_YEAR_KEY: String = "iyr"
        private const val EXPIRATION_YEAR_KEY: String = "eyr"
        private const val HEIGHT_KEY: String = "hgt"
        private const val HAIR_COLOR_KEY: String = "hcl"
        private const val EYE_COLOR_KEY: String = "ecl"
        private const val PASSPORT_ID_KEY: String = "pid"
        private const val VALUE_PATTERN: String = ":([^\\s:]+)"
    }
}
