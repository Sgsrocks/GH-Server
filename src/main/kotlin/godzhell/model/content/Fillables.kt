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
object Fillables {
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
                    c.fillingWater = true
                    CycleEventHandler.getSingleton().addEvent(c, object : CycleEvent() {
                        override fun execute(container: CycleEventContainer) {
                            if (c == null || c.disconnected || c.session == null) {
                                stop()
                                return
                            }
                            if (c.fillingWater) {
                                if (!c.items.playerHasItem(g.emptyId, 1)) {
                                    c.sendMessage("You have run out of " + ItemAssistant.getItemName(g.emptyId).lowercase(Locale.getDefault()) + " to fill.")
                                    container.stop()
                                    return
                                }
                                c.startAnimation(832)
                                c.items.deleteItem(g.emptyId, 1)
                                c.items.addItem(g.filledId, 1)
                                c.sendMessage("You fill " + ItemAssistant.getItemName(g.emptyId).lowercase(Locale.getDefault()) + " from the " + ObjectDef.getObjectDef(objectID).name.lowercase(Locale.getDefault()) + ".")
                            } else {
                                container.stop()
                            }
                        }

                        override fun stop() {
                            c.stopAnimation()
                            c.fillingWater = false
                        }
                    }, AnimationLength.getFrameLength(832))
                }
            }
        }
    }

    enum class fillData(val emptyId: Int, val filledId: Int) {
        VIAL(229, 227), BUCKET(1925, 1929), JUG(1935, 1937), BOWL(1923, 1921), CUP(1980, 4458), WATERING_CAN(5331, 5340), WATERING_CAN2(5333, 5340), WATERING_CAN3(5334, 5340), WATERING_CAN4(5335, 5340), WATERING_CAN5(5336, 5340), WATERING_CAN6(5337, 5340), WATERING_CAN7(5338, 5340), WATERING_CAN8(5339, 5340), WATERSKIN(1831, 1823), WATERSKIN2(1825, 1823), WATERSKIN3(1827, 1823), WATERSKIN4(1829, 1823), FISHBOWL(6667, 6668);

    }
}