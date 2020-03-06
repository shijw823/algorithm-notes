package com.demo.important.masterworker;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shijianwei
 * @since 2017/12/11
 */
public class Worker implements Runnable {
	private final CountDownLatch latch;

	public Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			this.doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
		}
	}

	private void doSomething() throws InterruptedException {
		TimeUnit.SECONDS.sleep(Long.valueOf(new Random().nextInt(3)));
		System.out.println(Thread.currentThread() + " doSomething");
	}
}
