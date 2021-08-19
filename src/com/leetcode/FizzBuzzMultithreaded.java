package com.leetcode;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzzMultithreaded {
    private int n;
    private int count = 1;
    private boolean divisibleBy3 = false;
    private boolean divisibleBy5 = false;
    private ReentrantLock lock = new ReentrantLock();

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            try {
                lock.lock();
                if(count > n) break;
                if (divisibleBy3 && !divisibleBy5) {
                    printFizz.run();
                    count++;
                    divisibleBy3 = count % 3 == 0;
                    divisibleBy5 = count % 5 == 0;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            try {
                lock.lock();
                if(count > n) break;
                if (!divisibleBy3 && divisibleBy5) {
                    printBuzz.run();
                    count++;
                    divisibleBy3 = count % 3 == 0;
                    divisibleBy5 = count % 5 == 0;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            try {
                lock.lock();
                if(count > n) break;
                if (divisibleBy3 && divisibleBy5) {
                    printFizzBuzz.run();
                    count++;
                    divisibleBy3 = false;
                    divisibleBy5 = false;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            try {
                lock.lock();
                if(count > n) break;
                if (!divisibleBy3 && !divisibleBy5) {
                    printNumber.accept(count);
                    count++;
                    divisibleBy3 = count % 3 == 0;
                    divisibleBy5 = count % 5 == 0;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}