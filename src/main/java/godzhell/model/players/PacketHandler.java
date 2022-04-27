package godzhell.model.players;

import godzhell.Config;
import godzhell.model.players.packets.*;
import godzhell.model.players.packets.action.InterfaceAction;
import godzhell.model.players.packets.action.JoinChat;
import godzhell.model.players.packets.action.ReceiveString;
import godzhell.model.players.packets.itemoptions.ItemOptionOne;
import godzhell.model.players.packets.itemoptions.ItemOptionThree;
import godzhell.model.players.packets.itemoptions.ItemOptionTwo;

public class PacketHandler {

	private static PacketType packetId[] = new PacketType[255];
	public static final int OPCODE_OUT_OF_RANGE_SIZE = -5000;

	public static int getPacketSize(int opcode) {
		if (opcode < 0 || opcode >= PACKET_SIZES.length)
			return OPCODE_OUT_OF_RANGE_SIZE;
		return PACKET_SIZES[opcode];
	}
	public static final int PACKET_SIZES[] = {
			0, 0, 0, 1, -1, 0, 0, 0, 4, 0, //0 - 9
			0, 0, 0, 0, 8, 0, 6, 2, 2, 0, //10 - 19
			0, 2, 0, 6, 0, 12, 0, 0, 0, 0, //20 - 29
			0, 0, 0, 0, 0, 8, 4, 0, 0, 2, //30 - 39
			2, 6, 0, 6, 0, -1, 0, 0, 0, 0, //40 - 49
			0, 0, 0, 12, 0, 0, 0, 8, 8, 12, //50 - 59
			8, 8, 0, 0, 0, 0, 0, 0, 0, 0, //60 - 69
			8, 0, 2, 2, 8, 6, 0, -1, 0, 6, //70 - 79
			0, 0, 0, 0, 0, 1, 4, 6, 0, 0, //80 - 89
			0, 0, 0, 0, 0, 3, 0, 0, -1, 0, //90 - 99
			0, 13, 0, -1, 0, 0, 0, 0, 0, 0, //100 - 109
			0, 0, 0, 0, 0, 0, 0, 6, 0, 0, //110 - 119
			1, 0, 6, 0, 16, 0, -1, -1, 2, 6, //120 - 129
			0, 4, 8, 8, 0, 6, 0, 0, 0, 2, //130 - 139
			6, 10, -1, 0, 0, 6, 6, 0, 0, 0, //140 - 149
			0, 0, 1, 2, 0, 2, 6, 0, 0, 0, //150 - 159
			0, 0, 0, 0, -1, -1, 0, 0, 0, 0, //160 - 169
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, //170 - 179
			0, 8, 0, 3, 0, 2, 2, 0, 8, 1, //180 - 189
			0, 0, 12, 0, 0, 0, 0, 0, 0, 0, //190 - 199
			2, 0, 0, 0, 0, 0, 0, 0, 4, 0, //200 - 209
			4, 0, 0, 4, 7, 8, 0, 0, 10, 0, //210 - 219
			0, 0, 0, 0, 0, 0, -1, 0, 8, 0, //220 - 229
			1, 0, 4, 0, 8, 0, 6, 8, 1, 0, //230 - 239
			0, 4, 0, 0, 0, 0, -1, 0, -1, 4, //240 - 249
			0, 0, 8, 6, 0, 0, 0, //250 - 255
	};

	static {
		SilentPacket u = new SilentPacket();
		packetId[3] = u;
		packetId[202] = u;
		packetId[77] = u;
		packetId[86] = u;
		packetId[78] = u;
		packetId[36] = u;
		packetId[226] = u;
		packetId[246] = u;
		packetId[148] = u;
		packetId[183] = u;
		packetId[230] = u;
		packetId[136] = u;
		packetId[189] = u;
		packetId[152] = u;
		packetId[200] = u;
		packetId[85] = u;
		packetId[165] = u;
		packetId[238] = u;
		packetId[150] = u;
		packetId[74] = u;
		packetId[34] = u;
		packetId[68] = u;
		packetId[79] = u;
		//packetId[140] = u;
		// packetId[18] = u;
		packetId[223] = u;
		packetId[8] = new Moderate();
		packetId[142] = new InputField();
		packetId[253] = new ItemOptionTwoGroundItem();
		packetId[218] = new Report();
		packetId[40] = new Dialogue();
		packetId[232] = new OperateItem();
		KeyEventPacketHandler ke = new KeyEventPacketHandler();
		packetId[186] = ke;
		ClickObject co = new ClickObject();
		packetId[132] = co;
		packetId[252] = co;
		packetId[70] = co;
		packetId[234] = co;
		packetId[228] = co;
		packetId[146] = new ObjectExamine();
		packetId[57] = new ItemOnNpc();
		ClickNPC cn = new ClickNPC();
		packetId[72] = cn;
		packetId[131] = cn;
		packetId[155] = cn;
		packetId[17] = cn;
		packetId[21] = cn;
		packetId[18] = cn;
		packetId[124] = new SelectItemOnInterface();
		packetId[16] = new ItemOptionTwo();
		packetId[75] = new ItemOptionThree();
		packetId[122] = new ItemOptionOne();
		packetId[241] = new ClickingInGame();
		packetId[4] = new Chat();
		packetId[236] = new PickupItem();
		packetId[87] = new DropItem();
		packetId[185] = new ClickingButtons();
		packetId[130] = new ClickingStuff();
		packetId[103] = new Commands();
		packetId[214] = new MoveItems();
		packetId[237] = new MagicOnItems();
		packetId[181] = new MagicOnFloorItems();
		packetId[202] = new IdleLogout();
		AttackPlayer ap = new AttackPlayer();
		packetId[73] = ap;
		packetId[249] = ap;
		packetId[128] = new ChallengePlayer();
		packetId[39] = new Trade();
		packetId[139] = new FollowPlayer();
		packetId[41] = new WearItem();
		packetId[145] = new RemoveItem();
		packetId[117] = new Bank5();
		packetId[43] = new Bank10();
		packetId[129] = new BankAll();
		packetId[140] = new BankAllButOne();
		packetId[141] = new BankModifiableX();
		packetId[101] = new ChangeAppearance();
		PrivateMessaging pm = new PrivateMessaging();
		packetId[188] = pm;
		packetId[126] = pm;
		packetId[215] = pm;
		packetId[74] = pm;
		packetId[95] = pm;
		packetId[133] = pm;
		
		packetId[135] = new BankX1();
		packetId[208] = new BankX2();
		Walking w = new Walking();
		packetId[98] = w;
		packetId[164] = w;
		packetId[248] = w;
		packetId[53] = new ItemOnItem();
		packetId[192] = new ItemOnObject();
		packetId[25] = new ItemOptionOneGroundItem();
		@SuppressWarnings("unused")
		ChangeRegions cr = new ChangeRegions();
		packetId[60] = new JoinChat();
		packetId[127] = new ReceiveString();
		packetId[213] = new InterfaceAction();
		packetId[14] = new ItemOnPlayer();
		packetId[121] = new MapRegionFinish();
		packetId[210] = new MapRegionChange();
		packetId[35] = new MagicOnObject();
		MouseMovement ye = new MouseMovement();
		packetId[187] = ye;

	}
		public static void main(String...args) {
		int last = 0;
		for (int index = 0; index < PACKET_SIZES.length; index++) {
			if (index % 10 == 0 && index != 0) {
				System.out.print("//" + last + " - " + (index - 1));
				System.out.println();
				last = index;
			}
			System.out.print(PACKET_SIZES[index] + ", ");
			if (index == PACKET_SIZES.length - 1) {
				System.out.print("//" + last + " - " + (index - 1));
			}
		}
	}
	public static void processPacket(Player c, int packetType, int packetSize) {
		PacketType p = packetId[packetType];
		if (p != null && packetType > 0 && packetType < 258 && packetType == c.packetType && packetSize == c.packetSize) {
			if (Config.sendServerPackets && c.getRights().isOrInherits(Right.OWNER)) {
				c.sendMessage("PacketType: " + packetType + ". PacketSize: " + packetSize + ".");
			}
			if (c.sendServerPackets && c.getRights().isOrInherits(Right.OWNER)) {
				c.sendMessage("PacketType: " + packetType + ". PacketSize: " + packetSize + ".");
			}
			
			try {
				p.processPacket(c, packetType, packetSize);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			c.disconnected = true;
			System.out.println(c.playerName + " is sending invalid PacketType: " + packetType + ". PacketSize: " + packetSize);
		}
	}
}