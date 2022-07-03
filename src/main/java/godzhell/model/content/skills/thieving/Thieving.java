package godzhell.model.content.skills.thieving;

import godzhell.Config;
import godzhell.Server;
import godzhell.definitions.ItemCacheDefinition;
import godzhell.model.content.SkillcapePerks;
import godzhell.model.content.achievement.AchievementType;
import godzhell.model.content.achievement.Achievements;
import godzhell.model.content.achievement_diary.ardougne.ArdougneDiaryEntry;
import godzhell.model.content.achievement_diary.desert.DesertDiaryEntry;
import godzhell.model.content.achievement_diary.falador.FaladorDiaryEntry;
import godzhell.model.content.achievement_diary.lumbridge_draynor.LumbridgeDraynorDiaryEntry;
import godzhell.model.content.achievement_diary.varrock.VarrockDiaryEntry;
import godzhell.model.content.achievement_diary.western_provinces.WesternDiaryEntry;
import godzhell.model.content.dailytasks.DailyTasks;
import godzhell.model.content.dailytasks.DailyTasks.PossibleTasks;
import godzhell.model.content.skills.Skill;
import godzhell.model.items.GameItem;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.mode.ModeType;
import godzhell.util.Location3D;
import godzhell.util.Misc;
import godzhell.world.objects.GlobalObject;

/**
 * A representation of the thieving skill. Support for both object and npc actions will be supported.
 *
 * @author Jason MacKeigan
 * @date Feb 15, 2015, 7:12:14 PM
 */
public class Thieving {

    /**
     * The constant delay that is required inbetween interactions
     */
    private static final long INTERACTION_DELAY = 1_500L;
    /**
     * The stealing animation
     */
    private static final int ANIMATION = 881;
    private static final int[] rogueOutfit = {5553, 5554, 5555, 5556, 5557};
    /**
     * The managing player of this class
     */
    private final Player player;
    /**
     * The last interaction that player made that is recorded in milliseconds
     */
    private long lastInteraction;

    /**
     * Constructs a new {@link Thieving} object that manages interactions between players and stalls, as well as players and non playable characters.
     *
     * @param player the visible player of this class
     */
    public Thieving(final Player player) {
        this.player = player;
    }

    /**
     * A method for stealing from a stall
     *
     * @param stall    the stall being stolen from
     * @param objectId the object id value of the stall
     * @param location the location of the stall
     */
    public void steal(StallData stall, int objectId, Location3D location) {
        double osrsExperience;
        double regExperience;
        int pieces = 0;
        for (int aRogueOutfit : rogueOutfit) {
            if (player.getItems().isWearingItem(aRogueOutfit)) {
                pieces += 2;
            }
        }
        if (System.currentTimeMillis() - lastInteraction < INTERACTION_DELAY) {
            //player.sendMessage("You must wait a few more seconds before you can steal again.");
            return;
        }
        if (player.getItems().freeSlots() == 0) {
            player.sendMessage("You need at least one free slot to steal from this.");
            return;
        }
		/*if (!Server.getGlobalObjects().exists(objectId, location.getX(), location.getY()) || Server.getGlobalObjects().exists(4797, location.getX(), location.getY())) {
			player.sendMessage("The stall has been depleted.");
			return;
		}*/
        if (player.playerLevel[Skill.THIEVING.getId()] < stall.level) {
            player.sendMessage("You need a thieving level of " + stall.level + " to steal from this.");
            return;
        }
        if (false) {//Misc.random(50) == 0 && player.getInterfaceEvent().isExecutable()) {
            player.getInterfaceEvent().execute();
            return;
        }
        switch (stall) {
            case Spice:
                if (Boundary.isIn(player, Boundary.VARROCK_BOUNDARY)) {
                    player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.TEA_STALL);
                }
                break;
            case Baker:
                if (Boundary.isIn(player, Boundary.ARDOUGNE_BOUNDARY)) {
                    player.getDiaryManager().getArdougneDiary().progress(ArdougneDiaryEntry.STEAL_CAKE);
                }
                break;
            case Gem:
                if (Boundary.isIn(player, Boundary.ARDOUGNE_BOUNDARY)) {
                    player.getDiaryManager().getArdougneDiary().progress(ArdougneDiaryEntry.STEAL_GEM_ARD);
                }

                break;
            case Silver:
                DailyTasks.increase(player, PossibleTasks.SILVER_SICKLES);
                break;
            case Scimitar:
                break;
            case FUR:
                if (Boundary.isIn(player, Boundary.ARDOUGNE_BOUNDARY)) {
                    player.getDiaryManager().getArdougneDiary().progress(ArdougneDiaryEntry.STEAL_FUR);
                }
                break;
            default:
                break;
        }
        player.turnPlayerTo(location.getX(), location.getY());
        if (Misc.random(stall.depletionProbability) == 0) {
            GlobalObject stallObj = Server.getGlobalObjects().get(objectId, location.getX(), location.getY(), location.getZ());
            if (stallObj != null) {
                Server.getGlobalObjects().add(new GlobalObject(stall.depletionobject, location.getX(), location.getY(), location.getZ(), stallObj.getFace(), 10, 8, stallObj.getObjectId()));
            }
        }

        GameItem item = stall.getRandomItem();
        if (Misc.random(stall.petChance) == 20 && player.getItems().getItemCount(20663, false) == 0 && player.summonId != 20663) {
            PlayerHandler.executeGlobalMessage("[<col=CC0000>News</col>] @cr20@ <col=255>" + player.playerName + "</col> now goes hand in hand with a <col=CC0000>Rocky</col> pet!");
            player.getItems().addItemUnderAnyCircumstance(20663, 1);
        }
        int experience = (int) stall.experience;

        /**
         * Experience calculation
         */
        /**
         * 10 + 10 / 10 * 4
         * 10 * 40 + 10 * 40 / 10 * 4
         */
        osrsExperience = experience + experience / 10 * pieces;
        regExperience = experience * Config.THIEVING_EXPERIENCE + experience * Config.THIEVING_EXPERIENCE / 10 * pieces;

        player.startAnimation(ANIMATION);
        boolean maxCape = SkillcapePerks.THIEVING.isWearing(player) || SkillcapePerks.isWearingMaxCape(player);
        if (item != null) {
            player.getItems().addItem(item.getId(), maxCape ? item.getAmount() * 2 : item.getAmount());
            player.sendMessage("You steal a " + ItemCacheDefinition.forID(item.getId()).getName() + " from the stall.");
        } else {
            player.sendMessage("You were unable to find anything useful.");
        }
        player.getPA().addSkillXP((int) (player.getMode().getType().equals(ModeType.OSRS) ? osrsExperience * 3 : regExperience), Skill.THIEVING.getId(), true);

        Achievements.increase(player, AchievementType.THIEV, 1);
        lastInteraction = System.currentTimeMillis();
    }

    /**
     * A method for pick pocketing npc's
     *
     * @param pickpocket the pickpocket type
     * @param npc        the npc being pick pocketed
     */
    public void steal(PickpocketData pickpocket, NPC npc) {
        double multiplier = 0;
        for (int aRogueOutfit : rogueOutfit) {
            if (player.getItems().isWearingItem(aRogueOutfit)) {
                multiplier += 0.625;
            }
        }
        if (System.currentTimeMillis() - lastInteraction < INTERACTION_DELAY) {
            //player.sendMessage("You must wait a few more seconds before you can steal again.");
            return;
        }
        if (player.getItems().freeSlots() == 0) {
            player.sendMessage("You need at least one free slot to steal from this npc.");
            return;
        }
        if (player.playerLevel[Skill.THIEVING.getId()] < pickpocket.level) {
            player.sendMessage("You need a thieving level of " + pickpocket.level + " to steal from this npc.");
            return;
        }
        if (Misc.random(100) == 0 && player.getInterfaceEvent().isExecutable()) {
            player.getInterfaceEvent().execute();
            return;
        }
        /**
         * Incorporate chance for failure
         */
        switch (pickpocket) {
            case FARMER:
                if (Boundary.isIn(player, Boundary.ARDOUGNE_BOUNDARY)) {
                    player.getDiaryManager().getArdougneDiary().progress(ArdougneDiaryEntry.PICKPOCKET_ARD);
                }
                if (Boundary.isIn(player, Boundary.FALADOR_BOUNDARY)) {
                    player.getDiaryManager().getFaladorDiary().progress(FaladorDiaryEntry.PICKPOCKET_MASTER_FARMER_FAL);
                }
                if (Boundary.isIn(player, Boundary.DRAYNOR_BOUNDARY)) {
                    player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_FARMER_DRAY);
                }
                DailyTasks.increase(player, PossibleTasks.MASTER_FARMER);
                break;
            case MAN:
                if (Boundary.isIn(player, Boundary.FALADOR_BOUNDARY)) {
                    player.getDiaryManager().getFaladorDiary().progress(FaladorDiaryEntry.PICKPOCKET_MAN);
                }
                if (Boundary.isIn(player, Boundary.LUMRIDGE_BOUNDARY)) {
                    player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_MAN_LUM);
                }
                break;
            case GNOME:
                player.getDiaryManager().getWesternDiary().progress(WesternDiaryEntry.PICKPOCKET_GNOME);
                break;
            case HERO:
                player.getDiaryManager().getArdougneDiary().progress(ArdougneDiaryEntry.PICKPOCKET_HERO);
                break;
            case MENAPHITE_THUG:
                player.getDiaryManager().getDesertDiary().progress(DesertDiaryEntry.PICKPOCKET_THUG);
                break;
            default:
                break;

        }
        player.turnPlayerTo(npc.getX(), npc.getY());
        player.startAnimation(ANIMATION);
        GameItem item = pickpocket.getRandomItem();
        double percentOfXp = pickpocket.experience * (player.getMode().getType().equals(ModeType.OSRS) ? 3 : Config.THIEVING_EXPERIENCE) / 100 * multiplier;
        boolean maxCape = SkillcapePerks.THIEVING.isWearing(player) || SkillcapePerks.isWearingMaxCape(player);
        if (item != null) {
            player.getItems().addItem(item.getId(), maxCape ? item.getAmount() * 2 : item.getAmount());
        } else {
            player.sendMessage("You were unable to find anything useful.");
        }
        if (Misc.random(pickpocket.petChance) == 20 && player.getItems().getItemCount(20663, false) == 0 && player.summonId != 20663) {
            PlayerHandler.executeGlobalMessage("[<col=CC0000>News</col>] @cr20@ <col=255>" + player.playerName + "</col> now goes hand in hand with a <col=CC0000>Rocky</col> pet!");
            player.getItems().addItemUnderAnyCircumstance(20663, 1);
        }
        Achievements.increase(player, AchievementType.THIEV, 1);
        player.getPA().addSkillXP((int) (pickpocket.experience * (player.getMode().getType().equals(ModeType.OSRS) ? 3 : Config.THIEVING_EXPERIENCE) + percentOfXp), Skill.THIEVING.getId(), true);
        lastInteraction = System.currentTimeMillis();
    }


}
