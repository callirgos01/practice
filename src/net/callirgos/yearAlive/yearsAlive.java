package net.callirgos.yearAlive;
//given a list of people and their birth years and death years, how do you find the year with the most people alive

import java.security.KeyPair;
import java.util.*;

public class yearsAlive {
    public static class Person {
        String name;
        int birthYear;
        int deathYear;
        public Person(String name, int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.name=name;
            this.deathYear = deathYear;
        }
    }
    private HashMap<Integer, Integer> getDeltas(List<Person> people) {
        HashMap<Integer, Integer> years = new LinkedHashMap<>();

        for(Person person : people) {
            //System.out.println(i);
            if (!years.containsKey(person.birthYear)) {
                years.put(person.birthYear, 1);
            } else {
                years.replace(person.birthYear, years.get(person.birthYear) + 1);
            }
            if (!years.containsKey(person.deathYear+1)) {
                years.put(person.deathYear+1, - 1);
            } else {
                years.replace(person.deathYear+1, years.get(person.deathYear+1) - 1);
            }
        }
        return years;
    }
    private int getYear(HashMap<Integer,Integer> years, int min, int max) {
        int highestPopulation = 0;
        int highestPopulationYear = 0;
        int population=0;
        SortedSet<Integer> yearsKeys = new TreeSet<>(years.keySet());
        System.out.printf("%d => %d\r\n",min, max);
        for(Integer key : yearsKeys) {
            System.out.printf("[%d] = %d\r\n",key, years.get(key));
            population += years.get(key);
            if(highestPopulation<population) {
                highestPopulation = population;
                highestPopulationYear = key;
            }
        }
        return highestPopulationYear;
    }
    private int getMinBirthYear(List<Person> people) {
        int minBirthYear = Integer.MAX_VALUE;
        for(Person person : people) {
            if(minBirthYear>person.birthYear) {
                minBirthYear = person.birthYear;
            }
        }
        return minBirthYear;
    }
    private int getMaxBirthYear(List<Person> people) {
        int maxBirthYear = 0;
        for(Person person : people) {
            if(maxBirthYear<person.birthYear) {
                maxBirthYear = person.birthYear;
            }
        }
        return maxBirthYear;
    }
    public int yearWithMostPeople(List<Person> people) {
        int highestPopulationYear = 0;
        int startYear = getMinBirthYear(people);
        int endYear = getMaxBirthYear(people);
        //get deltas
        HashMap<Integer, Integer> years = getDeltas(people);
        //get highestPopulation year
        highestPopulationYear = getYear(years, startYear, endYear);

        return highestPopulationYear;
    }
//O(P + Y)
}
