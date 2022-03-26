package jd2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int TOTAL_NUMBER_HOURS_PER_COURS = 198;
    public static final int NUMBER_OF_STUDENTS = 3;

    public static void main(String[] args) {

        SkillStrategy type1 = new StudentType1Strategy();
        SkillStrategy type2 = new StudentType2Strategy();
        SkillStrategy type3 = new StudentType3Strategy();

        List<Student> studentType1 = new ArrayList<>();
        List<Student> studentType2 = new ArrayList<>();
        List<Student> studentType3 = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            studentType1.add(new Student(type1));
            studentType2.add(new Student(type2));
            studentType3.add(new Student(type3));
        }

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            studentType1.get(i).printInfo();
            studentType2.get(i).printInfo();
            studentType3.get(i).printInfo();
        }
    }
}
