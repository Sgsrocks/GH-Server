package godzhell.model.players.packets;

import godzhell.Server;
import godzhell.model.content.random.PartyRoom;
import godzhell.model.content.skills.crafting.JewelryMaking;
import godzhell.model.content.skills.smithing.Smithing;
import godzhell.model.content.tradingpost.Listing;
import godzhell.model.items.GameItem;
import godzhell.model.multiplayer_session.MultiplayerSession;
import godzhell.model.multiplayer_session.MultiplayerSessionFinalizeType;
import godzhell.model.multiplayer_session.MultiplayerSessionStage;
import godzhell.model.multiplayer_session.MultiplayerSessionType;
import godzhell.model.multiplayer_session.duel.DuelSession;
import godzhell.model.multiplayer_session.trade.TradeSession;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

import java.util.Objects;

/**
 * Remove Item
 **/
public class RemoveItem implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		int interfaceId = c.getInStream().readUnsignedWordA();
		int removeSlot = c.getInStream().readUnsignedWordA();
		int removeId = c.getInStream().readUnsignedWordA();
		
		if (c.viewingLootBag || c.addingItemsToLootBag) {
			if (c.getLootingBag().handleClickItem(removeId, 1)) {
				return;
			}
		}
		if (c.getRunePouch().handleClickItem(removeId, 1, interfaceId)) {
			return;
		}
		if (c.getInterfaceEvent().isActive()) {
			c.sendMessage("Please finish what you're doing.");
			return;
		}
		if (c.debugMessage)
			c.sendMessage("Bank 1: interfaceid: "+interfaceId+", removeSlot: "+removeSlot+", removeID: " + removeId);
		
		switch (interfaceId) {
			case 41609:
				switch(c.boxCurrentlyUsing) {
					case 28826: //ultra rare
						c.getUltraMysteryBox().reward();
						break;
					case 28822:
						c.getUncommonMysteryBox().reward();
						break;

					case 28964:
						//c.getRareKey().reward();
						break;
					case 29326:
						c.getDrCapeMysteryBox().reward();
						break;
					case 28823:
						c.getCommonMysteryBox().reward();
						break;
					case 28824:
						c.getRareMysteryBox().reward();
						break;
					case 28825:
						c.getSuperRareMysteryBox().reward();
						break;
					case 6199:
						c.getMysteryBox().reward();
						break;
				}
				break;
		case 48021:
			Listing.buyListing(c, removeSlot, 1);
		break;
		
		case 48847:
			Listing.cancelListing(c, removeSlot, removeId);
		break;
		
		case 48500: //Listing interface
			if(c.isListing) {
				Listing.openSelectedItem(c, removeId, 1, 0);
			}
		break;
		
		case 35007:
			c.getSafeBox().withdraw(removeId, c.getItems().isStackable(removeId) ? 10000000 : 1);
			break;

			case 7423:
				if (Server.getMultiplayerSessionListener().inSession(c, MultiplayerSessionType.TRADE)) {
					Server.getMultiplayerSessionListener().finish(c, MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
					c.sendMessage("You cannot add items to the deposit box whilst trading.");
					return;
				}
				c.getItems().addToBank(removeId, 1, true);
				c.getItems().resetItems(7423);
				break;
		case 4233:
		case 4239:
		case 4245:
			JewelryMaking.mouldItem(c, removeId, 1);
			break;
		case 1688:
			if (Server.getMultiplayerSessionListener().inSession(c, MultiplayerSessionType.TRADE)) {
				Server.getMultiplayerSessionListener().getMultiplayerSession(c, MultiplayerSessionType.TRADE).finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				c.sendMessage("You cannot remove items whilst trading, trade declined.");
				return;
			}
			DuelSession duelSession = (DuelSession) Server.getMultiplayerSessionListener().getMultiplayerSession(c, MultiplayerSessionType.DUEL);
			if (Objects.nonNull(duelSession) && duelSession.getStage().getStage() > MultiplayerSessionStage.REQUEST
					&& duelSession.getStage().getStage() < MultiplayerSessionStage.FURTHER_INTERATION) {
				c.sendMessage("Your actions have declined the duel.");
				duelSession.getOther(c).sendMessage("The challenger has declined the duel.");
				duelSession.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				return;
			}
			c.getItems().removeItem(removeId, removeSlot);
			break;

		case 5064:
			if (c.inPartyRoom) {
				PartyRoom.depositItem(c, removeId, 1);
			} 
			if (Server.getMultiplayerSessionListener().inSession(c, MultiplayerSessionType.TRADE)) {
				Server.getMultiplayerSessionListener().finish(c, MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				c.sendMessage("You cannot add items to the bank whilst trading.");
				return;
			}
			duelSession = (DuelSession) Server.getMultiplayerSessionListener().getMultiplayerSession(c, MultiplayerSessionType.DUEL);
			if (Objects.nonNull(duelSession) && duelSession.getStage().getStage() > MultiplayerSessionStage.REQUEST
					&& duelSession.getStage().getStage() < MultiplayerSessionStage.FURTHER_INTERATION) {
				c.sendMessage("You have declined the duel.");
				duelSession.getOther(c).sendMessage("The challenger has declined the duel.");
				duelSession.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				return;
			}
			if (c.isBanking) {
				c.getItems().addToBank(removeId, 1, true);
			}
			if (c.inSafeBox) {
				if (!c.pkDistrict && removeId != 13307) {
					c.sendMessage("You cannot do this right now.");
					return;
				}
				c.getSafeBox().deposit(removeId, 1);
			}
			break;
		case 5382:
			if (Server.getMultiplayerSessionListener().inSession(c, MultiplayerSessionType.TRADE)) {
				Server.getMultiplayerSessionListener().finish(c, MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				c.sendMessage("You cannot remove items from the bank whilst trading.");
				return;
			}
			duelSession = (DuelSession) Server.getMultiplayerSessionListener().getMultiplayerSession(c, MultiplayerSessionType.DUEL);
			if (Objects.nonNull(duelSession) && duelSession.getStage().getStage() > MultiplayerSessionStage.REQUEST
					&& duelSession.getStage().getStage() < MultiplayerSessionStage.FURTHER_INTERATION) {
				c.sendMessage("You have declined the duel.");
				duelSession.getOther(c).sendMessage("The challenger has declined the duel.");
				duelSession.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				return;
			}
			if (c.getBank().getBankSearch().isSearching()) {
				
				c.getBank().getBankSearch().removeItem(removeId, 1);
				return;
			}
			c.getItems().removeFromBank(removeId, 1, true);
			break;
			
			/**
			 * Shop value
			 */
			
		case 64016:
			c.getShops().buyFromShopPrice(removeId, removeSlot);
			break;

		case 3900:
			c.getShops().buyFromShopPrice(removeId, removeSlot);
			break;

		case 3823:
			c.getShops().sellToShopPrice(removeId, removeSlot);
			break;

		case 3322:
			MultiplayerSession session = Server.getMultiplayerSessionListener().getMultiplayerSession(c);
			if (Objects.isNull(session)) {
				return;
			}
			if (session instanceof TradeSession || session instanceof DuelSession) {
				session.addItem(c, new GameItem(removeId, 1));
			}
			break;

		case 3415:
			session = Server.getMultiplayerSessionListener().getMultiplayerSession(c);
			if (Objects.isNull(session)) {
				return;
			}
			if (session instanceof TradeSession) {
				session.removeItem(c, removeSlot, new GameItem(removeId, 1));
			}
			break;

		case 6669:
			session = Server.getMultiplayerSessionListener().getMultiplayerSession(c);
			if (Objects.isNull(session)) {
				return;
			}
			if (session instanceof DuelSession) {
				session.removeItem(c, removeSlot, new GameItem(removeId, 1));
			}
			break;

		case 1119:
		case 1120:
		case 1121:
		case 1122:
		case 1123:
			Smithing.readInput(c.playerLevel[Player.playerSmithing], Integer.toString(removeId), c, 1);
			break;

		}
	}

}
