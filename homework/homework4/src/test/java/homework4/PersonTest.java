package homework4;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest{

    @Test
    public void TestCheckAge() {
        Person person1 = new Person("name1", "surname1");
        Person person2 = new Person("name2", "surname2");
        Person person3 = new Person("name3", "surname3");
        Person person4 = new Person("name4", "surname4");

        person1.setAge(15);
        person2.setAge(31);
        person3.setAge(20);
        person4.setAge(68);

        Assert.assertEquals(true, person1.checkAge());
        Assert.assertEquals(false, person2.checkAge());
        Assert.assertEquals(true, person3.checkAge());
        Assert.assertEquals(false, person4.checkAge());
    }
}