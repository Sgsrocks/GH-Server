package ethos.model.players.packets;

import ethos.model.players.PacketType;
import ethos.model.players.Player;

public class BankModifiableX implements PacketType {

	@Override
	public void processPacket(Player player, int packetType, int packetSize) {
		int slot = player.getInStream().readUnsignedWordA();
		int component = player.getInStream().readUnsignedWord();
		int item = player.getInStream().readUnsignedWordA();
		int amount = player.getInStream().readInteger();
		if (player.debugMessage) {
			player.sendMessage("Bank ModifiableX: removeSlot: "+slot+", item: " + item+", amount: "+amount);
			player.sendMessage("interface: " + component);
		}
			
		if (player.getInterfaceEvent().isActive()) {
			player.sendMessage("Please finish what you're doing.");
			return;
		}
		if (amount <= 0)
			return;
		switch (component) {
		case 5382: //bank (withdraw)
			if (player.getBank().getBankSearch().isSearching()) {
				player.getBank().getBankSearch().removeItem(item, amount);
				return;
			}
			player.getItems().removeFromBank(item, amount, true);
			break;
			
		case 5064: //bank (deposit)
			player.getItems().addToBank(item, amount, true);
			break;
			
		case 64016: //shop (buying)
			if(player.inWild() || player.inClanWars()) { //Fix wildy resource zone here inwild() && !inwildyzone
				return;
			}
			if (amount > 10000) {
				player.sendMessage("You can only buy 10,000 items at a time.");
				amount = 10000;
			}
			player.getShops().buyItem(item, slot, amount);// buy X
			player.xRemoveSlot = 0;
			player.xInterfaceId = 0;
			player.xRemoveId = 0;
			break;
		
		
		case 3823: //inv (selling)
			if(player.inWild() || player.inClanWars()) {
				return;
			}
			player.getShops().sellItem(item, slot, amount);// sell X
			player.xRemoveSlot = 0;
			player.xInterfaceId = 0;
			player.xRemoveId = 0;
			break;
		}
	}

}
