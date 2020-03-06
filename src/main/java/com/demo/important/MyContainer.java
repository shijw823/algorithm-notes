package com.demo.important;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shijianwei
 * @create 2017-06-05
 */
public class MyContainer {
	private List<Object> list = new ArrayList<Object>();

	public void add(Object o) {
		list.add(o);
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		MyContainer myContainer = new MyContainer();
		CountDownLatch latch = new CountDownLatch(1);

		Thread t1 = new Thread(()-> {
			System.out.println("t1 start");
			for(int i=0;i<10;i++) {
				System.out.println("add " + i);
				myContainer.add(new Object());
				if(myContainer.size() == 5) {
					latch.countDown();
				}
				try {
					TimeUnit.MILLISECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(()->{
			System.out.println("t2 start");
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t2 is over");
		});

		t2.start();
		try {
			TimeUnit.MILLISECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();

	}
}
