package godzhell.model.npcs.bosses.zulrah.impl;

import godzhell.event.CycleEventContainer;
import godzhell.model.npcs.bosses.zulrah.Zulrah;
import godzhell.model.npcs.bosses.zulrah.ZulrahLocation;
import godzhell.model.npcs.bosses.zulrah.ZulrahStage;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;

public class RangeStageSeven extends ZulrahStage {

	public RangeStageSeven(Zulrah zulrah, Player player) {
		super(zulrah, player);
	}

	@Override
	public void execute(CycleEventContainer container) {
		if (container.getOwner() == null || zulrah == null || zulrah.getNpc() == null || zulrah.getNpc().isDead || player == null || player.isDead
				|| zulrah.getInstancedZulrah() == null) {
			container.stop();
			return;
		}
		if (zulrah.getNpc().totalAttacks > 5) {
			player.getZulrahEvent().changeStage(8, CombatType.MAGE, ZulrahLocation.SOUTH);
			zulrah.getNpc().totalAttacks = 0;
			container.stop();
			return;
		}
	}

}
