package godzhell.model.tools;

import godzhell.definitions.NPCCacheDefinition;
import godzhell.model.npcs.NPCHandler;

public class SpawnDumper {


	public static void main(String[] args) {
		NPCCacheDefinition.unpackConfig();
		NPCHandler.Dumpspawns();

	}

}
