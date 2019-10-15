package jetbrains.datalore.plot.base.interact

import jetbrains.datalore.plot.base.Aes

interface MappedDataAccess {

    val mappedAes: Set<Aes<*>>

    fun isMapped(aes: Aes<*>): Boolean

    fun <T> getMappedData(aes: Aes<T>, index: Int): MappedData<T>

    class MappedData<T>(
            val label: String,
            val value: String,
            val isContinuous: Boolean)
}