package godzhell.util;

import java.util.*;

public class AlphaBeta {

    public static final boolean IN_BETA_ALPHA = false;

    public static final boolean RESTRICTED_LOGIN = true;

    public static final boolean RESTRICTED_DROPPING = false;

    public static final boolean RESTRICTED_EMPTY = false;

    private static Collection<String> testers = new ArrayList<>();

    static {
        testers.addAll(Arrays.asList(
                "sgsrocks", "twistndshout", "swoc", "lp316", "sethg", "198078", "mitch", "navis", "tristorm", "thomasw28", "smackdown", "hyrulekid17", "sphynxmods", "sphynx", "zezima", "christian", "Italianboy", "dev snow", "rabea", "angar"
                , "spadow", "marty", "albion", "anum", "father", "docdeadly2", "super", "pink piggy", "justyzz", "justin", "admin bort", "dev snow", "jbogle", "halo", "sixxor2", "super", "someonelse13", "rico", "villain", "jayarrowz","woman", "mark"));
    }

    public static boolean isTester(String name) {
        return testers.contains(name.toLowerCase());
    }

    public static void addTester(String name) {
        testers.add(name.toLowerCase());
    }

    public static void removeTester(String name) {
        testers.remove(name.toLowerCase());
    }

}

