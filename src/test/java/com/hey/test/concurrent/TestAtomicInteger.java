package com.hey.test.concurrent;

import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by heer on 2018/4/19.
 * 测试AtomicInteger
 */
public class TestAtomicInteger {

    @Test
    public void testAll() throws InterruptedException{
        final AtomicInteger value = new AtomicInteger(10);
        assertEquals(value.compareAndSet(1, 2), false);
        assertEquals(value.get(), 10);
        assertTrue(value.compareAndSet(10, 3));
        assertEquals(value.get(), 3);
        value.set(0);
        //
        assertEquals(value.incrementAndGet(), 1);
        assertEquals(value.getAndAdd(2),1);
        assertEquals(value.getAndSet(5),3);
        assertEquals(value.get(),5);
        //
        final int threadSize = 10;
        final int j = 0;

        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {


            ts[i] = new Thread() {
                public void run() {
                    value.incrementAndGet();
                    changeJ(j);
                    System.out.println("这个是j："+j);
                    System.out.println("这个是value："+value);
                }
            };
        }
        //
        for(Thread t:ts) {
            t.start();
        }
        for(Thread t:ts) {
            t.join();
        }
        //
        assertEquals(value.get(), 5+threadSize);
    }
    public void changeJ(int j){
        ++j;
    }

//    @Test
//    public void testJ(){
//        Thread thread = new Thread() {
//            int j = 0;
//            for(
//            int i = 0;
//            i<10;i++)
//
//            {
//                public void run () {
//                changeJ(j);
//                System.out.println("这个是j：" + j);
//            }
//            }
//
//            ;
//        }
//
//
//        int j=0;
//        for (int i = 0; i < 100; i++) {
//            ++j;
//            System.out.println(j);
//        }
//    }
}
