package godzhell.model.content.skills.thieving;

import com.google.common.collect.Lists;
import godzhell.model.items.GameItem;
import godzhell.util.Misc;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

public enum PickpocketData {
    MAN(1, 8, 55000, new HashMap<Rarity, List<GameItem>>() {
        {
            put(Rarity.ALWAYS, Arrays.asList(new GameItem(995, 750), new GameItem(995, 1000), new GameItem(995, 1250)));
        }
    }), FARMER(60, 65, 52000, new HashMap<Rarity, List<GameItem>>() {
        {
            put(Rarity.ALWAYS, Arrays.asList(new GameItem(5291), new GameItem(5292), new GameItem(5293)));
            put(Rarity.COMMON, Arrays.asList(new GameItem(5294), new GameItem(5297), new GameItem(5296)));
            put(Rarity.UNCOMMON, Arrays.asList(new GameItem(5295), new GameItem(5298), new GameItem(5301), new GameItem(5302)));
            put(Rarity.RARE, Arrays.asList(new GameItem(5299), new GameItem(5300), new GameItem(5303)));
            put(Rarity.VERY_RARE, Collections.singletonList(new GameItem(5304)));
        }
    }), MENAPHITE_THUG(65, 75, 41000, new HashMap<Rarity, List<GameItem>>() {
        {
            put(Rarity.ALWAYS, Arrays.asList(new GameItem(995, 1000), new GameItem(995, 800), new GameItem(995, 950)));
        }
    }), GNOME(75, 85, 45000, new HashMap<Rarity, List<GameItem>>() {
        {
            put(Rarity.ALWAYS, Arrays.asList(new GameItem(995, 1200), new GameItem(995, 800), new GameItem(995, 1250)));
            put(Rarity.UNCOMMON, Arrays.asList(new GameItem(444), new GameItem(557), new GameItem(13431, 5)));
        }
    }), HERO(80, 100, 38000, new HashMap<Rarity, List<GameItem>>() {
        {
            put(Rarity.ALWAYS, Arrays.asList(new GameItem(995, 1500), new GameItem(995, 1800), new GameItem(995, 3500)));
            put(Rarity.UNCOMMON, Arrays.asList(new GameItem(560, 2), new GameItem(565), new GameItem(444), new GameItem(1601)));
        }
    });

    /**
     * The level required to pickpocket
     */
    final int level;

    /**
     * The experience gained from the pick pocket
     */
    final int experience;

    /**
     * The chance of receiving a pet
     */
    final int petChance;

    /**
     * The list of possible items received from the pick pocket
     */
    private Map<Rarity, List<GameItem>> items = new HashMap<>();

    /**
     * Creates a new pickpocket level requirement and experience gained
     *
     * @param level      the level required to steal from
     * @param experience the experience gained from stealing
     */
    PickpocketData(int level, int experience, int petChance, Map<Rarity, List<GameItem>> items) {
        this.level = level;
        this.experience = experience;
        this.petChance = petChance;
        this.items = items;
    }
    GameItem getRandomItem() {
        for (Map.Entry<Rarity, List<GameItem>> entry : items.entrySet()) {
            final Rarity rarity = entry.getKey();

            if (rarity == Rarity.ALWAYS) {
                continue;
            }
            final List<GameItem> items = entry.getValue();

            if (items.isEmpty()) {
                continue;
            }

            if (RandomUtils.nextInt(1, rarity.rarity) == 1) {
                return Misc.getItemFromList(items).randomizedAmount();
            }
        }

        List<GameItem> always = items.getOrDefault(Rarity.ALWAYS, Lists.newArrayList());

        if (!always.isEmpty()) {
            return Misc.getItemFromList(always).randomizedAmount();
        }

        return null;
    }
}