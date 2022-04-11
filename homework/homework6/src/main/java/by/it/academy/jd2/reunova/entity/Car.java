package by.it.academy.jd2.reunova.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@MyTable(name = "car")
public class Car {
    @MyColumn(name = "identifier")
    private int identifier;

    @MyColumn(name = "name")
    private String name;

    @MyColumn(name = "color")
    private String color;

    @MyColumn(name = "price")
    private int price;

    public Car() {
    }
}
