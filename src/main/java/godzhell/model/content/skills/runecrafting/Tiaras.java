package godzhell.model.content.skills.runecrafting;

import godzhell.model.players.Player;
import godzhell.model.content.skills.SkillHandler;

public class Tiaras {

    public static boolean bindTiara(Player player, int itemId, int objectId) {
        for (int[] ruin : Runecrafting.RC_DATA) {
            if (itemId == ruin[0] && objectId == ruin[2]) {
                if (!SkillHandler.RUNECRAFTING) {
                    player.sendMessage("This skill is currently disabled.");
                    return false;
                }
                if (player.getItems().playerHasItem(5525)) {
                    player.getItems().deleteItem(5525, 1);
                    player.getItems().addItem(ruin[1], 1);
                    player.sendMessage("You bind the power of the talisman into the tiara.");
                }
                return true;
            }
        }
        return false;
    }

    public static void handleTiara(Player player, int id) {
        int[][] tiaras = {
                { 5527, 0 },
                { 5529, 1 },
                { 5531, 2 },
                { 5535, 3 },
                { 5537, 4 },
                { 5533, 5 },
                { 5539, 6 },
                { 5543, 7 },
                { 5541, 8 },
                { 5545, 9 },
                { 5547, 10 }
        };
        for (int[] t : tiaras) {
            if (t[0] == id) {
                player.getPA().sendConfig(491,  t[1]);
                return;
            }
            player.getPA().sendConfig(491, 0);
        }
    }

}
