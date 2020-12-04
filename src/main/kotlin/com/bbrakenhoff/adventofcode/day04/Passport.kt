package com.bbrakenhoff.adventofcode.day04

class Passport(private val batchLine: String) {

    fun isValid(): Boolean {
        return batchLine.contains(BIRTH_YEAR_KEY) && batchLine.contains(ISSUE_YEAR_KEY) && batchLine.contains(EXPIRATION_YEAR_KEY) && batchLine.contains(
            HEIGHT_KEY) && batchLine.contains(HAIR_COLOR_KEY) && batchLine.contains(EYE_COLOR_KEY) && batchLine.contains(PASSPORT_ID_KEY)
    }

    companion object {
        private const val BIRTH_YEAR_KEY: String = "byr"
        private const val ISSUE_YEAR_KEY: String = "iyr"
        private const val EXPIRATION_YEAR_KEY: String = "eyr"
        private const val HEIGHT_KEY: String = "hgt"
        private const val HAIR_COLOR_KEY: String = "hcl"
        private const val EYE_COLOR_KEY: String = "ecl"
        private const val PASSPORT_ID_KEY: String = "pid"
    }
}
