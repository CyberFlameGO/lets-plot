package jetbrains.datalore.visualization.plot.gog.plot.coord

import jetbrains.datalore.base.gcommon.collect.ClosedRange
import jetbrains.datalore.base.geometry.DoubleVector
import jetbrains.datalore.base.values.Pair

internal class CartesianCoordProvider : CoordProviderBase() {

    override fun adjustDomains(xDomain: ClosedRange<Double>, yDomain: ClosedRange<Double>, displaySize: DoubleVector): Pair<ClosedRange<Double>, ClosedRange<Double>> {
        // unchanged
        return Pair(xDomain, yDomain)
    }
}