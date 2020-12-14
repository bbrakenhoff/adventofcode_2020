package com.bbrakenhoff.adventofcode.day12

class ShipWithWaypoint : Ship() {

    private var eastWestWaypoint = 10
    private var northSouthWaypoint = 1

    override fun navigateNorth(units: Int) {
        northSouthWaypoint += units
    }

    override fun navigateSouth(units: Int) {
        northSouthWaypoint -= units
    }

    override fun navigateEast(units: Int) {
        eastWestWaypoint += units
    }

    override fun navigateWest(units: Int) {
        eastWestWaypoint -= units
    }

    override fun navigateForward(units: Int) {
        northSouthPosition += northSouthWaypoint * units
        eastWestPosition += eastWestWaypoint * units
    }

    override fun rotateClockwise(units: Int) {
        repeat(units / 90) {
            northSouthWaypoint = -eastWestWaypoint.also {
                eastWestWaypoint = northSouthWaypoint
            }
        }
    }

    override fun rotateCounterclockwise(units: Int) {
        repeat(units / 90) {
            eastWestWaypoint = -northSouthWaypoint.also {
                northSouthWaypoint = eastWestWaypoint
            }
        }
    }
}
