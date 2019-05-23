package jetbrains.datalore.visualization.plot.builder.scale.provider

import jetbrains.datalore.base.gcommon.collect.ClosedRange
import jetbrains.datalore.visualization.plot.base.Aes.Companion.SIZE
import jetbrains.datalore.visualization.plot.base.aes.AestheticsUtil
import jetbrains.datalore.visualization.plot.builder.scale.DefaultNaValue

class SizeMapperProvider(range: ClosedRange<Double>,
                         naValue: Double) : LinearNormalizingMapperProvider(range, naValue) {

    companion object {
        private val DEF_RANGE = ClosedRange.closed(
                AestheticsUtil.sizeFromCircleDiameter(3.0),
                AestheticsUtil.sizeFromCircleDiameter(21.0))

        val DEFAULT = SizeMapperProvider(DEF_RANGE, DefaultNaValue[SIZE])
    }
}