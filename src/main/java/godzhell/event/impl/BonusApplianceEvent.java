package godzhell.event.impl;

import java.util.concurrent.TimeUnit;

import godzhell.Config;
import godzhell.event.Event;
import godzhell.model.content.wogw.Wogw;
import godzhell.model.players.PlayerHandler;
import godzhell.util.Misc;

public class BonusApplianceEvent extends Event<Object> {
	
	/**
	 * The amount of time in game cycles (600ms) that the event pulses at
	 */
	private static final int INTERVAL = Misc.toCyclesOrDefault(1, 1, TimeUnit.SECONDS);

	/**
	 * Creates a new event to cycle through messages for the entirety of the runtime
	 */
	public BonusApplianceEvent() {
		super(new String(), new Object(), INTERVAL);
	}

	@Override
	public void execute() {
		if (Wogw.EXPERIENCE_TIMER > 0) {
			Wogw.EXPERIENCE_TIMER--;
			if (Wogw.EXPERIENCE_TIMER == 1) {
				PlayerHandler.executeGlobalMessage("@cr10@[@blu@WOGW@bla@] <col=6666FF>The well is no longer granting bonus experience!");
				Config.BONUS_XP_WOGW = false;
				Wogw.appendBonus();
			}
		}
		if (Wogw.MINIGAME_BONUS_TIMER > 0) {
			Wogw.MINIGAME_BONUS_TIMER--;
			if (Wogw.MINIGAME_BONUS_TIMER == 1) {
				PlayerHandler.executeGlobalMessage("@cr10@[@blu@WOGW@bla@] <col=6666FF>The well is no longer granting bonus pc points!");
				Config.BONUS_MINIGAME_WOGW = false;
				Wogw.appendBonus();
			}
		}
		if (Wogw.DOUBLE_DROPS_TIMER > 0) {
			Wogw.DOUBLE_DROPS_TIMER--;
			if (Wogw.DOUBLE_DROPS_TIMER == 1) {
				PlayerHandler.executeGlobalMessage("@cr10@[@blu@WOGW@bla@] <col=6666FF>The well is no longer granting double drops!");
				Config.DOUBLE_DROPS = false;
				Wogw.appendBonus();
			}
		}
	}
}
