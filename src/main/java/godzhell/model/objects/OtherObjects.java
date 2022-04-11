package godzhell.model.objects;

import godzhell.model.content.traveling.DesertHeat;
import godzhell.model.players.Player;

public class OtherObjects {

    public static boolean openShantay(Player player, int objectId) {
        return (objectId == 4033 || objectId == 4031);
    }
    private static boolean movePlayer2(Player player) {
        if (player.getY() == 3117) {
            player.getPlayerAssistant().movePlayer(player.getX(), player.getY() - 2, 0);
            return true;
        } else if (player.getY() == 3115) {
            player.getPlayerAssistant().movePlayer(player.getX(), player.getY() + 2, 0);
            return true;
        }
        player.sendMessage("Move closer so you can use the gate.");
        return false;
    }
    public static void initShantay(Player player, int objectId) {
        if (!player.getItems().playerHasItem(1854, 1) && player.getY() == 3117) {
           // player.getDialogueHandler().sendStatement("You need a Shantay pass to go through.");
            return;
        }
        final int[] coords = new int[2];
        if (openShantay(player, objectId)) {
            player.sendMessage("You pass through the gate.");
            movePlayer2(player);
            player.turnPlayerTo(player.objectX, player.objectY);
            coords[0] = player.objectX;
            coords[1] = player.objectY;
            if (player.desertWarning == false && player.getY() == 3117) {
                DesertHeat.showWarning(player);
                player.desertWarning = true;
            }
        }
        if (player.getY() == 3117) {
            player.getItems().deleteItem(1854, player.getItems().getItemSlot(1854), 1);
        }
    }
}
