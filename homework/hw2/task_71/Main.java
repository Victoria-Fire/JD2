package homework.hw2.task_71;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        Class<Print> printClass = Print.class;

        Method method = printClass.getMethod("printHelloWorld");
        method.invoke(new Print());

    }
}
