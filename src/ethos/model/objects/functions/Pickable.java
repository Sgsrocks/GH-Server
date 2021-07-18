package ethos.model.objects.functions;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;
import ethos.world.objects.GlobalObject;

/**
 * Pickables
 * @author Andrew (I'm A Boss on Rune-Server and Mr Extremez on Mopar & Runelocus)
 */

public class Pickable {

	private final static int[][] PICKABLE_ITEMS = { 
			{ 1161, 1965 }, // Cabbage
			{ 2646, 1779 }, // Flax
			{ 313, 1947 }, { 5583, 1947 }, { 5584, 1947 }, { 5585, 1947 }, { 15506, 1947 },  { 15507, 1947 },  { 15508, 1947 }, { 22300, 1947 },  { 22473, 1947 }, { 22474, 1947 }, { 22475, 1947 }, { 22476, 1947 }, // Wheat
			{ 5585, 1947 }, { 5584, 1947 }, { 5585, 1947 }, { 312, 1942 }, // Potato
			{ 3366, 1957 }, // Onion
	};

	public static void pickObject(final Player player, final int objectType, final int objectX, final int objectY) {
		if (player.miscTimer + 1800 > System.currentTimeMillis()) {
			return;
		}
		for (int[] data : PICKABLE_ITEMS) {
			final int objectId = data[0];
			int itemId = data[1];
			if (objectType == objectId) {
				player.getItems().addItem(itemId, 1);
				break;
			}
		}
		if (player.getItems().freeSlots() > 0) {
			player.turnPlayerTo(objectX, objectY);
			player.startAnimation(827);
			if (objectType == 2646 && random(3) == 0 || objectType != 2646) {
					Server.getGlobalObjects().add(new GlobalObject(-1, objectX, objectY, player.heightLevel, 0, 10, 5, objectType));
			}
			//player.getActionSender().sendSound(SoundList.PICKABLE, 100, 1);
			player.miscTimer = System.currentTimeMillis();
		} else {
			player.sendMessage("Your inventory is too full to hold any more items!");
		}
	}

	private static int random(int range) {
		return (int) (java.lang.Math.random() * (range + 1));
	}
}
