package godzhell.model.content;

import godzhell.Server;
import godzhell.definitions.AnimationLength;
import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.content.achievement_diary.lumbridge_draynor.LumbridgeDraynorDiaryEntry;
import godzhell.model.content.achievement_diary.varrock.VarrockDiaryEntry;
import godzhell.model.items.GameItem;
import godzhell.model.multiplayer_session.MultiplayerSessionFinalizeType;
import godzhell.model.multiplayer_session.MultiplayerSessionStage;
import godzhell.model.multiplayer_session.MultiplayerSessionType;
import godzhell.model.multiplayer_session.duel.DuelSession;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;
import godzhell.util.Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
		YES(151243, 855, -1),
		NO(151244, 856, -1),
		BOW(151239, 858, -1),
		ANGRY(151242, 859, -1),
		THINK(151237, 857, -1),
		WAVE(151238, 863, -1),
		SHRUG(152005, 2113, -1),
		CHEER(151246, 862, -1),
		BECKON(151240, 864, -1),
		LAUGH(151245, 861, -1),
		JUMP_FOR_JOY(152001, 2109, -1),
		YAWN(152003, 2111, -1),
		DANCE(151241, 866, -1),
		JIG(151254, 2106, -1),
		SPIN(151255, 2107, -1),
		HEADBANG(152000, 2108, -1),
		CRY(151236, 860, -1),
		BLOW_KISS(151252, 0x558, 574),
		PANIC(151253, 2105, -1),
		RASPBERRY(152002, 2110, -1),
		CLAP(151247, 865, -1),
		SALUTE(152004, 2112, -1),
		GOBLIN_BOW(152006, 0x84F, -1),
		GOBLIN_SALUTE(152007, 0x850, -1),
		GLASS_BOX(151249, 0x46B, -1),
		CLIMB_ROPE(151250, 0x46A, -1),
		LEAN_ON_AIR(151251, 0x469, -1),
		GLASS_WALL(151248, 0x468, -1),
		ZOMBIE_WALK(152009, 3544, -1),
		ZOMBIE_DANCE(152010, 3543, -1),
		SCARED(152008, 2836, -1),
		RABBIT_HOP(152008, 6111, -1),
		Hypermobile_Drinker(152054, 7131, -1),
		STAR_JUMP(152051, 7188, -1),
		SIT_UP(152011, 7190, -1),
		PUSH_UP(152012, 7189, -1),
		JOG(152052, 2764, -1),
		FLAP(152015, 4280, -1),
		SLAP_HEAD(152016, 4275, -1),
		STOMP(152014,  1745, -1),
		IDEA(152013,  4276, 712),
		ZOMBIE_HAND(152017, -1, -1),
		SMOOTH_DANCE(152058, 7533 , -1),
		CRAZY_DANCE(152059, -1, -1),
		AIR_GUITAR(152056, 4751, 1239),
		URI_TRANSFORM(152057, -1, -1),
		PREMIER_SHEILD(152060, 7751, -1);
		
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
				if (animation.getButton() == 150192) {
					if (Boundary.isIn(player, Boundary.VARROCK_BOUNDARY)) {
						player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.BECOME_A_DANCER);
					}
					if (player.getItems().isWearingItem(10394, player.playerLegs)) {
						player.startAnimation(5316);
						return;
					}
				}
				if(animation.getButton() == 152057){
					CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
						int time = 0;
						@Override
						public void execute(CycleEventContainer container) {

							if(time == 1){
								player.doinguri = true;
								player.gfx100(86);
								player.npcId2 = 7313;
								player.isNpc = true;
								player.updateRequired = true;
								player.appearanceUpdateRequired = true;
							}
							if(time == 3){
								player.startAnimation(7278);
								player.gfx0(1306);
							}
							if(time == 12){
								player.startAnimation(4069);
							}
							if(time == 14){
								player.startAnimation(4731);
								player.gfx0(678);
							}
							if(time == 15){
								player.isNpc = false;
								player.updateRequired = true;
								player.appearanceUpdateRequired = true;
								player.gfx100(86);
								player.stopAnimation();
								player.getPA().requestUpdates();
							}
							if (player == null || time >= 15) {
								if(player.doinguri) {
									container.stop();
									return;
								}
							}
							if (time >= 0) {
								time++;
							}
						}

						@Override
						public void stop() {
							player.doinguri = false;
						}
					}, 1);
				}
				if(animation.getButton() == 152059){
					int random = Misc.random(1);
					if(random == 0) {
						player.startAnimation(7536);
					} else if(random == 1) {
						player.startAnimation(7537);
					}
				}else {
					player.startAnimation(animation.getAnimation());
				}
				if(animation.getButton() == 152060){
					int random = Misc.random(2);
					if(random == 0) {
						player.gfx0(1412);
					} else if(random == 1) {
						player.gfx0(1413);
					} else if(random == 2) {
						player.gfx0(1414);
					}
				} else {
					player.gfx0(animation.getGraphic());
				}
				player.lastPerformedEmote = AnimationLength.getFrameLength(animation.getAnimation());
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
