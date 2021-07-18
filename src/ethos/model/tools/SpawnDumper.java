package ethos.model.tools;

import ethos.definitions.NPCCacheDefinition;
import ethos.model.npcs.NPCHandler;

public class SpawnDumper {


	public static void main(String[] args) {
		NPCCacheDefinition.unpackConfig();
		NPCHandler.Dumpspawns();

	}

}
