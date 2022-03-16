package homework.hw2.group_task;

import java.util.List;
import java.util.Random;

public class Servant implements Runnable {
    Random rand = new Random();
    private Dump dumpSource;
    private Storage storageSource;

    public Servant(Dump dumpSource, Storage storageSource) {
        this.dumpSource = dumpSource;
        this.storageSource = storageSource;
    }

    public void run() {
        for (int i = 0; i < Main.NIGHTS_COUNT; i++) {
            storageSource.updateSizeVar();
            for (int j = 0; j < rand.nextInt(Main.RANDOM_DETAILS_TAKE_COUNT) + 1; j++) {
                synchronized (dumpSource) {
                    if (dumpSource.isDumpEmpty()) {
                        break;
                    }
                    storageSource.addStorageItem(dumpSource.takeDumpItem());
                }
            }

            storageSource.PrintStorage();

            while (storageSource.isContainsItems(List.of(Parts.values()))) {
                storageSource.assembleRobot();
                storageSource.incRobotsCount();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Кол-во роботов у " + Thread.currentThread().getName() + " ученого: " + storageSource.getRobotsCount());
    }
}

