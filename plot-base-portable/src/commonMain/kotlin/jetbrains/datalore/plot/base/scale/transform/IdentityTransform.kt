/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base.scale.transform

import jetbrains.datalore.base.gcommon.base.Preconditions.checkArgument
import jetbrains.datalore.plot.base.Transform
import jetbrains.datalore.plot.common.data.SeriesUtil

internal class IdentityTransform : Transform {
    override fun apply(rawData: List<*>): List<Double?> {
        val checkedDoubles = SeriesUtil.checkedDoubles(rawData)
        checkArgument(checkedDoubles.canBeCast(), "Not a collections of numbers")
        return checkedDoubles.cast()
    }

    override fun applyInverse(v: Double?): Any? {
        return v
    }
}
