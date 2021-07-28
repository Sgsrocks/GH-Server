package ethos.model.content;

import ethos.Server;
import ethos.model.players.Player;

public class Sawmill {

    public static int INTERFACE = 31137;

    public static void OpemSawMill(Player player) {
        player.getPA().showInterface(INTERFACE);
    }

    public static void HandleBottons(Player c, int button) {
        switch (button){
            case 122012:
                if(c.getItems().playerHasItem(995, 100)) {
                    if(c.getItems().playerHasItem(1511,1)){
                        int amount = c.getItems().getItemAmount(1511);
                        c.getItems().deleteItem2(995, 100);
                        c.getItems().deleteItem(1511, 1);
                        c.getItems().addItem(960, 1);
                        Server.itemHandler.createGroundItem(c, 9468, c.absX, c.absY, c.heightLevel, 1, c.getIndex());
                        c.sendMessage("You make a plank.");
                    } else {
                        c.sendMessage("You need logs to do this.");
                    }
                } else {
                     c.sendMessage("You don't have enough coins.");
                }
                break;
        }
    }
}
