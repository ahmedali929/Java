package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//this programs shows the relationship between Stream Parallelism and Ordering

//create a Person records so we can generate persons as examples
record Person(String firstName, String lastName, int age) {
    private final static String[] firsts = {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};
    private final static String[] lasts = {"Norton", "Ohara", "Peterson", "Quincy", "Richardson", "Smith"};
    private final static Random random = new Random();

    public Person() {
        this(firsts[random.nextInt(firsts.length)], lasts[random.nextInt(lasts.length)], random.nextInt(18,100));
    }

    @Override
    public String toString() {
        return "%s, %s, (%d)".formatted(lastName, firstName, age);
    }
}

public class MoreStreams {

    public static void main(String[] args) {
        //generate 10 persons and order them
        var persons = Stream.generate(Person::new)
                .limit(10)
                .sorted(Comparator.comparing(Person::lastName))
                .toArray();

        for (var person : persons) {
            System.out.println(person);
        }

        System.out.println("-----------------------------");

        Arrays.stream(persons)
                .limit(10)
                .parallel()
                //.sorted(Comparator.comparing(Person::lastName)) doesnt work for parallel streams
                .forEachOrdered(System.out::println); //forEachOrdered guarantees that the order of the person is the same as the original order

        System.out.println("-----------------------------");
        int sum = IntStream.range(1, 101)
                .parallel()
                .reduce(0, Integer::sum);

        System.out.println("The sum of the numbers is " + sum);

        String fatiha = """
                I begin in the name of Allah, the Most Beneficent, the Most Merciful
                All Praise to Allah, the Lord of All the Worlds
                The Most Beneficent, the Most Merciful
                Master of the Day of Judgement
                We only worship You and we only ask You for help
                Guide us to the straight path
                The path of those who earned your favor, not of those who gained your ire or went astray
                """;

        System.out.println("-----------------------------");
        var words = new Scanner(fatiha).tokens().toList();
        words.forEach(System.out::println);
        System.out.println("-----------------------------");

        var fatihaAgain = words
                .parallelStream()
                .collect(Collectors.joining(" ")); //this uses StringJoiner in a thread safe way
        System.out.println(fatihaAgain);

        Map<String, Long> lastNameCounts =
                Stream.generate(Person::new)
                        .limit(10000)
                        .parallel()
                        .collect(Collectors.groupingByConcurrent(
                                Person::lastName,
                                Collectors.counting()
                        ));
        lastNameCounts.entrySet().forEach(System.out::println);

        System.out.println(lastNameCounts.getClass().getName());

        //a ConcurrentSkipListMap is a way to use Maps in parallel. HashMaps and TreeMaps aren't thread-safe
        var lastCounts = new ConcurrentSkipListMap<String, Long>();
        Stream.generate(Person::new)
                .limit(10000)
                .parallel()
                .forEach((person) -> lastCounts.merge(person.lastName(), 1L, Long::sum));

        System.out.println(lastCounts);

        int total = 0;
        for (Long count: lastCounts.values()) {
            total += count;
        }

        System.out.println("Total = " + total);
        System.out.println(lastCounts.getClass().getName());


    }

}
