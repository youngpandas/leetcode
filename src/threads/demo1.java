package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition decCondition = lock.newCondition();
    private int i = 0;
    private boolean isFirst = true;

    public void addFirst(Runnable add1) {

    }

    public void addSecond(Runnable add2) {

    }

    public void decFirst(Runnable dec1) {

    }

    public void decSecond(Runnable dec2) {

    }

    public void solve() {
        Runnable add1 = new Runnable() {
            @Override
            public void run() {
                i++;
            }
        };
        Runnable add2 = new Runnable() {
            @Override
            public void run() {
                i++;
            }
        };
        Runnable dec1 = new Runnable() {
            @Override
            public void run() {
                i--;
            }
        };
        Runnable dec2 = new Runnable() {
            @Override
            public void run() {
                i--;
            }
        };
    }

    public static void main(String[] args) {

    }

}
