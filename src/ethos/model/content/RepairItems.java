package ethos.model.content;

import ethos.model.players.Player;

public class RepairItems {
	public static enum armourData {
		DHAROKS_HELM_0(4884, 4716, 60000),
		DHAROKS_HELM_25(4883, 4716, 15000),
		DHAROKS_HELM_50(4882, 4716, 30000),
		DHAROKS_HELM_75(4881, 4716, 45000),
		DHAROKS_HELM_100(4880, 4716, 60000);
		
		private int repair, fixed, price;
		
		private armourData(final int repair, final int fixed, final int price) {
			this.repair = repair;
			this.fixed = fixed;
			this.price = price;
		}
		
		public int getRepair(final int id) {
			return repair;
		}
		
		public int getFixed(final int id) {
			return fixed;
		}
		public int getPrice(final int id) {
			return price;
		}
	}
	
	public static void repairItems(Player c, int itemId) {
		for(final armourData d : armourData.values()) {
		if(c.getItems().playerHasItem(995, d.getPrice(itemId))) {
				if(itemId == d.getRepair(itemId)) {
					c.getItems().deleteItem(995, d.getPrice(itemId));
					c.getItems().deleteItem(itemId, 1);
					c.getItems().addItem(d.getFixed(itemId), 1);
					c.sendMessage("You repair the "+c.getItems().getItemName(d.getFixed(itemId))+".");
				}
		} else {
			c.sendMessage("You need "+d.getPrice(itemId)+" coins the repair the item.");
		}
	}
	}
}
