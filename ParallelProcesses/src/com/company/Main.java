package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class RecusriveSumTask extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    private final int division;

    public RecusriveSumTask(long[] numbers, int start, int end, int division) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.division = division;
    }

    @Override
    protected Long compute() {
        if ((end - start) <= (numbers.length / division)) {
            //if the end index minus start index is less than array length divided by number of tasks,
            //that means the array length is smaller than the size we want to split by so we process it here
            System.out.println(start + " : " + end);
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            // so if we do divide the work
            int mid = (start + end) /2;
            RecusriveSumTask leftTask = new RecusriveSumTask(numbers, start, mid, division);
            RecusriveSumTask rightTask = new RecusriveSumTask(numbers, mid, end, division);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength, 1, numbersLength).toArray();

        long sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        ForkJoinPool threadPool = ForkJoinPool.commonPool();

        List<Callable<Long>> tasks = new ArrayList<>();

        int taskNo = 10;
        int splitCount = numbersLength/taskNo;
        for (int i = 0; i < taskNo; i++) {
            int start = i * splitCount;
            int end = start + splitCount;
            tasks.add(() -> {
                long tasksum = 0;
                for (int j = start; j < end; j++) {
                    tasksum += (long) numbers[j];
                }
                return tasksum;
            });
        }

        List<Future<Long>> futures = threadPool.invokeAll(tasks);

        System.out.println("CPUs: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Parallelism = " + threadPool.getParallelism());
        System.out.println("Pool size = " + threadPool.getPoolSize());
        System.out.println("Steal count = " + threadPool.getStealCount());

        long taskSum = 0;
        for (Future<Long> future : futures) {
            taskSum += future.get();
        }

        System.out.println("Thread Pool Sum = " + taskSum);

        RecursiveTask<Long> task = new RecusriveSumTask(numbers, 0, numbersLength, 2);
        long forkJoinSum = threadPool.invoke(task);
        System.out.println("RecursiveTask sum is: " + forkJoinSum);

        threadPool.shutdown();

        System.out.println(threadPool.getClass().getName());

    }
}
