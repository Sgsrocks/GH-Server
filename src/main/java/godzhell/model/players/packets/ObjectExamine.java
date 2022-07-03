package godzhell.model.players.packets;

import godzhell.clip.ObjectDef;
import godzhell.clip.Region;
import godzhell.model.objects.ObjectExamines;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.model.players.Position;
import godzhell.model.players.Right;

public class ObjectExamine implements PacketType {

    @Override
    public void processPacket(Player c, int packetType, int packetSize) {
        final int x = c.getInStream().readSignedWordBigEndianA();
        final int id = c.getInStream().readUnsignedWord();
        final int y = c.getInStream().readUnsignedWordA();
        final Position position = new Position(x, y, c.getHeight());
        if (c.debugMessage) {
            c.sendMessage("Object Examine: " + id + " objectX: " + x + " objectY: " + y);
        }
        if (!Region.objectExists(id, x, y, c.getHeight())) {
            return;
        }

        ObjectExamines description = ObjectExamines.forId(id);
        if (description != null) {
            String examine = description.getName();
            c.sendMessage(examine);
        } else {
            if (c.getRights().contains(Right.OWNER)) {
                c.sendMessage("Object id: "+id+" Needs a examine.");
            } else {
                ObjectDef cacheDefinition = ObjectDef.getObjectDef(id);
                c.sendMessage("Its a " + cacheDefinition.name + ".");
            }
        }
    }
}
