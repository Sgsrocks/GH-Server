package ethos.model.npcs.pets;

import ethos.Server;
import ethos.clip.Region;
import ethos.definitions.NPCCacheDefinition;
import ethos.model.npcs.NPC;
import ethos.model.players.PlayerHandler;

public class NPCData {

    public static boolean checkClip(NPC n) {
        int x2 = 0, y2 = 0, x3 = 0, y3 = 0;
        if (n.killerId > 0) {
            if (PlayerHandler.players[n.killerId] == null) {
                return false;
            }
            x2 = PlayerHandler.players[n.killerId].getX();
            y2 = PlayerHandler.players[n.killerId].getY();
        } else {
            return false;
        }
        int x = n.getX(); // -1
        int y = n.getY(); // 1
        final int dis = Server.npcHandler.distanceRequired(n.npcType) + NPCCacheDefinition.forID(n.npcType).getSize();
        int dis2 = 0;
        final boolean melee = Server.npcHandler.distanceRequired(n.npcType) < 2;
        if (NPCCacheDefinition.forID(n.npcType).getSize() < 1 && x != x2 && y != y2) {
            return false;
        }
        // Algorithm starts here
        int w = x2 - x;
        int h = y2 - y;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
        if (w < 0) {
            dx1 = -1;
        } else if (w > 0) {
            dx1 = 1;
        }
        if (h < 0) {
            dy1 = -1;
        } else if (h > 0) {
            dy1 = 1;
        }
        if (w < 0) {
            dx2 = -1;
        } else if (w > 0) {
            dx2 = 1;
        }
        int longest = Math.abs(w);
        int shortest = Math.abs(h);
        if (!(longest > shortest)) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) {
                dy2 = -1;
            } else if (h > 0) {
                dy2 = 1;
            }
            dx2 = 0;
        }
        int numerator = longest >> 1;
        boolean firstCheck = false;
        for (int i = 0; i <= longest; i++) {
            if (dis2 > dis) {
                return false;
            }
            dis2++;
            x3 = x;
            y3 = y;
            numerator += shortest;
            if (!(numerator < longest)) {
                numerator -= longest;
                x += dx1;
                y += dy1;
            } else {
                x += dx2;
                y += dy2;
            }
            if (!firstCheck) {
                if (melee) {
                    if (!Region.getClipping(x, y, n.heightLevel, x - x3, y - y3)) {
                        return false;
                    }
                }
                if (x == x2 && y == y2) {
                    break;
                }
                firstCheck = true;
            }
            if (melee) {
                if (!Region.getClipping(x, y, n.heightLevel, x - x3, y - y3)) {
                    return false;
                }
            }
            if (x == x2 && y == y2) {
                return true;
            }
        }
        return true;
    }

}
