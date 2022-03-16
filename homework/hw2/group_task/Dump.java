package homework.hw2.group_task;

import java.util.ArrayList;
import java.util.Random;

public class Dump {
    private Random rand;
    public ArrayList<Parts> dump;

    public Dump() {
        rand = new Random();
        dump = new ArrayList<>();
    }

    public synchronized boolean isDumpEmpty() {
        return dump.isEmpty();
    }

    public synchronized Parts takeDumpItem() {
        return dump.remove(rand.nextInt(dump.size()));
    }

    public synchronized void addDumpItem(Parts item) {
        dump.add(item);
    }
}

