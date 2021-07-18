package ethos.model.players.skills.magic;

import ethos.model.items.GameItem;
import ethos.model.players.Player;
/**
 * 
 * @author Sgsrocks 7/6/2020
 *
 */
public class EnchantBoits {

public static void OpenEnchantBoits(Player c) {
	c.getPA().showInterface(34874);
	UpdateItems(c);
}
public static void UpdateItems(Player c) {
	int amountCosmic = c.getItems().getItemCount(564);
	int amountAir = c.getItems().getItemCount(556);
	int amountEarth = c.getItems().getItemCount(557);
	int amountNat = c.getItems().getItemCount(561);
	int amountFire = c.getItems().getItemCount(554);
	int amountLaw = c.getItems().getItemCount(563);
	int amountBlood = c.getItems().getItemCount(565);
	int amountWater = c.getItems().getItemCount(555);
	int amountSoul = c.getItems().getItemCount(566);
	int amountMind = c.getItems().getItemCount(558);
	int amountDeath = c.getItems().getItemCount(560);
	c.getPA().itemOnInterface(34985,150, 9354);//Sapphire
	c.getPA().itemOnInterface(34972, 150, 9346);//Jade
	c.getPA().itemOnInterface(34977, 150, 3822);//Pearl
	c.getPA().itemOnInterface(34989, 150, 9358);//Emerald
	c.getPA().itemOnInterface(34981, 150, 9350);//Red Topaz
	c.getPA().itemOnInterface(34993, 150, 9362);//Ruby
	c.getPA().itemOnInterface(34997, 150, 9366);//Diamond
	c.getPA().itemOnInterface(35001, 150, 9370);//Dragonstone
	c.getPA().itemOnInterface(35005, 150, 9374);//Onyx
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126(" @gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35007);
	} else {
	c.getPA().sendFrame126(" @dre@0/1", 35007);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126(" @gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35015);
	} else {
	c.getPA().sendFrame126(" @dre@0/1", 35015);
	}
	if(amountWater >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountWater)+"/1", 35040);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35040);
	}
	if(amountMind >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountMind)+"/1", 35038);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35038);
	}
	if(amountAir >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountAir)+"/2", 35028);
	} else {
	c.getPA().sendFrame126("@dre@0/2", 35028);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35009);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35009);
	}
	if(amountEarth >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountEarth)+"/2", 35032);
	} else {
	c.getPA().sendFrame126("@dre@0/2", 35032);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35011);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35011);
	}
	if(amountWater >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountWater)+"/2", 35034);
	} else {
	c.getPA().sendFrame126("@dre@0/2", 35034);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35017);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35017);
	}
	if(amountAir >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountAir)+"/3", 35046);
	} else {
	c.getPA().sendFrame126("@dre@0/3", 35046);
	}
	if(amountNat >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountNat)+"/1", 35054);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35054);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35013);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35013);
	}
	if(amountFire >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountFire)+"/2", 35036);
	} else {
	c.getPA().sendFrame126("@dre@0/2", 35036);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35019);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35019);
	}
	if(amountFire >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountFire)+"/5", 35044);
	} else {
	c.getPA().sendFrame126("@dre@0/5", 35044);
	}
	if(amountBlood >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountBlood)+"/1", 35042);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35042);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35021);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35021);
	}
	if(amountEarth >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountEarth)+"/10", 35067);
	} else {
	c.getPA().sendFrame126("@dre@0/10", 35067);
	}
	if(amountLaw >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountLaw)+"/2", 35048);
	} else {
	c.getPA().sendFrame126("@dre@0/2", 35048);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35023);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35023);
	}
	if(amountEarth >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountEarth)+"/15", 35030);
	} else {
	c.getPA().sendFrame126("@dre@0/15", 35030);
	}
	if(amountSoul >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountSoul)+"/1", 35052);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35052);
	}
	if(amountCosmic >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountCosmic)+"/1", 35025);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35025);
	}
	if(amountFire >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountFire)+"/20", 35069);
	} else {
	c.getPA().sendFrame126("@dre@0/20", 35069);
	}
	if(amountDeath >= 1) {
	c.getPA().sendFrame126("@gre@"+ethos.util.Misc.getValueWithoutRepresentation(amountDeath)+"/1", 35050);
	} else {
	c.getPA().sendFrame126("@dre@0/1", 35050);
	}
}

public static void EnchantButton(Player c , int Button) {
	switch(Button) {
	case 75007:
		OpenEnchantBoits(c);
		break;
	case 136152://Opal bolts
		if(c.playerLevel[c.playerMagic] >= 4) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(556, 2)) {
			if(c.getItems().playerHasItem(879)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(556, 2);
				c.getItems().deleteItem2(879, 10);
				c.getItems().addItem(9236, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(9, c.playerMagic, true);
			}else {
				c.sendMessage("You need Opal bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 4 to Enchant this.");
		}
		break;
	case 136170://Sapphire bolts
		if(c.playerLevel[c.playerMagic] >= 7) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(555, 1) && c.getItems().playerHasItem(558, 1)) {
			if(c.getItems().playerHasItem(9337)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(555, 1);
				c.getItems().deleteItem2(558, 1);
				c.getItems().deleteItem2(9337, 10);
				c.getItems().addItem(9240, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(17, c.playerMagic, true);
			}else {
				c.sendMessage("You need Sapphire bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 7 to Enchant this.");
		}
		break;
	case 136157://Jade bolts
		if(c.playerLevel[c.playerMagic] >= 14) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) &&c.getItems().playerHasItem(557, 2)) {
			if(c.getItems().playerHasItem(9335)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(557, 2);
				c.getItems().deleteItem2(9335, 10);
				c.getItems().addItem(9237, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(19, c.playerMagic, true);
			}else {
				c.sendMessage("You need Jade bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 14 to Enchant this.");
		}
		break;
	case 136162:// Pearl bolts
		if(c.playerLevel[c.playerMagic] >= 24) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) &&c.getItems().playerHasItem(555, 2)) {
			if(c.getItems().playerHasItem(880)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(555, 2);
				c.getItems().deleteItem2(880, 10);
				c.getItems().addItem(9238, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(29, c.playerMagic, true);
			}else {
				c.sendMessage("You need Pearl bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 24 to Enchant this.");
		}
		break;
	case 136174:// Emerald bolts
		if(c.playerLevel[c.playerMagic] >= 27) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(556, 3) && c.getItems().playerHasItem(561, 1)) {
			if(c.getItems().playerHasItem(9338)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(556, 3);
				c.getItems().deleteItem2(561, 1);
				c.getItems().deleteItem2(9338, 10);
				c.getItems().addItem(9241, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(37, c.playerMagic, true);
			}else {
				c.sendMessage("You need Emerald bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 27 to Enchant this.");
		}
		break;
	case 136166:// Red Topaz bolts
		if(c.playerLevel[c.playerMagic] >= 29) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(554, 2)) {
			if(c.getItems().playerHasItem(9336)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(554, 2);
				c.getItems().deleteItem2(9336, 10);
				c.getItems().addItem(9239, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(33, c.playerMagic, true);
			}else {
				c.sendMessage("You need Red Topaz bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 29 to Enchant this.");
		}
		break;
	case 136178:// Ruby bolts
		if(c.playerLevel[c.playerMagic] >= 49) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(554, 5) && c.getItems().playerHasItem(565, 1)) {
			if(c.getItems().playerHasItem(9339)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(554, 5);
				c.getItems().deleteItem2(565, 1);
				c.getItems().deleteItem2(9339, 10);
				c.getItems().addItem(9242, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(59, c.playerMagic, true);
			}else {
				c.sendMessage("You need Ruby bolts.");
			}
		} else {
			c.sendMessage("You dont have the runes for this spell,");
		}
		} else {
			c.sendMessage("You need a Magic Level of 49 to Enchant this.");
		}
		break;
	case 136182:// Diamond bolts
		if(c.playerLevel[c.playerMagic] >= 57) {
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(557, 10) && c.getItems().playerHasItem(563, 2)) {
			if(c.getItems().playerHasItem(9340)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(557, 10);
				c.getItems().deleteItem2(563, 2);
				c.getItems().deleteItem2(9340, 10);
				c.getItems().addItem(9243, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(67, c.playerMagic, true);
			}else {
				c.sendMessage("You need Diamond bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 57 to Enchant this.");
		}
		break;
	case 136186:// Dragonstone bolts
		if(c.playerLevel[c.playerMagic] >= 68) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(557, 15) && c.getItems().playerHasItem(566, 1)) {
			if(c.getItems().playerHasItem(9341)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(557, 15);
				c.getItems().deleteItem2(566, 1);
				c.getItems().deleteItem2(9341, 10);
				c.getItems().addItem(9244, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(78, c.playerMagic, true);
			}else {
				c.sendMessage("You need Dragonstone bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 68 to Enchant this.");
		}
		break;
	case 136190:// Onyx bolts
		if(c.playerLevel[c.playerMagic] >= 87) {
			if(!c.getItems().hasFreeSlots(1)) {
				c.sendMessage("You need 1 Inv space.");
				return;
			}
		if(c.getItems().playerHasItem(564, 1) && c.getItems().playerHasItem(554, 20) && c.getItems().playerHasItem(560, 1)) {
			if(c.getItems().playerHasItem(9342)) {
				c.getItems().deleteItem2(564, 1);
				c.getItems().deleteItem2(554, 20);
				c.getItems().deleteItem2(560, 1);
				c.getItems().deleteItem2(9342, 10);
				c.getItems().addItem(9245, 10);
				c.startAnimation(4462);
				c.getPA().closeAllWindows();
				UpdateItems(c);
				c.getPA().addSkillXP(97, c.playerMagic, true);
			}else {
				c.sendMessage("You need Onyx bolts.");
			}
		} else {
			c.sendMessage("You don't have the runes for this spell.");
		}
		} else {
			c.sendMessage("You need a Magic Level of 87 to Enchant this.");
		}
		break;
	}
}
}
