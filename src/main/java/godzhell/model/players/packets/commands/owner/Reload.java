package godzhell.model.players.packets.commands.owner;

import java.io.IOException;

import godzhell.Config;
import godzhell.Server;
import godzhell.clip.doors.DoorDefinition;
import godzhell.model.content.music.MusicLoader;
import godzhell.model.content.music.MusicManager;
import godzhell.model.items.ItemDefinition;
import godzhell.model.objects.Doors;
import godzhell.model.objects.DoubleDoors;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Reloading certain objects by {String input}
 * 
 * @author Matt
 */

public class Reload extends Command {

	@Override
	public void execute(Player player, String input) {
		switch (input) {
		
		case "":
			player.sendMessage("@red@Usage: ::reload doors, drops, items, objects, shops or npcs");
			break;

		case "doors":
			Doors.getSingleton().load();
			DoubleDoors.getSingleton().load();
			player.sendMessage("@blu@Reloaded Doors.");
			break;

		case "drops":
			Server.getDropManager().read();
			player.sendMessage("@blu@Reloaded Drops.");
			break;

		case "items":
			Server.itemHandler.loadItemList("item_config.cfg");
			Server.itemHandler.loadItemPrices("item_prices.txt");
			try {
				ItemDefinition.load();
			} catch (IOException e) {
				player.sendMessage("@blu@Unable to reload items, check console.");
				e.printStackTrace();
			}
			player.sendMessage("@blu@Reloaded Items.");
			break;

		case "objects":
			try {
				Server.getGlobalObjects().reloadObjectFile(player);
				player.sendMessage("@blu@Reloaded Objects.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case "shops":
			Server.shopHandler = new godzhell.world.ShopHandler();
			player.sendMessage("@blu@Reloaded Shops");
			break;

		case "npcs":
			Server.npcHandler = null;
			Server.npcHandler = new godzhell.model.npcs.NPCHandler();
			player.sendMessage("@blu@Reloaded NPCs");
			break;
			
		case "punishments":
			try {
				Server.getPunishments().initialize();
				player.sendMessage("@blu@Reloaded Punishments.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case "looting":
			Config.BAG_AND_POUCH_PERMITTED = !Config.BAG_AND_POUCH_PERMITTED;
			player.sendMessage(""+(Config.BAG_AND_POUCH_PERMITTED ? "Enabled" : "Disabled" +"") + " bag and pouch.");
			break;
			
		case "music":
			try {
				new MusicLoader().load();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

}
