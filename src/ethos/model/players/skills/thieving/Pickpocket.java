package ethos.model.players.skills.thieving;

import ethos.Config;
import ethos.Server;
import ethos.definitions.ItemCacheDefinition;
import ethos.definitions.NPCCacheDefinition;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.content.randomevents.RandomEventHandler;
import ethos.model.items.ItemList;
import ethos.model.npcs.NPCHandler;
import ethos.model.players.Player;
import ethos.model.players.combat.Hitmark;
import ethos.model.players.skills.SkillHandler;
import ethos.util.Misc;

public class Pickpocket extends SkillHandler {

    /**
     * Pickpocket.java
     **/

    public static enum npcData {

        MAN(new int[]{3106, 3107, 3108, 3109, 3110}, 1, 8.0, 1, 5, new int[][]{
                {995, 3},
        }, "second"),
        WOMEN(new int[]{3111, 3112, 3113}, 1, 8.0, 1, 5, new int[][]{
                {995, 3},
        }, "second"),
        FARMER(new int[]{3114, 3243}, 10, 14.5, 1, 5, new int[][]{
                {995, 9},
                {5318, 4},
        }, "second"),
        HAM_FEMALE(new int[]{2541, 2540}, 15, 18.5, 2, 4, new int[][]{
                {995, 2, 19},
                {4302, 1},
                {4304, 1},
                {4298, 1},
                {4308, 1},
                {4300, 1},
                {4310, 1},
                {4306, 1},
        }, "first");

        private final int levelReq, damage, stun;
        private final int[] npcId;
        private final int[][] pickpockets;
        private final double xp;
        private final String pickupOption;

        private npcData(final int[] npcId, final int levelReq, final double xp,
                        final int damage, final int stun, final int[][] pickpockets, String pickupOption) {
            this.npcId = npcId;
            this.levelReq = levelReq;
            this.xp = xp;
            this.pickpockets = pickpockets;
            this.damage = damage;
            this.stun = stun;
            this.pickupOption = pickupOption;
        }

        public int getNpc(final int npc) {
            for (int element : npcId) {
                if (npc == element) {
                    return element;
                }
            }
            return -1;
        }

        public int getLevel() {
            return levelReq;
        }

        public double getXp() {
            return xp;
        }

        public int[][] getPickPockets() {
            return pickpockets;
        }

        public int getDamage() {
            return damage;
        }

        public int getStun() {
            return stun;
        }
    }

        public static int r(int random) {
            return Misc.random(random);
        }

        public static int i(String ItemName) {
            return getItemId(ItemName);
        }

        public static int getItemId(String itemName) {
            for (int i = 0; i < Config.ITEM_LIMIT; i++) {
                if (ItemCacheDefinition.forID(i) != null) {
                    if (ItemCacheDefinition.forID(i).getName().equalsIgnoreCase(itemName)) {
                        return ItemCacheDefinition.forID(i).id;
                    }
                }
            }
            return -1;
        }

        public static String getOptionForNpcId(Player c, int npcId) {
            for (final npcData n : npcData.values()) {
                if (npcId == n.getNpc(npcId)) {
                    return n.pickupOption;
                }
            }
            return null;
        }

        public static boolean isNPC(Player c, int npc) {
            for (final npcData n : npcData.values()) {
                if (npc == n.getNpc(npc)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean canSteal(Player player, int npcId) {
            if (System.currentTimeMillis() - player.lastThieve < 2000 || player.playerStun) {
                return false;
            }
            if (player.underAttackBy > 0 || player.underAttackBy2 > 0) {
                player.sendMessage("You can't pickpocket while in combat!");
                return false;
            }
            if (System.currentTimeMillis() - player.logoutDelay < 4000) {
                return false;
            }
            if (!THIEVING) {
                player.sendMessage("This skill is currently disabled.");
                return false;
            }
            return true;
        }

        public static void attemptPickpocket(final Player player, final int npcId) {
            if (!canSteal(player, npcId)) {
                return;
            }
            for (final npcData n : npcData.values()) {
                if (npcId == n.getNpc(npcId)) {
                    if (player.playerLevel[player.playerThieving] < n.getLevel()) {
                        player.sendMessage("You need a Thieving level of " + n.getLevel() + " to pickpocket the " + NPCCacheDefinition.forID(npcId).getName().toLowerCase() + ".");
                        return;
                    }
                    player.sendMessage("You attempt to pick the  " + NPCCacheDefinition.forID(npcId).getName().toLowerCase() + "'s pocket.");
                    player.startAnimation(881);
                    if (Misc.random(player.playerLevel[17] + 5) < Misc.random(n.getLevel())) {
                        //RandomEventHandler.addRandom(player);
                        CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
                            @Override
                            public void execute(CycleEventContainer container) {
                                if (player.disconnected) {
                                    container.stop();
                                    return;
                                }
                                player.playerStun = true;
                                player.appendDamage(n.getDamage(), Hitmark.HIT);
                                //player.setHitUpdateRequired(true);
                                player.playerLevel[3] -= n.getDamage();
                                player.getPlayerAssistant().refreshSkill(3);
                                player.gfx100(80);
                                player.startAnimation(404);
                                // player.getPacketSender().sendSound(SoundList.STUNNED, 100, 0);
                                for (int i = 0; i < NPCHandler.maxNPCs; i++) {
                                    if (NPCHandler.npcs[i] != null) {
                                        if (NPCHandler.npcs[i].npcType == npcId) {
                                            if (player.goodDistance(player.absX, player.absY, NPCHandler.npcs[i].absX, NPCHandler.npcs[i].absY, 1) && player.heightLevel == NPCHandler.npcs[i].heightLevel) {
                                                if (!NPCHandler.npcs[i].underAttack) {
                                                    NPCHandler.npcs[i].forceChat("What do you think you're doing?");
                                                    NPCHandler.npcs[i].facePlayer(player.getIndex());
                                                }
                                            }
                                        }
                                    }
                                }
                                player.lastThieve = System.currentTimeMillis() + 5000;
                                player.sendMessage("You fail to pick the " + NPCCacheDefinition.forID(npcId).getName().toLowerCase() + "'s pocket.");
                                container.stop();
                            }

                            @Override
                            public void stop() {

                            }
                        }, 2);
                        CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
                            @Override
                            public void execute(CycleEventContainer container) {
                                if (player.disconnected) {
                                    container.stop();
                                    return;
                                }
                                player.playerStun = false;
                                container.stop();
                            }

                            @Override
                            public void stop() {

                            }
                        }, n.getStun());
                    } else {
                        String message = "You pick the " + NPCCacheDefinition.forID(npcId).getName().toLowerCase() + "'s pocket.";
                        final String message2 = message;
                        CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
                            @Override
                            public void execute(CycleEventContainer container) {
                                player.sendMessage(message2);
                                player.getPlayerAssistant().addSkillXP((int) n.getXp() * Config.THIEVING_EXPERIENCE,
                                        player.playerThieving);
                                int[] random = n.getPickPockets()[Misc.random(n.getPickPockets().length - 1)];
                                player.getItems().addItem(random[0], random[1] + (random.length > 2 ? Misc.random(random[2]) : 0));
                                container.stop();
                            }

                            @Override
                            public void stop() {

                            }
                        }, 2);
                    }
                    player.lastThieve = System.currentTimeMillis();
                }
            }
        }
}