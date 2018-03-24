package net.callirgos.yearAlive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class yearsAliveTest {

    @Test
    void highestpopulation() {

        List<yearsAlive.Person> people = new ArrayList<>();
        people.add(new yearsAlive.Person("john",1900, 1990));
        people.add(new yearsAlive.Person("john",1920, 2005));
        people.add(new yearsAlive.Person("john",2000, 2050));
        people.add(new yearsAlive.Person("john",1975, 2030));
        people.add(new yearsAlive.Person("john",1935, 2040));
        people.add(new yearsAlive.Person("john",1965, 2050));
        people.add(new yearsAlive.Person("john",1995, 2050));
        people.add(new yearsAlive.Person("john",1935, 2070));
        people.add(new yearsAlive.Person("john",1935, 2050));
        people.add(new yearsAlive.Person("john",1995, 2080));
        people.add(new yearsAlive.Person("john",1995, 2050));
        people.add(new yearsAlive.Person("john",1975, 2000));
        people.add(new yearsAlive.Person("john",1995, 2090));
        people.add(new yearsAlive.Person("john",1995, 2070));
        people.add(new yearsAlive.Person("john",1965, 1999));

        int actualResult = new yearsAlive().yearWithMostPeople(people);
        System.out.println(actualResult);

    }
}