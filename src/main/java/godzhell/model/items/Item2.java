package godzhell.model.items;

public class Item2 {

    public static int Phat[] = {
            1038, 1040, 1042, 1044, 1046, 1048, 28231};

    public static int randomPhat() {
        return Phat[(int) (Math.random() * Phat.length)];
    }
}
