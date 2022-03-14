package homework.hw2.task_72;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Info> clz = Info.class;

        Method method1 = clz.getMethod("withAnnotation");
        AcademyInfo info1 = method1.getAnnotation(AcademyInfo.class);
        checkAnnotation(info1, method1);

        Method method2 = clz.getMethod("withoutAnnotation");
        AcademyInfo info2 = method2.getAnnotation(AcademyInfo.class);
        checkAnnotation(info2, method2);
    }

    private static void checkAnnotation(AcademyInfo academyInfo, Method method) {
        if (academyInfo == null) {
            System.out.println("Annotation is missing on method: " + method);
        } else {
            System.out.println("Annotation is present on method: " + method);
            System.out.println(academyInfo.year());
        }
    }
}
