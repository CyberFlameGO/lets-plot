package jetbrains.datalore.visualization.base.svgMapper.jfx

import jetbrains.datalore.base.awt.toPngDataUri
import jetbrains.datalore.visualization.base.svg.SvgImageElementEx.RGBEncoder
import java.awt.image.BufferedImage
import java.io.IOException

// ToDo: duplicated, not JFX specific
internal class RGBEncoderAwt : RGBEncoder {

    override fun toDataUrl(width: Int, height: Int, argbValues: IntArray): String {
        val bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)

        for (y in 0 until height) {
            for (x in 0 until width) {
                bufferedImage.setRGB(x, y, argbValues[y * width + x])
            }
        }

        try {
            return bufferedImage.toPngDataUri()
        } catch (e: IOException) {
            throw IllegalArgumentException("Can't build image $width X $height", e)
        }

    }
}