/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.vis.svgMapperDemo

import jetbrains.datalore.vis.demoUtils.SvgViewerDemoWindowBatik
import jetbrains.datalore.vis.svg.SvgSvgElement
import jetbrains.datalore.vis.svgDemoModel.a.DemoModelA

fun main() {
    val svgGroup = DemoModelA.createModel()
    val svgRoot = SvgSvgElement(500.0, 500.0)
    svgRoot.children().add(svgGroup)
    SvgViewerDemoWindowBatik(
        "Svg Elements (A)",
        listOf(svgRoot)
    ).open()
}
