package ethos.model.content.MysteryBoxs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import ethos.definitions.ItemCacheDefinition;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.content.MysteryBoxs.UltraMysteryBox.Rarity;
import ethos.model.items.GameItem;
import ethos.model.items.ItemAssistant;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.util.Misc;


/**
 * Revamped a simple means of receiving a random item based on chance.
 *
 * @author Jason MacKeigan
 * @date Oct 29, 2014, 1:43:44 PM
 */
public class MysteryBox {

    /**
     * The item id of the mystery box required to trigger the event
     */
    private static final int MYSTERY_BOX = 6199;

    /**
     * A map containing a List of {@link GameItem}'s that contain items relevant to their rarity.
     */
    private static Map<Rarity, List<GameItem>> items = new HashMap<>();

    /**
     * Stores an array of items into each map with the corresponding rarity to the list
     */
    static {
        items.put(Rarity.COMMON,
                Arrays.asList(
                		new GameItem(4566),
                        new GameItem(452, 45),
                        new GameItem(6739, 1),
                        new GameItem(71, 20),
                        new GameItem(12439),
                        new GameItem(12397),
                        new GameItem(452, 500),
                        new GameItem(2364, 350),
                        new GameItem(12412),
                        new GameItem(12357),
                        new GameItem(13442, 75),
                        new GameItem(11937, 75),
                        new GameItem(12351),
                        new GameItem(1419),
                        new GameItem(1305, 1),
                        new GameItem(11235, 1),
                        new GameItem(4084),
                        new GameItem(4212),
                        new GameItem(4708),
                        new GameItem(4710),
                        new GameItem(4712),
                        new GameItem(4714),
                        new GameItem(11840),
                        new GameItem(11731, 1),
                        new GameItem(12848),
                        new GameItem(2513),
                        new GameItem(9740),
                        new GameItem(11230, 40),
                        new GameItem(811, 50),
                        new GameItem(11128),
                        new GameItem(11130),
                        new GameItem(4716),
                        new GameItem(4718),
                        new GameItem(4720),
                        new GameItem(4722),
                        new GameItem(4724),
                        new GameItem(4726),
                        new GameItem(4728),
                        new GameItem(4730),
                        new GameItem(4732),
                        new GameItem(4734),
                        new GameItem(4736),
                        new GameItem(4738),
                        new GameItem(4742),
                        new GameItem(4745),
                        new GameItem(7158),
                        new GameItem(4747),
                        new GameItem(4749),
                        new GameItem(1514, 50),
                        new GameItem(1516, 50),
                        new GameItem(1518, 60),
                        new GameItem(11944, 25),
                        new GameItem(1520, 70),
                        new GameItem(4751),
                        new GameItem(4753),
                        new GameItem(19670, 25),
                        new GameItem(4755),
                        new GameItem(4757),
                        new GameItem(4759),
                        new GameItem(4224),
                        new GameItem(12432),
                        new GameItem(12422),
                        new GameItem(12424),
                        new GameItem(12426),
                        new GameItem(12379),
                        new GameItem(220, 25),
                        new GameItem(12391),
                        new GameItem(12849),
                        new GameItem(4151),
                        new GameItem(12786),
                        new GameItem(12783),
                        new GameItem(1615, 1),
                        new GameItem(12798),
                        new GameItem(13307, 200),
                        new GameItem(2996, 400),
                        new GameItem(12337))
        );

        items.put(Rarity.UNCOMMON,
                Arrays.asList(
                        new GameItem(4566),
                        new GameItem(452, 45),
                        new GameItem(6739, 1),
                        new GameItem(71, 20),
                        new GameItem(12439),
                        new GameItem(12397),
                        new GameItem(452, 500),
                        new GameItem(2364, 350),
                        new GameItem(12412),
                        new GameItem(12357),
                        new GameItem(13442, 75),
                        new GameItem(11937, 75),
                        new GameItem(12351),
                        new GameItem(1419),
                        new GameItem(1305, 1),
                        new GameItem(11235, 1),
                        new GameItem(4084),
                        new GameItem(4212),
                        new GameItem(4708),
                        new GameItem(4710),
                        new GameItem(4712),
                        new GameItem(4714),
                        new GameItem(11840),
                        new GameItem(11731, 1),
                        new GameItem(12848),
                        new GameItem(2513),
                        new GameItem(9740),
                        new GameItem(11230, 40),
                        new GameItem(811, 50),
                        new GameItem(11128),
                        new GameItem(11130),
                        new GameItem(4716),
                        new GameItem(4718),
                        new GameItem(4720),
                        new GameItem(4722),
                        new GameItem(4724),
                        new GameItem(4726),
                        new GameItem(4728),
                        new GameItem(4730),
                        new GameItem(4732),
                        new GameItem(4734),
                        new GameItem(4736),
                        new GameItem(4738),
                        new GameItem(4742),
                        new GameItem(4745),
                        new GameItem(7158),
                        new GameItem(4747),
                        new GameItem(4749),
                        new GameItem(1514, 50),
                        new GameItem(1516, 50),
                        new GameItem(1518, 60),
                        new GameItem(11944, 25),
                        new GameItem(1520, 70),
                        new GameItem(4751),
                        new GameItem(4753),
                        new GameItem(19670, 25),
                        new GameItem(4755),
                        new GameItem(4757),
                        new GameItem(4759),
                        new GameItem(4224),
                        new GameItem(12432),
                        new GameItem(12422),
                        new GameItem(12424),
                        new GameItem(12426),
                        new GameItem(12379),
                        new GameItem(220, 25),
                        new GameItem(12391),
                        new GameItem(12849),
                        new GameItem(4151),
                        new GameItem(12786),
                        new GameItem(12783),
                        new GameItem(1615, 1),
                        new GameItem(12798),
                        new GameItem(13307, 200),
                        new GameItem(2996, 400),
                        new GameItem(12337))
        );

        items.put(Rarity.RARE,
                Arrays.asList(
                        new GameItem(11818, 1),
                        new GameItem(995, 10000000),
                        new GameItem(2996, 600),
                        new GameItem(12437, 1),
                        new GameItem(12424, 1),
                        new GameItem(12426, 1),
                        new GameItem(12422, 1),
                        new GameItem(12359, 1),
                        new GameItem(12849, 1),
                        new GameItem(12802, 1),
                        new GameItem(12800, 1),
                        new GameItem(12798, 1),
                        new GameItem(2697, 1),
                        new GameItem(12373, 1)));
    }

    /**
     * The player object that will be triggering this event
     */
    private Player player;

    /**
     * Constructs a new myster box to handle item receiving for this player and this player alone
     *
     * @param player the player
     */
    public MysteryBox(Player player) {
        this.player = player;
    }

    /**
	 * Can the player open the mystery box
	 */
	private boolean canMysteryBox = true;
	
	/**
	 * The prize received
	 */
	private int mysteryPrize;

	private int mysteryAmount;
	
	private int spinNum = 0;
	
	/**
	 * The chance to obtain the item
	 */
	private int random;
	
	private final int INTERFACE_ID = 47000;
	private final int ITEM_FRAME = 47101;
	
	/**
	 * The rarity of the reward
	 */
	private Rarity rewardRarity;

	/**
	 * Represents the rarity of a certain list of items
	 */
	enum Rarity {
		UNCOMMON("<col=005eff>"),
		COMMON("<col=336600>"),
		RARE("<col=B80000>");
		
		private String color;
		
		Rarity(String color) {
			this.color = color;
		}
		
		public String getColor() {
			return color;
		}
		
	    public static Rarity forId(int id) {
	        for (Rarity tier : Rarity.values()) {
	            if (tier.ordinal() == id)
	                return tier;
	        }
	        return null;
	    }
	}
	
	public void spin() {
		// Server side checks for spin
		if (!canMysteryBox) {
			player.sendMessage("Please finish your current spin.");
			return;
		}
		if (!player.getItems().playerHasItem(MYSTERY_BOX)) {
			player.sendMessage("You require a mystery box to do this.");
			return;
		}

		// Delete box
		player.getItems().deleteItem(MYSTERY_BOX, 1);
		// Initiate spin
		player.sendMessage(":resetBox");
		for (int i=0; i<66; i++){
			player.getPA().mysteryBoxItemOnInterface(-1, 1, ITEM_FRAME, i);
		}
		spinNum = 0;
		player.sendMessage(":spin");
		process();
	}
	
	public void process() {
		// Reset prize
		mysteryPrize = -1;

		mysteryAmount = -1;
		// Can't spin when already in progress
		canMysteryBox = false;
		
		random = Misc.random(100);
		List<GameItem> itemList = random < 40 ? items.get(Rarity.COMMON) : random >= 40 && random <= 95 ? items.get(Rarity.UNCOMMON) : items.get(Rarity.RARE);
		rewardRarity = random < 40 ? Rarity.COMMON : random >= 40 && random <= 95 ? Rarity.UNCOMMON : Rarity.RARE;
		
		GameItem item = Misc.getRandomItem(itemList);

		mysteryPrize = item.getId();

		mysteryAmount = item.getAmount();

		// Send items to interface
		// Move non-prize items client side if you would like to reduce server load
		if (spinNum == 0) {
			for (int i=0; i<66; i++){
				Rarity notPrizeRarity = Rarity.values()[new Random().nextInt(Rarity.values().length)];
				GameItem NotPrize =Misc.getRandomItem(items.get(notPrizeRarity));
				final int NOT_PRIZE_ID = NotPrize.getId();
				final int NOT_PRIZE_AMOUNT = NotPrize.getAmount();
				sendItem(i, 55, mysteryPrize, NOT_PRIZE_ID,1);
			}
		} else {
			for (int i=spinNum*50 + 16; i<spinNum*50 + 66; i++){
				Rarity notPrizeRarity = Rarity.values()[new Random().nextInt(Rarity.values().length)];	
				final int NOT_PRIZE_ID = Misc.getRandomItem(items.get(notPrizeRarity)).getId();
				sendItem(i, (spinNum+1)*50 + 5, mysteryPrize, NOT_PRIZE_ID, mysteryAmount);
			}
		}
		spinNum++;
	}
	
	public void reward() {
		if (mysteryPrize == -1) {
			return;
		}
		
		//player.boxCurrentlyUsing = -1;
		
		player.getItems().addItemUnderAnyCircumstance(mysteryPrize, mysteryAmount);
		
		// Reward text colour
		String tier = rewardRarity.getColor();
		
		// Reward message
		String name = ItemCacheDefinition.forID(mysteryPrize).getName();
		if (name.substring(name.length() - 1).equals("s")) {
			player.sendMessage("Congratulations, you have won " + tier + name + "@bla@!");
		}
		else {
			player.sendMessage("Congratulations, you have won a " + tier + name + "@bla@!");
		}
		
		if (random > 95) {
			PlayerHandler.executeGlobalMessage("[<col=CC0000>Normal</col>] <col=255>" + Misc.formatPlayerName(player.playerName)
					+ "</col> hit the jackpot and got a <col=CC0000>"+name+"</col> !");
		}
		
		// Can now spin again
		canMysteryBox = true;
	}
	
	public void sendItem(int i, int prizeSlot, int PRIZE_ID, int NOT_PRIZE_ID, int amount) {
		if (i == prizeSlot) {
			player.getPA().mysteryBoxItemOnInterface(PRIZE_ID, amount, ITEM_FRAME, i);
		}
		else {
			player.getPA().mysteryBoxItemOnInterface(NOT_PRIZE_ID, amount, ITEM_FRAME, i);
		}
	}
	
	public void openInterface() {
		player.boxCurrentlyUsing = MYSTERY_BOX;
		// Reset interface
		player.sendMessage(":resetBox");
		for (int i=0; i<66; i++){
			player.getPA().mysteryBoxItemOnInterface(-1, 1, ITEM_FRAME, i);
		}
		spinNum = 0;
		// Open
		player.getPA().sendString("Mystery Box", 47002);
		player.getPA().showInterface(INTERFACE_ID);
	}
}
