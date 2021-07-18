package ethos.model.players.packets.objectoptions;

import ethos.Server;
import ethos.model.players.Player;
import ethos.model.players.Right;
import ethos.model.players.skills.construction.Construction;

public class ObjectOptionFive {
	
	public static void handleOption(final Player c, int objectType, int obX, int obY) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		c.getPA().resetVariables();
		c.clickObjectType = 0;
		c.turnPlayerTo(obX, obY);
		if (c.getRights().isOrInherits(Right.OWNER))
			c.sendMessage("Clicked Object Option 5:  "+objectType+"");
		Construction.handleConstructionClick(c, objectType, obX, obY);
		switch (objectType) {	
		case 12309:
			c.getShops().openShop(14);
			break;
		}
	}

}
