package godzhell.model.players.packets;

import godzhell.definitions.NPCCacheDefinition;
import godzhell.model.npcs.NpcExamines;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

public class NpcExamine implements PacketType {

    @Override
    public void processPacket(Player c, int packetType, int packetSize) {
        final int npcId = c.getInStream().readUnsignedWord();
        final int index = c.getInStream().readUnsignedWord();
        if (c.debugMessage) {
            c.sendMessage("Item examine: " + npcId + " slot: " + index);
        }
        final NPCCacheDefinition definition = NPCCacheDefinition.forID(npcId);
        NpcExamines description = NpcExamines.forId(npcId);
        if (description != null) {
            String examine = description.getName();
            c.sendMessage(examine);
                if(c.debugMessage) {
                    c.sendMessage("Item id: " + npcId + " Needs a examine.");
                }
            } else {
            NPCCacheDefinition cacheDefinition = NPCCacheDefinition.forID(npcId);
                c.sendMessage("Its a " + cacheDefinition.getName() + ".");
        }

    }
}
