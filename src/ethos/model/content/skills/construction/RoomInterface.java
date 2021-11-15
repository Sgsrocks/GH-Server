package ethos.model.content.skills.construction;

import ethos.model.players.Player;
import ethos.model.content.skills.construction.rooms.Bedroom;
import ethos.model.content.skills.construction.rooms.Dining;
import ethos.model.content.skills.construction.rooms.Garden;
import ethos.model.content.skills.construction.rooms.Kitchen;
import ethos.model.content.skills.construction.rooms.Parlour;
import ethos.model.content.skills.construction.rooms.Workshop;

public class RoomInterface {

	public static boolean clickButton(Player c, int actionButtonId) {
		switch (actionButtonId) {
		case 121131: 
			if(c.playerLevel[22] >= 1) {
			if(c.getItems().playerHasItem(995, 1000)) {
			c.replaceWith = new Parlour();
		 c.start(new RoomDialogue());
			} else {
				c.sendMessage("You need 1000 coins to do this.");
			}
			} else {
				c.sendMessage("You need a construction level of 1  to make this.");
			}
		  break;
		case 121132: 
			if(c.playerLevel[22] >= 1) {
				if(c.getItems().playerHasItem(995, 1000)) {
			c.replaceWith = new Garden();
		 c.start(new RoomDialogue());
				} else {
					c.sendMessage("You need 1000 coins to do this.");
				}
			} else {
				c.sendMessage("You need a construction level of 1  to make this.");
			}
		  break;
		case 121133: 
			c.replaceWith = new Kitchen();
		 c.start(new RoomDialogue());
		  break;
		case 121134: 
			c.replaceWith = new Dining();
		 c.start(new RoomDialogue());
		  break;
		case 121135: 
			c.replaceWith = new Workshop();
		 c.start(new RoomDialogue());
		  break;
		case 121136: 
			c.replaceWith = new Bedroom();
		 c.start(new RoomDialogue());
		  break;
		}
		return false;
	}
}
