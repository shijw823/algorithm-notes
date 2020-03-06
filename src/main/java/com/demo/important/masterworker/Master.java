package com.demo.important.masterworker;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author shijianwei
 * @since 2017/12/11
 */
public class Master {
	private static int workerNum = 5;
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(workerNum);

		List<Future> futures = new ArrayList<>();
		for (int i = 0; i < workerNum; i++) {
			//new Thread(new Worker(latch)).start();
			Future<?> future = executorService.submit(new Worker2(latch, i));
			futures.add(future);
		}

		try {
			latch.await();
			for (Future f : futures) {
				System.out.println(f.get());
			}

			System.out.println("master doSomething");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
