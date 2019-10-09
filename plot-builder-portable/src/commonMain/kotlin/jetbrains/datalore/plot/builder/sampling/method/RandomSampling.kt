package jetbrains.datalore.plot.builder.sampling.method

import jetbrains.datalore.base.gcommon.base.Preconditions.checkArgument
import jetbrains.datalore.plot.builder.sampling.PointSampling
import jetbrains.datalore.visualization.plot.base.DataFrame
import kotlin.random.Random

/**
 * Take any point with equal probability without replacement
 */
internal class RandomSampling(sampleSize: Int, private val mySeed: Long?) : SamplingBase(sampleSize),
    PointSampling {

    override val expressionText: String
        get() = "sampling_" + ALIAS + "(" +
                "n=" + sampleSize +
                (if (mySeed != null) ", seed=$mySeed" else "") +
                ")"

    override fun apply(population: DataFrame): DataFrame {
        checkArgument(isApplicable(population))
        val rand = mySeed?.let { Random(it) } ?: Random.Default

        return SamplingUtil.sampleWithoutReplacement(population.rowCount(),
            sampleSize,
            rand,
            { population.selectIndices(it) },
            { population.dropIndices(it) })
    }

    companion object {
        const val ALIAS = "random"
    }
}