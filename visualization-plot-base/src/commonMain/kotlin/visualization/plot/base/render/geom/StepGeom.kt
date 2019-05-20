package jetbrains.datalore.visualization.plot.base.render.geom

import jetbrains.datalore.visualization.plot.base.render.*
import jetbrains.datalore.visualization.plot.base.render.geom.util.LinesHelper

class StepGeom : LineGeom() {
    private var myDirection = DEF_DIRECTION

    fun setDirection(dir: String) {
        myDirection = Direction.toDirection(dir)
    }

    override fun buildIntern(root: SvgRoot, aesthetics: Aesthetics, pos: PositionAdjustment, coord: CoordinateSystem, ctx: GeomContext) {
        val dataPoints = dataPoints(aesthetics)
        val helper = LinesHelper(pos, coord, ctx)
        val pathInfos = helper.createSteps(dataPoints, myDirection)
        for (pathInfo in pathInfos) {
            root.add(pathInfo.path.rootGroup)
        }
    }

    enum class Direction {
        HV, VH;


        companion object {

            fun toDirection(str: String): Direction {
                when (str) {
                    "hv", "HV" -> return HV
                    "vh", "VH" -> return VH
                    else -> throw IllegalArgumentException("Direction $str is not allowed, only accept 'hv' or 'vh'")
                }
            }
        }
    }

    companion object {
        // default
        val DEF_DIRECTION = Direction.HV
        val RENDERS = LineGeom.RENDERS
        val HANDLES_GROUPS = LineGeom.HANDLES_GROUPS
    }
}