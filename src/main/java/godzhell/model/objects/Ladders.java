package godzhell.model.objects;

import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.players.Player;

public class Ladders {

	public static void climbLadder(final Player player, int x, int y, int h) {
		player.startAnimation(828/*method == "up" ? 828 : 827*/);
		player.getPA().removeAllWindows();
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
					player.getPA().movePlayer(x, y, h);
				player.startAnimation(65535);
				container.stop();
			}
			@Override
			public void stop() {
				//player.setStopPacket(false);
			}
		}, 2);
	}

}
