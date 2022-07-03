package godzhell.model.players.packets;

import godzhell.definitions.ItemCacheDefinition;
import godzhell.model.items.Item;
import godzhell.model.items.ItemExamines;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.util.Misc;

public class ItemExamine implements PacketType {

    @Override
    public void processPacket(Player c, int packetType, int packetSize) {
        final int itemId = c.getInStream().readUnsignedWord();
        final int slot = c.getInStream().readUnsignedWord();
        final int interfaceId = c.getInStream().readUnsignedWord();
        if (c.debugMessage) {
            c.sendMessage("Item examine: " + itemId + " slot: " + slot + " interfaceId: " + interfaceId);
        }
        final ItemCacheDefinition definition = ItemCacheDefinition.forID(itemId);
        ItemExamines description = ItemExamines.forId(itemId);
        if (description != null) {
            String examine = description.getName();
            if (c.getItems().getItemAmount(itemId) >= 100000) {
                c.sendMessage(Misc.insertCommas(Integer.toString(c.getItems().getItemAmount(itemId))) + " x " + definition.getName() + ".");
            } else {
                if (!Item.itemIsNote[itemId]) {
                    c.sendMessage(examine);
                } else {
                    c.sendMessage("Swap this note at any bank for a " + definition.name + ".");
                }
                c.sendMessage("Price of @blu@" + definition.getName() + "@bla@: Shop price: @blu@" + definition.getvalue() + "@bla@ HA value @blu@" + definition.getvalue() * 0.6);
                c.sendMessage("@bla@LA value @blu@" + definition.getvalue() * 0.4);
            }
            if (c.debugMessage) {
                c.sendMessage("Item id: " + itemId + " Needs a examine.");
            }
        } else {
            if (!Item.itemIsNote[itemId]) {
                c.sendMessage("Its a " + definition.name + ".");
            } else {
                c.sendMessage("Swap this note at any bank for a " + definition.name + ".");
            }
        }

    }


}
