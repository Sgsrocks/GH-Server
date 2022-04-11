package godzhell.model.content.instances.impl;

import godzhell.Server;
import godzhell.model.content.instances.SingleInstancedArea;
import godzhell.model.npcs.NPCHandler;
import godzhell.model.npcs.bosses.zulrah.Zulrah;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;

public class SingleInstancedZulrah extends SingleInstancedArea {

	public SingleInstancedZulrah(Player player, Boundary boundary, int height) {
		super(player, boundary, height);
	}

	@Override
	public void onDispose() {
		Zulrah zulrah = player.getZulrahEvent();
		if (zulrah.getNpc() != null) {
			NPCHandler.kill(zulrah.getNpc().npcType, height);
		}
		Server.getGlobalObjects().remove(11700, height);
		NPCHandler.kill(Zulrah.SNAKELING, height);
	}

}
