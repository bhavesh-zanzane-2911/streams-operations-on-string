package org.example;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFuturePractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //run Async return type is CompletableFuture<Void>
        CompletableFuture<Void> hello = CompletableFuture.runAsync(() -> System.out.println("hello"));
        System.out.println(hello.get()); // returns null

        //SupplyAsync with future return type CompletableFuture<T>
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        //then apply also takes 1 argument
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenApply(s1 -> s1 + " World");
        System.out.println(stringCompletableFuture1.get()); //returns Hello World

        //supplyAsync with future return type CompletableFuture<Void>
        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> "Hello");
        //then accept takes 1 argument
        CompletableFuture<Void> voidCompletableFuture = stringCompletableFuture2.thenAccept(s -> System.out.println(s + " world"));
        System.out.println(voidCompletableFuture.get());//returns null

        //don't need the value of computation nor want to have a rerun type
        //then use then run which takes 0 argumentes and returns CompletableFuture<Void>


        CompletableFuture<String> stringCompletableFuture3 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> completed = stringCompletableFuture3.thenRun(() -> System.out.println("Completed"));
        System.out.println(completed.get());//returns null



        //Combining multiple futures together
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        //return type is of CompletableFuture<Void>
        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);
        System.out.println(combinedFuture.get());

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println("Combined Result"+combined+"Bhavesh");


    }

}
