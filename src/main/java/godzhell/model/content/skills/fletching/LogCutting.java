package godzhell.model.content.skills.fletching;

import godzhell.Config;
import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.items.ItemAssistant;
import godzhell.model.players.Player;
import godzhell.util.Misc;

public class LogCutting {

    private static final int KNIFE = 946, CUT_SOUND = 375;

    public static void resetFletching(Player player) {
        if (player.playerIsFletching) {
            player.playerIsFletching = false;
            player.stopAnimation();
        }
    }

    public static void cutLog(final Player player, final int product, final int level, final double xp, int amount) {
        player.doAmount = amount;
        player.getPA().closeAllWindows();
        if (player.playerLevel[9] < level) {
            player.sendMessage("You need a fletching level of " + level + " to make this.");
            return;
        }
        if (!player.playerIsFletching) {
            player.playerIsFletching = true;
            CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
                @Override
                public void execute(CycleEventContainer container) {
                    if (player.doAmount <= 0 || !player.getItems().playerHasItem(player.getFletching().log)
                            || !player.getItems().playerHasItem(KNIFE) || player.isBanking || player.isSmelting || player.isCooking || player.isCrafting) {
                        container.stop();
                        return;
                    } else {
                        player.startAnimation(1248);
                        player.getItems().deleteItem(player.getFletching().log, 1);
                        if (product == 52 || product == 19584) {
                            player.getItems().addItem(product, 15);
                            player.sendMessage("You carefully cut the " + ItemAssistant.getItemName(player.getFletching().log) + " into 15 " + ItemAssistant.getItemName(product) + "s.");

                        } else {
                            player.getItems().addItem(product, 1);
                            player.sendMessage("You carefully cut the " + ItemAssistant.getItemName(player.getFletching().log) + " into a " + ItemAssistant.getItemName(product) + ".");

                        }
                        player.getPlayerAssistant().addSkillXP(xp * Config.FLETCHING_EXPERIENCE, player.playerFletching);
                        player.doAmount--;
                       // player.getPacketSender().sendSound(CUT_SOUND, 100, 0);
                    }
                }

                @Override
                public void stop() {
                    player.playerIsFletching = false;
                    player.stopAnimation();
                }
            }, 3);
        }
    }

    public static void handleClick(Player player, int buttonId) {
        if (player.doAmount == 28 && player.playerIsFletching) {
            player.getPA().closeAllWindows();
            player.playerIsFletching = false;
            return;
        }
        switch (buttonId) {
            /*
             * normal log (item on interface 3)
             */
            case 34246:
                if (player.playerIsFletching) {
                    cutLog(player, 52, 1, 5, 1);
                    player.playerIsFletching = false;
                    return;
                }
                break;
            case 34245:
                cutLog(player, 52, 1, 5, 5);
                return;
            case 34244:
                cutLog(player, 52, 1, 5, 10);
                return;
            case 34242:
                cutLog(player, 52, 1, 5, player.getItems().getItemCount(1511));
                return;
            case 34251:
                if (player.playerIsFletching) {
                    cutLog(player, 19584, 3, 5, 1);
                    player.playerIsFletching = false;
                    return;
                }
                break;
            case 34250:
                cutLog(player, 19584, 3, 5, 5);
                return;
            case 34249:
                cutLog(player, 19584, 3, 5, 10);
                return;
            case 34247:
                cutLog(player, 19584, 3, 5, player.getItems().getItemCount(1511));
                return;
            case 35000:
                if (player.playerIsFletching) {
                    cutLog(player, 50, 5, 5, 1);
                    player.playerIsFletching = false;
                    return;
                }
                break;
            case 34255:
                cutLog(player, 50, 5, 5, 5);
                return;
            case 34254:
                cutLog(player, 50, 5, 5, 10);
                return;
            case 34252:
                cutLog(player, 50, 5, 5, player.getItems().getItemCount(1511));
                return;
            case 35005:
                if (player.playerIsFletching) {
                    cutLog(player, 48, 10, 10, 1);
                    player.playerIsFletching = false;
                    return;
                }
                break;
            case 35004:
                cutLog(player, 48, 10, 10, 5);
                return;
            case 35003:
                cutLog(player, 48, 10, 10, 10);
                return;
            case 35001:
                cutLog(player, 48, 10, 10, player.getItems().getItemCount(1511));
                return;
            case 35010:
                if (player.playerIsFletching) {
                    cutLog(player, 9440, 9, 6, 1);
                    player.playerIsFletching = false;
                    return;
                }
                break;
            case 35009:
                cutLog(player, 9440, 9, 6, 5);
                return;
            case 35008:
                cutLog(player, 9440, 9, 6, 10);
                return;
            case 35006:
                cutLog(player, 9440, 9, 6, player.getItems().getItemCount(1511));
                return;
            /*
             * rest of the log's (item on interface 2)
             */
            /*
             * first item
             */
            case 34206:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 54, 20, 16.5, 1);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 60, 35, 33.3, 1);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 64, 50, 50, 1);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 68, 65, 67.5, 1);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 72, 80, 83.25, 1);
                }
                return;
            case 34205:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 54, 20, 16.5, 5);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 60, 35, 33.3, 5);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 64, 50, 50, 5);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 68, 65, 67.5, 5);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 72, 80, 83.25, 5);
                }
                return;
            case 34204:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 54, 20, 16.5, 10);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 60, 35, 33.3, 10);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 64, 50, 50, 10);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 68, 65, 67.5, 10);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 72, 80, 83.25, 10);
                }
                return;
            case 34202:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 54, 20, 16.5, player.getItems().getItemCount(1521));
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 60, 35, 33.3, player.getItems().getItemCount(1519));
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 64, 50, 50, player.getItems().getItemCount(1517));
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 68, 65, 67.5, player.getItems().getItemCount(1515));
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 72, 80, 83.25, player.getItems().getItemCount(1513));
                }
                return;
            /*
             * second item
             */
            case 34211:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 56, 25, 25, 1);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 58, 40, 41.5, 1);
                    player.playerIsFletching = false;
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 62, 55, 58.3, 1);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 66, 70, 70, 1);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 70, 85, 91.5, 1);
                }
                return;
            case 34210:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 56, 25, 25, 5);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 58, 40, 41.5, 5);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 62, 55, 58.3, 5);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 66, 70, 70, 5);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 70, 85, 91.5, 5);
                }
                return;
            case 34209:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 56, 25, 25, 10);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 58, 40, 41.5, 10);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 62, 55, 58.3, 10);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 66, 70, 70, 10);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 70, 85, 91.5, 10);
                }
                return;
            case 34207:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 56, 25, 25, player.getItems().getItemCount(1521));
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 58, 40, 41.5, player.getItems().getItemCount(1519));
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 62, 55, 58.3, player.getItems().getItemCount(1517));
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 66, 70, 70, player.getItems().getItemCount(1515));
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 70, 85, 91.5, player.getItems().getItemCount(1513));
                }
                return;
            /*
             * 3rd item
             */
            case 34216:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 9442, 24, 16, 1);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 9444, 39, 22, 1);
                    player.playerIsFletching = false;
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 9448, 54, 32, 1);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 9452, 69, 50, 1);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 21952, 78, 70, 1);
                }
                return;
            case 34215:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 9442, 24, 16, 5);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 9444, 39, 22, 5);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 9448, 54, 32, 5);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 9452, 69, 50, 5);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 21952, 78, 70, 5);
                }
                return;
            case 34214:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 9442, 24, 16, 10);
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 9444, 39, 22, 10);
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 9448, 54, 32, 10);
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 9452, 69, 50, 10);
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 21952, 78, 70, 10);
                }
                return;
            case 34212:
                if (player.getFletching().log == 1521) {
                    cutLog(player, 9442, 24, 26, player.getItems().getItemCount(1521));
                }
                if (player.getFletching().log == 1519) {
                    cutLog(player, 9444, 39, 22, player.getItems().getItemCount(1519));
                }
                if (player.getFletching().log == 1517) {
                    cutLog(player, 9448, 54, 32, player.getItems().getItemCount(1517));
                }
                if (player.getFletching().log == 1515) {
                    cutLog(player, 9452, 69, 50, player.getItems().getItemCount(1515));
                }
                if (player.getFletching().log == 1513) {
                    cutLog(player, 21952, 78, 70, player.getItems().getItemCount(1513));
                }
                return;
        }
    }

    public static void wolfBoneArrow(Player c) {
        if (c.getItems().playerHasItem(2859) && c.getItems().playerHasItem(1755)) {
            final int amount = c.getItems().getItemAmount(2859);
            final int makeAmount = c.getItems().getItemAmount(2859) + c.getItems().getItemAmount(2859) * Misc.random(4);
            if (!c.getItems().playerHasItem(2859)) {
                c.sendMessage("You don't have any bones left to chisel.");
                return;
            }
            c.startAnimation(1248);
            c.getItems().deleteItem(2859, amount);
            c.getItems().addItem(2861, makeAmount);
            c.getPlayerAssistant().addSkillXP(3 * amount, c.playerFletching);
            c.sendMessage("You turn your " + ItemAssistant.getItemName(2859) + " into " + ItemAssistant.getItemName(2861) + ".");
        }
    }

    public static void flightedArrow(Player c) {// to do
        if (c.playerLevel[c.playerFletching] < 5) {
            c.sendMessage("You need 5 fletching to fletch this.");
            c.nextChat = 0;
            return;
        }
        if (!c.getItems().playerHasItem(314) || !c.getItems().playerHasItem(2864)) {
            c.sendMessage("You don't enough materials to make these arrows.");
            c.nextChat = 0;
            return;
        }
        if (c.getItems().playerHasItem(314) && c.getItems().playerHasItem(2864)) {
            final int feather = c.getItems().getItemAmount(314), arrowShaft = c.getItems().getItemAmount(2864);
            if (feather == arrowShaft * 4) {
                c.startAnimation(1248);
                c.getItems().deleteItem(314, feather * 4);
                c.getItems().deleteItem(2864, arrowShaft);
                c.getItems().addItem(2865, arrowShaft);
                c.sendMessage("You turn your " + ItemAssistant.getItemName(2864) + " into " + ItemAssistant.getItemName(2865) + "(s).");
            } else {
                c.sendMessage("You need 4 times the amount of feathers as arrow shafts to do this.");
            }
        }
    }

    public static void ogreArrow(Player c) {
        if (c.playerLevel[c.playerFletching] < 5) {
            c.sendMessage("You need 5 fletching to fletch this.");
            c.nextChat = 0;
            return;
        }
        if (!c.getItems().playerHasItem(2861) || !c.getItems().playerHasItem(2865)) {
            c.sendMessage("You don't enough materials to make these arrows.");
            c.nextChat = 0;
            return;
        }
        final int wolfBoneArrow = c.getItems().getItemAmount(2861), flightedArrow = c.getItems().getItemAmount(2865);
        if (c.getItems().playerHasItem(2861) && c.getItems().playerHasItem(2865)) {
            if (wolfBoneArrow == flightedArrow) {
                c.startAnimation(1248);
                c.getItems().addItem(2866, wolfBoneArrow);
                c.getPlayerAssistant().addSkillXP(1 * wolfBoneArrow, c.playerFletching);
                c.getItems().deleteItem(2861, wolfBoneArrow);
                c.getItems().deleteItem(2865, wolfBoneArrow);
                c.sendMessage("You turn your " + ItemAssistant.getItemName(2865) + " (s) into " + ItemAssistant.getItemName(2866) + "(s).");
            } else if (wolfBoneArrow > flightedArrow) {
                c.startAnimation(1248);
                c.getItems().addItem(2866, flightedArrow);
                c.getPlayerAssistant().addSkillXP(1 * flightedArrow, c.playerFletching);
                c.getItems().deleteItem(2861, flightedArrow);
                c.getItems().deleteItem(2865, flightedArrow);
                c.sendMessage("You turn your " + ItemAssistant.getItemName(2865) + " (s) into " + ItemAssistant.getItemName(2866) + "(s).");
            } else if (wolfBoneArrow < flightedArrow) {
                c.startAnimation(1248);
                c.getItems().addItem(2866, wolfBoneArrow);
                c.getPlayerAssistant().addSkillXP(1 * wolfBoneArrow, c.playerFletching);
                c.getItems().deleteItem(2861, wolfBoneArrow);
                c.getItems().deleteItem(2865, wolfBoneArrow);
                c.sendMessage("You turn your " + ItemAssistant.getItemName(2865) + " (s) into " + ItemAssistant.getItemName(2866) + "(s).");
            }
        }
    }

    public static void makeShafts(Player c) {
        if (c.getItems().playerHasItem(2862) && c.getItems().playerHasItem(946)) {
            final int amount = c.getItems().getItemAmount(2862);
            final int makeAmount = c.getItems().getItemAmount(2862) + c.getItems().getItemAmount(2862) * Misc.random(4);
            if (!c.getItems().playerHasItem(2862)) {
                c.sendMessage("You don't have any logs left to fletch.");
                c.nextChat = 0;
                return;
            }
            c.startAnimation(1248);
            c.getItems().deleteItem(2862, amount);
            c.getItems().addItem(2864, makeAmount);
            c.getPlayerAssistant().addSkillXP(2 * amount, c.playerFletching);
            c.sendMessage("You turn your " + ItemAssistant.getItemName(2862) + " (s) into " + ItemAssistant.getItemName(2864) + "(s).");
        }
    }
}