package homework.hw2.task_72;

public class Info {
    @AcademyInfo(year=1999)
    public void withAnnotation() {
        System.out.println("Hello from withAnnotation");
    }

    public void withoutAnnotation() {
        System.out.println("Hello from withoutAnnotation");
    }

}
