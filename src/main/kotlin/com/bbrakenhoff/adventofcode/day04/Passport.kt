package com.bbrakenhoff.adventofcode.day04

class Passport(private val batchLine: String) {

    fun isValid(): Boolean {
        val isBirthYearValid=isBirthYearValid()
        val isIssueYearValid=isIssueYearValid()
        val isExpirationYearValid = isExpirationYearValid()
        val isHeightValid = isHeightValid()
        val isHairColorValid=isHairColorValid()
        val isEyeColorValid =isEyeColorValid()
        val isPassportIdValid=isPassportIdValid()

        return isBirthYearValid &&
                isIssueYearValid &&
                isExpirationYearValid &&
                isHeightValid &&
                isHairColorValid &&
                isEyeColorValid &&
                isPassportIdValid
    }

    private fun isBirthYearValid(): Boolean = BIRTH_YEAR_REGEX.find(batchLine)?.groupValues?.size == 3

    private fun isIssueYearValid(): Boolean = ISSUE_YEAR_REGEX.find(batchLine)?.groupValues?.size == 3

    private fun isExpirationYearValid(): Boolean = EXPIRATION_YEAR_REGEX.find(batchLine)?.groupValues?.size == 3

    private fun isHeightValid(): Boolean = HEIGHT_REGEX.find(batchLine)?.groups?.size == 3

    private fun isHairColorValid(): Boolean = HAIR_COLOR_REGEX.find(batchLine)?.groupValues?.size == 3

    private fun isEyeColorValid(): Boolean = EYE_COLOR_REGEX.find(batchLine)?.groupValues?.size == 3

    private fun isPassportIdValid(): Boolean = PASSPORT_ID_REGEX.find(batchLine)?.groupValues?.size == 3

    companion object {
        private const val KEY_VALUE_REGEX_PATTERN: String = ":(.*?)\\s(?=[^\\s:]+:|\$)"
        private const val BIRTH_YEAR_KEY: String = "byr"
        private const val ISSUE_YEAR_KEY: String = "iyr"
        private const val EXPIRATION_YEAR_KEY: String = "eyr"
        private const val HEIGHT_KEY: String = "hgt"
        private const val HAIR_COLOR_KEY: String = "hcl"
        private const val EYE_COLOR_KEY: String = "ecl"
        private const val PASSPORT_ID_KEY: String = "pid"
        private const val COUNTRY_ID_KEY: String = "cid"
        private val BIRTH_YEAR_REGEX: Regex = Regex("($BIRTH_YEAR_KEY)$KEY_VALUE_REGEX_PATTERN")
        private val ISSUE_YEAR_REGEX: Regex = Regex("($ISSUE_YEAR_KEY)$KEY_VALUE_REGEX_PATTERN")
        private val EXPIRATION_YEAR_REGEX: Regex = Regex("($EXPIRATION_YEAR_KEY)$KEY_VALUE_REGEX_PATTERN")
        private val HEIGHT_REGEX: Regex = Regex("($HEIGHT_KEY)$KEY_VALUE_REGEX_PATTERN")
        private val HAIR_COLOR_REGEX: Regex = Regex("($HAIR_COLOR_KEY)$KEY_VALUE_REGEX_PATTERN")
        private val EYE_COLOR_REGEX: Regex = Regex("($EYE_COLOR_KEY)$KEY_VALUE_REGEX_PATTERN")
        private val PASSPORT_ID_REGEX: Regex = Regex("($PASSPORT_ID_KEY)$KEY_VALUE_REGEX_PATTERN")
    }
}