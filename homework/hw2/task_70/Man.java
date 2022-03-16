package homework.hw2.task_70;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Man {
    private String name;
    private int age;
    private String country;

    public Man() {
    }

    public Man(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void sayHello() {
        System.out.println("Привет!");
    }

    public void sayBye() {
        System.out.println("Пока!");
    }

    public void sayMeow() {
        System.out.println("Ну мяу!");
    }

    public void printInfo() {
        for (Method method: this.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
        for (Field field: this.getClass().getDeclaredFields()) {
            System.out.println(field);
        }
    }
}
