package com.demo.important.shouxie;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shijianwei
 * @since 2019/03/26
 */
public class MyContainer2<T> {
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();
    private LinkedList<T> list = new LinkedList<>();
    private int capacity = 10;

    public void put(T t) {
        lock.lock();
        try {
            while(list.size() >= capacity) {
                producer.await();
            }
            list.add(t);
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        try {
            while (list.size() == 0) {
                consumer.await();
            }
            T t = list.removeFirst();
            producer.signalAll();
            return t;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return null;
    }
}
