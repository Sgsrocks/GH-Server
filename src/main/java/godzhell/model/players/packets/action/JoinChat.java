package godzhell.model.players.packets.action;

import godzhell.Server;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.content.skills.construction.House;
import godzhell.util.Misc;
import godzhell.world.Clan;

public class JoinChat implements PacketType {

	@Override
	public void processPacket(Player player, int packetType, int packetSize) {
		String owner = Misc.longToPlayerName2(player.getInStream().readLong()).replaceAll("_", " ");
		
		if (player.documentGraphic) {
			player.sendMessage("Test: " + owner);
			
			return;
		}
		switch (player.inputData[0]) {
		case 0:
			if (owner != null && owner.length() > 0) {
				if (player.clan == null) {
					/*
					 * if (player.inArdiCC) { return; }
					 */
					Clan clan = Server.clanManager.getClan(owner);
					if (clan != null) {
						clan.addMember(player);
					} else if (owner.equalsIgnoreCase(player.playerName)) {
						Server.clanManager.create(player);
					} else {
						player.sendMessage(Misc.formatPlayerName(owner) + " has not created a clan yet.");
					}
					player.getPA().refreshSkill(21);
					player.getPA().refreshSkill(22);
					player.getPA().refreshSkill(23);
				}
			}
			break;
		case 1: // construction join
			Player toJoin = null;

			for (Player player1 : PlayerHandler.players) {
				if (player != null && player.playerName.equalsIgnoreCase(owner)) {
					toJoin = player1;
					break;
				}
			}

			if (toJoin == null) {
				player.sendMessage("That player is not online.");
				return;
			}
			
			if (toJoin.getHouse() == null || !toJoin.getHouse().getOwner().equals(toJoin)) {
				player.sendMessage(Misc.formatPlayerName(toJoin.playerName) + " does not appear to be home.");
				return;
			}

			House house = toJoin.getHouse();
			player.setHouse(house);
			house.enter(player);
			break;
		default:
			player.sendMessage("Unhandled text input id: " + player.inputData[0]);
			break;
		}
		player.inputData[0] = 0;
	}

}