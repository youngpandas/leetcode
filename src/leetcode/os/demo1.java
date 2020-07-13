package leetcode.os;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {

    private int val = 1;
    private int tag = 0;
    private int n = 100;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c0 = lock.newCondition();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public static void main(String[] args) {
        new demo1().solve();
    }

    public void solve() {
        new Thread(new PrintThread(0, 1, c0, c1)).start();
        new Thread(new PrintThread(1, 2, c1, c2)).start();
        new Thread(new PrintThread(2, 3, c2, c3)).start();
        new Thread(new PrintThread(3, 0, c3, c0)).start();
    }

    private class PrintThread implements Runnable {

        private int cur;
        private int next;
        private Condition curCondition;
        private Condition nextCondition;

        public PrintThread(int cur, int next, Condition curCondition, Condition nextCondition) {
            this.cur = cur;
            this.next = next;
            this.curCondition = curCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (tag != cur) {
                        curCondition.await();
                    }
                    val = (1 - val);
                    System.out.print(val);
                    tag = next;
                    nextCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
