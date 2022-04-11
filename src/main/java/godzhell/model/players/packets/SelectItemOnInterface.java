package godzhell.model.players.packets;

import godzhell.model.content.presets.Preset;
import godzhell.model.content.presets.PresetSlotAction;
import godzhell.model.content.presets.PresetType;
import godzhell.model.items.GameItem;
import godzhell.model.items.ItemDefinition;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

/**
 * @author Jason MacKeigan
 * @date Dec 29, 2014, 1:12:35 PM
 */
public class SelectItemOnInterface implements PacketType {

	@Override
	public void processPacket(Player player, int packetType, int packetSize) {
		int interfaceId = player.getInStream().readInteger();
		@SuppressWarnings("unused")
		int slot = player.getInStream().readInteger();
		int itemId = player.getInStream().readInteger();
		int itemAmount = player.getInStream().readInteger();
		PresetType type = player.getPresets().getCurrent().getEditingType();
		Preset preset = player.getPresets().getCurrent();
		GameItem item = new GameItem(itemId, itemAmount);
		
		switch (interfaceId) {
		/*Apparent Dupe Fix
		case 62011:
			player.sendMessage("Spawned x" + itemAmount + " of " + ItemAssistant.getItemName(itemId) + ", ID: " + itemId);
			player.getItems().addItem(itemId, itemAmount);
			break;*/
		
		case 32011:
				if (type.isEquipment()) {
					ItemDefinition itemDefinition = ItemDefinition.forId(itemId);
					if (itemDefinition != null) {
						int equipmentSlot = PresetSlotAction.getEquipmentSlot(type, preset.getSelectedSlot());
						if (!itemDefinition.isWearable()) {
							player.sendMessage("This item cannot be worn.");
							return;
						}
						if (itemDefinition.getSlot() != equipmentSlot) {
							player.sendMessage("This item cannot be inserted into this equipment slot.");
							return;
						}
					} else {
						player.sendMessage("This item is currently unavailable.");
						return;
					}
					preset.getEquipment().add(player, preset.getSelectedSlot(), item);
				} else if (type.isInventory()) {
					preset.getInventory().add(player, preset.getSelectedSlot(), item);
				}
				player.getPresets().hideSearch();
			break;
		}
	}

}
