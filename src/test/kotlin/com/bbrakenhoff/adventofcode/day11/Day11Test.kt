package com.bbrakenhoff.adventofcode.day11

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day11Test{

     private lateinit var day11Test: Day11

     @BeforeEach
     fun beforeEach(){
         day11Test = Day11()
     }

    @Test
    fun `solution part one`(){
        day11Test.partOne() shouldBe "2273"
    }

    @Test
    fun `solution part two`(){
        day11Test.partTwo() shouldBe "2064"
    }
 }
