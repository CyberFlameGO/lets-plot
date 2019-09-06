package jetbrains.livemap.demo

import jetbrains.datalore.base.values.Color
import jetbrains.livemap.api.PathBuilder
import jetbrains.livemap.api.Paths
import jetbrains.livemap.api.PointBuilder
import jetbrains.livemap.api.Points
import jetbrains.livemap.demo.model.GeoObject

fun Points.point(block: PointBuilder.() -> Unit) {
    items.add(
        PointBuilder().apply {
            animation = 0
            index = 0
            mapId = ""
            regionId = ""
            label = ""

            strokeWidth = 1.0
            strokeColor = Color.BLACK

            fillColor = Color.WHITE

            radius = 4.0
            shape = 1
        }
            .apply(block)
            .build()
    )
}

fun Paths.path(block: PathBuilder.() -> Unit) {
    items.add(
        PathBuilder().apply {
            index = 0
            mapId = ""
            regionId = ""

            lineDash = emptyList()
            strokeColor = Color.BLACK
            strokeWidth = 1.0
            coordinates = emptyList()

            animation = 0
            speed = 0.0
            flow = 0.0

        }
            .apply(block)
            .build()
    )
}

fun PointBuilder.coord(geoObj: GeoObject) {
    lon = geoObj.lon
    lat = geoObj.lat
}