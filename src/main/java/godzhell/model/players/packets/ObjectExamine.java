package godzhell.model.players.packets;

import godzhell.clip.ObjectDef;
import godzhell.clip.Region;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.model.players.Position;

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
        if(!Region.objectExists(id, x, y, c.getHeight())) {
            return;
        }
        ObjectDef def = ObjectDef.getObjectDef(id);
        c.sendMessage("It's a "+def.getName()+".");
    }
}
