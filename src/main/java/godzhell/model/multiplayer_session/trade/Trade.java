package godzhell.model.multiplayer_session.trade;

import java.util.Arrays;
import java.util.Objects;

import godzhell.Server;
import godzhell.model.minigames.pest_control.PestControl;
import godzhell.model.multiplayer_session.Multiplayer;
import godzhell.model.multiplayer_session.MultiplayerSession;
import godzhell.model.multiplayer_session.MultiplayerSessionStage;
import godzhell.model.multiplayer_session.MultiplayerSessionType;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;

public class Trade extends Multiplayer {

	public Trade(Player player) {
		super(player);
	}

	@Override
	public boolean requestable(Player requested) {
		if (requested == null) {
			player.sendMessage("The requested player cannot be found.");
			return false;
		}
		if (player.viewingLootBag || player.addingItemsToLootBag ||
			requested.viewingLootBag || requested.addingItemsToLootBag) {
			return false;
		}
		if (!player.getMode().isTradingPermitted()) {
			player.sendMessage("You are not permitted to trade other players.");
			return false;
		}
		if (!requested.getMode().isTradingPermitted()) {
			player.sendMessage("That player is on a game mode that restricts trading.");
			return false;
		}
		if (player.playTime < (3000)) {
			player.sendMessage("You cannot request a trade, you must play for at least 30 minutes.");
			return false;
		}
		if (requested.playTime < (3000)) {
			player.sendMessage("You cannot trade this player, they have not played for 30 minutes.");
			return false;
		}
		if (Server.getMultiplayerSessionListener().requestAvailable(requested, player, MultiplayerSessionType.TRADE) != null) {
			player.sendMessage("You have already sent a request to this player.");
			return false;
		}
		if (player.getBH().hasTarget() && player.getBH().getTarget() != null && player.getBH().getTarget().getName() != null) {
			if (player.getBH().getTarget().getName().equalsIgnoreCase(requested.playerName)) {
				player.sendMessage("You cannot trade your bounty hunter target.");
				return false;
			}
		}
		if (Objects.equals(player, requested)) {
			player.sendMessage("You cannot trade yourself.");
			return false;
		}
		if (Server.getMultiplayerSessionListener().inAnySession(player)) {
			player.sendMessage("You cannot request a trade whilst in a session.");
			return false;
		}
		if (Server.getMultiplayerSessionListener().inAnySession(requested)) {
			player.sendMessage("This player is currently is a session with another player.");
			return false;
		}
		if (player.teleTimer > 0 || requested.teleTimer > 0) {
			player.sendMessage("You cannot request or accept whilst you, or the other player are teleporting.");
			return false;
		}
		if (Boundary.isIn(player, PestControl.GAME_BOUNDARY) || Boundary.isIn(requested, PestControl.GAME_BOUNDARY)) {
			player.sendMessage("You cannot trade in the pest control minigame.");
			return false;
		}
		return true;
	}

	@Override
	public void request(Player requested) {
		if (Objects.isNull(requested)) {
			player.sendMessage("The player cannot be found, try again shortly.");
			return;
		}
		if (Objects.equals(player, requested)) {
			player.sendMessage("You cannot trade yourself.");
			return;
		}
		player.faceUpdate(requested.getIndex());
		MultiplayerSession session = Server.getMultiplayerSessionListener().requestAvailable(player, requested, MultiplayerSessionType.TRADE);
		if (session != null) {
			session.getStage().setStage(MultiplayerSessionStage.OFFER_ITEMS);
			session.populatePresetItems();
			session.updateMainComponent();
			Server.getMultiplayerSessionListener().removeOldRequests(player);
			Server.getMultiplayerSessionListener().removeOldRequests(requested);
			session.getStage().setAttachment(null);
		} else {
			session = new TradeSession(Arrays.asList(player, requested), MultiplayerSessionType.TRADE);
			if (Server.getMultiplayerSessionListener().appendable(session)) {
				player.sendMessage("Sending trade offer...");
				requested.sendMessage(player.playerName + ":tradereq:");
				session.getStage().setAttachment(player);
				Server.getMultiplayerSessionListener().add(session);
			}
		}
	}

}
