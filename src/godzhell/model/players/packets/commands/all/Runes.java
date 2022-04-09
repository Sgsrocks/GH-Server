package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.util.ItemID;

public class Runes extends Command {
    @Override
    public void execute(Player c, String input) {
        if(c.getItems().hasFreeSlots(15)) {
            c.getItems().addItem(ItemID.FIRE_RUNE, 100);
            c.getItems().addItem(ItemID.WATER_RUNE, 100);
            c.getItems().addItem(ItemID.AIR_RUNE, 100);
            c.getItems().addItem(ItemID.EARTH_RUNE, 100);
            c.getItems().addItem(ItemID.MIND_RUNE, 100);
            c.getItems().addItem(ItemID.BODY_RUNE, 100);
            c.getItems().addItem(ItemID.DEATH_RUNE, 100);
            c.getItems().addItem(ItemID.NATURE_RUNE, 100);
            c.getItems().addItem(ItemID.CHAOS_RUNE, 100);
            c.getItems().addItem(ItemID.LAW_RUNE, 100);
            c.getItems().addItem(ItemID.COSMIC_RUNE, 100);
            c.getItems().addItem(ItemID.BLOOD_RUNE, 100);
            c.getItems().addItem(ItemID.SOUL_RUNE, 100);
            c.getItems().addItem(ItemID.ASTRAL_RUNE, 100);
            c.getItems().addItem(ItemID.WRATH_RUNE, 100);
            c.sendMessage("Have some runes.");
        } else {
            c.sendMessage("You need 15 free slots to do this command.");
        }
    }
}
