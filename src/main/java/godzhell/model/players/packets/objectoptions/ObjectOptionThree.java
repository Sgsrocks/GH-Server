package godzhell.model.players.packets.objectoptions;

import godzhell.Server;
import godzhell.clip.ObjectDef;
import godzhell.clip.Region;
import godzhell.model.content.tradingpost.Listing;
import godzhell.model.players.Player;
import godzhell.model.players.Right;

/*
 * @author Matt
 * Handles all 3rd options for objects.
 */

public class ObjectOptionThree {

	public static void handleOption(final Player c, int objectType, int obX, int obY) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		if (!Region.objectExists(objectType, obX, obY, c.heightLevel)) {
			return;
		}
		c.clickObjectType = 0;
		// c.sendMessage("Object type: " + objectType);
		if (Server.getHolidayController().clickObject(c, 3, objectType, obX, obY)) {
			return;
		}
		ObjectDef def = ObjectDef.getObjectDef(objectType);
		if((def!=null ? def.name : null)!= null && def.name.toLowerCase().equals("ladder")) {
			if(def.actions[2].toLowerCase().equals("climb-up")) {
				if(obX == 3069 && obY == 10256) { // custom locations
					c.getPA().movePlayer(3017, 3850, 0);
					return;
				}
				if(obX == 3017 && obY == 10249) { // custom locations
					c.getPA().movePlayer(3069, 3857, 0);
					return;
				}
				if(c.getX() > 6400) {
					c.getPA().movePlayer(c.getX(), c.getX()-6400, c.heightLevel);
					return;
				} else {
					c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
					return;
				}
			}
			if(def.actions[2].toLowerCase().equals("climb-down")) {
				if(obX == 3017 && obY == 3849) { // custom locations
					c.getPA().movePlayer(3069, 10257, 0);
					return;
				}
				if(obX == 3069 && obY == 3856) { // custom locations
					c.getPA().movePlayer(3017, 10248, 0);
					return;
				}
				if(obX == 1570 && obY == 2829 && c.heightLevel == 1) {
					c.getPA().movePlayer(1570, 2830, 0);
					return;
				}
				if(obX == 1560 && obY == 2829 && c.heightLevel == 1) {
					c.getPA().movePlayer(1560, 2830, 0);
					return;
				}
				if(c.getX() < 6400 && (c.heightLevel & 3) == 0) {
					c.getPA().movePlayer(c.getX(), c.getX()+6400, c.heightLevel);
					return;
				} else {
					c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
					return;
				}
			}
		}
		if((def!=null ? def.name : null)!= null && def.name.toLowerCase().equals("staircase")) {
			if(def.actions[2].equals("Climb-up")) {
				c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
				return;
				
			}
			if(def.actions[2].equals("Climb-down")) {	
				if(obX == 3103 && obY == 3159) { // Wizard tower
					c.getPA().movePlayer(3104, 3161, 0);
					return;
				}
				c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
				return;
			}
		}
		if (c.getRights().isOrInherits(Right.OWNER))
			c.sendMessage("Clicked Object Option 3:  "+objectType+", Object name: "+def.getName());
		
		switch (objectType) {
		case 24101:
			if (c.debugMessage) {
				Listing.openPost(c, false, true);
			} else {
				c.sendMessage("Trading post is currently disabled until further notice.");
			}
			//Listing.openPost(c, false, true);
			break;
		case 8356://streexerics
			c.getPA().movePlayer(1311, 3614, 0);
			break;
		case 7811:
			if (!c.inClanWarsSafe()) {
				return;
			}
			c.getDH().sendDialogues(818, 6773);
			break;
		}
	}

}
