package godzhell.definitions;

import godzhell.util.Stream;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * A class that loads & manages NPC configurations. 
 * 
 * <p>An <code>NPCDefinition</code> is a component of the NPC configuration file
 * that defines several aspects of the NPC (such as models, model colors, animations, 
 * name, description, and combat level). We use these definitions both client and server-
 * sided in order to display information on the client and pull data when necessary
 * server-sided (i.e. - for combat formulas). </p>  
 * @author Craze/Warren
 * @date Sep 20, 2015 5:13:47 PM

 */
public class AnimationDefinition {
	
	/**
	 * Represents the total whole number integer of Items.
	 */
	public static int AMIN_TOTAL = 8532;
	
	/**
	 * Unpacks the Item configurations.
	 */
    /**
     * Represents an array of {@link NPCCacheDefinition}s.
     */
    public static AnimationDefinition[] definitions = new AnimationDefinition[AMIN_TOTAL];

	/**
	 * Gets all definitions in the form of an array.
	 * @return	definitions	the {@link NPCCacheDefinition} in array form
	 */
	public static AnimationDefinition[] getDefinitions() {
		return definitions;
	}
    public static final void unpackConfig() {
    	try {
    	Stream buffer = new Stream(FileUtils.readFileToByteArray(new File("./Data/cache/seq.dat")));
		final int length = buffer.readUnsignedWord();

		if (animations == null) {
			animations = new AnimationDefinition[length];
		}

		for (int i = 0; i < length; i++) {
			if (animations[i] == null) {
				animations[i] = new AnimationDefinition();
			}

			animations[i].decode(buffer);
		}
        System.out.println("Successfully loaded: " + length + " Animation Cache definitions.");
    	} catch (Exception e) {
    		System.err.println("An error has occurred whilst loading Animation definitions!");
    		e.printStackTrace();
    	}
    }
    
	private void decode(Stream buffer) {
		while(true) {
			final int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				break;
			} else if (opcode == 1) {
				frameCount = buffer.readUnsignedWord();
				primaryFrames = new int[frameCount];
				secondaryFrames = new int[frameCount];
				durations = new int[frameCount];

				for (int i = 0; i < frameCount; i++) {
					durations[i] = buffer.readUnsignedWord();
				}

				for (int i = 0; i < frameCount; i++) {
					primaryFrames[i] = buffer.readUnsignedWord();
					secondaryFrames[i] = -1;
				}

				for (int i = 0; i < frameCount; i++) {
					primaryFrames[i] += buffer.readUnsignedWord() << 16;
				}

			} else if (opcode == 2) {
				loopOffset = buffer.readUnsignedWord();
			} else if (opcode == 3) {
				int len = buffer.readUnsignedByte();
				interleaveOrder = new int[len + 1];
				for (int i = 0; i < len; i++) {
					interleaveOrder[i] = buffer.readUnsignedByte();
				}
				interleaveOrder[len] = 9999999;
			} else if (opcode == 4) {
				stretches = true;
			} else if (opcode == 5) {
				forcedPriority = buffer.readUnsignedByte();
			} else if (opcode == 6) {
				playerOffhand = buffer.readUnsignedWord();
			} else if (opcode == 7) {
				playerMainhand = buffer.readUnsignedWord();
			} else if (opcode == 8) {
				maxLoops = buffer.readUnsignedByte();
			} else if (opcode == 9) {
				animatingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 10) {
				walkingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 11) {
				replayMode = buffer.readUnsignedByte();
			} else if (opcode == 12) {
				int len = buffer.readUnsignedByte();

				for (int i = 0; i < len; i++) {
					buffer.readUnsignedWord();
				}

				for (int i = 0; i < len; i++) {
					buffer.readUnsignedWord();
				}
			} else if (opcode == 13) {
				int len = buffer.readUnsignedByte();

				for (int i = 0; i < len; i++) {
					buffer.read24Int();
				}
			} else if (opcode == 14) {
				skeletalId = buffer.readInt();
			} else if (opcode == 15) {
				int count = buffer.readUnsignedWord();
				skeletalsoundEffect = new int[count];
				skeletalsoundRange = new int[count];
				for (int index = 0; index < count; ++index) {
					skeletalsoundEffect[index] = buffer.readUnsignedWord();
					skeletalsoundRange[index] = buffer.read24Int();
				}
			} else if (opcode == 16) {
				skeletalRangeBegin = buffer.readUnsignedWord();
				skeletalRangeEnd = buffer.readUnsignedWord();
			} else if (opcode == 17) {
				int count = buffer.readUnsignedByte();
				unknown = new int[count];
				for (int index = 0; index < count; ++index) {
					unknown[index] = buffer.readUnsignedByte();
				}
			}
		}

		if (frameCount == 0) {
			frameCount = 1;
			primaryFrames = new int[1];
			primaryFrames[0] = -1;
			secondaryFrames = new int[1];
			secondaryFrames[0] = -1;
			durations = new int[1];
			durations[0] = -1;
		}

		if (animatingPrecedence == -1) {
			animatingPrecedence = (interleaveOrder == null) ? 0 : 2;
		}

		if (walkingPrecedence == -1) {
			walkingPrecedence = (interleaveOrder == null) ? 0 : 2;
		}
	}

	private AnimationDefinition() {
		animatingPrecedence = -1; //Stops character from moving
		walkingPrecedence = -1;
		replayMode = 1;
	}
    /**
     * Gets the NPC's stand index.
     * @return
     */
    public int getframeCount() {
    	return frameCount;
    }
		public static AnimationDefinition animations[];
		public int frameCount;
		public int primaryFrames[];
		public int secondaryFrames[];
		public int[] durations;
		public int loopOffset = -1;
		public int interleaveOrder[];
		public boolean stretches;
		public int forcedPriority = 5;
		public int playerOffhand = -1;
		public int playerMainhand = -1;
		public int maxLoops = 99;
		public int animatingPrecedence;
		public int walkingPrecedence;
		public int replayMode;
	private int skeletalRangeBegin = -1;
	private int skeletalRangeEnd = -1;
	private int skeletalId = -1;
	private int[] skeletalsoundEffect;
	private int[] unknown;
	private int[] skeletalsoundRange;
}