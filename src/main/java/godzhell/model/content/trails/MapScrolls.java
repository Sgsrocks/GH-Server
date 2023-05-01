package godzhell.model.content.trails;

import godzhell.model.players.Player;
import godzhell.model.players.Position;
import godzhell.definitions.Items;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by IntelliJ IDEA. User: vayken Date: 04/01/12 Time: 16:08 To change
 * this template use File | Settings | File Templates.
 */
public class MapScrolls {

    /* contains the whole map clue */

    public static enum MapCluesData {
        BLACK_FORTERESS(Items.CLUE_SCROLL_MEDIUM, 9507, new Position(3026, 3628), true, 2),
        GALAHAD(Items.CLUE_SCROLL_EASY, 9108, new Position(2612, 3482), false, 1),
        CHAMPION_GUILD(Items.CLUE_SCROLL_MEDIUM_2, 6994, new Position(3166, 3360), false, 2),
        FALADOR_ROCK(Items.CLUE_SCROLL_MEDIUM_3, 7271, new Position(3043, 3399), false, 2),
        DRAYNOR(Items.CLUE_SCROLL_MEDIUM_4, 7113, new Position(3092, 3226), false, 2),
        //GOBLIN_VILLAGE(Items.CLUE_SCROLL_HARD_32, 39908, new Position(2457, 3182), true, 3),
        NECROMANCER(Items.CLUE_SCROLL_HARD_33, 9632, new Position(2654, 3233), false, 3),
        LUMBERYARD(Items.CLUE_SCROLL_EASY_2, 7221, new Position(3309, 3503), true, 1),
        VARROCK_MINE(Items.CLUE_SCROLL_EASY_3, 7045, new Position(3290, 3373), false, 1),
        YANILLE(Items.CLUE_SCROLL_EASY_4, 9040, new Position(2616, 3077), false, 1),
        RIMMINGTON(Items.CLUE_SCROLL_EASY_5, 9839, new Position(2924, 3209), false, 1),
        HOBGOBLIN(Items.CLUE_SCROLL_MEDIUM_5, 4305, new Position(2906, 3294), false, 2),
        MCGRUBOR(Items.CLUE_SCROLL_MEDIUM_6, 9196, new Position(2658, 3488), true, 2),
        CLOCK_TOWER(Items.CLUE_SCROLL_EASY_6, 9720, new Position(2565, 3248), true, 1),
        WEST_ARDOUGNE(Items.CLUE_SCROLL_EASY_7, 9359, new Position(2488, 3308), false, 1),
        WIZARD_TOWER(Items.CLUE_SCROLL_MEDIUM_7, 9275, new Position(3109, 3153), false, 2),
        MORT_TON(Items.CLUE_SCROLL_HARD_34, 17774, new Position(3434, 3265), false, 3),
        CHAOS_ALTAR(Items.CLUE_SCROLL_HARD_35, 17888, new Position(2454, 3230), false, 3),
        WILDERNESS_AGILITY(Items.CLUE_SCROLL_MEDIUM_8, 17620, new Position(3021, 3912), false, 2),
        MISCELLANIA(Items.CLUE_SCROLL_EASY_8, 17687, new Position(2535, 3865), false, 1),
        CAMELOT(Items.CLUE_SCROLL_HARD_36, 18055, new Position(2666, 3562), false, 3),
        LEGEND_GUILD(Items.CLUE_SCROLL_HARD_37, 17634, new Position(2723, 3339), false, 3),
        FALADOR_STATUE(Items.CLUE_SCROLL_MEDIUM_9, 17537, new Position(2970, 3414), false, 2),
        RELLEKA(Items.CLUE_SCROLL_MEDIUM_10, 17907, new Position(2579, 3597), false, 2),
        CRAFTING_GUILD_EAST(Items.CLUE_SCROLL_EASY_9, 7162, new Position(2702, 3428), false, 1),
        Zul_Andra(Items.CLUE_SCROLL_ELITE_20, 39970, new Position(2202, 3061), false, 4),
        APE_ATOLL(Items.CLUE_SCROLL_ELITE_21, 39978, new Position(2703, 2716), true,4),
        SOUL_ALTAR(Items.CLUE_SCROLL_ELITE_22, 39974, new Position(1815, 3852), false, 4),
        CASTLE_WARS(Items.CLUE_SCROLL_ELITE_23, 39986, new Position(2449, 3130), false, 4);

        private int clueId;
        private int interfaceId;
        private Position finalPosition;
        private boolean isCrate;
        private int level;

        private static Map<Position, MapCluesData> positions = new HashMap<Position, MapCluesData>();
        private static Map<Integer, MapCluesData> clues = new HashMap<Integer, MapCluesData>();

        public static MapCluesData forIdPosition(Position position) {
            for (int i = 0; i < MapCluesData.values().length; i++) {
                if (MapCluesData.values()[i].getFinalPosition().equals(position)) {
                    return MapCluesData.values()[i];
                }
            }
            return null;
        }
        public static MapCluesData forIdClue(int clueId) {
            return clues.get(clueId);
        }

        static {
            for (MapCluesData data : MapCluesData.values()) {
                positions.put(data.finalPosition, data);
                clues.put(data.clueId, data);
            }
        }

        MapCluesData(int clueId, int interfaceId, Position finalPosition, boolean crate, int level) {
            this.clueId = clueId;
            this.interfaceId = interfaceId;
            this.finalPosition = finalPosition;
            isCrate = crate;
            this.level = level;
        }

        public int getClueId() {
            return clueId;
        }

        public int getInterfaceId() {
            return interfaceId;
        }

        public Position getFinalPosition() {
            return finalPosition;
        }

        public boolean isCrate() {
            return isCrate;
        }

        public int getLevel() {
            return level;
        }
    }

    /* loading the clue interface */

    public static boolean loadClueInterface(Player player, int itemId) {
        MapCluesData mapCluesData = MapCluesData.forIdClue(itemId);
        if (mapCluesData == null) {
            return false;
        }
        if (mapCluesData.getInterfaceId() < 0) {
            return false;
        }
        player.getPA().showInterface(mapCluesData.getInterfaceId());
        return true;
    }

    /* handles the digging clue method */

    public static boolean digClue(Player player) {
        MapCluesData mapCluesData = MapCluesData.forIdPosition(new Position(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getHeight()));
        if (mapCluesData == null) {
            return false;
        }
        if (!player.getItems().playerHasItem(mapCluesData.getClueId())) {
            return false;
        }
        player.getItems().deleteItem2(mapCluesData.getClueId(), 1);
        switch (mapCluesData.getLevel()) {
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

    /* getting a random clue scroll */

    public static int getRandomScroll(int level) {
        int pick = new Random().nextInt(MapCluesData.values().length);
        while (MapCluesData.values()[pick].getLevel() != level) {
            pick = new Random().nextInt(MapCluesData.values().length);
        }

        return MapCluesData.values()[pick].getClueId();
    }

    /* handle crate clicking for some of the clues */

    public static boolean handleCrate(Player player, int objectX, int objectY) {
        MapCluesData mapCluesData = MapCluesData.forIdPosition(new Position(objectX, objectY));
        if (mapCluesData == null) {
            return false;
        }
        if (!mapCluesData.isCrate()) {
            return false;
        }
        if (!player.getItems().playerHasItem(mapCluesData.getClueId())) {
            return false;
        }
        player.getItems().deleteItem2(mapCluesData.getClueId(), 1);
        player.startAnimation(832);
        ClueScroll.clueReward(player, mapCluesData.getLevel(), "You've found another clue!", false, "");
        return true;
    }

}