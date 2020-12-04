package com.bbrakenhoff.adventofcode.day04

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PassportTest {

    @Test
    fun `should return true when all required fields present`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe true
    }

    @Test
    fun `should return true when only country id is missing`() {
        val batchLine: String = "iyr:2013 ecl:amb eyr:2023 pid:028048884 hcl:#cfa07d byr:1929"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when birth year is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd iyr:2017 cid:147 hgt:183cm"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when issue year is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 cid:147 hgt:183cm"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when height is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when hair color is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 byr:1937 iyr:2017 cid:147 hgt:183cm"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when eye color is missing`() {
        val batchLine: String = "pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when passport id is missing`() {
        val batchLine: String = "ecl:gry eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        val passport: Passport = Passport(batchLine)
        val isValid = passport.isValid()

        isValid shouldBe false
    }
}
