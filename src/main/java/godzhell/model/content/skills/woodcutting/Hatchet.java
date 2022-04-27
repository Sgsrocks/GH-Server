package godzhell.model.content.skills.woodcutting;

import godzhell.definitions.AnimationID;
import godzhell.definitions.ItemID;
import godzhell.model.players.Player;

enum Hatchet {
	BRONZE(ItemID.BRONZE_AXE, 1, AnimationID.WOODCUTTING_BRONZE, 1.0),
	IRON(ItemID.IRON_AXE, 1, AnimationID.WOODCUTTING_IRON, 1.0),
	STEEL(ItemID.STEEL_AXE, 6, AnimationID.WOODCUTTING_STEEL, .9),
	BLACK(ItemID.BLACK_AXE, 6, AnimationID.WOODCUTTING_BLACK, .9),
	MITHRIL(ItemID.MITHRIL_AXE, AnimationID.WOODCUTTING_MITHRIL, 871, .80),
	ADAMANT(ItemID.ADAMANT_AXE, AnimationID.WOODCUTTING_ADAMANT, 869, .65),
	RUNE(ItemID.RUNE_AXE, 41, AnimationID.WOODCUTTING_RUNE, .55),
	GILDED_AXE(ItemID.GILDED_AXE, 41, AnimationID.WOODCUTTING_GILDED, .55),
	DRAGON(ItemID.DRAGON_AXE, 61, AnimationID.WOODCUTTING_DRAGON, .45),
	DRAGON_OR(ItemID.DRAGON_AXE_OR, 61, AnimationID.WOODCUTTING_DRAGON_OR, .45),
	INFERNAL_AXE(ItemID.INFERNAL_AXE, 61, AnimationID.WOODCUTTING_INFERNAL, .45),
	INFERNAL_AXE_OR(ItemID.INFERNAL_AXE_OR, 61, AnimationID.WOODCUTTING_TRAILBLAZER, .45),
	THIRD_AGE(ItemID._3RD_AGE_AXE, 61, AnimationID.WOODCUTTING_3A_AXE, .45),
	CRYSTAL_AXE(ItemID.CRYSTAL_AXE, 71, AnimationID.WOODCUTTING_CRYSTAL, .45),
	TRAILBLAZER_AXE(ItemID.TRAILBLAZER_AXE, 71, AnimationID.WOODCUTTING_TRAILBLAZER, -45);

	private int itemId, levelRequired, animation;
	private double chopSpeed;

	/**
	 * Constructs a new {@link Hatchet} used to cut down trees.
	 * 
	 * @param itemId the item identification value of the hatchet
	 * @param levelRequired the level required for use
	 * @param animation the animation displayed during use
	 * @param chopSpeed the effectiveness of the hatchet when determining a log has been cut
	 */
	private Hatchet(int itemId, int levelRequired, int animation, double chopSpeed) {
		this.itemId = itemId;
		this.levelRequired = levelRequired;
		this.animation = animation;
		this.chopSpeed = chopSpeed;
	}

	/**
	 * The item id associated with the hatchet.
	 * 
	 * @return the item id
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * The level required to operate the hatchet whether its in your inventory or in your equipment.
	 * 
	 * @return the level required for operation
	 */
	public int getLevelRequired() {
		return levelRequired;
	}

	/**
	 * The animation displayed when the hatchet is being operated
	 * 
	 * @return the hatchet animation
	 */
	public int getAnimation() {
		return animation;
	}

	/**
	 * The speed at which this axe effects log cut time
	 * 
	 * @return the chop speed of the hatchet
	 */
	public double getChopSpeed() {
		return chopSpeed;
	}

	/**
	 * Determines the best hatchet the player has in their inventory, or equipment.
	 * 
	 * @param player the player we're trying to find the best axe for
	 * @return null if the player doesn't have a hatchet they can operate, otherwise the best hatchet on their person.
	 */
	public static Hatchet getBest(Player player) {
		Hatchet hatchet = null;
		for (Hatchet h : values()) {
			if ((player.getItems().playerHasItem(h.itemId) || player.getItems().isWearingItem(h.itemId)) && player.playerLevel[player.playerWoodcutting] >= h.levelRequired) {
				if (hatchet == null) {
					hatchet = h;
					continue;
				}
				if (hatchet.levelRequired < h.levelRequired) {
					hatchet = h;
				}
			}
		}
		return hatchet;
	}
}
