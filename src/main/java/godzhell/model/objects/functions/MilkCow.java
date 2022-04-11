package godzhell.model.objects.functions;

import godzhell.model.players.Player;

public class MilkCow {

	public static void milkCow(final Player player) {
		if (!player.getItems().playerHasItem(1925, 1)) {
			player.sendMessage("You need a bucket in order to milk this cow.");
			return;
		}
		player.startAnimation(2305);
		player.getItems().deleteItem2(1925, 1);
		player.getItems().addItem(1927, 1);
		player.sendMessage("You milk the cow.");
	}
}

