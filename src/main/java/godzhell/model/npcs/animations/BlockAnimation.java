package godzhell.model.npcs.animations;

import godzhell.Server;
import godzhell.definitions.NPCCacheDefinition;
import godzhell.definitions.NpcID;
import godzhell.model.npcs.NPCHandler;
import godzhell.model.npcs.bosses.skotizo.Skotizo;

public class BlockAnimation {

	public static int handleEmote(int i) {
		switch(NPCCacheDefinition.forID(NPCHandler.npcs[i].npcType).getName().toLowerCase()) {
			case "ghost":
				return 5535;
			case "undead druid":
				return 5574;
		}
		switch (Server.npcHandler.getNPCs()[i].npcType) {
			case 5007:
				return 170;
			case NpcID.SCORPION:
			case NpcID.SCORPION_2480:
			case NpcID.SCORPION_3024:
			case NpcID.SCORPION_5242:
			case NpcID.KHARID_SCORPION_5229:
			case NpcID.KHARID_SCORPION_5230:
			case NpcID.KING_SCORPION:
				return 6255;
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
				return 6183;
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
				return 6189;
			case NpcID.HOBGOBLIN:
			case NpcID.HOBGOBLIN_2241:
			case NpcID.HOBGOBLIN_3049:
			case NpcID.HOBGOBLIN_3050:
			case NpcID.HOBGOBLIN_3286:
			case NpcID.HOBGOBLIN_3287:
			case NpcID.HOBGOBLIN_3288:
			case NpcID.HOBGOBLIN_3289:
			case NpcID.HOBGOBLIN_4805:
				return 165;
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
				return 4934;
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
				return 6370;
			//Inferno Npcs
			case NpcID.BLACK_BEAR:
				return 4926;
			case NpcID.MOUNTED_TERRORBIRD_GNOME_5971:
				return 6792;
			case NpcID.WOLF:
				return 6557;
			case NpcID.COW:
			case NpcID.COW_2791:
			case NpcID.COW_2793:
			case NpcID.COW_2795:
			case NpcID.COW_5842:
			case NpcID.COW_6401:
			case NpcID.COW_10598:
				return 5783;
			case NpcID.COW_CALF:
			case NpcID.COW_CALF_2794:
			case NpcID.COW_CALF_2801:
				return 5850;
			case 2838:
				return 4926;
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
				return 4671;
			case NpcID.MOSS_GIANT:
			case NpcID.MOSS_GIANT_2091:
			case NpcID.MOSS_GIANT_2092:
			case NpcID.MOSS_GIANT_2093:
			case NpcID.MOSS_GIANT_3851:
			case NpcID.MOSS_GIANT_3852:
			case NpcID.MOSS_GIANT_7262:
			case NpcID.MOSS_GIANT_8736:
				return 4657;
			case NpcID.UNICORN:
			case NpcID.UNICORN_FOAL:
			case NpcID.BLACK_UNICORN:
			case NpcID.BLACK_UNICORN_FOAL:
				return 6375;
			case 7691:
				return 7575;
			case 7692:
				return 7579;
			case 7693:
				return 7585;
			case 7694:
				return 7585;
			case 7695:
				return 7585;
			case 7696:
				return 7585;
			case 7697:
				return 7598;
			case 7699:
				return 7609;
			case 7700:
				return 7591;
			case 7702:
				return 7607;
			case 7706:
				return 7565;
			case 7707:
				return 7568;
			case 7708:
				return 2869;





		// case 7573:
		// return 7196;
		case 7563:
			return 7421;
		case Skotizo.SKOTIZO_ID:
			return 4676;
		case 7585:
		case Skotizo.REANIMATED_DEMON:
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
			return 65;
		case 7604: // Skeletal mystic
		case 7605: // Skeletal mystic
		case 7606: // Skeletal mystic
			return 5489;
			case NpcID.ICE_GIANT:
			case NpcID.ICE_GIANT_2086:
			case NpcID.ICE_GIANT_2087:
			case NpcID.ICE_GIANT_2088:
			case NpcID.ICE_GIANT_2089:
			case NpcID.ICE_GIANT_7878:
			case NpcID.ICE_GIANT_7879:
			case NpcID.ICE_GIANT_7880:
			return 4671;
		case 7544: // Tekton
			return 7489;
		case 5916:
			return 4523;
		case 5890:
			return 5755;
		case 955:
		case 957:
		case 959:
			return 6232;
		case 7144:
		case 7145:
		case 7146:
			return 7228;
		case 458:
			return 2777;
		case 3544:
			return 276;
		case 1267:
			return 2020;
		case 2064:
			return 1012;
		case 2067:
			return 6792;

		case 2593:
			return 6538;

		case 963:
			return 6232;
			
		case 8030:
        case 8031:	
			return 89;

		case 965:
			return 6237;

		case 5862:
			return 4489;

		case 465: // Skeletal wyverns
			return 2983;

		case 6766: // Lizardman shaman
		case 6768:
		case 6914:
		case 6915:
		case 6916:
		case 6917:
		case 6918:
		case 6919:
			return 7194;

		case 6618: // Crazy Archaeologist
		case 6619:
			return 424;

		case 6615: // Scorpia
		case 6616:
		case 6617:
			return 6255;
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
				return 5533;
		// case 6611:
		// return 5489;
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
			return 5574;
		case 6367: // Evil chicken
			return 2299;
		case 6369: // Agrith-na-na
			return 3500;
		case 6370: // Flambeed
			return 1751;
		case 6372: // Dessourt
			return 3505;
		case 6373:
		case 6374:
		case 6375:
		case 6376:
		case 6377:
		case 6378:
			return 1340;
		case 437:
		case 7277: // Jelly
		case 7400:
		case 7399:
		case 411: // Kurask
		case 7405:
		case NpcID.CAVE_HORROR: // Cave Horror
		case 7401:
			return 4235;
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
				return 5489;
		case 419: // Cockatrice
		case 7393:
			return -1;
		case 101:
			return 6183;
		case 3835:
			return 6232;
		case 2037:
			return 5489;
		case 5529:
			return 5783;
		case 5219:
		case 5218:
			return 5096;
		case 5235:
			return 5395;
		case 10127:
			return 13170;
		case 10057:
			return 10818;
		case 5904:
			return 6330;
		case 5779:
			return 3311;
		case 5903:
			return 6346;
		case 9463:
		case 9465:
		case 9467:
			return 12792;
		case 6624:
			return 7413;
		case 6649:
			return 7469;
		case 6646:
			return 7462;
		case 3836:
			return 6237;
		case 4005: // Dark Beast
		case 7409:
			return 2732;
		case 8133:
			return 10058;
		case 10141:
			return 13601;
		case 8349:
			return 10923;
		case 9947:
			return 13771;
		case 2215:
			return 7019;
		case 2216:
		case 2217:
		case 2218:
			return 6155;
		case 3162:
			return 6978;
		case 3163:
		case 3164:
		case 3165:
		case 3169:
			return 6952;
		case 6576:
			return 6944;
		case 3130:
		case 3131:
		case 3132:
			return 65;
		case 6575:
			return 6966;
		case 6342:
			return 5897;
		/*
		 * case 2006: return 6375;
		 */
		case 6229:
		case 6230:
		case 6231:
		case 6232:
		case 6233:
		case 6234:
		case 6235:
		case 6236:
		case 6237:
		case 6238:
		case 6239:
		case 6240:
		case 6241:
		case 6242:
		case 6243:
		case 6244:
		case 6245:
		case 6246:
			return 6952;
		case 6268:
			return 2933;
		case 6269:
		case 6270:
			return 4651;
		case 6272:
		case 6273:
		case 6274:
			return 4322;
		case 6275:
			return 165;
		case 6276:
		case 6277:
		case 6278:
			return 4322;
		case 6279:
		case 6280:
			return 6183;
		case 6281:
			return 6136;
		case 6282:
			return 6189;
		case 6283:
			return 6183;
		case 6210:
			return 6578;
		case 6211:
			return 170;
		case 6212:
		case 6213:
			return 6538;
		case 6215:
			return 1550;
		case 6216:
		case 6217:
			return 1581;
		case 6218:
			return 4301;
		case 6258:
			return 2561;
		case 10775:
			return 13154;
		case 113:
			return 129;
		case 114:
			return 360;
		case 3058:
			return 2937;
		case 3061:
			return 2961;
		case 3063:
			return 2937;
		case 3065:
			return 2720;
		case 3066:
			return 2926;
		case 5935:// sand crabs
			return 1313;
		case 100:// rc
			return 1313;
		case 118:
			return 100;
		case 2263:
			return 2181;
		case 752:
		case 3064:
			return 65;
		case 3347:
		case 3346:
			return 3325;
		case 1192:
			return 1244;
		case 3062:
			return 2953;
		case 3060:
			return 2964;
		case 5947:
		case 5961:
			return 2869;
		case 423: // Dust Devil
		case 7404:
			return 1555;
		case 2054:
			return 3148;
		case 1354:
		case 1341:
		case 2455:// dagannoth
		case 2454:
		case 2456:
		case 983:
		case 984:
		case 985:
		case 986:
		case 987:
		case 988:
			return 1340;
		case 127:
			return 186;
		case 291:
			return 100;
		case 2267: // supreme
		case 2266: // prime
		case 2265: // rex
			return 2852;
		case 3452:// penance queen
			return 5413;
		case 2745:
			return 2653;
		case 2743:
			return 2645;
		case 1270:// metal dragon
			return 89;
		case 2598:
		case 2599:
		case 2600:
		case 2610:
		case 2601:
		case 2602:
		case 2603:
		case 2606:// tzhaar-xil
		case 2591:
		case 2604:// tzhar-hur
			return 2606;
		case 3121:
			return 2629;
		case 168:
		case 169:
		case 162:
			return 193;
		case 160:
		case 161:
			return 194;
		case 163:
		case 164:
			return 193;
		case 438:
		case 439:
		case 440:
		case 441:
		case 442: // Tree spirit
		case 443:
			return 95;
		case 391:
		case 392:
		case 393:
		case 394:
		case 395:// river troll
		case 396:
			return 285;

		case 1153:
		case 1154:
		case 1155:
		case 1156:
		case 1157:
		case 1158: // kalphite
			return 1186;
		case 1160: // kalphite
			return 1179;
		case 2734:
		case 2627:// tzhaar
			return 2622;
		case 2630:
		case 2629:
		case 2736:
		case 2738:
			return 2626;
		case 2631:
		case 2632:
			return 2629;
		case 2741:
			return 2635;

		case 908:
			return 129;
		case 909:
			return 147;
		case 911:
			return 65;

		case 1459:// monkey guard
			return 1403;

		case 435: // pyrefiend
		case 3406:
		case 7394:
			return 1581;

		case 414:// banshee
		case 7272:
		case 7391:
		case 7390:
			return 1525;

		case 448:
		case 7388:
		case 1649:
		case 1650:
		case 1651:
		case 1652:
		case 1653:
		case 1654:
		case 1655:
		case 1656:
		case 1657:// crawling hand
			return 1591;

		case 484:
		case 7276:
		case 1619:// bloodveld
		case 7398:
		case 7397:
			return 1550;

		case 446:
		case 7396:
		case 1644:
		case 1645:
		case 1646:
		case 1647:// infernal mage
			return 430;

		case 11:// nechryael
		case 7411:
		case 7278:
			return 1529;

		case 1543:
		case 1611:// gargoyle
		case 7407:
			return 1519;

		case 415:// abyssal demon
		case 7410:
			return 1537;

		case 1770:
		case 1771:
		case 1772:
		case 1773:
		case 2678:
		case 2679:
		case 1774:
		case 1775:
		case 1776:// goblins
			return 312;


		case 1030:
		case 1031:
		case 1032:
		case 1033:
		case 1034:
		case 1035: // wolfman
			return 6538;

		case 1456:// monkey archer
			return 1395;

		case 108:// scorpion
		case 1477:
			return 247;
		case 107:
		case 144:
			return 6255;

		case 1125:// dad
			return 285;

		case 1096:
		case 1097:
		case 1098:
		case 1942:
		case 1101:// troll
		case 1106:
			return 285;
		case 1095:
			return 285;

		case 123:
		case 122:// hobgoblin
			return 165;

			case NpcID.HELLHOUND:
			case NpcID.HELLHOUND_105:
			case NpcID.HELLHOUND_135:
			case NpcID.HELLHOUND_3133:
			case NpcID.HELLHOUND_7256:
			case NpcID.HELLHOUND_7877:
			return 6578;

		case 1593:
		case 152:
		case 1558: // wolf
		case 1954:
			return 76;

		case 133: // unicorns
			return 290;



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
			return 5328;


		case 1585:
		case 111:
			return 4671;

		case 239: // kbd
			return 89;
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
			case NpcID.MITHRIL_DRAGON:
			case NpcID.MITHRIL_DRAGON_8088:
			case NpcID.MITHRIL_DRAGON_8089:
			return 89;
		case 2889:
			return 2860;
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
				return 6250;
		case 708: // imp
			return 170;

		case 2457:
			return 2366;
		case 128: // snake
		case 1479:
			return 276;


		case 1:
			return 424;
		default:
			return -1;
		}
	}
}
