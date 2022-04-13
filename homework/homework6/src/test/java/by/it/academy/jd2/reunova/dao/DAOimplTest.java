package by.it.academy.jd2.reunova.dao;

import by.it.academy.jd2.reunova.entity.Car;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class DAOimplTest {

    private static Statement statement;

    static {
        try {
            Connection connection = getConnection("jdbc:h2:mem:homework_6", "sa", "");
            statement = connection.createStatement();
            statement.execute("create schema homework_6_test");
            statement.execute("create table car(identifier int auto_increment primary key, name char(100), color char(100)," +
                    "price int)");
            statement.execute("insert into car(name, color, price) values ('Volkswagen Polo', 'Orange', 27000)");
            statement.execute("insert into car(name, color, price) values ('Citroen', 'Green', 61500)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect() {
        DAO<Car> dao = new DAOimpl<>();
        Car car = new Car();
        dao.select(car);
    }

    @Test
    public void testUpdate() {
        DAO<Car> dao = new DAOimpl<>();
        Car car = new Car();
        dao.update(car, "name", "Oka", 1);
    }

    @Test
    public void testDelete() {
        DAO<Car> dao = new DAOimpl<>();
        Car car = new Car();
        dao.delete(car, 2);
    }

    @Test
    public void testInsert() {
        DAO<Car> dao = new DAOimpl<>();
        Car car = new Car(4, "Mercedes-Benz", "Black", 85000);
        dao.insert(car);
    }
}