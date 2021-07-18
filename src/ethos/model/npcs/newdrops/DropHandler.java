package ethos.model.npcs.newdrops;

import ethos.Server;
import ethos.model.npcs.NPC;
import ethos.model.players.Player;
import ethos.util.Location3D;
import ethos.util.Misc;

public class DropHandler {

	public DropHandler() {
		// TODO Auto-generated constructor stub
	}
	static int[] Easy_clues = {2677, 2678, 2679, 2680,
	};
    public static int Easyclues()
    {
    	return Easy_clues[(int)(Math.random()*Easy_clues.length)];
    }	
	public static void create(Player player, NPC npc, Location3D location) {
		if(npc.getName().equalsIgnoreCase("goblin")) {
		if (Misc.random(64) == 1) {
			if (player.getItems().getItemCount(23182, false) < 1) {
				player.sendMessage("@pur@You sense a @red@clue scroll @pur@being dropped to the ground.");
			Server.itemHandler.createGroundItem(player, 23182, location.getX(), location.getY(), location.getZ(), 1, player.getIndex());
			}
		}
		if (Misc.random(128) == 1) {
			if (player.getItems().getItemCount(Easyclues(), false) < 1) {
				player.sendMessage("@pur@You sense a @red@clue scroll @pur@being dropped to the ground.");
			Server.itemHandler.createGroundItem(player, Easyclues(), location.getX(), location.getY(), location.getZ(), 1, player.getIndex());
			}
		}
	}
	}

}
