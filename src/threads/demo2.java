package threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class demo2 {

    private int i = 1;
    private int n = 100;
    private Semaphore dec1 = new Semaphore(0);
    private Semaphore add1 = new Semaphore(0);
    private Semaphore dec2 = new Semaphore(0);
    private Semaphore add2 = new Semaphore(0);

    public demo2(int n) {
        this.n = n;
    }

    public void solve() {
        Runnable d1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        dec1.acquire();
                        i--;
                        System.out.print(i);
                        add1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable a1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        add1.acquire();
                        i++;
                        System.out.print(i);
                        dec2.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable d2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        dec2.acquire();
                        i--;
                        System.out.print(i);
                        add2.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable a2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        add2.acquire();
                        i++;
                        System.out.print(i);
                        dec1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(d1).start();
        new Thread(a1).start();
        new Thread(d2).start();
        new Thread(a2).start();
    }

    public static void main(String[] args) {
        new demo2(100).solve();
    }

}
