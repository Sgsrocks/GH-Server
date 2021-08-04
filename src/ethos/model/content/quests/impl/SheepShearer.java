package ethos.model.content.quests.impl;

import ethos.model.players.Player;

public class SheepShearer {

    public static void showInformation(Player client) {
        for (int i = 8144; i < 8195; i++) {
            client.getPA().sendString("", i);
        }
        client.getPA().sendString("@dre@Sheep Shearer", 8144);
        client.getPA().sendString("", 8145);
        if (client.sheepShear == 0) {
            client.getPA().sendString("Sheep Shearer", 8144);
            client.getPA().sendString(
                    "I can start this quest by speaking to Fred in", 8147);
            client.getPA().sendString("Lumbridge.", 8148);
            client.getPA().sendString("Minimum Requirments:", 8149);
            client.getPA().sendString("None.", 8150);
        } else if (client.sheepShear == 1) {
            client.getPA().sendString("Sheep Shearer", 8144);
            client.getPA().sendString("<str>I've talked to fred</str>",
                    8147);
            client.getPA().sendString(
                    "I've agreed to get him some wool.", 8148);
            if (client.getItems().playerHasItem(1759, 20)) {
                client.getPA().sendString("<str>Ball of Wool</str>", 8149);
            } else {
                client.getPA().sendString("@red@Ball of Wool",
                        8149);
            }
        } else if (client.sheepShear == 2) {
            client.getPA().sendString("Sheep Shearer", 8144);
            client.getPA().sendString("<str>I gave fred his wool</str>",
                    8147);
            client.getPA().sendString("<str>So he awarded me.</str>",
                    8148);
            client.getPA().sendString("@red@     QUEST COMPLETE",
                    8149);
            client.getPA().sendString("As a reward, 60 coins.",
                    8150);
            client.getPA().sendString("150 crating exp", 8150);
            client.getPA().sendString("And 1 Quest Point", 8151);
            client.getPA().sendString("", 8152);
        }
        client.getPA().showInterface(8134);
    }

}