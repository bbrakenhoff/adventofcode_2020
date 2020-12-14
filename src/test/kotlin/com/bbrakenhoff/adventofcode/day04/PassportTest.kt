package com.bbrakenhoff.adventofcode.day04

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PassportTest {

    private fun testPasswordIsValid(batchLine: String): Boolean {
        val passport: Passport = Passport(batchLine)
        return passport.isValid()
    }

    @Test
    fun `should return true when all required fields present and valid`() {
        val batchLines: List<String> =
            listOf("eyr:2029 ecl:amb cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
                   "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:brn cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:gry cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:grn cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:hzl cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:oth cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:60in",
                   "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:006056539 hcl:#a97842 hgt:60in")

        for (batchLine: String in batchLines) {
            testPasswordIsValid(batchLine) shouldBe true
        }
    }

    @Test
    fun `should return true when only country id is missing`() {
        val batchLine: String = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2025 byr:1980 hcl:#623a2f"
        testPasswordIsValid(batchLine) shouldBe true
    }

    @Test
    fun `should return false when birth year is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when issue year is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when height is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when hair color is missing`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 byr:1937 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when eye color is missing`() {
        val batchLine: String = "pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when passport id is missing`() {
        val batchLine: String = "ecl:gry eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when birth year is below 1920`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1919 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when birth year is above 2002`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:2003 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when issue year is below 2010`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2009 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when issue year is above 2020`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2021 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when expiration year is below 2020`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2019 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when expiration year is above 2030`() {
        val batchLine: String = "ecl:gry pid:860033327 eyr:2031 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when height in cm is below 150`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:149cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when height in cm is above 193`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:194cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when height in inch is below 59`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:58in"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when height in inch is above 76`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a9784a hgt:77in"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when hair color is not a valid hex color`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a9784q hgt:77in"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when eye color is not equal to amb, blu, brn, gry, grn, hzl or oth`() {
        val batchLine: String = "eyr:2029 ecl:plp cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when passport id contains letters`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:q96056539 hcl:#a97842 hgt:60in"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when passport id is longer than 9 digits`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:00096056539 hcl:#a97842 hgt:60in"
        testPasswordIsValid(batchLine) shouldBe false
    }

    @Test
    fun `should return false when passport id is shorter than 9 digits`() {
        val batchLine: String = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:6056539 hcl:#a97842 hgt:60in"
        testPasswordIsValid(batchLine) shouldBe false
    }
}
