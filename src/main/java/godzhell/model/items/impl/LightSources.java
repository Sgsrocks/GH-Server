package godzhell.model.items.impl;

import godzhell.model.players.Player;

public class LightSources {

    public static void saveBrightness(Player player) {
        if (player.brightness == 1) {
            brightness1(player);
        } else if (player.brightness == 2) {
            brightness2(player);
        } else if (player.brightness == 4) {
            brightness4(player);
        } else {
            brightness3(player);
        }
    }

    public static void brightness1(Player player) {
        player.getPA().sendConfig(505, 1);
        player.getPA().sendConfig(506, 0);
        player.getPA().sendConfig(507, 0);
        player.getPA().sendConfig(508, 0);
        player.getPA().sendConfig(166, 1);
        player.brightness = 1;
    }

    public static void brightness2(Player player) {
        player.getPA().sendConfig(505, 0);
        player.getPA().sendConfig(506, 1);
        player.getPA().sendConfig(507, 0);
        player.getPA().sendConfig(508, 0);
        player.getPA().sendConfig(166, 2);
        player.brightness = 2;
    }

    public static void brightness3(Player player) {
        player.getPA().sendConfig(505, 0);
        player.getPA().sendConfig(506, 0);
        player.getPA().sendConfig(507, 1);
        player.getPA().sendConfig(508, 0);
        player.getPA().sendConfig(166, 3);
        player.brightness = 3;
    }

    public static void brightness4(Player player) {
        player.getPA().sendConfig(505, 0);
        player.getPA().sendConfig(506, 0);
        player.getPA().sendConfig(507, 0);
        player.getPA().sendConfig(508, 1);
        player.getPA().sendConfig(166, 4);
        player.brightness = 4;
    }

    public static void setBrightness(Player c) {
        if (c.getItems().playerHasItem(594) || c.getItems().playerHasItem(32) || c.getItems().playerHasItem(33)) {
            brightness2(c);
        } else if (c.getItems().playerHasItem(4535) || c.getItems().playerHasItem(4524)) {
            brightness3(c);
        } else if (c.getItems().playerHasItem(4550)) {
            brightness4(c);
        }
    }

    public static final int[] lightSources = {594, 32, 33, 4524, 4539, 4550};

    public static boolean playerHasLightSource(Player client) {
        for (int lightSource : lightSources) {
            if (client.getItems().playerHasItem(lightSource)) {
                setBrightness(client);
                return true;
            }
        }
        client.sendMessage("It's recommended that you get a light source to continue.");
        brightness1(client);
        return false;
    }
}
