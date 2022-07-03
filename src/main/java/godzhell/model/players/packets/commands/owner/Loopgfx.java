package godzhell.model.players.packets.commands.owner;

import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * loops gfx's to find the right one
 * 
 * @author Sgsrocks
 *
 */
public class Loopgfx extends Command {
	
	@Override
	public void execute(Player c, String input) {
		CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
			int gfxid = Integer.parseInt(input);
			@Override
			public void execute(CycleEventContainer container) {
				if (c.disconnected) {
					container.stop();
					return;
				}
				c.gfx0(gfxid);
				c.sendMessage("GfxID: " + gfxid);
				gfxid ++;
				if(gfxid > 2096) {
					container.stop();
				}
			}
			@Override
			public void stop() {

			}
		}, 3);
	}
}
