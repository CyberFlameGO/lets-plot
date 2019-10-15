package jetbrains.datalore.plot.base.stat

import jetbrains.datalore.plot.base.stat.regression.RegressionEvaluator
import jetbrains.datalore.plot.base.stat.regression.SimpleRegression

actual object SmoothingMethods {
    actual fun lm(valuesX: List<Double?>, valuesY: List<Double?>, confidenceLevel: Double): RegressionEvaluator {
        return SimpleRegression(valuesX, valuesY, confidenceLevel)
    }

    actual fun loess(valuesX: List<Double?>, valuesY: List<Double?>, confidenceLevel: Double): RegressionEvaluator {
        TODO("not implemented")
    }
}