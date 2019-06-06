package jetbrains.datalore.visualization.base.svgMapper.jfx

import javafx.scene.Group
import jetbrains.datalore.mapper.core.Synchronizers
import jetbrains.datalore.visualization.base.svg.SvgGElement

internal class SvgGElementMapper(
        source: SvgGElement,
        target: Group,
        peer: SvgAwtPeer) : SvgElementMapper<SvgGElement, Group>(source, target, peer) {

    override fun registerSynchronizers(conf: SynchronizersConfiguration) {
        super.registerSynchronizers(conf)

        if (!source.isPrebuiltSubtree) {
            val targetList = Utils.elementChildren(target)
            conf.add(Synchronizers.forObservableRole(
                    this,
                    source.children(),
                    targetList,
                    SvgNodeMapperFactory(peer)
            ))
        } else {
            TODO()
//            conf.add(SvgNodeSubtreeGeneratingSynchronizer(source, target, myDoc))
        }
    }
}