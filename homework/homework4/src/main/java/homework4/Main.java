package homework4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> person100 = new LinkedList<>();
        File dir = new File("src/main/java/homework4");
        File file = new File(dir, "out.txt");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (int i = 1; i < 101; i++) {
            person100.add(new Person("name_" + (new Random().nextInt(100) + 1),
                    "surname_" + (new Random().nextInt(100) + 1)));
        }

        List<Person> person21 = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            if (person100.get(i).checkAge()) {
                person21.add(person100.get(i));
            }
        }

        System.out.println("Person меньше 21 года:");
        for (Person p : person21) {
            System.out.println(p);
        }
        System.out.println();

        Set<Person> personWithoutRepeat = new TreeSet<>(Comparator.comparing(Person::getSurname).thenComparing((Person::getName)));

        for (int i = 0; i < person21.size(); i++) {
            personWithoutRepeat.add(person21.get(i));
        }

        List<Person> personSortedWithoutRepeat = new LinkedList<>();
        personSortedWithoutRepeat.addAll(personWithoutRepeat);

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (int i = 0; i < personSortedWithoutRepeat.size(); i++) {
                oos.writeObject(personSortedWithoutRepeat.get(i));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        List<Person> personDeserialized = new ArrayList<>();
        try (ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            for (int i = 0; i < personSortedWithoutRepeat.size(); i++) {
                personDeserialized.add((Person) is.readObject());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        List<String> personResult = personDeserialized.stream()
                .map(person -> person.getSurname() + " " + person.getName())
                .collect(Collectors.toList());

        System.out.println("Вывод результата Person:");
        personResult.forEach(System.out::println);
    }
}
