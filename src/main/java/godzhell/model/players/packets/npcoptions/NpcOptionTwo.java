package godzhell.model.players.packets.npcoptions;

import java.util.concurrent.TimeUnit;

import godzhell.Config;
import godzhell.Server;
import godzhell.model.content.Sawmill;
import godzhell.model.content.achievement_diary.fremennik.FremennikDiaryEntry;
import godzhell.model.content.achievement_diary.karamja.KaramjaDiaryEntry;
import godzhell.model.content.achievement_diary.lumbridge_draynor.LumbridgeDraynorDiaryEntry;
import godzhell.model.content.achievement_diary.varrock.VarrockDiaryEntry;
import godzhell.model.npcs.pets.PetHandler;
import godzhell.model.npcs.pets.Probita;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerAssistant;
import godzhell.model.players.PlayerAssistant.PointExchange;
import godzhell.model.content.skills.Fishing;
import godzhell.model.content.skills.agility.AgilityHandler;
import godzhell.model.content.skills.thieving.Pickpocket;

/*
 * @author Matt
 * Handles all 2nd options on non playable characters.
 */

public class NpcOptionTwo {

	public static void handleOption(Player player, int npcType) {
		if (Server.getMultiplayerSessionListener().inAnySession(player)) {
			return;
		}
		player.clickNpcType = 0;
		player.rememberNpcIndex = player.npcClickIndex;
		player.npcClickIndex = 0;

		/*
		 * if(Fishing.fishingNPC(c, npcType)) { Fishing.fishingNPC(c, 2, npcType);
		 * return; }
		 */
		// if (PetHandler.talktoPet(player, npcType))
		// return;
		if (Pickpocket.isNPC(player, npcType)) {
			if(Pickpocket.getOptionForNpcId(player, npcType) == "second") {
				Pickpocket.attemptPickpocket(player, npcType);
				return;
			}
		}
		if (PetHandler.isPet(npcType)) {
			if (PetHandler.getOptionForNpcId(npcType) == "second") {
				if (PetHandler.pickupPet(player, npcType, true))
					return;
			}
		}
		if (Server.getHolidayController().clickNpc(player, 2, npcType)) {
			return;
		}
		switch (npcType) {
		case 1306:
			if (player.getItems().isWearingItems()) {
				player.sendMessage("You must remove your equipment before changing your appearance.");
				player.canChangeAppearance = false;
			} else {
				player.getPA().showInterface(3559);
				player.canChangeAppearance = true;
			}
			break;
			case 3101:
				Sawmill.OpemSawMill(player);
				break;
			case 3935:
				player.getShops().openShop(Config.SKULGRIMENS_BATTLE_GEAR);
				break;
			case 3947:
				player.getShops().openShop(Config.FREMENNIK_FISH_MONGER);
				break;
			case 2874:
				player.getShops().openShop(Config.GEM_TRADER);
				break;
			case 4638:
				player.getShops().openShop(Config.BEDABIN_VILLAGE_BARTERING);
				break;
			case 3894:
				player.getShops().openShop(Config.SIGMUND_THE_MERCHANT);
				break;
			case 3948:
				player.getShops().openShop(Config.FREMENNIK_FUR_TRADER);
				break;
			case 3933:
				player.getShops().openShop(Config.YRSAS_ACCOUTREMENTS);
				break;
			case 679:
				player.getShops().openShop(Config.RASOLO_THE_WANDERING_MERCHANT);
				break;
			case 3688:
				player.getShops().openShop(Config.ISLAND_FISHMONGER);
				break;
			case 3689:
				player.getShops().openShop(Config.GREENGROCER_OF_MISCELLANIA);
				break;
			case 1079:
				player.getShops().openShop(Config.MISCELLANIAN_CLOTHES_SHOP);
				break;
			case 1081:
				player.getShops().openShop(Config.MISCELLANIAN_FOOD_SHOP);
				break;
			case 1080:
				player.getShops().openShop(Config.MISCELLANIAN_GENERAL_STORE);
				break;
			case 2784:
				player.getShops().openShop(Config.CROSSBOW_SHOP2);
				break;
			case 7688:
				player.getShops().openShop(Config.TZHAAR_HUR_ZALS_EQUIPMENT_STORE);
				break;
			case 1884:
				player.getShops().openShop(Config.NEITIZNOT_SUPPLIES);
				break;
			case 8722:
				player.getShops().openShop(Config.ARDOUGNE_SILVER_STALL);
				break;
			case 8681:
				player.getShops().openShop(Config.ZENESHAS_PLATE_MAIL_BODY_SHOP);
				break;
			case 8682:
			case 8683:
				player.getShops().openShop(Config.AEMADS_ADVENTURING_SUPPLIES);
				break;
			case 8724:
			case 8725:
				player.getShops().openShop(Config.ARDOUGNE_BAKERS_STALL);
				break;
			case 8723:
				player.getShops().openShop(Config.ARDOUGNE_GEM_STALL);
				break;
			case 2888:
				player.getShops().openShop(Config.KHAZARD_GENERAL_STORE);
				break;
			case 8727:
				player.getShops().openShop(Config.ARDOUGNE_FUR_STALL);
				break;
			case 14:
				player.getShops().openShop(Config.ROMETTIS_FINE_FASHIONS);
				break;
			case 16:
				player.getShops().openShop(Config.FUNCHS_FINE_GROCERIES);
				break;
            case 4642:
            	player.getShops().openShop(Config.SHANTAY_PASS_SHOP);
            	break;
			case 12:
				player.getShops().openShop(Config.GRAND_TREE_GROCERIES);
				break;
			case 6532:
				player.getShops().openShop(Config.BLURBERRY_BAR);
				break;
			case 0:
				player.getToolLeprechaun().loadInterfaces();
				break;
			case 5721:
				player.getShops().openShop(Config.CASTLE_WARS_TICKET_EXCHANGE);
				break;
			case 8726:
				player.getShops().openShop(Config.ARDOUGNE_SPICE_STALL);
				break;
			case 503:
				player.getShops().openShop(Config.RICHARDS_FARMING_SHOP);
				break;
			case 6059:
				player.getShops().openShop(Config.AARONS_ARCHERY_APPENDAGES);
				break;
			case 6060:
				player.getShops().openShop(Config.DARGAUDS_BOWS_AND_ARROWS);
				break;
			case 6069:
				player.getShops().openShop(Config.AUTHENTIC_THROWING_WEAPONS);
				break;
			case 7798:
				player.getShops().openShop(Config.GAIUS_TWO_HANDED_SHOP);
				break;
			case 3247:
				player.getShops().openShop(Config.MAGIC_GUILD_STORE_RUNES_AND_STAVES);
				break;
			case 3249:
				player.getShops().openShop(Config.MAGIC_GUILD_STORE_MYSTIC_ROBES);
				break;
			case 1502:
				player.getShops().openShop(Config.LEON_PROTOTYPE_CROSSBOWS);
				break;
			case 8685:
				player.getShops().openShop(Config.FRENITAS_COOKERY_SHOP);
				break;
		case 6562:
			player.getShops().openShop(Config.PROSPECTOR_PERCYS_NUGGET_SHOP);
			break;
		case 2880:
			player.getShops().openShop(Config.ZAFFS_SUPERIOR_STAFFS);
			break;
			case 3200:
				player.getShops().openShop(Config.ARHEINS_STORE);
				break;
			case 3199:
				player.getShops().openShop(Config.CANDLE_SHOP);
				break;
			case 3212:
				player.getShops().openShop(Config.HICKTONS_ARCHERY_EMPORIUM);
				break;
			case 3213:
				player.getShops().openShop(Config.HARRYS_FISHING_SHOP);
				break;
			case 502:
				player.getShops().openShop(Config.VANESSAS_FARMING_SHOP);
				break;
		case 2884:
		case 2885:
			player.getShops().openShop(Config.VARROCK_SWORDSHOP);
			break;
		case 2882:
			player.getShops().openShop(Config.HORVIKS_ARMOUR_SHOP);
			break;
		case 2883:
			player.getShops().openShop(Config.LOWES_ARCHERY_EMPORIUM);
			break;
		case 2886:
			player.getShops().openShop(Config.AUBURYS_RUNE_SHOP);
			break;
		case 2872:
			player.getShops().openShop(Config.HELMET_SHOP);
			break;
		case 2822:
		case 2821:
			player.getShops().openShop(Config.EDGEVILLE_GENERAL_STORE);
			break;
		case 4280:
			player.getShops().openShop(Config.NED_ROPES);
			break;
		case 8693:
			player.getShops().openShop(Config.DIANGOS_TOY_STORE);
			break;
		case 1260:
			player.getShops().openShop(Config.FORTUNATOS_FINE_WINE);
			break;
		case 2121:
			player.getShops().openShop(Config.DRAYNOR_SEED_MARKET);
			break;
		case 2892:
			player.getShops().openShop(Config.BRIANS_BATTLEAXE_BAZAAR);
			break;
		case 2890:
			player.getShops().openShop(Config.WYDINS_FOOD_STORE);
			break;
		case 3205:
			player.getShops().openShop(Config.KARAMJA_WINES_SPIRITS_AND_BEERS);
			break;
		case 2825:
		case 2826:
			player.getShops().openShop(Config.KARAMJA_GENERAL_STORE);
			break;
		case 2875:
			player.getShops().openShop(Config.ZEKES_SUPERIOR_SCIMITARS);
			break;
		case 2817:
		case 2818:
			player.getShops().openShop(Config.AL_KHARID_GENERAL_STORE);
			break;
		case 2879:
			player.getShops().openShop(Config.DOMMIKS_CRAFTING_STORE);
			break;
		case 2876:
			player.getShops().openShop(Config.LOUIES_ARMOURED_LEGS_BAZAAR);
			break;
		case 2878:
			player.getShops().openShop(Config.RANAELS_SUPER_SKIRT_STORE);
			break;
		case 1400:
			player.getShops().openShop(Config.MULTICANNON_PARTS_FOR_SALE);
			break;
		case 8686:
			player.getShops().openShop(Config.NURMOFS_PICKAXE_SHOP);
			break;
		case 7717:
			player.getShops().openShop(Config.HENDORS_AWESOME_ORES);
			break;
		case 7718:
			player.getShops().openShop(Config.YARSULS_PRODIGIOUS_PICKAXES);
			break;
		case 5895:
			player.getShops().openShop(Config.DROGOS_MINING_EMPORIUM);
			break;
		case 2785:
			player.getShops().openShop(Config.CROSSBOW_SHOP);
			break;
		case 5904:
			player.getShops().openShop(Config.DWARVERN_SHOPPING_STORE);
			break;
		case 2891:
			player.getShops().openShop(Config.GERRANTS_FISHY_BUSINESS);
			break;
		case 2815:
		case 2816:
			player.getShops().openShop(Config.VARROCK_GENERAL_STORE);
			break;
		case 2813:
		case 2814:
			player.getShops().openShop(Config.LUMBRIDGE_GENERAL_STORE);
			break;
		case 2812:
			player.getShops().openShop(Config.BOBS_BRILLIANT_AXES);
			break;
		case 3214:
			player.getShops().openShop(Config.CASSIES_SHIELD_SHOP);
			break;
		case 8694:
			player.getShops().openShop(Config.BRIANS_ARCHERY_SUPPLIES);
			break;
		case 5905:
			player.getShops().openShop(Config.BETTYS_MAGIC_EMPORIUM);
			break;
		case 6530:
			player.getShops().openShop(Config.ROMIKS_CRAFTY_SUPPLIES);
			break;
		case 2823:
		case 2824:
			player.getShops().openShop(Config.RIMMINGTON_GENERAL_STORE);
			break;
		case 5896:
			player.getShops().openShop(Config.FLYNNS_MACE_MARKET);
			break;
		case 5897:
			player.getShops().openShop(Config.WAYNES_CHAINS);
			break;
		case 6529:
			player.getShops().openShop(Config.HERQUINS_GEMS);
			break;
		case 2819:
		case 2820:
			player.getShops().openShop(Config.FALADOR_GENERAL_STORE);
			break;
		case 7690:
			player.getInfernoMinigame().gamble();
			break;
		case 1909:
			player.getDH().sendDialogues(901, 1909);
			break;
			case 3940:
				player.getPA().showInterface(51000);
				player.getTeleport().selection(player, 0);
				break;


		case 3307:
			player.getPA().showInterface(37700);
			player.sendMessage("Set different colors for specific items for easier looting!");
			break;
			
		case 17: //Rug merchant - Nardah
			if (!player.getDiaryManager().getDesertDiary().hasCompleted("EASY")) {
				player.getDH().sendNpcChat1("You must have completed all easy diaries here in the desert \\n to use this location.", 17, "Rug Merchant");
				return;
			}
			player.startAnimation(2262);
			AgilityHandler.delayFade(player, "NONE", 3402, 2916, 0, "You step on the carpet and take off...", "at last you end up in nardah.", 3);
			break;

		case 4321:
			int totalBlood = player.getItems().getItemAmount(13307);
			if (totalBlood >= 1) {
				player.getPA().exchangeItems(PointExchange.BLOOD_POINTS, 13307, totalBlood);
			}
			break;

		case 822:
			player.getShops().openShop(Config.OZIACHS_ARMOUR);
			break;

		case 7520:
			player.getDH().sendDialogues(855, 7520);
			break;

		case 8532:
			player.getShops().openShop(Config.JATIXS_HERBLORE_SHOP);
			break;
		case 8480:
			if (player.lastTeleportX == 0) {
				player.sendMessage("You haven't teleported anywhere recently.");
			} else {
				player.getPA().startTeleport(player.lastTeleportX, player.lastTeleportY, player.lastTeleportZ, "modern", false);
			}
			break;
		case 3254:
			player.getPA().showInterface(65000);
			player.getTeleport().loadMonsterTab();
			/*
			 * player.getPA().showInterface(62100); int startId = 62107; for (final
			 * teleports t : teleports.values()) { for(int i = 0; i <
			 * t.getTeleports().length; i++) { TeleportOption tele = t.getTeleports()[i];
			 * player.getPA().sendFrame126("<shad=-1>"+tele.getName(), startId); startId++;
			 * } } for(int i = startId; i < 62197; i++) { player.getPA().sendFrame126("",
			 * i); break;}
			 */
		case 6773:
			if (!player.pkDistrict) {
				player.sendMessage("You cannot do this right now.");
				return;
			}
			if (player.inClanWarsSafe()) {
				player.getSafeBox().openSafeBox();
			}
			break;


		case 2040:
			if (player.getZulrahLostItems().size() > 0) {
				player.getDH().sendDialogues(642, 2040);
				player.nextChat = -1;
			} else {
				if (player.getZulrahEvent().isActive()) {
					player.getDH().sendStatement("It seems that a zulrah instance for you is already created.",
							"If you think this is wrong then please re-log.");
					player.nextChat = -1;
					return;
				}
				player.getZulrahEvent().initialize();
			}
			break;


		case 3077:
			long milliseconds = (long) player.playTime * 600;
			long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
			long hours = TimeUnit.MILLISECONDS.toHours(milliseconds - TimeUnit.DAYS.toMillis(days));
			String time = days + " days and " + hours + " hours.";
			player.getDH().sendNpcChat1("You've been playing Anguish for " + time, 3077, "Hans");
			player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.HANS);
			break;

		case 3680:
			AgilityHandler.delayFade(player, "NONE", 2674, 3274, 0, "The sailor brings you onto the ship.",
					"and you end up in ardougne.", 3);
			player.getDiaryManager().getKaramjaDiary().progress(KaramjaDiaryEntry.SAIL_TO_ARDOUGNE);
			break;

		case 5034:
			player.getPA().startTeleport(2929, 4813, 0, "modern", false);
			player.getDiaryManager().getLumbridgeDraynorDiary()
					.progress(LumbridgeDraynorDiaryEntry.TELEPORT_ESSENCE_LUM);
			break;

		case 5906:
			Probita.cancellationOfPreviousPet(player);
			break;

		case 2180:
			player.getDH().sendDialogues(70, 2180);
			break;
		case 405:
			if(player.combatLevel<100){
				player.getDH().sendNpcChat1("You need to a combat level of 100 to recieve tasks from me.",405,"Duradel");
				return;
			}
			if (player.playerLevel[18] < 50) {
				player.getDH().sendNpcChat1("You must have a slayer level of at least 50 to recieve my tasks.", 405, "Duradel");
				return;
			}
			player.getDH().sendDialogues(3300, npcType);
			break;
		case 401:
		case 402:
		case 7663:
			player.getDH().sendDialogues(3304, npcType);
			break;
		case 6797: // Nieve
			if (player.playerLevel[18] < 90) {
				player.getDH().sendNpcChat1("You must have a slayer level of atleast 90 weakling.", 6797, "Nieve");
				return;
			} else {
				player.getDH().sendDialogues(3304, player.npcType);
			}
			break;
		case 311:
			player.getDH().sendDialogues(661, 311);
			break;
		case 2184:
			player.getShops().openShop(Config.TZHAAR_HUR_LEKS_ORE_AND_GEM_STORE);
			break;
		case 2185:
			player.getShops().openShop(Config.TZHAAR_MEJ_ROHS_RUNE_STORE);
			break;
		case 2183:
			player.getShops().openShop(Config.TZHAAR_HUR_TELS_EQUIPMENT_STORE);
			break;
		case 8680:
			player.getShops().openShop(Config.DAVONS_AMULET_STORE);
			break;
		case 2893:
			player.getShops().openShop(Config.JIMINUAS_JUNGLE_STORE);
			break;
		case 5362:
			player.getShops().openShop(Config.OBLIS_GENERAL_STORE);
			break;
		case 2580:
			player.getPA().startTeleport(3039, 4835, 0, "modern", false);
			player.dialogueAction = -1;
			player.teleAction = -1;
			break;
		case 3936:
			AgilityHandler.delayFade(player, "NONE", 2421, 3781, 0, "You board the boat...", "And end up in Jatizso",
					3);
			player.getDiaryManager().getFremennikDiary().progress(FremennikDiaryEntry.TRAVEL_JATIZSO);
			break;
		case 3078:

		case 534:
			if (Boundary.isIn(player, Boundary.VARROCK_BOUNDARY)) {
				player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.DRESS_FOR_SUCESS);
			}
			player.getShops().openShop(Config.THESSALIAS_FINE_CLOTHES);
			break;
	
		case 4625:
			player.getShops().openShop(Config.DONATOR_SHOP);
			break;

		case 3341:
			PlayerAssistant.refreshSpecialAndHealth(player);
			break;
		case 403:
			player.getDH().sendDialogues(12001, -1);
			break;
		case 2578:
			player.getDH().sendDialogues(2400, -1);
			break;
		case 3913: // BAIT + NET
			Fishing.attemptdata(player, 2);
			break;
		case 310:
		case 314:
		case 317:
		case 318:
		case 328:
		case 329:
		case 331:
		case 3417: // BAIT + LURE
			Fishing.attemptdata(player, 6);
			break;
		case 3657:
		case 321:
		case 324:// SWORDIES+TUNA-CAGE+HARPOON
			Fishing.attemptdata(player, 7);
			break;
		case 1520:
		case 322:
		case 334: // NET+HARPOON
			Fishing.attemptdata(player, 10);
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
		case 394:
		case 567: // Banker
		case 766:
		case 1036: // Banker
		case 1360: // Banker
		case 2163: // Banker
		case 2164: // Banker
		case 2354: // Banker
		case 2355: // Banker
		case 2568: // Banker
		case 2569: // Banker
		case 2570: // Banker
		case 2200:
			player.getPA().openUpBank();
			break;


		case 548:
			player.getDH().sendDialogues(69, player.npcType);
			break;

		case 2258:

			break;

		case 1045: // Santa
			int stage = player.getHolidayStages().getStage("Christmas");

			if (player.getItems().isWearingItems()) {
				player.sendMessage("You cannot bring your armour here, you'd freeze to the ground.");
				return;
			}

			if (stage > 1) {
				player.getPA().startTeleport(2833, 3804, 0, "modern", false);
			} else {
				player.sendMessage("I should perhaps speak to santa first.");
			}
			break;

		case 506:
			if (player.getMode().isIronman() || player.getMode().isUltimateIronman()) {
				player.getShops().openShop(41);
			} else {
				player.sendMessage("You must be an Iron Man to access this shop.");
			}
			break;

		}
	}

}
