package by.it.academy.jd2.reunova;

import by.it.academy.jd2.reunova.dao.DAO;
import by.it.academy.jd2.reunova.dao.DAOimpl;
import by.it.academy.jd2.reunova.entity.Car;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        DAO<Car> dao = new DAOimpl<>();

        Car car1 = new Car(9, "Niva", "Green", 44000);
        dao.insert(car1);
        Car car2 = new Car();
        dao.delete(car2, 5);
        dao.update(car2, "name", "Audi TT", 3);
        dao.select(car2);
    }
}
