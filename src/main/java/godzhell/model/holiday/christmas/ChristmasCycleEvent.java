package godzhell.model.holiday.christmas;

import godzhell.Config;
import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.model.holiday.HolidayController;
import godzhell.model.players.PlayerHandler;

public class ChristmasCycleEvent extends CycleEvent {

	@Override
	public void execute(CycleEventContainer container) {
		Christmas christmas = (Christmas) container.getOwner();
		if (christmas == null) {
			container.stop();
			return;
		}
		if (!HolidayController.CHRISTMAS.isActive()) {
			PlayerHandler.executeGlobalMessage("@red@The Christmas event is officially over. Enjoy the rest of your Holidays.");
			christmas.finalizeHoliday();
			container.stop();
			return;
		}
		christmas.getSnowball().update();
		for (int i = 0; i < Config.AMOUNT_OF_SANTA_MINIONS; i++) {
			christmas.getMinion().update();
		}
	}

}
