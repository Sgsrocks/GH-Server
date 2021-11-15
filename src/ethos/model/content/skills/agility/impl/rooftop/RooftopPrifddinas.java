package ethos.model.content.skills.agility.impl.rooftop;

import ethos.model.players.Player;
import ethos.model.content.skills.agility.AgilityHandler;

public class RooftopPrifddinas {

    public static final int
            LADDER1 = 36221,
            Tightrope1 = 36225,
            chimney = 36227,
            roofEdge = 36228,
            DarkHole = 36229,
            ladder2 = 36231,
            RobeBridge1 = 36233,
            Tightrobe2 = 36234,
            RopeBridge2 = 36235,
            Tightrope3 = 36236,
            Tightrope4 = 36237,
            DarkHole2 = 36238;

    public boolean execute(final Player c, final int objectId) {
        switch (objectId) {
            case LADDER1:
                AgilityHandler.delayEmote(c, "CLIMB_UP", 3255, 6109, 2, 2);
                c.getAgilityHandler().agilityProgress[0] = true;
            return true;
            case Tightrope1:
               // if (AgilityHandler.failObstacle(c, 2710, 3486, 0)) {
                  //  return false;
               // }
                c.setForceMovement(3272, 6105, 0, 220, "EAST", 762);
                c.getAgilityHandler().agilityProgress[2] = true;
                return true;
        }
        return false;
    }
}
