package ethos.model.content;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ethos.Server;
import ethos.model.content.achievement_diary.lumbridge_draynor.LumbridgeDraynorDiaryEntry;
import ethos.model.content.achievement_diary.varrock.VarrockDiaryEntry;
import ethos.model.items.GameItem;
import ethos.model.multiplayer_session.MultiplayerSessionFinalizeType;
import ethos.model.multiplayer_session.MultiplayerSessionStage;
import ethos.model.multiplayer_session.MultiplayerSessionType;
import ethos.model.multiplayer_session.duel.DuelSession;
import ethos.model.players.Boundary;
import ethos.model.players.Player;
import ethos.util.Misc;

/**
 * Performing player available animations
 * @author Matt
 */

public class PlayerEmotes {
	
	/**
	 * Checks wether or not a player is able to perform an animation
	 * @param player
	 */
	public static boolean canPerform(final Player player) {
		if (player.underAttackBy > 0 || player.underAttackBy2 > 0 || player.inDuelArena() || player.inPcGame()
				|| player.inPcBoat() || player.isInJail() || player.getInterfaceEvent().isActive()
				|| player.getPA().viewingOtherBank || player.isDead || player.viewingRunePouch) {
			return false;
		}
		//if (player.getTutorial().isActive()) {
		//	player.getTutorial().refresh();
		//	return false;
		//}
		DuelSession duelSession = (DuelSession) Server.getMultiplayerSessionListener().getMultiplayerSession(player,
				MultiplayerSessionType.DUEL);
		if (Objects.nonNull(duelSession) && duelSession.getStage().getStage() > MultiplayerSessionStage.REQUEST
				&& duelSession.getStage().getStage() < MultiplayerSessionStage.FURTHER_INTERATION) {
			player.sendMessage("Your actions have declined the duel.");
			duelSession.getOther(player).sendMessage("The challenger has declined the duel.");
			duelSession.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
			return false;
		}
		if (player.isStuck) {
			player.isStuck = false;
			player.sendMessage("@red@You've disrupted stuck command, you will no longer be moved home.");
			return false;
		}
		
		return true;
	}

	public enum PLAYER_ANIMATION_DATA {
		YES(150194, 855, -1),
		NO(150195, 856, -1),
		BOW(150190, 858, -1),
		ANGRY(150193, 859, -1),
		THINK(150188, 857, -1),
		WAVE(150189, 863, -1),
		SHRUG(150212, 2113, -1),
		CHEER(150197, 862, -1),
		BECKON(150191, 864, -1),
		LAUGH(150196, 861, -1),
		JUMP_FOR_JOY(150208, 2109, -1),
		YAWN(150210, 2111, -1),
		DANCE(150192, 866, -1),
		JIG(150205, 2106, -1),
		SPIN(150206, 2107, -1),
		HEADBANG(150207, 2108, -1),
		CRY(150187, 860, -1),
		BLOW_KISS(150203, 0x558, 574),
		PANIC(150204, 2105, -1),
		RASPBERRY(150209, 2110, -1),
		CLAP(150198, 865, -1),
		SALUTE(150211, 2112, -1),
		GOBLIN_BOW(150213, 0x84F, -1),
		GOBLIN_SALUTE(150214, 0x850, -1),
		GLASS_BOX(150200, 0x46B, -1),
		CLIMB_ROPE(150201, 0x46A, -1),
		LEAN_ON_AIR(150202, 0x469, -1),
		GLASS_WALL(150199, 0x468, -1),
		ZOMBIE_WALK(150216, 3544, -1),
		ZOMBIE_DANCE(150217, 3543, -1),
		SCARED(150215, 2836, -1),
		RABBIT_HOP(151009, 6111, -1),
		Hypermobile_Drinker(151010, 7131, -1),
		STAR_JUMP(151007, 7188, -1),
		SIT_UP(150218, 7190, -1),
		PUSH_UP(150219, 7189, -1),
		JOG(151008, 2764, -1),
		FLAP(150222, 4280, -1),
		SLAP_HEAD(150223, 4275, -1),
		STOMP(150221,  1745, -1),
		IDEA(150220,  4276, 712),
		ZOMBIE_HAND(150224, 1708, 320),
		PREMIER_SHEILD(151016, 7751, 1412+ Misc.random(2));
		
		private int button;
		private int animation;
		private int graphic;
		
		PLAYER_ANIMATION_DATA(int button, int animation, int graphic) {
			this.button = button;
			this.animation = animation;
			this.graphic = graphic;
		}
		
		public int getButton() {
			return button;
		}

		public int getAnimation() {
			return animation;
		}

		public int getGraphic() {
			return graphic;
		}


	};
	
	public static void performEmote(final Player player, int button) {
		if (!canPerform(player)) {
			return;
		}
		for (PLAYER_ANIMATION_DATA animation : PLAYER_ANIMATION_DATA.values()) {
			String name = animation.name().toLowerCase().replaceAll("_", " ");
			if (animation.getButton() == button) {
				if (System.currentTimeMillis() - player.lastPerformedEmote < 3500)
					return;			
				if (animation.getButton() == 166) {
					if (Boundary.isIn(player, Boundary.VARROCK_BOUNDARY)) {
						player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.BECOME_A_DANCER);
					}
					if (player.getItems().isWearingItem(10394, player.playerLegs)) {
						player.startAnimation(5316);
						return;
					}
				}
				player.startAnimation(animation.getAnimation());
				player.gfx0(animation.getGraphic());
				player.lastPerformedEmote = System.currentTimeMillis();
				player.sendMessage("Performing emote: " + name + ".");
				player.stopMovement();
			}
		}
	}
	
	public enum SKILLCAPE_ANIMATION_DATA {
		ATTACK_CAPE(new int[] { 9747, 9748 }, 4959, 823, 7),
		DEFENCE_CAPE(new int[] { 9753, 9754 }, 4961, 824, 10),
		STRENGTH_CAPE(new int[] { 9750, 9751 }, 4981, 828, 25),
		HITPOINTS_CAPE(new int[] { 9768, 9769 }, 4971, 833, 12),
		RANGING_CAPE(new int[] { 9756, 9757 }, 4973, 832, 12),
		PRAYER_CAPE(new int[] { 9759, 9760 }, 4979, 829, 15),
		MAGIC_CAPE(new int[] { 9762, 9763 }, 4939, 813, 6),
		COOKING_CAPE(new int[] { 9801, 9802 }, 4955, 821, 36),
		WOODCUTTING_CAPE(new int[] { 9807, 9808 }, 4957, 822, 25),
		FLETCHING_CAPE(new int[] { 9783, 9784 }, 4937, 812, 20),
		FISHING_CAPE(new int[] { 9798, 9799 }, 4951, 819, 19),
		FIREMAKING_CAPE(new int[] { 9804, 9805 }, 4975, 831, 14),
		CRAFTING_CAPE(new int[] { 9780, 9781 }, 4949, 818, 15),
		SMITHING_CAPE(new int[] { 9795, 9796 }, 4943, 815, 23),
		MINING_CAPE(new int[] { 9792, 9793 }, 4941, 814, 8),
		HERBLORE_CAPE(new int[] { 9774, 9775 }, 4969, 835, 16),
		AGILITY_CAPE(new int[] { 9771, 9772 }, 4977, 830, 8),
		THIEVING_CAPE(new int[] { 9777, 9778 }, 4965, 826, 16),
		SLAYER_CAPE(new int[] { 9786, 9787 }, 4967, 827, 8),
		FARMING_CAPE(new int[] { 9810, 9811 }, 4963, 825, 16),
		RUNECRAFTING_CAPE(new int[] { 9765, 9766 }, 4947, 817, 10),
		HUNTER_CAPE(new int[] { 9948, 9949 }, 5158, 907, 14),
		CONSTRUCTION_CAPE(new int[] { 9789, 9790 }, 4953, 820, 16),
		QUEST_CAPE(new int[] { 9813 }, 4945, 816, 19),
		MAX_CAPE(new int[] { 13280, 13329, 13337, 13331, 13333, 13335, 20760 }, 7121, 1286, 35),
		ACHIEVEMENT_CAPE(new int[] { 13069 }, 2709, 323, 35);
	
		
		private final GameItem[] cape;
		private final int animation;
		private final int graphic;
		private final int delay;
		
		SKILLCAPE_ANIMATION_DATA(int[] skillcape, int animation, int graphic, int delay) {
			cape = new GameItem[skillcape.length];
			for (int i = 0; i < skillcape.length; i++) {
				cape[i] = new GameItem(skillcape[i]);
			}
			this.animation = animation;
			this.graphic = graphic;
			this.delay = delay;
		}
		
		private static Map<Integer, SKILLCAPE_ANIMATION_DATA> SKILLCAPE_DATA = new HashMap<Integer, SKILLCAPE_ANIMATION_DATA>();

		static {
			for (SKILLCAPE_ANIMATION_DATA animations : SKILLCAPE_ANIMATION_DATA.values()) {
				for (GameItem item : animations.cape) {
					SKILLCAPE_DATA.put(item.getId(), animations);
				}
			}
		}
	};
	
	public static void performSkillcapeAnimation(final Player player, final GameItem skillcape) {
		if (!canPerform(player)) {
			return;
		}
		GameItem cape = skillcape;
		SKILLCAPE_ANIMATION_DATA data = SKILLCAPE_ANIMATION_DATA.SKILLCAPE_DATA.get(cape.getId());
		if (data != null) {
			String name = data.name().toLowerCase().replaceAll("_", " ");
			if (System.currentTimeMillis() - player.lastPerformedEmote < data.delay * 500)
				return;
			if (name.contains("hunter")) {
				if (Boundary.isIn(player, Boundary.DRAYNOR_BOUNDARY)) {
					player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.ACHIEVEMENT_EMOTE);
				}
			}
			player.startAnimation(data.animation);
			player.gfx0(data.graphic);
			player.lastPerformedEmote = System.currentTimeMillis();
			player.sendMessage("Performing emote: " + name + ".");
			player.stopMovement();
		} else {
			player.sendMessage("You must be wearing a skillcape in order to do this emote.");
			return;
		}
	}
}
