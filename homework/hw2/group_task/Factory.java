package homework.hw2.group_task;

import java.util.Random;

public class Factory implements Runnable {
    private Random rand = new Random();
    private Dump dumpSource;

    public Factory(Dump dumpSource) {
        this.dumpSource = dumpSource;
    }

    public void run() {
        for (int i = 0; i < Main.NIGHTS_COUNT; i++) {
            for (int j = 0; j < rand.nextInt(Main.RANDOM_DETAILS_PUT_COUNT) + 1; j++) {
                dumpSource.addDumpItem(Parts.ret(rand.nextInt(9) + 1));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

