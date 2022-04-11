package godzhell.model.players.packets;

import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

/**
 * Change appearance
 **/
public class ChangeAppearance implements PacketType {

	private static final int[][] MALE_VALUES = {{0, 8}, // head
			{10, 17}, // jaw
			{18, 25}, // torso
			{26, 31}, // arms
			{33, 34}, // hands
			{36, 40}, // legs
			{42, 43}, // feet
	};

	private static final int[][] FEMALE_VALUES = {{45, 54}, // head
			{-1, -1}, // jaw
			{56, 60}, // torso
			{61, 65}, // arms
			{67, 68}, // hands
			{70, 77}, // legs
			{79, 80}, // feet
	};

	private static final int[][] ALLOWED_COLORS = {{0, 11}, // hair color
			{0, 15}, // torso color
			{0, 15}, // legs color
			{0, 5}, // feet color
			{0, 7} // skin color
	};

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		int gender = c.getInStream().readSignedByte();
		int head = c.getInStream().readSignedByte();
		int jaw = c.getInStream().readSignedByte();
		int torso = c.getInStream().readSignedByte();
		int arms = c.getInStream().readSignedByte();
		int hands = c.getInStream().readSignedByte();
		int legs = c.getInStream().readSignedByte();
		int feet = c.getInStream().readSignedByte();
		int hairColour = c.getInStream().readSignedByte();
		int torsoColour = c.getInStream().readSignedByte();
		int legsColour = c.getInStream().readSignedByte();
		int feetColour = c.getInStream().readSignedByte();
		int skinColour = c.getInStream().readSignedByte();

		if (c.canChangeAppearance) {


			c.playerAppearance[0] = gender; // gender
			c.playerAppearance[6] = feet; // feet
			c.playerAppearance[7] = jaw; // beard
			c.playerAppearance[8] = hairColour; // hair colour
			c.playerAppearance[9] = torsoColour; // torso colour
			c.playerAppearance[10] = legsColour; // legs colour
			c.playerAppearance[11] = feetColour; // feet colour
			c.playerAppearance[12] = skinColour; // skin colour
			if (head < 0) // head
				c.playerAppearance[1] = head + 256;
			else
				c.playerAppearance[1] = head;
			if (torso < 0)
				c.playerAppearance[2] = torso + 256;
			else
				c.playerAppearance[2] = torso;
			if (arms < 0)
				c.playerAppearance[3] = arms + 256;
			else
				c.playerAppearance[3] = arms;
			if (hands < 0)
				c.playerAppearance[4] = hands + 256;
			else
				c.playerAppearance[4] = hands;
			if (legs < 0)
				c.playerAppearance[5] = legs + 256;
			else
				c.playerAppearance[5] = legs;

			c.getPA().removeAllWindows();
			c.getPA().requestUpdates();
			c.canChangeAppearance = false;


		}
	}
}
