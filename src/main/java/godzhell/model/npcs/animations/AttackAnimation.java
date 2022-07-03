package godzhell.model.npcs.animations;

import godzhell.definitions.NPCCacheDefinition;
import godzhell.definitions.NpcID;
import godzhell.model.minigames.warriors_guild.AnimatedArmour;
import godzhell.model.npcs.NPCHandler;
import godzhell.model.players.combat.CombatType;
import godzhell.util.Misc;

/*
 * Handles all NPC Attack Emotes
 */

public class AttackAnimation extends NPCHandler {

	public static int handleEmote(int i) {
		if (AnimatedArmour.isAnimatedArmourNpc(npcs[i].npcType)) {
			return 412;
		}
		switch(NPCCacheDefinition.forID(NPCHandler.npcs[i].npcType).getName().toLowerCase()) {
			case "ghost":
				return 5532;
			case "undead druid":
				return 5567;
		}
		switch (NPCHandler.npcs[i].npcType) {
			case 5007:
				return 169;
				case NpcID.GOBLIN:
			case NpcID.GOBLIN_657:
			case NpcID.GOBLIN_659:
			case NpcID.GOBLIN_662:
			case NpcID.GOBLIN_664:
			case NpcID.GOBLIN_666:
			case NpcID.GOBLIN_3028://unarmed
			case NpcID.GOBLIN_3029:
			case NpcID.GOBLIN_3030:
			case NpcID.GOBLIN_3031:
			case NpcID.GOBLIN_3032:
			case NpcID.GOBLIN_3033:
			case NpcID.GOBLIN_3034:
			case NpcID.GOBLIN_3035:
			case NpcID.GOBLIN_3036:
			case NpcID.GOBLIN_3037:
			case NpcID.GOBLIN_3038:
			case NpcID.GOBLIN_3039:
			case NpcID.GOBLIN_3040:
			case NpcID.GOBLIN_5192:
			case NpcID.GOBLIN_5193:
			case NpcID.GOBLIN_5195:
			case NpcID.GOBLIN_5196:
			case NpcID.GOBLIN_5197:
			case NpcID.GOBLIN_5198:
			case NpcID.GOBLIN_5199:
			case NpcID.GOBLIN_5200:
			case NpcID.GOBLIN_5201:
			case NpcID.GOBLIN_5202:
			case NpcID.GOBLIN_5203:
			case NpcID.GOBLIN_5205:
			case NpcID.GOBLIN_5206:
			case NpcID.GOBLIN_5207:
			case NpcID.GOBLIN_5208:
				return 6184;
			case NpcID.GOBLIN_3073:
			case NpcID.GOBLIN_3074:
			case NpcID.GOBLIN_5204:
			case NpcID.GOBLIN_3075://armed
			case NpcID.GOBLIN_3076:
			case NpcID.GOBLIN_656:
			case NpcID.GOBLIN_658:
			case NpcID.GOBLIN_660:
			case NpcID.GOBLIN_661:
			case NpcID.GOBLIN_663:
			case NpcID.GOBLIN_665:
			case NpcID.GOBLIN_667:
			case NpcID.GOBLIN_668:
				return 6188;
			case NpcID.HOBGOBLIN:
			case NpcID.HOBGOBLIN_2241:
			case NpcID.HOBGOBLIN_3049:
			case NpcID.HOBGOBLIN_3050:
			case NpcID.HOBGOBLIN_3286:
			case NpcID.HOBGOBLIN_3287:
			case NpcID.HOBGOBLIN_3288:
			case NpcID.HOBGOBLIN_3289:
			case NpcID.HOBGOBLIN_4805:
				return 164;
			case NpcID.SCORPION:
			case NpcID.SCORPION_2480:
			case NpcID.SCORPION_3024:
			case NpcID.SCORPION_5242:
			case NpcID.KHARID_SCORPION_5229:
			case NpcID.KHARID_SCORPION_5230:
			case NpcID.KING_SCORPION:
				return 6254;
			case NpcID.VYREWATCH_SENTINEL_9756:
			case NpcID.VYREWATCH_SENTINEL_9757:
			case NpcID.VYREWATCH_SENTINEL_9758:
			case NpcID.VYREWATCH_SENTINEL_9759:
			case NpcID.VYREWATCH_SENTINEL_9760:
			case NpcID.VYREWATCH_SENTINEL_9761:
			case NpcID.VYREWATCH_SENTINEL_9763:
				return 8705;
			case NpcID.HILL_GIANT:
			case NpcID.HILL_GIANT_2099:
			case NpcID.HILL_GIANT_2100:
			case NpcID.HILL_GIANT_2101:
			case NpcID.HILL_GIANT_2102:
			case NpcID.HILL_GIANT_2103:
			case NpcID.HILL_GIANT_7261:
			case NpcID.HILL_GIANT_10374:
			case NpcID.HILL_GIANT_10375:
			case NpcID.HILL_GIANT_10376:
			case NpcID.HILL_GIANT_11195:
				return 4652;
			case NpcID.ICE_GIANT:
			case NpcID.ICE_GIANT_2086:
			case NpcID.ICE_GIANT_2087:
			case NpcID.ICE_GIANT_2088:
			case NpcID.ICE_GIANT_2089:
			case NpcID.ICE_GIANT_7878:
			case NpcID.ICE_GIANT_7879:
			case NpcID.ICE_GIANT_7880:
				return 4672;
			case 11278:
				if(npcs[i].nexStage == 1 || npcs[i].nexStage == 2) {
					switch(npcs[i].glod) {
						case 1:
							return 9180;
						case 2:
							return 9181;
					}
				}
				else if(npcs[i].nexStage == 3 || npcs[i].nexStage == 4) {
					switch(npcs[i].glod) {
						case 1:
							return 9180;
						case 2:
							return 9181;
						case 3:
							return 9186;
					}
				}
				else if(npcs[i].nexStage == 5 || npcs[i].nexStage == 6) {
					switch(npcs[i].glod) {
						case 1:
						case 2:
							return 9188;
						case 3:
							return 9189;
					}
				}
				else if(npcs[i].nexStage == 7 || npcs[i].nexStage == 8) {
					switch(npcs[i].glod) {
						case 1:
						case 2:
						case 3:
							return 9188;
					}
				}
				else if(npcs[i].nexStage == 9) {
					switch(npcs[i].glod) {
						case 1:
							return 9188;
					}
				}
				return 9180;
			case NpcID.BLACK_BEAR:
				return 4925;
			case NpcID.GHOST:
			case NpcID.GHOST_86:
			case NpcID.GHOST_87:
			case NpcID.GHOST_88:
			case NpcID.GHOST_89:
			case NpcID.GHOST_90:
			case NpcID.GHOST_91:
			case NpcID.GHOST_92:
			case NpcID.GHOST_93:
			case NpcID.GHOST_94:
			case NpcID.GHOST_95:
			case NpcID.GHOST_96:
			case NpcID.GHOST_97:
			case NpcID.GHOST_98:
			case NpcID.GHOST_99:
			case NpcID.GHOST_472:
			case NpcID.GHOST_473:
			case NpcID.GHOST_474:
			case NpcID.GHOST_505:
			case NpcID.GHOST_506:
			case NpcID.GHOST_507:
			case NpcID.GHOST_920:
			case NpcID.GHOST_1786:
			case NpcID.GHOST_2527:
			case NpcID.GHOST_2528:
			case NpcID.GHOST_2529:
			case NpcID.GHOST_2530:
			case NpcID.GHOST_2531:
			case NpcID.GHOST_2532:
			case NpcID.GHOST_2533:
			case NpcID.GHOST_2534:
			case NpcID.GHOST_3516:
			case NpcID.GHOST_3617:
			case NpcID.GHOST_3625:
			case NpcID.GHOST_3975:
			case NpcID.GHOST_3976:
			case NpcID.GHOST_3977:
			case NpcID.GHOST_3978:
			case NpcID.GHOST_3979:
			case NpcID.GHOST_5370:
			case NpcID.GHOST_7263:
			case NpcID.GHOST_7264:
			case NpcID.GHOST_9194:
			case NpcID.GHOST_10538:
			case NpcID.GHOST_10697:
			case NpcID.GHOST_10698:
			case NpcID.GHOST_10699:
			case NpcID.GHOST_11301:
				return 5532;
			case NpcID.MOUNTED_TERRORBIRD_GNOME_5971:
				return 6790;
			//Inferno Npcs
			case NpcID.JALNIB:
				return 7574;
			case NpcID.JALMEJRAH:
				return 7578;
			case NpcID.JALAK:
				return 7582;
			case NpcID.JALAKREKMEJ:
				return 7582;
			case NpcID.JALAKREKXIL:
				return 7582;
			case NpcID.JALAKREKKET:
				return 7582;
			case NpcID.JALIMKOT:
				return 7597;
			case NpcID.JALZEK:
				return npcs[i].attackType == CombatType.MAGE ? 7610 : 7612;
			case NpcID.JALTOKJAD:
				if (npcs[i].attackType == CombatType.MAGE)
					return 7592;
				else if (npcs[i].attackType == CombatType.RANGE)
					return 7593;
				else if (npcs[i].attackType == CombatType.MELEE)
					return 7590;
			case NpcID.JALXIL_7702:
				return 7604;
			case NpcID.TZKALZUK:
				return 7566;
			case NpcID.JALMEJJAK:
				return 2868;

			case NpcID.KOLODION_1605:
				return 811;
			case NpcID.KOLODION_1606:
				return 128;
			case NpcID.KOLODION_1607:
				return 5319;
			case NpcID.KOLODION_1608:
				return 394;
			case NpcID.KOLODION_1609:
				return 64;
			case NpcID.ADAMANT_DRAGON:
	        case NpcID.RUNE_DRAGON_8031:
	            if (npcs[i].attackType == CombatType.DRAGON_FIRE) {
	                return 84;
	            } else if (npcs[i].attackType == CombatType.MELEE) {
	                return 80;
	            }

			case NpcID.VORKATH_8060:
		case NpcID.VORKATH_8061:
			return 7952;
		case NpcID.VANGUARD_7527:
			return 7441;
		case NpcID.VASA_NISTIRIO:
			return 7410;
		case NpcID.LIZARDMAN_SHAMAN_7573:
			return 7193;
		case NpcID.MUTTADILE_7563:
			return 7420;
		case NpcID.GALVEK_8095:
			return Misc.random(1) == 0 ? 7900 : 7900;
		case NpcID.SKOTIZO:
			return npcs[i].attackType == CombatType.MAGE ? 69 : 4680;
		case NpcID.ICE_DEMON_7585:
		case NpcID.REANIMATED_DEMON_SPAWN:
			return 64;
		case NpcID.SPAWN:
			return 4522;

			case NpcID.SKELETAL_MYSTIC: // Skeletal mystic
			case NpcID.SKELETAL_MYSTIC_7605: // Skeletal mystic
			case NpcID.SKELETAL_MYSTIC_7606: // Skeletal mystic
			return 5528;

			case NpcID.TEKTON: // Tekton
			return Misc.random(1) == 0 ? 7492 : 7494;

		case NpcID.MAMMOTH:
			return 304;
			case NpcID.ENT:
			return 7145;

		case NpcID.YAK:
			return 5782;
			case NpcID.COW:
			case NpcID.COW_2791:
			case NpcID.COW_2793:
			case NpcID.COW_2795:
			case NpcID.COW_5842:
			case NpcID.COW_6401:
			case NpcID.COW_10598:
				return 5782;
			case NpcID.COW_CALF:
			case NpcID.COW_CALF_2794:
			case NpcID.COW_CALF_2801:
				return 5849;
			case 2838:
				return 4925;
			case NpcID.UNICORN:
			case NpcID.UNICORN_FOAL:
			case NpcID.BLACK_UNICORN:
			case NpcID.BLACK_UNICORN_FOAL:
				return 6376;
			case NpcID.FIRE_GIANT:
			case NpcID.FIRE_GIANT_2076:
			case NpcID.FIRE_GIANT_2077:
			case NpcID.FIRE_GIANT_2078:
			case NpcID.FIRE_GIANT_2079:
			case NpcID.FIRE_GIANT_2080:
			case NpcID.FIRE_GIANT_2081:
			case NpcID.FIRE_GIANT_2082:
			case NpcID.FIRE_GIANT_2083:
			case NpcID.FIRE_GIANT_2084:
			case NpcID.FIRE_GIANT_7251:
			case NpcID.FIRE_GIANT_7252:
				return 4652;
			case NpcID.MOSS_GIANT:
			case NpcID.MOSS_GIANT_2091:
			case NpcID.MOSS_GIANT_2092:
			case NpcID.MOSS_GIANT_2093:
			case NpcID.MOSS_GIANT_3851:
			case NpcID.MOSS_GIANT_3852:
			case NpcID.MOSS_GIANT_7262:
			case NpcID.MOSS_GIANT_8736:
				return 4658;

		case NpcID.DEMONIC_GORILLA:
			case NpcID.DEMONIC_GORILLA_7145:
			case NpcID.DEMONIC_GORILLA_7146:
			return npcs[i].attackType == CombatType.MAGE ? 7225
					: npcs[i].attackType == CombatType.RANGE ? 7227
							: npcs[i].attackType == CombatType.SPECIAL ? 7225 : 7239;

			case NpcID.ABYSSAL_SIRE: // Abyssal sire
			return npcs[i].attackType == CombatType.MELEE ? Misc.random(1) == 0 ? 5366 : 5369
					: npcs[i].attackType == CombatType.MAGE ? 5751
							: npcs[i].attackType == CombatType.SPECIAL ? 5367 : -1;

		case NpcID.LIZARD:
			return 2776;
		case NpcID.DESERT_SNAKE:
			return 275;
		case NpcID.VULTURE:
			return 2019;
		case NpcID.TERRORBIRD:
			return 1010;
		case NpcID.MOUNTED_TERRORBIRD_GNOME:
			return 6790;

		case NpcID.GLOD:
			return 6501;
		case NpcID.ICE_QUEEN:
			return 1978;

		case NpcID.WEREWOLF:
			return 6536;

		case NpcID.KALPHITE_QUEEN_963:
			if (npcs[i].attackType == CombatType.MAGE || npcs[i].attackType == CombatType.RANGE) {
				return 6231;
			} else if (npcs[i].attackType == CombatType.MELEE) {
				return Misc.random(1) == 0 ? 6224 : 6225;
			}

		case NpcID.KALPHITE_QUEEN_965:
			if (npcs[i].attackType == CombatType.MAGE || npcs[i].attackType == CombatType.RANGE) {
				return 6234;
			} else if (npcs[i].attackType == CombatType.MELEE) {
				return Misc.random(1) == 0 ? 6235 : 1178;
			}

		case NpcID.KALPHITE_WORKER:
		case NpcID.KALPHITE_SOLDIER_957:
		case NpcID.KALPHITE_GUARDIAN:
			return Misc.random(1) == 0 ? 6224 : 6225;
		case NpcID.SUMMONED_SOUL:
			case NpcID.SUMMONED_SOUL_5868:
			case NpcID.SUMMONED_SOUL_5869:
			return 4504;

		case NpcID.CERBERUS:
			if (npcs[i].attackType == CombatType.MAGE || npcs[i].attackType == CombatType.RANGE) {
				return 4490;
			} else if (npcs[i].attackType == CombatType.MELEE) {
				return 4491;
			} else if (npcs[i].attackType == CombatType.SPECIAL) {
				return 4492;
			} else {
				return 4491;
			}



			case NpcID.SKELETAL_WYVERN: // Skeletal wyverns
			case NpcID.SKELETAL_WYVERN_466:
			case NpcID.SKELETAL_WYVERN_467:
			case NpcID.SKELETAL_WYVERN_468:
			return npcs[i].attackType == CombatType.MELEE ? Misc.random(1) == 1 ? 2985 : 2986
					: npcs[i].attackType == CombatType.RANGE ? 2989
							: npcs[i].attackType == CombatType.SPECIAL ? 2988 : 2985;

			case NpcID.CRAZY_ARCHAEOLOGIST: // Crazy Archaeologist
			return npcs[i].attackType == CombatType.MELEE ? 423 : 2614;

		case NpcID.LIZARDMAN_SHAMAN: // Lizardman shaman
			case NpcID.LIZARDMAN_SHAMAN_6767:
		case NpcID.LIZARDMAN:
			case NpcID.LIZARDMAN_6915:
			case NpcID.LIZARDMAN_6916:
		case NpcID.LIZARDMAN_6917:
		case NpcID.LIZARDMAN_BRUTE:
			case NpcID.LIZARDMAN_BRUTE_6919:
			return npcs[i].attackType == CombatType.MELEE ? 7192 : npcs[i].attackType == CombatType.MAGE ? 7193 : 7157;

		case NpcID.CHAOS_FANATIC:
			return 811;

		case NpcID.PENANCE_FIGHTER_5744:
			return 5097;
		case NpcID.PENANCE_RANGER_5762:
			return 5395;

			case NpcID.SCORPIA: // Scorpia
		case NpcID.SCORPIAS_OFFSPRING_6616:
		case NpcID.SCORPIAS_GUARDIAN:
			return 6254;

		case NpcID.ZOMBIE_6462: // Zombies
		case NpcID.ZOMBIE_6465:
			return 5571;
		case NpcID.WHITE_KNIGHT:// White knights
			case NpcID.WHITE_KNIGHT_1799:
			case NpcID.WHITE_KNIGHT_1800:
			return 407;
		case  NpcID.EVIL_CHICKEN_6367: // Evil chicken
			return 2302;
			case NpcID.CULINAROMANCER_6368: // Culinaromancer
			return 1979;
		case NpcID.AGRITHNANA_6369: // Agrith-na-na
			return 3501;
		case NpcID.FLAMBEED_6370: // Flambeed
			return 1750;
		case NpcID.KARAMEL_6371: // Karamel
			return npcs[i].attackType == CombatType.RANGE ? 2075 : 1979;
		case NpcID.DESSOURT_6372: // Dessourt
			return 3508;
		case NpcID.GELATINNOTH_MOTHER_6373:
		case NpcID.GELATINNOTH_MOTHER_6374:
		case NpcID.GELATINNOTH_MOTHER_6375:
		case NpcID.GELATINNOTH_MOTHER_6376:
		case NpcID.GELATINNOTH_MOTHER_6377:
		case NpcID.GELATINNOTH_MOTHER_6378:
			return 1341;

		case NpcID.DAGANNOTH_970: // Dagannoths
			case NpcID.DAGANNOTH_971:
			case NpcID.DAGANNOTH_972:
			case NpcID.DAGANNOTH_973:
			case NpcID.DAGANNOTH_974:
		case NpcID.DAGANNOTH_975:
		case NpcID.DAGANNOTH_MOTHER_983:
		case NpcID.DAGANNOTH_MOTHER_984:
		case NpcID.DAGANNOTH_MOTHER_985:
		case NpcID.DAGANNOTH_MOTHER_986:
		case NpcID.DAGANNOTH_MOTHER_987:
		case NpcID.DAGANNOTH_MOTHER_988:
			return 1341;
			case NpcID.ROCK_LOBSTER: // Rock lobster
			return 2859;
			case NpcID.WALLASALKI:
			case NpcID.WALLASALKI_5939:// Wallasalki
			return 2365;

			case NpcID.CORPOREAL_BEAST: // Corporeal Beast
			return npcs[i].attackType == CombatType.MAGE ? 1680
					: npcs[i].attackType == CombatType.SPECIAL ? 1680 : 1682;
		case NpcID.DARK_ENERGY_CORE:
			return 1689;

			case NpcID.CAVE_CRAWLER: // Cave Crawler
			case NpcID.CHASM_CRAWLER:
			return 227;
			case NpcID.SMOKE_DEVIL: // Smoke Devil
		case NpcID.THERMONUCLEAR_SMOKE_DEVIL:
		case NpcID.NUCLEAR_SMOKE_DEVIL:
			return 3847;
		case NpcID.BATTLE_MAGE:
		case NpcID.BATTLE_MAGE_1611:
			return 729;
		case NpcID.BATTLE_MAGE_1612:
			return 198;
		case NpcID.CHICKEN_2805:
			return 5849;
		case NpcID.SNAKELING:
			return 1741;
		case NpcID.RUNITE_GOLEM:
			return 153;
		case NpcID.ZULRAH_2043:
			return 5806;
		case NpcID.KURASK_411: // Kurask
			return 1512;
		case NpcID.KING_KURASK:
			return 4232;
		case NpcID.BRAWLER:
			return 3897;
		case NpcID.DEFILER:
			return 3920;
		case NpcID.SPINNER:
			return 3908;
		case NpcID.RAVAGER:
			return 3915;
		case NpcID.SHIFTER_1699:
			return 3908;
		case NpcID.SPLATTER:
			return 3891;
			case NpcID.JELLY:
			case NpcID.WARPED_JELLY: // Warped Jelly
			return -1;
			case NpcID.WOLF:
				return 6559;
		case NpcID.VITREOUS_WARPED_JELLY:
		case NpcID.VITREOUS_JELLY:
			return 1586;
		case NpcID.FLAMING_PYRELORD:
			return 1582;
		case NpcID.COCKATHRICE:
			return 1562;
		case NpcID.CAVE_HORROR: // Cave Horror
		case 7401:
			if (npcs[i].attackType == CombatType.MELEE)
				return 4234;
			else if (npcs[i].attackType == CombatType.MAGE)
				return 4237;
		case 8609:
			if (npcs[i].attackType == CombatType.MAGE)
				return 8261;
			else if (npcs[i].attackType == CombatType.RANGE)
				return 8262;
			else if (npcs[i].attackType == CombatType.SPECIAL)
				return 8262;
			case NpcID.SKELETON:
			case NpcID.SKELETON_71:
			case NpcID.SKELETON_72:
			case NpcID.SKELETON_73:
			case NpcID.SKELETON_74:
			case NpcID.SKELETON_75:
			case NpcID.SKELETON_76:
			case NpcID.SKELETON_77:
			case NpcID.SKELETON_78:
			case NpcID.SKELETON_79:
			case NpcID.SKELETON_80:
			case NpcID.SKELETON_81:
			case NpcID.SKELETON_82:
			case NpcID.SKELETON_83:
			case NpcID.SKELETON_130:
			case NpcID.SKELETON_924:
			return 5485;
		case 435: // Pyrefiend
		case 7349:
			case 7932:
			return 1582;

		// God wars
		case 2205:
			return npcs[i].attackType == CombatType.MAGE ? 6970 : 6967;
		case 2206:
			return 6376;
		case 2207:
			return 7036;
		case 2208:
			return 4311;
		case 2209:
			return 811;
		case 2211:
			return 426;
		case 3428:
			return npcs[i].attackType == CombatType.RANGE ? 426 : 426;
		case 3429:
			return 428;
		case 2212:
			return 711;
		case 2215:
			return npcs[i].attackType == CombatType.MELEE ? 7018 : 7021;
		case 2216:
		case 2217:
		case 2218:
			return 6154;
		case 2233:
			return 359;
		case 2234:
			return 2930;
		case 2235:
			return 4652;
		case 2237:
			return 4320;

		case 2242:
			return 4320;
		case 2243:
			return 4320;
		case 2244:
			return 4322;
		case 2245:
			return 6185;
		case 3129:
		case 3130:
		case 3131:
		case 3132:
			return 64;

		case 3134:
			return 169;
		case 3135:
			return 6536;
		case 3137:
			return 810;
		case 3138:
			return 1552;
		case 3139:
			return 1582;
		case 3140:
			return 1582;
		case 3141:
			return 4300;
		case 3159:
			return 390;
		case 3160:
			return 426;
		case 3161:
			return 811;
		case 3162:
			return 6980;
		case 3163:
		case 3164:
			return 6956;
		case 3165:
		case 3166:
		case 3169:
			return 6957;
		case 3167:
		case 3174:
			return 6956;
		case 3168:
			return 6956;

		case 2042:
		case 2044:
			return 5069;
		case 5054:
			return 6562;
		case 1046:
		case 1049:
			return 711;
		case 6611:
		case 6612:
			return Misc.random(1) == 0 ? 5485 : 5487;
		case 6610:
			return 5327;
		case 419: // Cockatrice
			return -1;
		case 494:
		case 492:
			return 3991;
		case 6609: // Callisto
			return 4925;
		case 5535:
			return 3618;
		case 484: // Bloodveld
		case 7276:
		case 7398:
		case 7397:
			return 1552;
		case 1679:
			return 240;
		case 1680:
			return 4933;
		case 1683:
			case NpcID.SPIDER:
			case NpcID.SPIDER_3019:
			case NpcID.SPIDER_4561:
			case NpcID.SPIDER_5238:
			case NpcID.SPIDER_5239:
			case NpcID.SPIDER_8137:
			case NpcID.SPIDER_8138:
			case NpcID.SPIDER_9643:
			case NpcID.SPIDER_9644:
			case NpcID.SPIDER_10442:
			case NpcID.SPIDER_10443:
			case NpcID.SPIDER_10652:
			case NpcID.SPIDER_11027:
			case NpcID.SPIDER_11174:
			case NpcID.SPIDER_11175:
			case NpcID.SPIDER_11176:
			return 6249;

		case 1685:
			return 5485;

		case 421: // Rockslug
		case 7392:
			return 1567;

		case 5779: // giant mole
			return 3312;
		case 438:
		case 439:
		case 440:
		case 441:
		case 442: // Tree spirit
		case 443:
			return 94;
		case 391:
		case 392:
		case 393:
		case 394:
		case 395:// river troll
		case 396:
			return 284;
		case 891: // moss
			return 4658;

		case 2834: // bats
			return 4915;
		case 414: // banshee
		case 7272:
		case 7391:
			return 1523;
		case 7390:
			return 7547;
		case 4005: // dark beast
		case 7409:
			case 7938:
			return 2731;
			case NpcID.HELLHOUND:
			case NpcID.HELLHOUND_105:
			case NpcID.HELLHOUND_135:
			case NpcID.HELLHOUND_3133:
			case NpcID.HELLHOUND_7256:
			case NpcID.HELLHOUND_7877:
			case 7935:
			return 6562;
		case 6268:
			return 2930;
		case 6269:
			return 4652;
		case 6270:
			return 4652;
		case 6272:
			return 4320;
		case 6273:
			return 4320;
		case 6274:
			case 7937:
			return 4320;
		case 1459:
			return 1402;


		case 871:// Ogre Shaman
		case 5181:// Ogre Shaman
		case 5184:// Ogre Shaman
		case 5187:// Ogre Shaman
		case 5190:// Ogre Shaman
			return 359;

		case 5947:
		case 5961:
			return 2868;
		case 3116:
			return 2621;
		case 3120:
			return 2625;
		case 3123:
			return 2637;
		case 2746:
			return 2637;
		case 3121:
			return 2633;
		case 3118:
			return 2625;

		case 2167:
			return 2611;
		case 3125:// 360
			return npcs[i].attackType == CombatType.MAGE ? 2647 : 2644;
		case 5247:
			return 5411;
		case 13: // wizards
			return 711;



		case 423: // Dust Devil
		case 7404:
			return 1557;

		case 448: // Crawling hand
			return 1590;
		case 7388:
			return 1592;

		case 415: // abby demon
		case 7410: // Greater Abby demon
			return 1537;

		case 11: // nechryael
		case 7278:
			return 1528;
		case 7411:
			return 4652;

		case 1543: // Gargoyle
		case 7407:
			return 1517;

		case 417: // basilisk
		case 7395:
			return 1546;

		// case 924: //skele
		// return 260;
		case 481:
			return 6079;

		case 239:// drags
			case 7940:
			return npcs[i].attackType == CombatType.MELEE ? 80 : 81;
		case NpcID.BABY_BLUE_DRAGON:
			case NpcID.BABY_BLUE_DRAGON_242:
			case NpcID.BABY_BLUE_DRAGON_243:
		case NpcID.BABY_RED_DRAGON:
		case NpcID.BABY_RED_DRAGON_244:
		case NpcID.BABY_RED_DRAGON_245:
			case NpcID.BABY_RED_DRAGON_246:
			case NpcID.BABY_GREEN_DRAGON:
			case NpcID.BABY_GREEN_DRAGON_5872:
			case NpcID.BABY_GREEN_DRAGON_5873:
			return 80;
		case NpcID.RED_DRAGON:
			case NpcID.RED_DRAGON_248:
			case NpcID.RED_DRAGON_249:
			case NpcID.RED_DRAGON_250:
			case NpcID.RED_DRAGON_251:
			case NpcID.RED_DRAGON_8075:
			case NpcID.RED_DRAGON_8078:
			case NpcID.RED_DRAGON_8079:
			case NpcID.BLACK_DRAGON:
			case NpcID.BLACK_DRAGON_253:
			case NpcID.BLACK_DRAGON_254:
			case NpcID.BLACK_DRAGON_255:
			case NpcID.BLACK_DRAGON_256:
			case NpcID.BLACK_DRAGON_257:
			case NpcID.BLACK_DRAGON_258:
			case NpcID.BLACK_DRAGON_259:
			case NpcID.GREEN_DRAGON:
			case NpcID.GREEN_DRAGON_261:
			case NpcID.GREEN_DRAGON_262:
			case NpcID.GREEN_DRAGON_263:
			case NpcID.GREEN_DRAGON_264:
			case NpcID.GREEN_DRAGON_7868:
			case NpcID.GREEN_DRAGON_7869:
			case NpcID.GREEN_DRAGON_7870:
			case NpcID.GREEN_DRAGON_8073:
			case NpcID.GREEN_DRAGON_8076:
			case NpcID.GREEN_DRAGON_8082:
			case NpcID.BLUE_DRAGON:
			case NpcID.BLUE_DRAGON_266:
			case NpcID.BLUE_DRAGON_267:
			case NpcID.BLUE_DRAGON_268:
			case NpcID.BLUE_DRAGON_269:
			case NpcID.BLUE_DRAGON_4385:
			case NpcID.BLUE_DRAGON_5878:
			case NpcID.BLUE_DRAGON_5879:
			case NpcID.BLUE_DRAGON_5880:
			case NpcID.BLUE_DRAGON_5881:
			case NpcID.BLUE_DRAGON_5882:
			case NpcID.BLUE_DRAGON_8074:
			case NpcID.BLUE_DRAGON_8077:
			case NpcID.BLUE_DRAGON_8083:
		case NpcID.BRONZE_DRAGON:
			case NpcID.BRONZE_DRAGON_271:
			case NpcID.BRONZE_DRAGON_7253:
			case NpcID.IRON_DRAGON:
			case NpcID.IRON_DRAGON_273:
			case NpcID.IRON_DRAGON_7254:
			case NpcID.IRON_DRAGON_8080:
		case NpcID.STEEL_DRAGON:
			case NpcID.STEEL_DRAGON_274:
			case NpcID.STEEL_DRAGON_275:
			case NpcID.STEEL_DRAGON_7255:
			case NpcID.STEEL_DRAGON_8086:
		case NpcID.LAVA_DRAGON:
		case NpcID.BRUTAL_BLUE_DRAGON:
			case NpcID.BRUTAL_BLACK_DRAGON:
			case NpcID.BRUTAL_BLACK_DRAGON_8092:
			case NpcID.BRUTAL_BLACK_DRAGON_8093:
			case NpcID.BRUTAL_GREEN_DRAGON:
			case NpcID.BRUTAL_GREEN_DRAGON_8081:
			case NpcID.BRUTAL_RED_DRAGON:
			case NpcID.BRUTAL_RED_DRAGON_8087:
			case NpcID.MITHRIL_DRAGON:
			case NpcID.MITHRIL_DRAGON_8088:
			case NpcID.MITHRIL_DRAGON_8089:
			if (npcs[i].attackType == CombatType.DRAGON_FIRE) {
				return 84;
			} else if (npcs[i].attackType == CombatType.MELEE) {
				return 80;
			}
			case 2840: // earth warrior
			return 390;

		case 803: // monk
			return 422;

			case NpcID.SHADOW_SPIDER:
			case NpcID.GIANT_SPIDER:
			case NpcID.GIANT_SPIDER_3017:
			case NpcID.GIANT_SPIDER_3018:
			case NpcID.JUNGLE_SPIDER:
			case NpcID.JUNGLE_SPIDER_5243:
			case NpcID.JUNGLE_SPIDER_6267:
			case NpcID.JUNGLE_SPIDER_6271:
			case NpcID.DEADLY_RED_SPIDER:
			case NpcID.ICE_SPIDER:
			case NpcID.ICE_SPIDER_10722:
			case NpcID.BLESSED_SPIDER:
			case NpcID.FEVER_SPIDER:
			case NpcID.POISON_SPIDER:
			case NpcID.GIANT_CRYPT_SPIDER:
			return 5327;


		case 412:
			// case 2834:
			return 30;
			case NpcID.ZOMBIE:
			case NpcID.ZOMBIE_27:
			case NpcID.ZOMBIE_28:
			case NpcID.ZOMBIE_29:
			case NpcID.ZOMBIE_30:
			case NpcID.ZOMBIE_31:
			case NpcID.ZOMBIE_32:
			case NpcID.ZOMBIE_33:
			case NpcID.ZOMBIE_34:
			case NpcID.ZOMBIE_35:
			case NpcID.ZOMBIE_36:
			case NpcID.ZOMBIE_37:
			case NpcID.ZOMBIE_38:
			case NpcID.ZOMBIE_39:
			case NpcID.ZOMBIE_40:
			case NpcID.ZOMBIE_41:
			case NpcID.ZOMBIE_42:
			case NpcID.ZOMBIE_43:
			case NpcID.ZOMBIE_44:
			case NpcID.ZOMBIE_45:
			case NpcID.ZOMBIE_46:
			case NpcID.ZOMBIE_47:
			case NpcID.ZOMBIE_48:
			case NpcID.ZOMBIE_49:
			case NpcID.ZOMBIE_50:
			case NpcID.ZOMBIE_51:
			case NpcID.ZOMBIE_52:
			case NpcID.ZOMBIE_53:
			case NpcID.ZOMBIE_54:
			case NpcID.ZOMBIE_55:
			case NpcID.ZOMBIE_56:
			case NpcID.ZOMBIE_57:
			case NpcID.ZOMBIE_58:
			case NpcID.ZOMBIE_59:
			case NpcID.ZOMBIE_60:
			case NpcID.ZOMBIE_61:
			case NpcID.ZOMBIE_62:
			case NpcID.ZOMBIE_63:
			case NpcID.ZOMBIE_64:
			case NpcID.ZOMBIE_65:
			case NpcID.ZOMBIE_66:
			case NpcID.ZOMBIE_67:
			case NpcID.ZOMBIE_68:
			case NpcID.ZOMBIE_880:
			case NpcID.ZOMBIE_1784:
			case NpcID.ZOMBIE_2501:
			case NpcID.ZOMBIE_2502:
			case NpcID.ZOMBIE_2503:
			case NpcID.ZOMBIE_2504:
			case NpcID.ZOMBIE_2505:
			case NpcID.ZOMBIE_2506:
			case NpcID.ZOMBIE_2507:
			case NpcID.ZOMBIE_2508:
			case NpcID.ZOMBIE_2509:
				return 5568;
			case NpcID.GIANT_RAT:
			case NpcID.GIANT_RAT_2511:
			case NpcID.GIANT_RAT_2512:
			case NpcID.GIANT_RAT_2856:
			case NpcID.GIANT_RAT_2857:
			case NpcID.GIANT_RAT_2858:
			case NpcID.GIANT_RAT_2859:
			case NpcID.GIANT_RAT_2860:
			case NpcID.GIANT_RAT_2861:
			case NpcID.GIANT_RAT_2862:
			case NpcID.GIANT_RAT_2863:
			case NpcID.GIANT_RAT_2864:
			case NpcID.GIANT_RAT_3313:
			case NpcID.GIANT_RAT_3314:
			case NpcID.GIANT_RAT_3315:
			case NpcID.GIANT_RAT_9483:
			case NpcID.GIANT_CRYPT_RAT_1681:
			case NpcID.GIANT_CRYPT_RAT_1682:
			case NpcID.ANGRY_GIANT_RAT_4689:
			case NpcID.ANGRY_GIANT_RAT_4690:
			case NpcID.BLESSED_GIANT_RAT_4535:
				return 4933;
		case 2033: // rat
			return 138;

			case NpcID.BLOODWORM: // bloodworm
			return 2070;

		case 1769:
		case 1770:
		case 1771:
		case 1772:
			case 7931:
		case 1773:
		case 101: // goblin
			return 6184;


		case 21: // hero
			return 451;



		case 1338: // dagannoth
		case 1340:
		case 1342:

			return 1341;

		case 19: // white knight
			return 406;
		case 7538:
			if (npcs[i].attackType == CombatType.MAGE)
				return 7540;
		case 2463:
			return 4652;
		case 3127:

			if (npcs[i].attackType == CombatType.MAGE)
				return 2656;
			else if (npcs[i].attackType == CombatType.RANGE)
				return 2652;
			else if (npcs[i].attackType == CombatType.MELEE)
				return 2655;
		case 2452:
			return 1312;

		case 2889:
			return 2859;

		case 118:
		case 291:
			return 99;

			case NpcID.LESSER_DEMON:
			case NpcID.LESSER_DEMON_2006:
			case NpcID.LESSER_DEMON_2007:
			case NpcID.LESSER_DEMON_2008:
			case NpcID.LESSER_DEMON_2018:
			case NpcID.LESSER_DEMON_7247:
			case NpcID.LESSER_DEMON_3982:
			case NpcID.LESSER_DEMON_7248:
			case NpcID.LESSER_DEMON_7656:
			case NpcID.LESSER_DEMON_7657:
			case NpcID.LESSER_DEMON_7664:
			case NpcID.LESSER_DEMON_7865:
			case NpcID.LESSER_DEMON_7866:
			case NpcID.LESSER_DEMON_7867:
			case NpcID.GREATER_DEMON:
			case NpcID.GREATER_DEMON_2026:
			case NpcID.GREATER_DEMON_2027:
			case NpcID.GREATER_DEMON_2028:
			case NpcID.GREATER_DEMON_2029:
			case NpcID.GREATER_DEMON_2030:
			case NpcID.GREATER_DEMON_2031:
			case NpcID.GREATER_DEMON_2032:
			case NpcID.GREATER_DEMON_7244:
			case NpcID.GREATER_DEMON_7245:
			case NpcID.GREATER_DEMON_7246:
			case NpcID.GREATER_DEMON_7871:
			case NpcID.GREATER_DEMON_7872:
			case NpcID.GREATER_DEMON_7873:
			case NpcID.REVENANT_DEMON:
			case NpcID.BLACK_DEMON:
			case NpcID.BLACK_DEMON_1432:
			case NpcID.BLACK_DEMON_2048:
			case NpcID.BLACK_DEMON_2049:
			case NpcID.BLACK_DEMON_2050:
			case NpcID.BLACK_DEMON_2051:
			case NpcID.BLACK_DEMON_2052:
			case NpcID.BLACK_DEMON_5874:
			case NpcID.BLACK_DEMON_5875:
			case NpcID.BLACK_DEMON_5876:
			case NpcID.BLACK_DEMON_5877:
			case NpcID.BLACK_DEMON_6357:
			case NpcID.BLACK_DEMON_7242:
			case NpcID.BLACK_DEMON_7243:
			case NpcID.BLACK_DEMON_7874:
			case NpcID.BLACK_DEMON_7875:
			case NpcID.BLACK_DEMON_7876:
			case NpcID.BLACK_DEMON_HARD:
		case 1472:// jungle demon
			return 64;
		case 5935:// sand crabs
			return 1312;
		case 100:// rock crabs
			return 1312;

		case 2841: // ice warrior
		case 178:
			return 451;

		case 1153: // Kalphite Worker
		case 1154: // Kalphite Soldier
		case 1155: // Kalphite guardian
		case 1156: // Kalphite worker
		case 1157: // Kalphite guardian
			return 1184;

		case 123:
		case 7933:
		case 122:
			return 164;

		case 1675: // karil
			return 2075;

		case 1672: // ahrim
			return 729;

		case 1673: // dharok
			return 2067;

		case 1674: // guthan
			return 2080;

		case 1676: // torag
			return 0x814;

		case 1677: // verac
			return 2062;

		case 2265: // supreme
			return 2855;

		case 2266: // prime
			return 2854;

		case 2267: // rex
			return 2851;

		case 6342:
			int test = Misc.random(2);
			if (test == 2) {
				return 5895;
			} else if (test == 1) {
				return 5894;
			} else {
				return 5896;
			}

		case 2054:
			return 3146;

		case 1739:
		case 1740:
		case 1741:
		case 1742:
			return -1;
			
		default:
			return 0x326;
		}
	}

}
