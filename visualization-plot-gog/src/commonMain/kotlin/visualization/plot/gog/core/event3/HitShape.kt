package jetbrains.datalore.visualization.plot.gog.core.event3

import jetbrains.datalore.base.geometry.DoubleRectangle
import jetbrains.datalore.base.geometry.DoubleVector

open class HitShape private constructor(val kind: Kind, private val myShape: Any) {

    val point: DoubleCircle
        get() = myShape as DoubleCircle

    val rect: DoubleRectangle
        get() = myShape as DoubleRectangle

    open val points: List<DoubleVector>
        get() = throw IllegalStateException("Not applicable to $kind")

    enum class Kind {
        POINT, RECT, POLYGON, PATH
    }

    class DoubleCircle(val center: DoubleVector, val radius: Double)

    companion object {
        fun point(p: DoubleVector, radius: Double): HitShape {
            return HitShape(Kind.POINT, DoubleCircle(p, radius))
        }

        fun rect(r: DoubleRectangle): HitShape {
            return HitShape(Kind.RECT, r)
        }

        fun path(points: List<DoubleVector>, closePath: Boolean): HitShape {
            return shapeWithPath(if (closePath) Kind.POLYGON else Kind.PATH, points)
        }

        private fun shapeWithPath(kind: Kind, points: List<DoubleVector>): HitShape {
            return object : HitShape(kind, points) {
                override val points: List<DoubleVector>
                    get() = points
            }
        }
    }
}