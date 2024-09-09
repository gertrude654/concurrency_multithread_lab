package com.week2.labs.ConcurrencyMultithreading.sychronization;

import com.week2.labs.ConcurrencyMultithreading.sychronization.methodsBlocks.Library;
import com.week2.labs.ConcurrencyMultithreading.sychronization.methodsBlocks.User;

public class SynchronizedExample {
    public static void main(String[] args) {
        Library library = new Library();
        User user1 = new User(library, "User 1");
        User user2 = new User(library, "User 2");
        User user3 = new User(library, "User 3");

        user1.start();
        user2.start();
        user3.start();
    }
}
