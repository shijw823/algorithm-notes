package com.demo.other;

public class SynchronizedTest {

    public static synchronized void m1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1");
    }

    public synchronized void m2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public synchronized void m3() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m3");
    }

    public static void main(String[] args) {

        SynchronizedTest test1 = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();

        new Thread(() -> {
            test1.m2();
        }).start();

        new Thread(() -> {
            test2.m3();
        }).start();
    }

}
