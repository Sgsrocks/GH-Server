package ethos.model.content.MysteryBoxs;

import ethos.definitions.ItemCacheDefinition;
import ethos.model.items.GameItem;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.util.Misc;

import java.util.*;


/**
 * Revamped a simple means of receiving a random item based on chance.
 *
 * @author Jason MacKeigan
 * @date Oct 29, 2014, 1:43:44 PM
 */
public class DrCapeMysteryBox {

    /**
     * The item id of the mystery box required to trigger the event
     */
    private static final int MYSTERY_BOX = 27326;

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
						new GameItem(26797),//Dr Cape (Blue)
						new GameItem(26798),//Dr Cape (Green)
						new GameItem(26799),//Dr Cape (Light Blue)
						new GameItem(26800),//Dr Cape (Orange)
						new GameItem(26801),//Dr Cape (Pink)
						new GameItem(26802),//Dr Cape (Purple)
						new GameItem(26803)//Dr Cape (Red)
						 )
        );

        items.put(Rarity.UNCOMMON,
                Arrays.asList(
						new GameItem(27103),//Dr Cape (White)
						new GameItem(27104),//Dr Cape (Neon Green)
						new GameItem(27105),//Dr Cape (Neon Pink)
						new GameItem(27106),//Dr Cape (Neon Blue)
						new GameItem(27107),//Dr Cape (Neon Purple)
						new GameItem(27108),//Dr Cape (Neon Yellow)
						new GameItem(27109)//Dr Cape (Neon Teal)
						 )
        );

        items.put(Rarity.RARE,
                Arrays.asList(
						new GameItem(27272),//Dr Cape
						new GameItem(27273),//Dr Cape
						new GameItem(27274),//Dr Cape
						new GameItem(27275),//Dr Cape
						new GameItem(27276),//Dr Cape
						new GameItem(27277),//Dr Cape
						new GameItem(27278),//Dr Cape
						new GameItem(27279),//Dr Cape
						new GameItem(27280),//Dr Cape
						new GameItem(27281)//Dr Cape
						 ));
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
    public DrCapeMysteryBox(Player player) {
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
		player.getPA().sendString("Dr Cape Mystery Box", 47002);
		player.getPA().showInterface(INTERFACE_ID);
	}
}
