package godzhell.model.npcs.bosses.zulrah;

import godzhell.event.CycleEvent;
import godzhell.model.players.Player;

public abstract class ZulrahStage extends CycleEvent {

	protected Zulrah zulrah;

	protected Player player;

	public ZulrahStage(Zulrah zulrah, Player player) {
		this.zulrah = zulrah;
		this.player = player;
	}

}
