package godzhell.model.content.quests.impl;

import godzhell.model.players.Player;

public class KnightsSword {
	
	public static void showInformation(Player c) {
		for (int i = 35488; i < 35665; i++) {
			c.getPlayerAssistant().sendFrame126("", i);
			c.getPlayerAssistant().sendFrame126("", 35486);
		}
		c.getPlayerAssistant().sendFrame126("@dre@The Knight's Sword", 35486);
		if(c.knightS == 0) {
			c.getPlayerAssistant().sendFrame126("I can start this quest by speaking to the squire", 35488);
			c.getPlayerAssistant().sendFrame126("who is in the courtyard of the White Knight's castle", 35489);
			c.getPlayerAssistant().sendFrame126("", 35490);
			c.getPlayerAssistant().sendFrame126("I will need at least 10 mining to complete this quest", 35491);
		} else if(c.knightS == 1) {
			c.getPlayerAssistant().sendFrame126("The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("by speaking to Reldo, the librarian in the Varrock Castle", 35490);
		} else if (c.knightS == 2) {
			c.getPlayerAssistant().sendFrame126("<str>The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("<str>to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("Red Berry Pie to get him to be willing to talk to me", 35494);
		} else if(c.knightS == 3) {
			c.getPlayerAssistant().sendFrame126("<str>The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("<str>to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("Red berry pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("and find out if he'll make the sword for me.", 35496);
		} else if(c.knightS == 4) {
			c.getPlayerAssistant().sendFrame126("<str>The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("<str>to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("<str>I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("<str>Red berry pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("<str>and find out if he'll make the sword for me.", 35496);
			c.getPlayerAssistant().sendFrame126("", 35497);
			c.getPlayerAssistant().sendFrame126("Thurgo says he needs a picture of the sword.", 35498);
			c.getPlayerAssistant().sendFrame126("Maybe the squire will have one?", 35499);
			c.getPlayerAssistant().sendFrame126("", 35500);
		} else if(c.knightS == 5) {
			c.getPlayerAssistant().sendFrame126("<str>The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("<str>to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me.", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("<str>I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("<str>Red berry pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("<str>and find out if he'll make the sword for me.", 35496);
			c.getPlayerAssistant().sendFrame126("", 35497);
			c.getPlayerAssistant().sendFrame126("Thurgo says he needs a picture of the sword.", 35498);
			c.getPlayerAssistant().sendFrame126("<str>Maybe the squire will have one?", 35499);
			c.getPlayerAssistant().sendFrame126("", 35500);
			c.getPlayerAssistant().sendFrame126("The squire thinks Sir Vyvin keeps a picture of the sword in", 35501);
			c.getPlayerAssistant().sendFrame126("a cupboard in his room, but I must be very careful not to", 35502);
			c.getPlayerAssistant().sendFrame126("get caught.", 35503);
			c.getPlayerAssistant().sendFrame126("", 35504);
			c.getPlayerAssistant().sendFrame126("", 35505);
			c.getPlayerAssistant().sendFrame126("", 35506);
			c.getPlayerAssistant().sendFrame126("", 35507);
			c.getPlayerAssistant().sendFrame126("", 35508); 
		} else if(c.knightS == 6) {
			c.getPlayerAssistant().sendFrame126("<str>The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("<str>to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me.", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("<str>I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("<str>Red berry pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("<str>and find out if he'll make the sword for me.", 35496);
			c.getPlayerAssistant().sendFrame126("", 35497);
			c.getPlayerAssistant().sendFrame126("Thurgo says he needs a picture of the sword.", 35498);
			c.getPlayerAssistant().sendFrame126("<str>Maybe the squire will have one?", 35499);
			c.getPlayerAssistant().sendFrame126("", 35500);
			c.getPlayerAssistant().sendFrame126("<str>The squire thinks Sir Vyvin keeps a picture of the sword in", 35501);
			c.getPlayerAssistant().sendFrame126("<str>a cupboard in his room, but I must be very careful not to", 35502);
			c.getPlayerAssistant().sendFrame126("<str>get caught.", 35503);
			c.getPlayerAssistant().sendFrame126("I should bring the picture to Thurgo", 35504);
			c.getPlayerAssistant().sendFrame126("", 35505);
			c.getPlayerAssistant().sendFrame126("", 35506);
			c.getPlayerAssistant().sendFrame126("", 35507);
			c.getPlayerAssistant().sendFrame126("", 35508); 
		} else if(c.knightS == 7) {
			c.getPlayerAssistant().sendFrame126("The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("to find a replacement.<str> He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me.", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("<str>I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("<str>Red berry Pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("<str>and find out if he'll make the sword for me.", 35496);
			c.getPlayerAssistant().sendFrame126("", 35497);
			c.getPlayerAssistant().sendFrame126("<str>Thurgo says he needs a picture of the sword.", 35498);
			c.getPlayerAssistant().sendFrame126("<str>Maybe the squire will have one?", 35499);
			c.getPlayerAssistant().sendFrame126("", 35500);
			c.getPlayerAssistant().sendFrame126("<str>The squire thinks Sir Vyvin keeps a picture of the sword in", 35501);
			c.getPlayerAssistant().sendFrame126("<str>cupboard in his room, but I must be very careful not to", 35502);
			c.getPlayerAssistant().sendFrame126("<str>get caught.", 35503);
			c.getPlayerAssistant().sendFrame126("<str>I should bring the picture to Thurgo", 35504);
			c.getPlayerAssistant().sendFrame126("", 35505);
			c.getPlayerAssistant().sendFrame126("Thurgo has asked me to bring him 2 iron bars and 1 blurite", 35506);
			c.getPlayerAssistant().sendFrame126("ore for him to make the sword with. He says blurite can be", 35507);
			c.getPlayerAssistant().sendFrame126("mined in the cave by his home, but it is guarded by", 35508);
			c.getPlayerAssistant().sendFrame126("dangerous monsters. So I should be very careful.", 35509);
		} else if(c.knightS == 8) {
			c.getPlayerAssistant().sendFrame126("The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("to find a replacement.<str> He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me.", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("<str>I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("<str>Red berry pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("<str>and find out if he'll make the sword for me.", 35496);
			c.getPlayerAssistant().sendFrame126("", 35497);
			c.getPlayerAssistant().sendFrame126("<str>Thurgo says he needs a picture of the sword.", 35498);
			c.getPlayerAssistant().sendFrame126("<str>Maybe the squire will have one?", 35499);
			c.getPlayerAssistant().sendFrame126("", 35500);
			c.getPlayerAssistant().sendFrame126("<str>The squire thinks Sir Vyvin keeps a picture of the sword in", 35501);
			c.getPlayerAssistant().sendFrame126("<str>cupboard in his room, but I must be very careful not to", 35502);
			c.getPlayerAssistant().sendFrame126("<str>get caught.", 35503);
			c.getPlayerAssistant().sendFrame126("<str>I should bring the picture to Thurgo", 35504);
			c.getPlayerAssistant().sendFrame126("", 35505);
			c.getPlayerAssistant().sendFrame126("<str>Thurgo has asked me to bring him 2 iron bars and 1 blurite", 35506);
			c.getPlayerAssistant().sendFrame126("<str>ore for him to make the sword with. He says blurite can be", 35507);
			c.getPlayerAssistant().sendFrame126("<str>mined in the cave by his home, but it is guarded by", 35508);
			c.getPlayerAssistant().sendFrame126("<str>dangerous monsters. So I should be very careful.", 35509);
			c.getPlayerAssistant().sendFrame126("", 8171);
			c.getPlayerAssistant().sendFrame126("Thurgo made me the sword, I should bring it back to the", 35510);
			c.getPlayerAssistant().sendFrame126("knight to get my reward!", 35511);
			c.getPlayerAssistant().sendFrame126("", 35512);
		} else if(c.knightS == 9) {
			c.getPlayerAssistant().sendFrame126("<str>The squire has lost Sir Vyvin's sword and asked me", 35488);
			c.getPlayerAssistant().sendFrame126("<str>to find a replacement. He suggested that I start", 35489);
			c.getPlayerAssistant().sendFrame126("<str>by speaking to Reldo, the librarian in the Varrock Castle", 35490);
			c.getPlayerAssistant().sendFrame126("", 35491);
			c.getPlayerAssistant().sendFrame126("<str>Reldo told me there may be an Imcando dwarf living near the", 35492);
			c.getPlayerAssistant().sendFrame126("<str>Asgarnian peninsula. He said I should bring him some", 35493);
			c.getPlayerAssistant().sendFrame126("<str>Red Berry Pie to get him to be willing to talk to me.", 35494);
			c.getPlayerAssistant().sendFrame126("", 35495);
			c.getPlayerAssistant().sendFrame126("<str>I found the Imcando dwarf named Thurgo and gave him some", 35495);
			c.getPlayerAssistant().sendFrame126("<str>Red berry pie. Now that he likes me I should talk to him", 35495);
			c.getPlayerAssistant().sendFrame126("<str>and find out if he'll make the sword for me.", 35496);
			c.getPlayerAssistant().sendFrame126("", 35497);
			c.getPlayerAssistant().sendFrame126("<str>Thurgo says he needs a picture of the sword.", 35498);
			c.getPlayerAssistant().sendFrame126("<str>Maybe the squire will have one?", 35499);
			c.getPlayerAssistant().sendFrame126("", 35500);
			c.getPlayerAssistant().sendFrame126("<str>The squire thinks Sir Vyvin keeps a picture of the sword in", 35501);
			c.getPlayerAssistant().sendFrame126("<str>a cupboard in his room, but I must be very careful not to", 35502);
			c.getPlayerAssistant().sendFrame126("<str>get caught.", 35503);
			c.getPlayerAssistant().sendFrame126("<str>I should bring the picture to Thurgo", 35504);
			c.getPlayerAssistant().sendFrame126("", 35505);
			c.getPlayerAssistant().sendFrame126("<str>Thurgo has asked me to bring him 2 iron bars and 1 blurite", 35506);
			c.getPlayerAssistant().sendFrame126("<str>ore for him to make the sword with. He says blurite can be", 35507);
			c.getPlayerAssistant().sendFrame126("<str>mined in the cave by his home, but it is guarded by", 35508);
			c.getPlayerAssistant().sendFrame126("<str>dangerous monsters. So I should be very careful.", 35509);
			c.getPlayerAssistant().sendFrame126("<str>Thurgo made me the sword, I should bring it back to the", 35510);
			c.getPlayerAssistant().sendFrame126("<str>knight to get my reward!", 35511);
			c.getPlayerAssistant().sendFrame126("", 35511);
			c.getPlayerAssistant().sendFrame126("@red@Quest Complete!", 35512);
		} 
		c.getPlayerAssistant().showInterface(35483);
	}

}
