package com.demo.important.masterworker;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shijianwei
 * @since 2017/12/11
 */
public class Worker2 implements Callable {
	private final CountDownLatch latch;
	private final int i;

	public Worker2(CountDownLatch latch, int i) {
		this.latch = latch;
		this.i = i;
	}

	@Override
	public Object call() {
		try {
			this.doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
		}
		return this.i;
	}

	private void doSomething() throws InterruptedException {
		TimeUnit.SECONDS.sleep(Long.valueOf(new Random().nextInt(3)));
		System.out.println(this.i + "->" + Thread.currentThread() + " doSomething");
	}
}
