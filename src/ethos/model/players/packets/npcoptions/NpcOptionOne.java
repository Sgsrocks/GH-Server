package ethos.model.players.packets.npcoptions;

import java.util.Objects;

import ethos.Config;
import ethos.Server;
import ethos.definitions.NPCCacheDefinition;
import ethos.model.content.achievement_diary.desert.DesertDiaryEntry;
import ethos.model.content.achievement_diary.fremennik.FremennikDiaryEntry;
import ethos.model.content.achievement_diary.kandarin.KandarinDiaryEntry;
import ethos.model.content.achievement_diary.varrock.VarrockDiaryEntry;
import ethos.model.content.dialogue.impl.BankerDialogue;
import ethos.model.content.dialogue.impl.ManandWomanDialogue;
import ethos.model.content.dialogue.impl.TraderCrewMemberFemale;
import ethos.model.content.dialogue.impl.TraderCrewMemberMale;
import ethos.model.content.dialogue.impl.Falador.CassieDialogue;
import ethos.model.content.dialogue.impl.Falador.DoricDialogue;
import ethos.model.content.dialogue.impl.Falador.FaladorShopKeeperDialogue;
import ethos.model.content.dialogue.impl.Falador.HerquinDialogue;
import ethos.model.content.dialogue.impl.Falador.SquireDialogue;
import ethos.model.content.dialogue.impl.Falador.ThurgoDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.BobDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.CooksDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.DoomsayerDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.HansDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.Lumbridge_guide_Dialogue;
import ethos.model.content.dialogue.impl.Lumbridge.LumbyShopKeeperDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.Melee_combat_tutorDialogue;
import ethos.model.content.dialogue.impl.Lumbridge.ShearedRamDialogue;
import ethos.model.content.dialogue.impl.Varrock.ReldoDIalogue;
import ethos.model.content.dialogue.impl.slayer.DuradelDialogue;
import ethos.model.holiday.halloween.HalloweenRandomOrder;
import ethos.model.npcs.NPC;
import ethos.model.npcs.NPCHandler;
import ethos.model.npcs.pets.PetHandler;
import ethos.model.npcs.pets.Probita;
import ethos.model.players.Player;
import ethos.model.players.Right;
import ethos.model.players.skills.Fishing;
import ethos.model.players.skills.agility.AgilityHandler;
import ethos.model.players.skills.crafting.Tanning;
import ethos.model.players.skills.hunter.impling.Impling;
import ethos.model.players.skills.mining.Mineral;
import ethos.model.players.skills.thieving.Thieving.Pickpocket;
import ethos.util.Location3D;
import ethos.model.players.Boundary;
/*
 * @author Matt
 * Handles all first options on non playable characters.
 */

public class NpcOptionOne {

	public static void handleOption(Player player, int npcType) {
		if (Server.getMultiplayerSessionListener().inAnySession(player)) {
			return;
		}
		player.clickNpcType = 0;
		player.rememberNpcIndex = player.npcClickIndex;
		player.npcClickIndex = 0;

		/*
		 * if(Fishing.fishingNPC(c, npcType)) { Fishing.fishingNPC(c, 1, npcType);
		 * return; }
		 */
		if (PetHandler.isPet(npcType)) {
			if (Objects.equals(PetHandler.getOptionForNpcId(npcType), "first")) {
				if (PetHandler.pickupPet(player, npcType, true))
					return;
			}
		}
		if (Server.getHolidayController().clickNpc(player, 1, npcType)) {
			return;
		}
		if(player.getRights().contains(Right.OWNER)) {
			player.sendMessage("Npc click 1: "+npcType);
		}
		switch (npcType) {
			case 2897:
			case 2898:
				player.start(new BankerDialogue());
				break;
		case 9336:
			player.start(new TraderCrewMemberMale());
			break;
		case 9360:
			player.start(new TraderCrewMemberFemale());
			break;
		case 1603:
			player.getDH().sendDialogues(150, npcType);
			break;
		case 7690:
			player.getDH().sendDialogues(1500, -1);
			break;
			case 1306:
				if (player.getItems().isWearingItems()) {
					player.sendMessage("You must remove your equipment before changing your appearance.");
					player.canChangeAppearance = false;
				} else {
					player.getPA().showInterface(3559);
					player.canChangeAppearance = true;
				}
				break;
			case 7546:
				player.start(new ShearedRamDialogue());
				break;
			case 3107:
			case 3111:
			case 3106:
			case 6818:
			case 3108:
				player.start(new ManandWomanDialogue());
				break;
			case 4737:
				player.start(new SquireDialogue());
				break;
			case 4733:
				player.start(new ThurgoDialogue());
				break;
			case 4243:
				player.start(new ReldoDIalogue());
				break;
			case 6529:
				player.start(new HerquinDialogue());
				break;
			case 3214:
				player.start(new CassieDialogue());
				 break;
			case 2820:
			case 2819:
				player.start(new FaladorShopKeeperDialogue());
				break;
			case 2813:
			case 2814:
				player.start(new LumbyShopKeeperDialogue());
				break;
			case 6773:
				player.start(new DoomsayerDialogue());
				break;
			case 3216:
				player.start(new Melee_combat_tutorDialogue());
				break;
			case 2812:
				player.start(new BobDialogue());
				break;
			case 3893:
player.start(new DoricDialogue());
				break;
			case 4626:
				player.start(new CooksDialogue());
				break;
			case 9157:
				player.getPA().spellTeleport(Config.START_LOCATION_X, Config.START_LOCATION_Y, 0, true);
				break;
		case 8480:
			player.getPA().showInterface(51000);
			player.getTeleport().selection(player, 0);
			// player.getTeleport().loadMonsterTab();
			break;
			
		case 822:
			boolean hascompleted = player.getDiaryManager().getWildernessDiary().hasDoneEasy();
			
			if (hascompleted) {
				//send a statment asking if you want to proceed
				player.getDH().sendDialogues(702, npcType);			
			} else {
				player.sendMessage("You need to complete the easy wilderness diary for Oziach to assist you.");
			}
			
			break;
		case 306:
			player.start(new Lumbridge_guide_Dialogue());
			break;
		case 3105:
			player.start(new HansDialogue());
			break;
		case 7303:
			player.sendMessage("I will trade a full set of clue scrolls with a master one.");
			break;
			
		case 3936:
			AgilityHandler.delayFade(player, "NONE", 2310, 3782, 0, "You board the boat...", "And end up in Neitiznot", 3);
			player.getDiaryManager().getFremennikDiary().progress(FremennikDiaryEntry.TRAVEL_NEITIZNOT);
			break;

		case 2914:
			player.getDH().sendNpcChat2("Use a Zamorakian Spear on me to turn", "it into a Hasta! Or Vice Versa.", 2914,
					"Otto Godblessed");
			break;

		case 1635:
		case 1636:
		case 1637:
		case 1638:
		case 1639:
		case 1640:
		case 1641:
		case 1642:
		case 1643:
		case 1654:
		case 7302:
			Impling.catchImpling(player, npcType, player.rememberNpcIndex);
			break;

		case 17: // Rug merchant - Pollnivneach
			player.getDiaryManager().getDesertDiary().progress(DesertDiaryEntry.TRAVEL);
			player.startAnimation(2262);
			AgilityHandler.delayFade(player, "NONE", 3351, 3003, 0, "You step on the carpet and take off...",
					"at last you end up in pollnivneach.", 3);
			break;
		case 276:
			if (Config.BONUS_XP_WOGW) {
				player.getDH().sendNpcChat1(
						"Well of Goodwill is currently @red@active@bla@! \\n It is granting 1 hour of @red@Double XP@bla@!",
						276, "Anguish Crier");
			} else if (Config.BONUS_MINIGAME_WOGW) {
				player.getDH().sendNpcChat1(
						"Well of Goodwill is currently @red@active@bla@! \\n It is granting 1 hour of @red@Double Pc Points@bla@!",
						276, "Anguish Crier");
			} else if (Config.DOUBLE_DROPS) {
				player.getDH().sendNpcChat1(
						"Well of Goodwill is currently @red@active@bla@! \\n It is granting 1 hour of @red@Double Drops@bla@!",
						276, "Anguish Crier");
			} else {
				player.getDH().sendNpcChat1("Well of Goodwill is currently @red@inactive@bla@!", 276, "Anguish Crier");
			}
			break;
		case 5520:
			player.getDiaryManager().getDesertDiary().claimReward();
			break;
		case 5519:
			player.getDiaryManager().getArdougneDiary().claimReward();
			break;
		case 5790:
			player.getDiaryManager().getKaramjaDiary().claimReward();
			break;
		case 5525:
			player.getDiaryManager().getVarrockDiary().claimReward();
			break;
		case 5523:
			player.getDiaryManager().getLumbridgeDraynorDiary().claimReward();
			break;
		case 5524:
			player.getDiaryManager().getFaladorDiary().claimReward();
			break;
		case 5521:
			player.getDiaryManager().getMorytaniaDiary().claimReward();
			break;
		case 5514:
			player.getDiaryManager().getWildernessDiary().claimReward();
			break;
		case 5517:
			player.getDiaryManager().getKandarinDiary().claimReward();
			break;
		case 5526:
			player.getDiaryManager().getFremennikDiary().claimReward();
			break;
		case 5518:
			player.getDiaryManager().getWesternDiary().claimReward();
			break;

		case 1031:
			if (player.getItems().playerHasItem(995, 30)) {
				player.getItems().deleteItem(995, 30);
				player.getItems().addItem(36, 1);
				player.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.BUY_CANDLE);
			} else {
				player.sendMessage("You need 30 coins to purchase a candle.");
				return;
			}
			break;

		case 6586:
			player.getDH().sendNpcChat1("No shirt, Sherlock", 6586, "Sherlock");
			player.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.SHERLOCK);
			break;

		case 5036:
			if (player.getItems().playerHasItem(225) || player.getItems().playerHasItem(223)) {
				player.sendMessage("The Apothecary takes your ingredients and creates a strength potion.");
				player.getItems().deleteItem(225, 1);
				player.getItems().deleteItem(223, 1);
				player.getItems().addItem(115, 1);
				player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.APOTHECARY_STRENGTH);
			} else {
				player.sendMessage("You must have limpwurt root and red spiders' eggs to do this.");
				return;
			}
			break;

		case 5906:
			Probita.hasInvalidPet(player);
			break;

		case 3500:
			player.getDH().sendDialogues(64, npcType);
			break;

		case 5870:
			if (player.getCerberusLostItems().size() > 0) {
				player.getDH().sendDialogues(640, 5870);
				return;
			}
			player.getDH().sendDialogues(105, npcType);
			break;

		case 7283:
			if (player.getSkotizoLostItems().size() > 0) {
				player.getDH().sendDialogues(640, 7283);
				return;
			}
			player.getDH().sendDialogues(105, npcType);
			break;


		case 6601:
			NPC golem = NPCHandler.npcs[player.rememberNpcIndex];
			if (golem != null) {
				player.getMining().mine(golem, Mineral.RUNE,
						new Location3D(golem.getX(), golem.getY(), golem.heightLevel));
			}
			break;
			case 6875:
				player.specRestore = 120;
				player.specAmount = 10.0;
				player.setRunEnergy(100);
				player.getItems().addSpecialBar(player.playerEquipment[player.playerWeapon]);
				player.playerLevel[5] = player.getPA().getLevelForXP(player.playerXP[5]);
				player.getHealth().removeAllStatuses();
				player.getHealth().reset();
				player.getPA().refreshSkill(5);
				player.getDH().sendItemStatement("Restored your HP, Prayer, Run Energy, and Spec", 4049);
				player.nextChat =  -1;
				break;
		case 2949:
			player.getPestControlRewards().showInterface();
			break;
		case 2461:
			player.getWarriorsGuild().handleDoor();
			break;
		case 7663:
			player.getDH().sendDialogues(3299, npcType);
			break;
		case 402:// slayer
			if(player.combatLevel<20){
				player.getDH().sendNpcChat2("Do not waste my time peasent.","You need a Combat level of 20.",402,"Mazchna");
				return;
			}
			player.getDH().sendDialogues(3300, npcType);
			break;
		case 401:
			player.getDH().sendDialogues(3300, npcType);
			break;
		case 405:
			player.start(new DuradelDialogue());
			break;
		case 6797: // Nieve
			if (player.playerLevel[18] < 90) {
				player.getDH().sendNpcChat1("You must have a slayer level of at least 90 weakling.", 6797, "Nieve");
				return;
			} else {
				player.getDH().sendDialogues(3300, npcType);
			}
			break;
		case 315:
			player.getDH().sendDialogues(550, npcType);
			break;
		case 4306:
			player.getShops().openSkillCape();
			break;
		// FISHING
		case 3913: // NET + BAIT
			Fishing.attemptdata(player, 1);
			break;
		case 3317:
			Fishing.attemptdata(player, 14);
			break;
		case 4712:
			Fishing.attemptdata(player, 15);
			break;
		case 1524:
			Fishing.attemptdata(player, 11);
			break;
		case 3417: // TROUT
			Fishing.attemptdata(player, 4);
			break;
		case 3657:
			Fishing.attemptdata(player, 8);
			break;
		case 635:
			Fishing.attemptdata(player, 13); // DARK CRAB FISHING
			break;
		case 6825: // Anglerfish
			Fishing.attemptdata(player, 16);
			break;
		case 1520: // LURE
		case 310:
		case 314:
		case 317:
		case 318:
		case 328:
		case 331:
			Fishing.attemptdata(player, 9);
			break;

		case 5809:
			Tanning.sendTanningInterface(player);
			break;

		case 1599:
			break;

		case 953: // Banker
		case 2574: // Banker
		case 166: // Gnome Banker
		case 1702: // Ghost Banker
		case 494: // Banker
		case 495: // Banker
		case 496: // Banker
		case 497: // Banker
		case 498: // Banker
		case 499: // Banker
		case 567: // Banker
		case 766: // Banker
		case 1036: // Banker
		case 1360: // Banker
		case 2163: // Banker
		case 2164: // Banker
		case 2354: // Banker
		case 2355: // Banker
		case 2568: // Banker
		case 2569: // Banker
		case 2570: // Banker
			player.getPA().openUpBank();
			break;

		/*
		 * case 198: c.getShops().openSkillCape(); break;
		 */

		/**
		 * Make over mage.
		 */

		}
	}

}
