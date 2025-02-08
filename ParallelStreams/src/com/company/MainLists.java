package com.company;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

public class MainLists {

    public static void main(String[] args) {

        var threadMap = new ConcurrentSkipListMap<String, Long>();

        var persons = Stream.generate(Person::new)
                .limit(10000)
                .parallel()
                //using peek to debug the code and to see which threads are doing the work
                .peek((p) -> {
                    var threadName = Thread.currentThread().getName()
                            .replace("ForkJoinPool.commonPool-worker-", "thread_");
                    threadMap.merge(threadName, 1L, Long::sum);
                })
                .toArray(Person[]::new);

        System.out.println("Total = " + persons.length);

        System.out.println(threadMap);

        long total = 0;
        for (long count : threadMap.values()) {
            total += count;
        }
        System.out.println("ThreadCounts: " + total);

    }

}
