package leetcode;

import sun.misc.ConditionLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo1114 {

    private Lock lock = new ReentrantLock();
    private Condition conditionLock2 = lock.newCondition();
    private Condition conditionLock3 = lock.newCondition();

    public demo1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            lock.lock();
            printFirst.run();
            conditionLock2.signal();
        } finally {
            lock.unlock();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            conditionLock2.await();
            printSecond.run();
            conditionLock3.signal();
        } finally {
            lock.unlock();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            conditionLock3.await();
            printThird.run();
        } finally {
            lock.unlock();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }

}
