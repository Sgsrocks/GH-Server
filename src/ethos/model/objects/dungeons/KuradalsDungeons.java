package ethos.model.objects.dungeons;

import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;

public class KuradalsDungeons {


	public static void handleObjects(final Player c, int objectType, final int obX, final int obY) {
		switch (objectType) {
		case 14464:
			c.getPA().movePlayer(1660, 5257, 0);
			break;

		case 14463:
			c.getPA().movePlayer(1735, 5313, 1);
			break;
		case 14469:
			if (c.playerLevel[16] >= 86) {
				if (c.absY < obY) {
					c.getPA().movePlayer(c.absX, c.absY + 8, c.heightLevel);
				} else if (c.absY > obY) {
					c.getPA().movePlayer(c.absX, c.absY - 8, c.heightLevel);
				}
			} else {
				c.sendMessage("You need an agility level of 86 to use this shortcut.");
			}
			break;

		case 14465:
			c.startAnimation(839);
			c.turnPlayerTo(c.objectX, c.objectY);
			CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
				@Override
				public void execute(CycleEventContainer e) {
					if (c.playerLevel[16] >= 86) {
						if (c.absY < obY) {
							c.getPA().movePlayer(c.absX, c.absY + 2, c.heightLevel);
						} else if (c.absY > obY) {
							c.getPA().movePlayer(c.absX, c.absY - 2, c.heightLevel);
						}
					} else {
						c.sendMessage("You need an agility level of 86 to use this shortcut.");
					}
					e.stop();
				}

				public void stop() {
				}
			}, 2);
			break;

		case 14468:
			c.startAnimation(9516);
			c.turnPlayerTo(c.objectX, c.objectY);
			CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
				@Override
				public void execute(CycleEventContainer e) {
					int x = c.objectX;
					int y = c.objectY;
					if (c.absX > x && c.absY < y) {
						c.getPA().movePlayer(c.absX, c.absY + 1, c.heightLevel);
					} else if (c.absY == 5281 || c.absY == 5265 || c.absY == 5289) {
						c.getPA().movePlayer(c.absX, c.absY - 1, c.heightLevel);
					} else if (c.absX == x && c.absY < y) {
						c.getPA().movePlayer(c.absX, c.absY + 1, c.heightLevel);
					} else if (c.absX > x && c.absY == y) {
						c.getPA().movePlayer(c.absX - 1, c.absY, c.heightLevel);
					} else if (c.absX == x && c.absY == y) {
						c.getPA().movePlayer(c.absX + 1, c.absY, c.heightLevel);
					} else {
						c.getPA().movePlayer(c.absX, c.absY - 1, c.heightLevel);
					}
					e.stop();
				}

				public void stop() {
				}
			}, 2);
			break;

		}
	}
}
