package com.bbrakenhoff.adventofcode.day12

import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NavigationInstructionTest {

    private lateinit var shipMock: Ship

    @BeforeEach
    fun beforeEach() {
        shipMock = mockk(relaxed = true)
    }

    @Test
    fun `should create North from instruction line`() {
        val instructionLine: String = "N3"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.North(3, shipMock)
    }

    @Test
    fun `should navigate north when navigating ship`() {
        NavigationInstruction.North(UNITS, shipMock).navigateShip()

        verify { shipMock.navigateNorth(UNITS) }
    }

    @Test
    fun `should create South from instruction line`() {
        val instructionLine: String = "S3"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.South(3, shipMock)
    }

    @Test
    fun `should navigate south when navigating ship`() {
        NavigationInstruction.South(UNITS, shipMock).navigateShip()

        verify { shipMock.navigateSouth(UNITS) }
    }

    @Test
    fun `should create East from instruction line`() {
        val instructionLine: String = "E3"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.East(3, shipMock)
    }

    @Test
    fun `should navigate east when navigating ship`() {
        NavigationInstruction.East(UNITS, shipMock).navigateShip()

        verify { shipMock.navigateEast(UNITS) }
    }

    @Test
    fun `should create West from instruction line`() {
        val instructionLine: String = "W3"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.West(3, shipMock)
    }

    @Test
    fun `should navigate west when navigating ship`() {
        NavigationInstruction.West(UNITS, shipMock).navigateShip()

        verify { shipMock.navigateWest(UNITS) }
    }

    @Test
    fun `should create Forward from instruction line`() {
        val instructionLine: String = "F3"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.Forward(3, shipMock)
    }

    @Test
    fun `should navigate forward when navigating ship`() {
        NavigationInstruction.Forward(UNITS, shipMock).navigateShip()

        verify { shipMock.navigateForward(UNITS) }
    }

    @Test
    fun `should create RotateClockwise from instruction line`() {
        val instructionLine: String = "R90"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.RotateClockwise(90, shipMock)
    }

    @Test
    fun `should rotate clockwise when navigating ship`() {
        NavigationInstruction.RotateClockwise(ROTATION_UNITS, shipMock).navigateShip()

        verify { shipMock.rotateClockwise(ROTATION_UNITS) }
    }

    @Test
    fun `should create RotateCounterclockwise from instruction line`() {
        val instructionLine: String = "L90"
        NavigationInstruction.createFromInstructionLine(instructionLine, shipMock) shouldBe NavigationInstruction.RotateCounterclockwise(90, shipMock)
    }

    @Test
    fun `should rotate counterclockwise when navigating ship`() {
        NavigationInstruction.RotateCounterclockwise(ROTATION_UNITS, shipMock).navigateShip()

        verify { shipMock.rotateCounterclockwise(ROTATION_UNITS) }
    }

    companion object {
        private const val UNITS: Int = 3
        private const val ROTATION_UNITS: Int = 90
    }
}

