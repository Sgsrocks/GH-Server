package godzhell.model.content.trails;


import godzhell.model.players.Player;
import godzhell.model.players.Position;
import godzhell.definitions.Items;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by IntelliJ IDEA. User: vayken Date: 15/01/12 Time: 11:03 To change
 * this template use File | Settings | File Templates.
 */
public class CoordinateScrolls {

    /* the observatory center Position */

    public static final Position OBSERVATORY_Position = new Position(2440, 3161, 0);

    /* constants for mathematical use */

    public static final double ONE_MINUTE_TO_SQUARE = 1.875;

    public static final int ONE_DEGREE_TO_MINUTE = 60;

    /* set of constants for the tools */

    public static final int SEXTANT = 2574;
    public static final int WATCH = 2575;
    public static final int CHART = 2576;

    /* contains all the coordinate clues */

    public static enum CoordinateData {
        COORDINATE_1(Items.CLUE_SCROLL_HARD, 25, 3, 23, 24, "north", "east", 3),
        COORDINATE_2(Items.CLUE_SCROLL_HARD_2, 25, 3, 17, 5, "north", "east", 3),
        COORDINATE_3(Items.CLUE_SCROLL_HARD_3, 24, 58, 18, 43, "north", "east", 3),
        COORDINATE_4(Items.CLUE_SCROLL_HARD_4, 24, 56, 22, 58, "north", "east", 3),
        COORDINATE_5(Items.CLUE_SCROLL_HARD_5, 24, 24, 26, 24, "north", "east", 3),
        COORDINATE_6(Items.CLUE_SCROLL_HARD_6, 22, 45, 26, 33, "north", "east", 3),
        COORDINATE_7(Items.CLUE_SCROLL_HARD_7, 22, 35, 19, 18, "north", "east", 3),
        //COORDINATE_8(2741, 22, 30, 3, 1, "north", "east", 2),
        COORDINATE_9(Items.CLUE_SCROLL_HARD_8, 21, 24, 17, 54, "north", "east", 3),
        COORDINATE_10(Items.CLUE_SCROLL_HARD_9, 20, 33, 15, 45, "north", "east", 3),
        COORDINATE_11(Items.CLUE_SCROLL_HARD_10, 20, 7, 18, 33, "north", "east", 3),
        COORDINATE_12(Items.CLUE_SCROLL_HARD_11, 20, 5, 21, 52, "north", "east", 3),
        COORDINATE_13(Items.CLUE_SCROLL_HARD_12, 19, 43, 25, 07, "north", "east", 3),
        COORDINATE_14(Items.CLUE_SCROLL_HARD_13, 18, 22, 16, 33, "north", "east", 3),
        COORDINATE_15(Items.CLUE_SCROLL_HARD_14, 18, 3, 25, 16, "north", "east", 3),
        COORDINATE_16(Items.CLUE_SCROLL_HARD_15, 17, 50, 8, 30, "north", "east", 3),
        COORDINATE_17(Items.CLUE_SCROLL_HARD_16, 16, 43, 19, 13, "north", "east", 3),
        COORDINATE_18(Items.CLUE_SCROLL_HARD_17, 16, 35, 27, 1,"north", "east", 3),
        COORDINATE_19(Items.CLUE_SCROLL_HARD_18, 16, 20, 12, 45, "north", "east", 3),
        COORDINATE_20(Items.CLUE_SCROLL_HARD_19, 15, 48, 13, 52, "north", "east", 3),
        COORDINATE_21(Items.CLUE_SCROLL_MEDIUM_11, 14, 54, 9, 13, "north", "east", 2),
        COORDINATE_22(Items.CLUE_SCROLL_HARD_20, 13, 46, 21, 1, "north", "east", 3),
        COORDINATE_23(Items.CLUE_SCROLL_HARD_21, 12, 48, 20, 20, "north", "east", 3),
        COORDINATE_24(Items.CLUE_SCROLL_MEDIUM_12, 11, 41, 14, 58, "north", "east", 2),
        COORDINATE_25(Items.CLUE_SCROLL_MEDIUM_13, 11, 5, 0, 45, "north", "west", 2),
        COORDINATE_26(Items.CLUE_SCROLL_MEDIUM_14, 11, 3, 31, 20, "north", "east", 2),
        COORDINATE_27(Items.CLUE_SCROLL_MEDIUM_15, 9, 48, 17, 39, "north", "east", 2),
        COORDINATE_29(Items.CLUE_SCROLL_MEDIUM_16, 8, 33, 1, 39, "north", "east", 2),
        //COORDINATE_30(3538, 8, 26, 10, 28, "south", "east", 3),
        //COORDINATE_31(3540, 8, 5, 15, 56, "south", "east", 3),
        COORDINATE_32(Items.CLUE_SCROLL_HARD_22, 8, 3, 31, 16, "north", "east", 3),
        //COORDINATE_33(3544, 7, 43, 12, 26, "south", "east", 3),
        COORDINATE_34(Items.CLUE_SCROLL_MEDIUM_17, 7, 33, 15, 0, "north", "east", 2),
        COORDINATE_35(Items.CLUE_SCROLL_MEDIUM_18, 7, 5, 30, 56, "north", "east", 2),
        COORDINATE_36(Items.CLUE_SCROLL_MEDIUM_19, 6, 31, 1, 45, "north", "west", 2),
        //COORDINATE_37(3552, 6, 11, 15, 7, "south", "east", 3),
        COORDINATE_38(Items.CLUE_SCROLL_HARD_23, 6, 0, 21, 48, "south", "east", 3),
        //COORDINATE_39(3556, 5, 50, 10, 5, "south", "east", 3),
        COORDINATE_40(Items.CLUE_SCROLL_MEDIUM_20, 5, 43, 23, 5, "north", "east", 2),
        //COORDINATE_41(3560, 5, 37, 31, 15, "north", "east", 3),
        COORDINATE_42(Items.CLUE_SCROLL_MEDIUM_21, 5, 20, 4, 28, "south", "east", 2),
        //COORDINATE_43(3582, 4, 41, 3, 9, "north", "west", 3),
        //COORDINATE_44(3584, 4, 16, 16, 16, "south", "east", 3),
        COORDINATE_45(Items.CLUE_SCROLL_MEDIUM_22, 4, 13, 12, 45, "north", "east", 2),
        //COORDINATE_46(3588, 4, 5, 4, 24, "south", "east", 3),
        //COORDINATE_47(3590, 4, 3, 3, 11, "south", "east", 3),
        COORDINATE_48(Items.CLUE_SCROLL_MEDIUM_23, 4, 0, 12, 46, "south", "east", 2),
        COORDINATE_49(Items.CLUE_SCROLL_HARD_24, 3, 45, 22, 45, "south", "east", 3),
        COORDINATE_50(Items.CLUE_SCROLL_MEDIUM_24, 3, 35, 13, 35, "south", "east", 2),
        COORDINATE_51(Items.CLUE_SCROLL_MEDIUM_25, 2, 50, 6, 20, "north", "east", 2),
        COORDINATE_52(Items.CLUE_SCROLL_MEDIUM_26, 2, 48, 22, 30, "north", "east", 2),
        COORDINATE_53(Items.CLUE_SCROLL_MEDIUM_27, 2, 46, 29, 11, "north", "east", 2),
        //COORDINATE_54(7264, 1, 35, 7, 28, "south", "east", 3),
        //COORDINATE_55(7266, 1, 26, 8, 1, "north", "east", 2),
        //COORDINATE_56(7305, 1, 24, 8, 5, "north", "west", 3),
        //COORDINATE_57(7307, 1, 18, 14, 15, "south", "east", 2),
        COORDINATE_58(Items.CLUE_SCROLL_MEDIUM_28, 0, 31, 17, 43, "south", "east", 2),
        COORDINATE_59(Items.CLUE_SCROLL_MEDIUM_29, 0, 30, 24, 16, "north", "east", 2),
        COORDINATE_60(Items.CLUE_SCROLL_MEDIUM_30, 0, 20, 23, 15, "south", "east", 2),
        COORDINATE_61(Items.CLUE_SCROLL_MEDIUM_31, 0, 18, 9, 28, "south", "east", 2),
        COORDINATE_62(Items.CLUE_SCROLL_MEDIUM_32, 0, 13, 13, 15, "south", "east", 2),
        COORDINATE_63(Items.CLUE_SCROLL_MEDIUM_33, 0, 5, 1, 13, "south", "east", 2),

        COORDINATE_64(Items.CLUE_SCROLL_ELITE, 0, 18, 2, 35, "south", "west", 4),
        COORDINATE_65(Items.CLUE_SCROLL_ELITE_2, 0, 35, 35, 50, "north", "east", 4),
        COORDINATE_66(Items.CLUE_SCROLL_ELITE_3, 2, 35, 11, 52, "south", "east", 4),
        COORDINATE_67(Items.CLUE_SCROLL_ELITE_4, 3, 9, 42, 50, "south", "east", 4),
        COORDINATE_68(Items.CLUE_SCROLL_ELITE_5, 3, 9, 42, 50, "south", "east", 4),
        COORDINATE_69(Items.CLUE_SCROLL_ELITE_6, 3, 36, 8, 7, "north", "west", 4),
        COORDINATE_70(Items.CLUE_SCROLL_ELITE_7, 5, 7, 13, 26, "south", "east", 4),
        COORDINATE_71(Items.CLUE_SCROLL_ELITE_8, 5, 18, 6, 48, "north", "west", 4),
        COORDINATE_72(Items.CLUE_SCROLL_ELITE_9, 5, 24, 26, 56, "south", "east", 4),
        COORDINATE_73(Items.CLUE_SCROLL_ELITE_10, 5, 39, 2, 13, "south", "east", 4),
        COORDINATE_74(Items.CLUE_SCROLL_ELITE_11, 6, 28, 3, 48, "south", "east", 4),
        COORDINATE_75(Items.CLUE_SCROLL_ELITE_12, 6, 35, 9, 7, "north", "east", 4),
        COORDINATE_76(Items.CLUE_SCROLL_ELITE_13, 8, 15, 35, 24, "north", "east", 4),
        COORDINATE_77(Items.CLUE_SCROLL_ELITE_14, 8, 30, 10, 48, "south", "west", 4),
        COORDINATE_78(Items.CLUE_SCROLL_ELITE_15, 9, 46, 43, 22, "south", "east", 4),
        COORDINATE_79(Items.CLUE_SCROLL_ELITE_16, 10, 5, 24, 31, "south", "east", 4),
        COORDINATE_80(Items.CLUE_SCROLL_ELITE_17, 10, 52, 30, 54, "north", "west", 4),
        COORDINATE_81(Items.CLUE_SCROLL_ELITE_18, 10, 54, 20, 50, "north", "west", 4),
        COORDINATE_82(Items.CLUE_SCROLL_ELITE_19, 12, 31, 43, 11, "north", "east", 4),
        ;
        private int clueId;
        private int degree1;
        private int minutes1;
        private int degree2;
        private int minutes2;
        private String hint1;
        private String hint2;
        private int level;

        private Position diggingPosition;

        private static Map<Integer, CoordinateData> clues = new HashMap<Integer, CoordinateData>();
        private static Map<Position, CoordinateData> positions = new HashMap<Position, CoordinateData>();

        public static CoordinateData forIdPosition(Position position) {
            for (int i = 0; i < CoordinateData.values().length; i++) {
                if (CoordinateData.values()[i].getDiggingPosition().equals(position)) {
                    return CoordinateData.values()[i];
                }
            }
            return null;
        }

        public static CoordinateData forIdClue(int clueId) {
            return clues.get(clueId);
        }

        static {
            for (CoordinateData data : CoordinateData.values()) {
                data.diggingPosition = calculateDiggingPosition(data.degree1, data.minutes1, data.degree2, data.minutes2, data.hint1, data.hint2);
                clues.put(data.clueId, data);
                positions.put(data.diggingPosition, data);

            }
        }

        CoordinateData(int clueId, int degree1, int minutes1, int degree2, int minutes2, String hint1, String hint2, int level) {
            this.clueId = clueId;
            this.degree1 = degree1;
            this.minutes1 = minutes1;
            this.degree2 = degree2;
            this.minutes2 = minutes2;
            this.hint1 = hint1;
            this.hint2 = hint2;
            this.level = level;
        }

        public int getClueId() {
            return clueId;
        }

        public int getDegree1() {
            return degree1;
        }

        public int getMinutes1() {
            return minutes1;
        }

        public int getDegree2() {
            return degree2;
        }

        public int getMinutes2() {
            return minutes2;
        }

        public String getHint1() {
            return hint1;
        }

        public String getHint2() {
            return hint2;
        }

        public int getLevel() {
            return level;
        }

        public Position getDiggingPosition() {
            return diggingPosition;
        }
    }

    /* loading the clue scroll interfaces */

    public static boolean loadClueInterface(Player player, int itemId) {
        CoordinateData coordinateData = CoordinateData.forIdClue(itemId);
        if (coordinateData == null) {
            return false;
        }
        player.getPA().showInterface(ClueScroll.CLUE_SCROLL_INTERFACE);
        player.getPA().sendString(putZeroToNumber(coordinateData.getDegree1()) + " degrees " + putZeroToNumber(coordinateData.getMinutes1()) + " minutes " + coordinateData.getHint1(), 6971);
        player.getPA().sendString(putZeroToNumber(coordinateData.getDegree2()) + " degrees " + putZeroToNumber(coordinateData.getMinutes2()) + " minutes " + coordinateData.getHint2(), 6972);
        return true;
    }

    /* handling digging */

    public static boolean digClue(Player player) {
        CoordinateData coordinateData = CoordinateData.forIdPosition(new Position(player.getPosition().getX(), player.getPosition().getY()));
        if (coordinateData == null) {
            return false;
        }
        if (!player.getItems().playerHasItem(coordinateData.getClueId())) {
            return false;
        }
        if (!player.getItems().playerHasItem(CHART) || !player.getItems().playerHasItem(SEXTANT) || !player.getItems().playerHasItem(WATCH)) {
            player.sendMessage("You need a chart, sextant, and watch in order to find the clue.");
            player.sendMessage("You can get these from the general store.");
            return false;
        }
        /*if (!player.hasKilledClueAttacker() && coordinateData.getLevel() == 3) {
            ClueScroll.spawnAttacker(player);
            player.getPA().sendMessage("You must kill the wizard before continuing the search!");
            return true;
        }
        player.setKilledClueAttacker(false);
*/
        player.getItems().deleteItem(coordinateData.getClueId(), 1);
        switch (coordinateData.getLevel()) {
            case 1 :
                player.getItems().addOrDropItem(ClueScroll.CASKET_LV1, 1);
                break;
            case 2 :
                player.getItems().addOrDropItem(ClueScroll.CASKET_LV2, 1);
                break;
            case 3 :
                player.getItems().addOrDropItem(ClueScroll.CASKET_LV3, 1);
                break;
            case 4 :
                player.getItems().addOrDropItem(ClueScroll.CASKET_LV4, 1);
                break;
        }
        player.getDH().sendItemStatement("You've found a casket!", ClueScroll.CASKET_LV1);
        return true;
    }

    /* put a 0 next to the number if its under 10 */

    private static String putZeroToNumber(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

    /* calculating the position of digging place with hint provided */

    public static Position calculateDiggingPosition(int degree1, int minutes1, int degree2, int minutes2, String firstHint, String secondHint) {
        int obsX = OBSERVATORY_Position.getX();
        int obsY = OBSERVATORY_Position.getY();

        /* first hint handling */

        if (firstHint == "north") {
            obsY += (int) Math.ceil(((degree1 * ONE_DEGREE_TO_MINUTE + minutes1) / ONE_MINUTE_TO_SQUARE));
        }
        if (firstHint == "south") {
            obsY -= (int) Math.ceil(((degree1 * ONE_DEGREE_TO_MINUTE + minutes1) / ONE_MINUTE_TO_SQUARE));
        }
        if (firstHint == "east") {
            obsX += (int) Math.ceil(((degree1 * ONE_DEGREE_TO_MINUTE + minutes1) / ONE_MINUTE_TO_SQUARE));
        }
        if (firstHint == "west") {
            obsX -= (int) Math.ceil(((degree1 * ONE_DEGREE_TO_MINUTE + minutes1) / ONE_MINUTE_TO_SQUARE));
        }

        /* second hint handling */

        if (secondHint == "north") {
            obsY += (int) Math.ceil(((degree2 * ONE_DEGREE_TO_MINUTE + minutes2) / ONE_MINUTE_TO_SQUARE));
        }
        if (secondHint == "south") {
            obsY -= (int) Math.ceil(((degree2 * ONE_DEGREE_TO_MINUTE + minutes2) / ONE_MINUTE_TO_SQUARE));
        }
        if (secondHint == "east") {
            obsX += (int) Math.ceil(((degree2 * ONE_DEGREE_TO_MINUTE + minutes2) / ONE_MINUTE_TO_SQUARE));
        }
        if (secondHint == "west") {
            obsX -= (int) ((degree2 * ONE_DEGREE_TO_MINUTE + minutes2) / ONE_MINUTE_TO_SQUARE);
        }

        return new Position(obsX, obsY);

    }

    /* gets the hint with coordinate provided */
    public static String[] calculateActualPosition(int x, int y) {
        int obsX = OBSERVATORY_Position.getX();
        int obsY = OBSERVATORY_Position.getY();
        int differenceX = x - obsX;
        int differenceY = y - obsY;
        double minutesX = Math.abs(differenceX) * ONE_MINUTE_TO_SQUARE;
        double minutesY = Math.abs(differenceY) * ONE_MINUTE_TO_SQUARE;
        int finalMinutesX = (int) Math.ceil(minutesX) % ONE_DEGREE_TO_MINUTE;
        int finalMinutesY = (int) Math.ceil(minutesY) % ONE_DEGREE_TO_MINUTE;
        int degreeX = (int) (minutesX / ONE_DEGREE_TO_MINUTE);
        int degreeY = (int) (minutesY / ONE_DEGREE_TO_MINUTE);
        /* setting the first strings */
        String XAxis = (differenceX < 0 ? "west" : "east");
        String YAxis = (differenceY < 0 ? "south" : "north");

        /* returning the final strings */
        return new String[]{degreeY + " degrees, " + finalMinutesY + " minutes " + YAxis, degreeX + " degrees, " + finalMinutesX + " minutes " + XAxis};
    }

    /* getting a random coordinate clue */

    public static int getRandomScroll(int level) {
        int pick = new Random().nextInt(CoordinateData.values().length);
        while (CoordinateData.values()[pick].getLevel() != level) {
            pick = new Random().nextInt(CoordinateData.values().length);
        }

        return CoordinateData.values()[pick].getClueId();
    }

}

