package com.hey.common.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * Created by heer on 2018/4/19.
 *
 */
public class TestAtomicInteger {

    public static void main(String[] args) throws Exception{
        final int max = 10;
        final int loopCount = 100000;
        long costTime = 0;
        final AtomicIntegerWithLock value1 = new AtomicIntegerWithLock(0);
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();

            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            value1.incrementAndGet();
                            System.out.println(value1);
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
//            for(Thread t:ts) {
//                t.join();
//            }

            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        System.out.println("cost1: " + (costTime));
        //
        System.out.println();
        costTime = 0;
        //
        final Object lock = new Object();
        for (int m = 0; m < max; m++) {
            staticValue=0;
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            synchronized(lock) {
                                ++staticValue;
                            }
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        //
        System.out.println("cost2: " + (costTime));
        System.out.println(staticValue);
    }

//    ConcurrentHashMap


    static int staticValue = 0;
}
