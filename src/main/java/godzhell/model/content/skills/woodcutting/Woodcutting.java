package godzhell.model.content.skills.woodcutting;

import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.content.skills.Skill;

public class Woodcutting {

	private static final Woodcutting INSTANCE = new Woodcutting();

	public void chop(Player player, int objectId, int x, int y) {
		Tree tree = Tree.forObject(objectId);
		player.turnPlayerTo(x, y);
		if (player.playerLevel[player.playerWoodcutting] < tree.getLevelRequired()) {
			player.sendMessage("You need a Woodcutting level of " + tree.getLevelRequired() + " to cut this tree.");
			return;
		}
		Hatchet hatchet = Hatchet.getBest(player);
		if (hatchet == null) {
			player.sendMessage("You do not have an axe which you have the woodcutting level to use.");
			return;
		}
		if (player.getItems().freeSlots() == 0) {
			player.sendMessage("Your inventory is too full to hold any more logs.");
			return;
		}
		if (Server.getGlobalObjects().exists(tree.getStumpId(), x, y)) {
			player.sendMessage("This tree has been cut down to a stump, you must wait for it to grow.");
			return;
		}
		player.getSkilling().stop();
		player.sendMessage("You swing your axe at the tree.");
		player.startAnimation(hatchet.getAnimation());
		player.getSkilling().setSkill(Skill.WOODCUTTING);
		Server.getEventHandler().submit(new WoodcuttingEvent(player, tree, hatchet, objectId, x, y));
	}

	public static Woodcutting getInstance() {
		return INSTANCE;
	}

}
