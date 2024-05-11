package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServicePractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Future<?> hi__ = executorService.submit(() -> System.out.println("Hi  "));
//        Future<String> submit = executorService.submit(() -> {
//            System.out.println("Thread Name"+Thread.currentThread().getName());
//            return "Hello";
//        });
//        System.out.println(submit.get());
//        executorService.shutdown();


        //Demo Callable task
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Current time :: " + LocalDateTime.now();
        };

        //Executor service instance
        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Callable<String>> tasksList = Arrays.asList(callableTask, callableTask, callableTask);

        //1. execute tasks list using invokeAll() method
//        try
//        {
//            List<Future<String>> results = executor.invokeAll(tasksList);
//
//            for(Future<String> result : results) {
//                System.out.println(result.get());
//            }
//        }
//        catch (InterruptedException e1)
//        {
//            e1.printStackTrace();
//        }

        //2. execute individual tasks using submit() method
        Future<String> result = executor.submit(callableTask);

        while(result.isDone() == false)
        {
            try
            {
                System.out.println("The method return value : " + result.get());
                break;
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }

            //Sleep for 1 second
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Shut down the executor service
        executor.shutdownNow();
    }

}
