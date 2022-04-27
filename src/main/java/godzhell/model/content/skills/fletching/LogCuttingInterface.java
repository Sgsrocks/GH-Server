package godzhell.model.content.skills.fletching;

import godzhell.model.items.ItemAssistant;
import godzhell.model.players.Player;

public class LogCuttingInterface {

    public int log;

    public static void handleLog(Player c, int item1, int item2) {
        if (item1 == 946) {
            fletchInterface(c, item2);
        } else {
            fletchInterface(c, item1);
        }
    }

    public static void fletchInterface(Player c, int item) {
        if (c.playerIsFletching) {
            c.playerIsFletching = false;
            return;
        }
        if (item < 1510 || item > 1521) {
            c.playerIsFletching = false;
            c.sendMessage("Nothing interesting happens.");
            return;
        }
        c.getFletching().log = item;
        if (item == 1511) {
            c.getPA().sendChatInterface(8938);
            c.getPA().sendString("What would you like to make?", 8971);
            c.getPA().sendFrame246(8941, 180, 52); // left
            c.getPA().sendFrame246(8942, 180, 19584); // left
            c.getPA().sendFrame246(8943, 180, 50); // middle
            c.getPA().sendFrame246(8944, 180, 48); // right
            c.getPA().sendFrame246(8945, 180, 9440); // right
            c.getPA().sendString(ItemAssistant.getItemName(52), 8950);
            c.getPA().sendString(ItemAssistant.getItemName(19584), 8955);
            c.getPA().sendString(ItemAssistant.getItemName(50), 8960);
            c.getPA().sendString(ItemAssistant.getItemName(48), 8965);
            c.getPA().sendString(ItemAssistant.getItemName(9440), 8970);
        } else if (item == 1521) {
            c.getPA().sendChatInterface(8899);
            c.getPA().sendString("What would you like to make?", 8926);
            c.getPA().sendFrame246(8902, 180, 54); // 1st
            c.getPA().sendFrame246(8903, 180, 56); // 2nd
            c.getPA().sendFrame246(8904, 180, 9442); // right
            c.getPA().sendFrame246(8905, 180, 22251); // right
            c.getPA().sendString(ItemAssistant.getItemName(54), 8910);
            c.getPA().sendString(ItemAssistant.getItemName(56), 8915);
            c.getPA().sendString(ItemAssistant.getItemName(9442), 8920);
            c.getPA().sendString(ItemAssistant.getItemName(22251), 8925);
        } else if (item == 1519) {
            c.getPA().sendChatInterface(8899);
            c.getPA().sendString("What would you like to make?", 8926);
            c.getPA().sendFrame246(8902, 180, 60); // 1st
            c.getPA().sendFrame246(8903, 180, 58); // 2nd
            c.getPA().sendFrame246(8904, 180, 9444); // right
            c.getPA().sendFrame246(8905, 180, 22254); // right
            c.getPA().sendString(ItemAssistant.getItemName(60), 8910);
            c.getPA().sendString(ItemAssistant.getItemName(58), 8915);
            c.getPA().sendString(ItemAssistant.getItemName(9444), 8920);
            c.getPA().sendString(ItemAssistant.getItemName(22254), 8925);
            //c.getPA().sendChatInterface(8866);
           //c.getPA().sendString("What would you like to make?", 8879);
           // c.getPA().sendFrame246(8869, 180, 60); // left
           // c.getPA().sendFrame246(8870, 180, 58); // right
           // c.getPA().sendString(ItemAssistant.getItemName(60), 8874);
          //  c.getPA().sendString(ItemAssistant.getItemName(58), 8878);
        } else if (item == 1517) {
            c.getPA().sendChatInterface(8899);
            c.getPA().sendString("What would you like to make?", 8926);
            c.getPA().sendFrame246(8902, 180, 64); // 1st
            c.getPA().sendFrame246(8903, 180, 62); // 2nd
            c.getPA().sendFrame246(8904, 180, 9448); // right
            c.getPA().sendFrame246(8905, 180, 22257); // right
            c.getPA().sendString(ItemAssistant.getItemName(64), 8910);
            c.getPA().sendString(ItemAssistant.getItemName(62), 8915);
            c.getPA().sendString(ItemAssistant.getItemName(9448), 8920);
            c.getPA().sendString(ItemAssistant.getItemName(22257), 8925);
           // c.getPA().sendChatInterface(8866);
          //  c.getPA().sendString("What would you like to make?", 8879);
          //  c.getPA().sendFrame246(8869, 180, 64); // left
           // c.getPA().sendFrame246(8870, 180, 62); // right
          //  c.getPA().sendString(ItemAssistant.getItemName(64), 8874);
         //   c.getPA().sendString(ItemAssistant.getItemName(62), 8878);
        } else if (item == 1515) {
            c.getPA().sendChatInterface(8899);
            c.getPA().sendString("What would you like to make?", 8926);
            c.getPA().sendFrame246(8902, 180, 68); // 1st
            c.getPA().sendFrame246(8903, 180, 66); // 2nd
            c.getPA().sendFrame246(8904, 180, 9452); // right
            c.getPA().sendFrame246(8905, 180, 22260); // right
            c.getPA().sendString(ItemAssistant.getItemName(68), 8910);
            c.getPA().sendString(ItemAssistant.getItemName(66), 8915);
            c.getPA().sendString(ItemAssistant.getItemName(9452), 8920);
            c.getPA().sendString(ItemAssistant.getItemName(22260), 8925);
            //c.getPA().sendChatInterface(8866);
            //c.getPA().sendString("What would you like to make?", 8879);
            //c.getPA().sendFrame246(8869, 180, 68); // left
           // c.getPA().sendFrame246(8870, 180, 66); // right
            //c.getPA().sendString(ItemAssistant.getItemName(68), 8874);
           // c.getPA().sendString(ItemAssistant.getItemName(66), 8878);
        } else if (item == 1513) {
            c.getPA().sendChatInterface(8899);
            c.getPA().sendString("What would you like to make?", 8926);
            c.getPA().sendFrame246(8902, 180, 72); // 1st
            c.getPA().sendFrame246(8903, 180, 70); // 2nd
            c.getPA().sendFrame246(8904, 180, 21952); // right
            c.getPA().sendFrame246(8905, 180, 22263); // right
            c.getPA().sendString(ItemAssistant.getItemName(72), 8910);
            c.getPA().sendString(ItemAssistant.getItemName(70), 8915);
            c.getPA().sendString(ItemAssistant.getItemName(21952), 8920);
            c.getPA().sendString(ItemAssistant.getItemName(22263), 8925);
            //c.getPA().sendChatInterface(8866);
           // c.getPA().sendString("What would you like to make?", 8879);
          //  c.getPA().sendFrame246(8869, 180, 72); // left
           // c.getPA().sendFrame246(8870, 180, 70); // right
          //  c.getPA().sendString(ItemAssistant.getItemName(72), 8874);
          //  c.getPA().sendString(ItemAssistant.getItemName(70), 8878);
        }
    }

    public static void handleItemOnItem(Player player, int itemUsed, int useWith) {
        if (itemUsed == 946 || useWith == 946) {
            handleLog(player, itemUsed, useWith);
        }
    }
}