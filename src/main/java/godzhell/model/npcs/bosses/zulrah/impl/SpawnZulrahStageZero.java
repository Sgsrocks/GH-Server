package godzhell.model.npcs.bosses.zulrah.impl;

import godzhell.Server;
import godzhell.event.CycleEventContainer;
import godzhell.model.npcs.NPC;
import godzhell.model.npcs.NPCHandler;
import godzhell.model.npcs.bosses.zulrah.Zulrah;
import godzhell.model.npcs.bosses.zulrah.ZulrahLocation;
import godzhell.model.npcs.bosses.zulrah.ZulrahStage;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;

public class SpawnZulrahStageZero extends ZulrahStage {

	public SpawnZulrahStageZero(Zulrah zulrah, Player player) {
		super(zulrah, player);
	}

	@Override
	public void execute(CycleEventContainer container) {
		if (container.getOwner() == null || zulrah == null || player == null || player.isDead || zulrah.getInstancedZulrah() == null) {
			container.stop();
			return;
		}
		int cycle = container.getTotalTicks();
		if (cycle == 8) {
			player.getPA().sendScreenFade("", -1, 4);
			player.getPA().movePlayer(2268, 3069, zulrah.getInstancedZulrah().getHeight());
		}
		if (cycle == 13) {
			Server.npcHandler.spawnNpc(player, 2042, 2266, 3072, zulrah.getInstancedZulrah().getHeight(), -1, 500, 41, 500, 500, false, false);
			NPC npc = NPCHandler.getNpc(2042, 2266, 3072, zulrah.getInstancedZulrah().getHeight());
			if (npc == null) {
				player.sendMessage("Something went wrong, please contact staff.");
				container.stop();
				return;
			}
			zulrah.setNpc(npc);
			npc.setFacePlayer(false);
			npc.facePlayer(player.getIndex());
			npc.startAnimation(5073);
		}
		if (cycle == 18) {
			zulrah.changeStage(1, CombatType.RANGE, ZulrahLocation.NORTH);
			container.stop();
		}
	}

}
