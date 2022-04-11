package godzhell.model.content.skills.smithing;

import godzhell.model.items.ItemAssistant;
import godzhell.model.players.Player;
import godzhell.model.players.combat.magic.CastRequirements;

public class Superheat {

    // ore1, ore1amount, ore2, ore2amount, item, xp, smith lvl req
    private static final int[][] SMELT = { { 436, 1, 438, 1, 2349, 6, 1, 6 }, // TIN
            { 438, 1, 436, 1, 2349, 6, 1, 6 }, // COPPER
            { 440, 1, 453, 2, 2353, 18, 30, 17 }, // STEEL ORE
            { 440, 1, -1, -1, 2351, 13, 15, 12 }, // IRON ORE
            { 442, 1, -1, -1, 2355, 14, 20, 13 }, // SILVER ORE
            { 444, 1, -1, -1, 2357, 23, 40, 22 }, // GOLD BAR
            { 447, 1, 453, 4, 2359, 30, 50, 30 }, // MITHRIL ORE
            { 449, 1, 453, 6, 2361, 38, 70, 37 }, // ADDY ORE
            { 451, 1, 453, 8, 2363, 50, 85, 50 }, // RUNE ORE
    };

    public static boolean superHeatItem(Player player, int itemID) {
        for (int smelt[] : SMELT) {
            if (itemID == smelt[0]) {
                if (!player.getItems().playerHasItem(smelt[2], smelt[3])) {
                    if (itemID == 440 && smelt[2] == 453) {
                        continue;
                    } else {
                        player.sendMessage("You haven't got enough " + ItemAssistant.getItemName(smelt[2]).toLowerCase() + " to cast this spell!");
                        return false;
                    }
                }
                if (!CastRequirements.hasRunes(player, new int[][]{{554, 4}, {561, 1}})) {
                    player.sendMessage("You don't have the correct runes to cast this spell.");
                    return false;
                }
                if (itemID == 444 && player.playerEquipment[player.playerHands] == 776) {
                    player.getPlayerAssistant().addSkillXP(56.2, player.playerSmithing);
                } else {
                    player.getPlayerAssistant().addSkillXP(smelt[7], player.playerSmithing);
                }
                if (player.playerLevel[player.playerSmithing] < smelt[6]) {
                    player.sendMessage("You need a smithing level of " + smelt[6] + " to superheat this ore.");
                    return false;
                }
                if (player.playerLevel[player.playerMagic] < 43) {
                    player.sendMessage("You need a magic level of 43 to superheat this ore.");
                    return false;
                }
                player.getItems().deleteItem(itemID, 1);
                player.getItems().deleteItem(smelt[2], smelt[3]);
                CastRequirements.deleteRunes(player, new int[][]{{554, 4}, {561, 1}});
                player.getItems().addItem(smelt[4], 1);
                player.getPlayerAssistant().addSkillXP(53, player.playerMagic);
                player.startAnimation(722);
                player.gfx0(148);
                //player.sendSound(SoundList.SUPERHEAT, 100, 0);
                if (itemID != 444) {
                    player.getPlayerAssistant().addSkillXP(smelt[7], player.playerSmithing);
                }
                player.getPA().sendFrame106(6);
                return true;
            }
        }
        player.sendMessage("You can only cast superheat item on ores!");
       // player.sendSound(SoundList.SUPERHEAT_FAIL, 100, 0);
        return false;
    }
}