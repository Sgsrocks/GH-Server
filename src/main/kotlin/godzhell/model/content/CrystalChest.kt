package godzhell.model.content

import godzhell.Server
import godzhell.definitions.ItemID
import godzhell.model.content.achievement.AchievementType
import godzhell.model.content.achievement.Achievements
import godzhell.model.items.GameItem
import godzhell.model.players.Boundary
import godzhell.model.players.Player
import godzhell.model.players.Right
import godzhell.util.Misc
import java.util.*

object CrystalChest {
    private const val ANIMATION = 881
    private val items: MutableMap<Rarity, List<GameItem>> = HashMap()

    init {
        items[Rarity.COMMON] = Arrays.asList(
                GameItem(140, 10),
                GameItem(374, 50),
                GameItem(380, 100),
                GameItem(995, Misc.random(50000)),
                GameItem(1127, 1),
                GameItem(2435, 2),
                GameItem(1163, 1),
                GameItem(1201, 1),
                GameItem(1303, 1),
                GameItem(1712, 1),
                GameItem(2677, 1),
                GameItem(441, 25),
                GameItem(454, 25),
                GameItem(1516, 20),
                GameItem(1512, 35),
                GameItem(208, 15),
                GameItem(565, 250),
                GameItem(560, 250),
                GameItem(71, 25),
                GameItem(1632, 5),
                GameItem(537, 10),
                GameItem(384, 15),
                GameItem(4131, 1))
        items[Rarity.UNCOMMON] = Arrays.asList(
                GameItem(386, 20),
                GameItem(990, 3),
                GameItem(995, 500000),
                GameItem(1305, 1),
                GameItem(1377, 1),
                GameItem(2368, 1),
                GameItem(2801, 1),
                GameItem(3027, 10),
                GameItem(3145, 15),
                GameItem(4587, 1),
                GameItem(6688, 10),
                GameItem(11840, 1))
    }

    private fun randomChestRewards(chance: Int): GameItem {
        val random = Misc.random(chance)
        val itemList = if (random < chance) items[Rarity.COMMON]!! else items[Rarity.UNCOMMON]!!
        return Misc.getRandomItem(itemList)
    }

    @JvmStatic
	fun makeKey(c: Player) {
        if (c.items.playerHasItem(ItemID.LOOP_HALF_OF_KEY, 1) && c.items.playerHasItem(ItemID.TOOTH_HALF_OF_KEY, 1)) {
            c.items.deleteItem(ItemID.LOOP_HALF_OF_KEY, 1)
            c.items.deleteItem(ItemID.TOOTH_HALF_OF_KEY, 1)
            c.items.addItem(ItemID.CRYSTAL_KEY, 1)
        }
    }

    @JvmStatic
	fun searchChest(c: Player) {
        if (c.items.playerHasItem(ItemID.CRYSTAL_KEY)) {
            c.items.deleteItem(ItemID.CRYSTAL_KEY, 1)
            c.startAnimation(ANIMATION)
            c.items.addItem(ItemID.UNCUT_DRAGONSTONE, 1)
            val reward = if (Boundary.isIn(c, Boundary.DONATOR_ZONE) && c.rights.isOrInherits(Right.DONATOR)) randomChestRewards(2) else randomChestRewards(9)
            if (!c.items.addItem(reward.id, reward.amount)) {
                Server.itemHandler.createGroundItem(c, reward.id, c.x, c.y, c.heightLevel, reward.amount)
            }
            Achievements.increase(c, AchievementType.LOOT_CRYSTAL_CHEST, 1)
            c.sendMessage("@blu@You stick your hand in the chest and pull an item out of the chest.")
        } else {
            c.sendMessage("@blu@The chest is locked, it won't budge!")
        }
    }

    internal enum class Rarity {
        UNCOMMON, COMMON, RARE
    }
}