package godzhell.model.content

import godzhell.clip.ObjectDef
import godzhell.definitions.AnimationLength
import godzhell.event.CycleEvent
import godzhell.event.CycleEventContainer
import godzhell.event.CycleEventHandler
import godzhell.model.items.ItemAssistant
import godzhell.model.players.Player
import java.util.*

/**
 * Fillables.java made by sgsrocks
 *
 */
object Sandpit {
    /**
     *
     * @param c the player
     * @param itemId the item that needs to be filled
     * @param objectID the object that is used to fill the item.
     */
    @JvmStatic
    fun fillTheItem(c: Player?, itemId: Int, objectID: Int) {
        for (g in fillData.values()) {
            if (c!!.items.playerHasItem(g.emptyId, 1)) {
                if (itemId == g.emptyId) {
                    c.fillingSand = true
                    CycleEventHandler.getSingleton().addEvent(c, object : CycleEvent() {
                        override fun execute(container: CycleEventContainer) {
                            if (c == null || c.disconnected || c.session == null) {
                                stop()
                                return
                            }
                            if (c.fillingSand) {
                                if (!c.items.playerHasItem(g.emptyId, 1)) {
                                    c.sendMessage("You have run out of " + ItemAssistant.getItemName(g.emptyId).lowercase(Locale.getDefault()) + " to fill.")
                                    container.stop()
                                    return
                                }
                                c.startAnimation(2305)
                                c.items.deleteItem(g.emptyId, 1)
                                c.items.addItem(g.filledId, 1)
                                c.sendMessage("You fill " + ItemAssistant.getItemName(g.emptyId).lowercase(Locale.getDefault()) + " from the " + ObjectDef.getObjectDef(objectID).name.lowercase(Locale.getDefault()) + ".")
                            } else {
                                container.stop()
                            }
                        }

                        override fun stop() {
                            c.stopAnimation()
                            c.fillingSand = false
                        }
                    }, AnimationLength.getFrameLength(2305))
                }
            }
        }
    }

    enum class fillData(val emptyId: Int, val filledId: Int) {
        BUCKET(1925, 1783);

    }
}