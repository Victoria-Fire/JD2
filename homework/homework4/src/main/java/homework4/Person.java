package homework4;

import java.io.Serializable;
import java.util.Random;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = new Random().nextInt(16) + 15;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean checkAge() {
        return age < 21;
    }

    @Override
    public String toString() {
        return "Person {" + name + ", " + surname + ", age = " + age + '}';
    }
}
