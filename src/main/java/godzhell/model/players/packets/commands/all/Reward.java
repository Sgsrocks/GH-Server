package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Auto Donation System / https://EverythingRS.com
 * @author Genesis
 *
 */

public class Reward extends Command {

	@Override
	public void execute(Player c, String input) {
		String[] args = input.split(" ");
		if (args.length == 1) {
			c.sendMessage("Please use [::reward id], [::reward id amount], or [::reward id all].");
			return;
		}
		final String playerName = c.playerName;
		final String id = args[1];
		final String amount = args.length == 3 ? args[2] : "1";

		com.everythingrs.vote.Vote.service.execute(new Runnable() {
			@Override
			public void run() {
				try {
					com.everythingrs.vote.Vote[] reward = com.everythingrs.vote.Vote.reward("A19JQmXq7mImMgdLZmIdTCZrOCmG4Q2uLIqXEYqsSYSRZXwH3w9hxmkNseO3s9QapC3CzV4f",
							playerName, id, amount);
					if (reward[0].message != null) {
						c.sendMessage(reward[0].message);
						return;
					}
					c.getItems().addItem(reward[0].reward_id, reward[0].give_amount);
					c.sendMessage(
							"Thank you for voting! You now have " + reward[0].vote_points + " vote points.");
				} catch (Exception e) {
					c.sendMessage("Api Services are currently offline. Please check back shortly");
					e.printStackTrace();
				}

			}
		});
	}
}