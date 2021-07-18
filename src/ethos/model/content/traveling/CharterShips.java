package ethos.model.content.traveling;

import ethos.Config;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;

/**
 * @author Andrew
 */

public class CharterShips {

	private static final int[][] TRAVEL_DATA = { {}, // 0 - Null

			{ 2954, 3158, 9}, //1 - From Port Sarim to Karamjama
			{ 3038, 3192, 8}, //2 - From Karamjama to Port Sarim
			
	};
	
	//2620, 3686 - relleka
	//2551, 3759 - waterbirth
	
	public static boolean checkForCash(Player player) {
		if (!player.getItems().playerHasItem(995, 1000)) {
			//player.getDialogueHandler().sendNpcChat1("You need 1000 coins to to travel on this ship!", 2437, NpcHandler.getNpcListName(player.npcType));
			//player.nextChat = 0;
			return false;
		}
		player.getItems().deleteItem2(995, 1000);
		player.sendMessage("Your free to go and pay the 1000 coins.");
		return true;
	}

	public static boolean checkForCoins(Player player) {
		if (!player.getItems().playerHasItem(995, 30)) {
			//player.getDialogueHandler().sendNpcChat1("You need 30 coins to to travel on this ship!", 381, NpcHandler.getNpcListName(player.npcType));
			//player.nextChat = 0;
			return false;
		}
		player.getItems().deleteItem2(995, 30);
		player.sendMessage("Your free to go and pay the 30 coins.");
		return true;
	}

	public static boolean searchForAlcohol(Player player) {
		for (int element : Config.ALCOHOL_RELATED_ITEMS) {
			if (player.getItems().playerHasItem(element, 1)) {
				//player.getDialogueHandler().sendNpcChat1("You can't bring intoxicating items to Asgarnia!", player.npcType, NpcHandler.getNpcListName(player.npcType));
				//player.nextChat = 0;
				return false;
			}
		}
		player.sendMessage(
				"Your clean of any possible alchohol.");
		return true;
	}

	public static boolean quickSearch(Player player) {
		for (int element : Config.COMBAT_RELATED_ITEMS) {
			if (player.getItems().playerHasItem(element, 1) || player.getItems().playerHasEquipped(element)) {
				//player.getDialogueHandler().sendNpcChat2("Grr! I see you brought some illegal items! Get", "out of my sight immediately!", 657, NpcHandler.getNpcListName(player.npcType));
				//player.nextChat = 0;
				return false;
			}
		}
		player.sendMessage("Your clean of any possible weapons.");
		return true;
	}

	public static void startTravel(final Player player, final int i) {
			if (!checkForCash(player)) {
				return;
			}
		player.stopPlayerPacket = true;
		player.getPA().movePlayer(0, 0, 0);
		player.getPlayerAssistant().showInterface(3281);
		player.getPlayerAssistant().sendConfig(75, i);
		
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
				player.getPlayerAssistant().movePlayer(getX(i), getY(i), 0);
				container.stop();
			}
			@Override
			public void stop() {
				
			}
		}, getTime(i) - 1);

		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
				player.stopPlayerPacket = false;
				player.getPlayerAssistant().sendConfig(75, -1);
				player.getPlayerAssistant().closeAllWindows();
				//player.getDialogueHandler().sendStatement("You arrive safely.");
				player.nextChat = 0;
				container.stop();
			}
			@Override
			public void stop() {
				
			}
		}, getTime(i));
	
	}

	public static int getX(int i) {
		return TRAVEL_DATA[i][0];
	}

	public static int getY(int i) {
		return TRAVEL_DATA[i][1];
	}

	public static int getTime(int i) {
		return TRAVEL_DATA[i][2];
	}

}
