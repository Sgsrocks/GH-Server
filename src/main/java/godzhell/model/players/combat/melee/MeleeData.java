package godzhell.model.players.combat.melee;

import godzhell.model.items.ItemAssistant;
import godzhell.model.npcs.animations.BlockAnimation;
import godzhell.model.players.Player;
import godzhell.model.players.combat.magic.MagicData;
import godzhell.definitions.ItemID;

public class MeleeData {

	public static void resetPlayerAttack(Player c) {
		c.usingMagic = false;
		c.npcIndex = 0;
		c.faceUpdate(0);
		c.playerIndex = 0;
		c.getPA().resetFollow();
		return;
	}

	public static boolean usingHally(Player c) {
		switch (c.playerEquipment[c.playerWeapon]) {
		case ItemID.BRONZE_HALBERD:
			case ItemID.IRON_HALBERD:
			case ItemID.STEEL_HALBERD:
			case ItemID.MITHRIL_HALBERD:
			case ItemID.ADAMANT_HALBERD:
			case ItemID.RUNE_HALBERD:
			case ItemID.DRAGON_HALBERD:
		case ItemID.WHITE_HALBERD:
		case ItemID.CRYSTAL_HALBERD_FULL:
			return true;

		default:
			return false;
		}
	}

	public static void getPlayerAnimIndex(Player c, String weaponName) {
		c.playerStandIndex = 0x328;
		c.playerTurnIndex = 0x337;
		c.playerWalkIndex = 0x333;
		c.playerTurn180Index = 0x334;
		c.playerTurn90CWIndex = 0x335;
		c.playerTurn90CCWIndex = 0x336;
		c.playerRunIndex = 0x338;
		
		if (weaponName.contains("hunting knife")) {
			c.playerStandIndex = 7329;
			c.playerWalkIndex = 7327;
			c.playerRunIndex = 7327;
			return;
		}
		if(weaponName.contains("rubber chicken")){
			c.playerStandIndex = 1832;
			c.playerWalkIndex = 1830;
			return;
		}
		if (weaponName.contains("bulwark")) {
			c.playerStandIndex = 7508;
			c.playerWalkIndex = 7510;
			c.playerRunIndex = 7509;
			return;
		}

		if (weaponName.contains("clueless")) {
			c.playerStandIndex = 7271;
			c.playerWalkIndex = 7272;
			c.playerRunIndex = 7273;
			return;
		}
		if (weaponName.contains("casket")) {
			c.playerRunIndex = 7274;
			return;
		}
		if(weaponName.contains("2h sword")){
			c.playerStandIndex = 2561;
			c.playerWalkIndex = 2562;
			c.playerTurn180Index = 2562;
			c.playerTurn90CWIndex = 2562;
			c.playerTurn90CCWIndex = 2562;
			c.playerRunIndex = 2563;
			return;
		}
		if (weaponName.contains("sled")) {
			c.playerStandIndex = 1461;
			c.playerWalkIndex = 1468;
			c.playerRunIndex = 1467;
			return;
		}
		if (weaponName.contains("dharok")) {
			c.playerStandIndex = 0x811;
			c.playerWalkIndex = 2064;
			return;
		}
		if (weaponName.contains("ahrim")) {
			c.playerStandIndex = 809;
			c.playerWalkIndex = 1146;
			c.playerRunIndex = 1210;
			return;
		}
		if (weaponName.contains("verac")) {
			c.playerStandIndex = 1832;
			c.playerWalkIndex = 1830;
			c.playerRunIndex = 1831;
			return;
		}
		if (weaponName.contains("wand") || weaponName.contains("staff") || weaponName.contains("trident")) {
			c.playerStandIndex = 809;
			c.playerRunIndex = 1210;
			c.playerWalkIndex = 1146;
			return;
		}
		if (weaponName.contains("karil")) {
			c.playerStandIndex = 2074;
			c.playerWalkIndex = 2076;
			c.playerRunIndex = 2077;
			return;
		}
		switch (c.playerEquipment[c.playerWeapon]) {
			case ItemID.IVANDIS_FLAIL:
				c.playerStandIndex = 8009;
				c.playerWalkIndex = 8011;
				c.playerRunIndex = 8016;
				c.playerTurnIndex = 8015;
				c.playerTurn180Index = 8012;
				c.playerTurn90CWIndex = 8013;
				c.playerTurn90CCWIndex = 8014;
				break;
			case ItemID.CURSED_GOBLIN_BOW:
			case ItemID.RAIN_BOW:
			case ItemID.TRAINING_BOW:
			case ItemID.SHORTBOW:
			case ItemID.LONGBOW:
			case ItemID.STARTER_BOW:
			case ItemID.OAK_SHORTBOW:
			case ItemID.OAK_LONGBOW:
			case ItemID.SIGNED_OAK_BOW:
			case ItemID.WILLOW_SHORTBOW:
			case ItemID.WILLOW_LONGBOW:
			case ItemID.WILLOW_COMP_BOW:
			case ItemID.MAPLE_SHORTBOW:
			case ItemID.MAPLE_LONGBOW:
			case ItemID.OGRE_BOW:
			case ItemID.COMP_OGRE_BOW:
			case ItemID.YEW_SHORTBOW:
			case ItemID.YEW_LONGBOW:
			case ItemID.YEW_COMP_BOW:
			case ItemID.SEERCULL:
			case ItemID.MAGIC_SHORTBOW:
			case ItemID.MAGIC_LONGBOW:
			case ItemID.MAGIC_COMP_BOW:
			case ItemID.CRAWS_BOW:
			case ItemID.DARK_BOW:
			case ItemID._3RD_AGE_BOW:
			case ItemID.CRYSTAL_BOW_FULL:
			case ItemID.BOW_OF_FAERDHINEN:
			case ItemID.BOW_OF_FAERDHINEN_C:
			case ItemID.TWISTED_BOW:
				c.playerStandIndex = 808;
				c.playerWalkIndex = 819;
				c.playerRunIndex = 824;
				break;
			case ItemID.VIGGORAS_CHAINMACE:
				c.playerStandIndex = 244;
				c.playerWalkIndex = 247;
				c.playerRunIndex = 248;
				break;
			case ItemID.NIGHTMARE_STAFF:
				c.playerStandIndex = 4504;
				c.playerWalkIndex = 1205;
				c.playerRunIndex = 1210;
				c.playerTurnIndex = 1209;
				c.playerTurn180Index = 1206;
				c.playerTurn90CWIndex = 1207;
				c.playerTurn90CCWIndex = 1208;
				break;
			case ItemID.ELDER_MAUL:
				c.playerStandIndex = 7518;
				c.playerWalkIndex = 7520;
				c.playerRunIndex = 7519;
				break;
			case ItemID.SCYTHE_OF_VITUR:
				c.playerStandIndex = 8057;
				break;
			case ItemID.ZAMORAKIAN_HASTA:
			case ItemID.ZAMORAKIAN_SPEAR:
				c.playerStandIndex = 1662;
				c.playerWalkIndex = 1663;
				c.playerRunIndex = 1664;
				break;
			case ItemID.HEAVY_BALLISTA:
			case ItemID.LIGHT_BALLISTA:
				c.playerStandIndex = 7220;
				c.playerWalkIndex = 7223;
				c.playerRunIndex = 7221;
				break;
		case ItemID.DRAGON_2H_SWORD:
			c.playerStandIndex = 2065;
			c.playerWalkIndex = 2064;
			break;
			case ItemID.ABYSSAL_WHIP:
		case ItemID.VOLCANIC_ABYSSAL_WHIP:
			case ItemID.FROZEN_ABYSSAL_WHIP:
			case ItemID.ABYSSAL_TENTACLE:
			c.playerWalkIndex = 1660;
			c.playerRunIndex = 1661;
			break;
			case ItemID.DRAGON_HUNTER_LANCE: //Dhunter Lance
			c.playerStandIndex = 813;
			c.playerWalkIndex = 1205;
			c.playerRunIndex = 2563;
			c.playerTurnIndex = 1209;
			c.playerTurn180Index = 1206;
			c.playerTurn90CWIndex = 1207;
			c.playerTurn90CCWIndex = 1208;
			break;
			case ItemID.GHRAZI_RAPIER: //Grhazi Rapier
		c.playerStandIndex = 809;
		c.playerRunIndex = 1210;
			break;
		case ItemID.TZHAARKETOM:
		case ItemID.HILL_GIANT_CLUB:
			c.playerStandIndex = 0x811;
			c.playerWalkIndex = 2064;
			c.playerRunIndex = 1664;
			break;
		case ItemID.GRANITE_MAUL_12848:
			case ItemID.GRANITE_MAUL:
		case ItemID.ABYSSAL_BLUDGEON:
			c.playerStandIndex = 1662;
			c.playerWalkIndex = 1663;
			c.playerRunIndex = 1664;
			break;
		case ItemID.BARRELCHEST_ANCHOR:
			c.playerStandIndex = 5869;
			c.playerWalkIndex = 5867;
			c.playerRunIndex = 5868;
			break;
			case ItemID.ARMADYL_GODSWORD:
			case ItemID.BANDOS_GODSWORD:
			case ItemID.SARADOMIN_GODSWORD:
			case ItemID.ZAMORAK_GODSWORD:
			case ItemID.SARADOMIN_SWORD:
			case ItemID.SARADOMINS_BLESSED_SWORD:
			case ItemID.ANCIENT_GODSWORD:
			case ItemID.ARMADYL_GODSWORD_OR:
			case ItemID.BANDOS_GODSWORD_OR:
			case ItemID.SARADOMIN_GODSWORD_OR:
			case ItemID.ZAMORAK_GODSWORD_OR:
			c.playerStandIndex = 7053;
			c.playerWalkIndex = 7052;
			c.playerRunIndex = 7043;
			c.playerTurnIndex = 7049;
			c.playerTurn180Index = 7052;
			c.playerTurn90CWIndex = 7052;
			c.playerTurn90CCWIndex = 7052;
			break;
		case ItemID.DRAGON_LONGSWORD:
			c.playerStandIndex = 809;
			c.playerRunIndex = 1210;
			c.playerWalkIndex = 1146;
			break;
			
		case ItemID.EVENT_RPG:
		case ItemID.FIXED_DEVICE: //2324 attack anim ;) add this later.
			c.playerStandIndex = 2316;
			c.playerTurnIndex = 2317;
			c.playerWalkIndex = 2317;
			c.playerTurn180Index = 2317;
			c.playerTurn90CWIndex = 2317;
			c.playerTurn90CCWIndex = 2317;
			c.playerRunIndex = 2322;
			break;
			
		case ItemID.ALE_OF_THE_GODS: //3040, 3039, 3039
			c.playerStandIndex = 3040;
			c.playerTurnIndex = 3039;
			c.playerWalkIndex = 3039;
			c.playerTurn180Index = 3039;
			c.playerTurn90CWIndex = 3039;
			c.playerTurn90CCWIndex = 3039;
			c.playerRunIndex = 3039;
			break;
			
		default:
			c.playerStandIndex = 0x328;
			c.playerTurnIndex = 0x337;
			c.playerWalkIndex = 0x333;
			c.playerTurn180Index = 0x334;
			c.playerTurn90CWIndex = 0x335;
			c.playerTurn90CCWIndex = 0x336;
			c.playerRunIndex = 0x338;
			break;
		}
	}

	public static int getWepAnim(Player c, String weaponName) {
		if (c.playerEquipment[c.playerWeapon] <= 0) {
			switch (c.fightMode) {
			case 0:
				return 422;
			case 2:
				return 423;
			case 1:
				return 422;
			}
		}
		if (weaponName.contains("ghrazi rapier")) {
			return 8145;
		}
		if(weaponName.contains("lance")) {
			return 8145;
		}
		if (weaponName.contains("scythe of vitur")) {
			return 8056;
		}
		if (weaponName.contains("bulwark")) {
			return 7511;
		}
		if (weaponName.contains("elder maul")) {
			return 7516;
		}
		if (weaponName.contains("zamorakian")) {
			return 2080;
		}
		if (weaponName.contains("hunting knife")) {
			return 7328;
		}
		if (weaponName.contains("ballista")) {
			return 7218;
		}
		if (weaponName.contains("toxic blowpipe")) {
			return 5061;
		}
		if (weaponName.contains("warhammer")) {
			return 401;
		}
		if (weaponName.contains("dart")) {
			return c.fightMode == 2 ? 806 : 6600;
		}
		if (weaponName.contains("2h sword")) {
			return 407;
		}
		if (weaponName.contains("knife") || weaponName.contains("javelin") || weaponName.contains("thrownaxe")) {
			return 806;
		}
		if (weaponName.contains("cross") && !weaponName.contains("karil") || weaponName.contains("c'bow") && !weaponName.contains("karil")) {
			return 4230;
		}
		if (weaponName.contains("halberd")) {
			return 440;
		}
		if (weaponName.startsWith("dragon dagger")) {
			return 402;
		}
		if (weaponName.contains("byssal dagger")) {
			return c.fightMode == 1 ? 3295 : c.fightMode == 0 || c.fightMode == 2 ? 3297 : 3294;
		}
		if (weaponName.contains("dagger")) {
			switch (c.fightMode) {
				case 0:// attack
					return 386;
				case 2:// str
					return 386;
				case 1:// def
					return 386;
				case 3:// crush
					return 390;
			}
		}

		if (weaponName.contains("scimitar")) {
			switch (c.fightMode) {
				case 0:// attack
					return 390;
				case 2:// str
					return 390;
				case 1:// def
					return 390;
				case 3:// crush
					return 386;
			}
		}
		if (weaponName.contains("axe")) {
			switch (c.fightMode) {
				case 0:// attack
					return 395;
				case 2:// str
					return 395;
				case 1:// def
					return 395;
				case 3:// crush
					return 401;
			}
		}
		if (weaponName.contains("2h sword") || weaponName.contains("godsword") || weaponName.contains("aradomin sword") || weaponName.contains("blessed sword") || weaponName.contains("large spade")) {
			switch (c.fightMode) {
			case 0:// attack
				return 7045;
			case 2:// str
				return 7045;
			case 1:// def
				return 7046;
			case 3:// crush
				return 7046;
			}
		}
		if (weaponName.contains("mace")) {
			switch (c.fightMode) {
				case 0:// attack
					return 401;
				case 2:// str
					return 401;
				case 1:// def
					return 401;
				case 3:// crush
					return 400;
			}
		}
		if (weaponName.contains("dharok")) {
			switch (c.fightMode) {
			case 0:// attack
				return 2067;
			case 2:// str
				return 2067;
			case 1:// def
				return 2067;
			case 3:// crush
				return 2066;
			}
		}
		if (weaponName.contains("sword") && !weaponName.contains("training")) {
			switch (c.fightMode) {
				case 0:// attack
					return 386;
				case 2:// str
					return 386;
				case 1:// def
					return 386;
				case 3:// crush
					return 390;
			}
		}
		if (weaponName.contains("karil")) {
			return 2075;
		}
		if (weaponName.contains("bow") && !weaponName.contains("'bow") && !weaponName.contains("karil")) {
			return 426;
		}
		if (weaponName.contains("'bow") && !weaponName.contains("karil")) {
			return 4230;
		}
		if (weaponName.contains("whip")) {
			return 1658;
		}
		if (weaponName.contains("hasta") || weaponName.contains("spear")) {
			if (weaponName.contains("zamorakian")) {
				return 412;
			}
			return 400;
		}
		switch (c.playerEquipment[c.playerWeapon]) { // if you don't want to use
														// strings
		case ItemID.TRAINING_SWORD:
			return 412;
			
		case ItemID.ABYSSAL_BLUDGEON:
			return 3298;
		
		case ItemID.DRAGON_HUNTER_LANCE:
			return 8145;

		case ItemID.TOKTZXILUL:
			return 2614;
		case ItemID.BLACK_CHINCHOMPA:
		case ItemID.CHINCHOMPA_10033:
		case ItemID.RED_CHINCHOMPA_10034:
			return 2779;
		case ItemID.STAFF_OF_THE_DEAD:
		case ItemID.TOXIC_STAFF_OF_THE_DEAD:
			return 440;
		case ItemID.GRANITE_MAUL_12848:
		case ItemID.GRANITE_MAUL: // granite maul
			return 1665;
		case ItemID.GUTHANS_WARSPEAR: // guthan
			return 2080;
			case ItemID.TORAGS_HAMMERS: // torag
			return 0x814;
			case ItemID.AHRIMS_STAFF: // ahrim
			return 406;
			case ItemID.VIGGORAS_CHAINMACE: //Viggoras
			case ItemID.VERACS_FLAIL: // verac
			return 2062;
			case ItemID.KARILS_CROSSBOW: // karil
			return 2075;
		case ItemID.TZHAARKETOM:
			return 2661;
		case ItemID.BARRELCHEST_ANCHOR:
			return 5865;
		default:
			switch (c.fightMode) {
				case 0:// attack
					return 422;
				case 2:// str
					return 422;
				case 3:// crush
					return 423;
			}
			return 422;
		}
	}

	public static int getBlockEmote(Player c) {
		String shield = ItemAssistant.getItemName(c.playerEquipment[c.playerShield]).toLowerCase();
		String weapon = ItemAssistant.getItemName(c.playerEquipment[c.playerWeapon]).toLowerCase();
		if (shield.contains("defender"))
			return 4177;
		if (shield.contains("2h sword"))
			return 410;
		if (shield.contains("book") || (weapon.contains("wand") || (weapon.contains("staff") || weapon.contains("trident"))))
			return 420;
		if (shield.contains("shield"))
			return 1156;
		if (shield.contains("warhammer"))
			return 397;
		if (shield.contains("bulwark"))
			return 7512;
		if (shield.contains("elder maul"))
			return 7517;
		if (shield.contains("whip")) {
			return 1659;
		}
		if (weapon.contains("scythe of vitur")) {
			return 435;
		}
		switch (c.playerEquipment[c.playerWeapon]) {
		case ItemID.VIGGORAS_CHAINMACE:
		case ItemID.VERACS_FLAIL:
			return 2063;
		case ItemID.GRANITE_MAUL_12848:
		case ItemID.GRANITE_MAUL:
		case ItemID.ABYSSAL_BLUDGEON:
			return 1666;
		case ItemID.ABYSSAL_DAGGER:
		case ItemID.ABYSSAL_DAGGER_P:
		case ItemID.ABYSSAL_DAGGER_P_13269:
		case ItemID.ABYSSAL_DAGGER_P_13271:
			return 3295;

			case ItemID.ARMADYL_GODSWORD:
			case ItemID.BANDOS_GODSWORD:
			case ItemID.SARADOMIN_GODSWORD:
			case ItemID.ZAMORAK_GODSWORD:
			case ItemID.SARADOMIN_SWORD:
			case ItemID.SARADOMINS_BLESSED_SWORD:
			case ItemID.ANCIENT_GODSWORD:
			case ItemID.ARMADYL_GODSWORD_OR:
			case ItemID.BANDOS_GODSWORD_OR:
			case ItemID.SARADOMIN_GODSWORD_OR:
			case ItemID.ZAMORAK_GODSWORD_OR:
			return 7056;
		default:
			return 424;
		}
	}

	public static int getAttackDelay(Player c, String s) {
		if (c.usingMagic) {
			if (c.spellId == 52 || c.spellId == 53) {
				return 4;
			}
			switch (MagicData.MAGIC_SPELLS[c.spellId][0]) {
			case 12871: // ice blitz
			case 13023: // shadow barrage
			case 12891: // ice barrage
				return 5;

			default:
				return 5;
			}
		}
		if (c.playerEquipment[c.playerWeapon] == -1)
			return 4;// unarmed
		switch (c.playerEquipment[c.playerWeapon]) {
		case ItemID.TOXIC_BLOWPIPE:
			return c.playerIndex > 0 ? 4 : 3;
			case ItemID.DARK_BOW:
			case ItemID.DARK_BOW_12765:
			case ItemID.DARK_BOW_12766:
			case ItemID.DARK_BOW_12767:
			case ItemID.DARK_BOW_12768:
			case ItemID.DARK_BOW_20408:
			return 9;
		case ItemID._3RD_AGE_BOW:
		case ItemID.SARADOMIN_SWORD:
		case ItemID.SARADOMINS_BLESSED_SWORD:
			return 4;
		case ItemID.TZHAARKETOM:
		case ItemID.LIGHT_BALLISTA:
		case ItemID.HEAVY_BALLISTA:
			return 7;
		case ItemID.CHINCHOMPA_10033:
		case ItemID.RED_CHINCHOMPA_10034:
		case ItemID.DRAGON_HUNTER_CROSSBOW:
			return 5;
		case ItemID.TRAINING_SWORD:
			return 5;
		}
		if (s.endsWith("greataxe"))
			return 7;
		else if (s.equals("torags hammers"))
			return 5;
		else if (s.equals("barrelchest anchor"))
			return 7;
		else if (s.equals("guthans warspear"))
			return 5;
		else if (s.equals("veracs flail"))
			return 5;
		else if (s.equals("ahrims staff"))
			return 6;
		else if (s.contains("staff")) {
			if (s.contains("zamarok") || s.contains("guthix") || s.contains("saradomian") || s.contains("slayer") || s.contains("ancient") || s.contains("trident"))
				return 4;
			else
				return 5;
		} else if (s.contains("bow")) {
			if (s.contains("composite") || s.equals("seercull"))
				return 5;
			else if (s.contains("aril"))
				return 4;
			else if (s.contains("Ogre"))
				return 8;
			else if (s.contains("short") || s.contains("hunt") || s.contains("sword"))
				return 4;
			else if (s.contains("long") || s.endsWith("crystal bow"))
				return 6;
			else if (s.contains("'bow") && !s.contains("armadyl"))
				return 6;
			return 5;
		} else if (s.contains("dagger"))
			return 4;
		else if (s.contains("godsword") || s.contains("2h"))
			return 6;
		else if (s.contains("longsword") || s.contains("elder maul"))
			return 5;
		else if (s.contains("sword") || s.contains("bulwark"))
			return 4;
		else if (s.contains("scimitar") || s.contains("of the dead"))
			return 4;
		else if (s.contains("mace"))
			return 5;
		else if (s.contains("battleaxe"))
			return 6;
		else if (s.contains("pickaxe"))
			return 5;
		else if (s.contains("thrownaxe"))
			return 5;
		else if (s.contains("axe"))
			return 5;
		else if (s.contains("warhammer"))
			return 6;
		else if (s.contains("2h"))
			return 7;
		else if (s.contains("spear"))
			return 5;
		else if (s.contains("claw"))
			return 4;
		else if (s.contains("halberd"))
			return 7;
		else if (s.equals("granite maul"))
			return 7;
		else if (s.equals("toktz-xil-ak")) // sword
			return 4;
		else if (s.equals("tzhaar-ket-em")) // mace
			return 5;
		else if (s.equals("tzhaar-ket-om")) // maul
			return 7;
		else if (s.equals("toktz-xil-ek")) // knife
			return 4;
		else if (s.equals("toktz-xil-ul")) // rings
			return 4;
		else if (s.equals("toktz-mej-tal")) // staff
			return 6;
		else if (s.contains("whip") || s.contains("tentacle") || s.contains("abyssal bludgeon"))
			return 4;
		else if (s.contains("dart"))
			return 3;
		else if (s.contains("knife"))
			return 3;
		else if (s.contains("javelin"))
			return 6;
		else if (s.contains("hasta")) {
			if (s.contains("zamorakian")) {
				return 4;
			}
			return 5;
		}
		return 5;
	}

	public static int getHitDelay(Player c, int i, String weaponName) {
		if (c.usingMagic) {
			switch (MagicData.MAGIC_SPELLS[c.spellId][0]) {
			case 12891:
				return 4;
			case 12871:
				return 6;
			default:
				return 4;
			}
		}
		if (weaponName.contains("dart")) {
			return 3;
		}
		if (weaponName.contains("knife") || weaponName.contains("javelin") || weaponName.contains("thrownaxe")) {
			return 3;
		}
		if (weaponName.contains("cross") || weaponName.contains("c'bow")) {
			return 4;
		}
		if (weaponName.contains("ballista")) {
			return 5;
		}
		if (weaponName.contains("bow") && !c.dbowSpec) {
			return 4;
		} else if (c.dbowSpec) {
			return 4;
		}

		switch (c.playerEquipment[c.playerWeapon]) {
		case ItemID.TOKTZXILUL:
			return 3;
		case ItemID.BARRELCHEST_ANCHOR:
			return 3;
		case ItemID.CHINCHOMPA_10033:
		case ItemID.RED_CHINCHOMPA_10034:
			return 3;
		default:
			return 2;
		}
	}

	public static int npcDefenceAnim(int i) {
		return BlockAnimation.handleEmote(i);
	}
}