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
        int[][] tiaras = { { 5527, 1 }, { 5529, 2 }, { 5531, 4 }, { 5535, 8 },
                { 5537, 16 }, { 5533, 31 }, { 5539, 64 }, { 5543, 128 },
                { 5541, 256 }, { 5545, 512 }, { 5547, 1024 } };
        for (int[] t : tiaras) {
            if (t[0] == id) {
                player.getPA().sendConfig(491, t[1]);
                return;
            }
        }
        player.getPA().sendConfig(491, 0);
    }

}
