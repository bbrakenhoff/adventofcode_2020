package com.bbrakenhoff.adventofcode.day12

class ShipWithWaypoint(navigationInstructions: List<NavigationInstruction>) :
    Ship(navigationInstructions) {

    private var eastWestWaypoint = 10
    private var northSouthWaypoint = 1

    override fun navigate() {
        navigationInstructions.forEach {
            when (it) {
                is NavigationInstruction.North -> northSouthWaypoint += it.units
                is NavigationInstruction.South -> northSouthWaypoint -= it.units
                is NavigationInstruction.East -> eastWestWaypoint += it.units
                is NavigationInstruction.West -> eastWestWaypoint -= it.units
                is NavigationInstruction.RotateLeft -> repeat(it.units / 90) {
                    eastWestWaypoint = -northSouthWaypoint.also {
                        northSouthWaypoint = eastWestWaypoint
                    }
                }
                is NavigationInstruction.RotateRight -> repeat(it.units / 90) {
                    northSouthWaypoint = -eastWestWaypoint.also {
                        eastWestWaypoint = northSouthWaypoint
                    }
                }
                is NavigationInstruction.Forward -> {
                    northSouthPosition += northSouthWaypoint * it.units
                    eastWestPosition += eastWestWaypoint * it.units
                }
            }
        }
    }
}
