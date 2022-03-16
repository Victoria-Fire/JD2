package homework.hw2.task_70;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Man.class.getMethod("printInfo").invoke(new Man());
    }
}
