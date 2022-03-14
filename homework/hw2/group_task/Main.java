package homework.hw2.group_task;

import java.util.Random;

public class Main {

    public static final int PARTS_COUNT = Parts.values().length;
    public static final int NIGHTS_COUNT = 100;
    public static final int RANDOM_DETAILS_PUT_COUNT = 4;
    public static final int RANDOM_DETAILS_TAKE_COUNT = 4;


    public static void main(String[] args) {
        Storage storage1 = new Storage();
        Storage storage2 = new Storage();
        Dump dump = new Dump();

        Factory factory = new Factory(dump);
        Servant servant1 = new Servant(dump, storage1);
        Servant servant2 = new Servant(dump, storage2);


        Random rand = new Random();
        for (int j = 0; j < 20; j++) {
            dump.addDumpItem(Parts.ret(rand.nextInt(PARTS_COUNT + 1)));
        }


        System.out.println("Хранилища с деталями: ");
        Thread factoryT = new Thread(factory);
        Thread servant1T = new Thread(servant1, "1");
        Thread servant2T = new Thread(servant2, "2");

        factoryT.start();
        servant1T.start();
        servant2T.start();
    }
}
