package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class demo1195 {
    class IntConsumer {
        public void accept(int x) {
            System.out.println(x);
        }
    }

    class FizzBuzz {
        private int n;
        private int i = 1;
        private ReentrantLock lock = new ReentrantLock();
        private Condition c0 = lock.newCondition();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                if (i > n) break;
                lock.lock();
                if (!(i % 3 == 0 && i % 5 != 0)) {
                    c0.await();
                }
                printFizz.run();
                i++;
                if (i % 3 == 0) {
                    if (i % 5 == 0) c2.signal();
                    else c0.signal();
                } else {
                    if (i % 5 == 0) c1.signal();
                    else c3.signal();
                }
                lock.unlock();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                if (i > n) break;
                lock.lock();
                if (!(i % 3 != 0 && i % 5 == 0)) {
                    c1.await();
                }
                printBuzz.run();
                i++;
                if (i % 3 == 0) {
                    if (i % 5 == 0) c2.signal();
                    else c0.signal();
                } else {
                    if (i % 5 == 0) c1.signal();
                    else c3.signal();
                }
                lock.unlock();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                if (i > n) break;
                lock.lock();
                if (!(i % 3 == 0 && i % 5 == 0)) {
                    c2.await();
                }
                printFizzBuzz.run();
                i++;
                if (i % 3 == 0) {
                    if (i % 5 == 0) c2.signal();
                    else c0.signal();
                } else {
                    if (i % 5 == 0) c1.signal();
                    else c3.signal();
                }
                lock.unlock();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                if (i > n) break;
                lock.lock();
                if (i % 3 != 0 && i % 5 != 0) {
                    c3.await();
                }
                printNumber.accept(i);
                i++;
                if (i % 3 == 0) {
                    if (i % 5 == 0) c2.signal();
                    else c0.signal();
                } else {
                    if (i % 5 == 0) c1.signal();
                    else c3.signal();
                }
                lock.unlock();
            }
        }
    }

}
