package com.game.grizzly.core.gameplace.mth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++) {
			executorService.execute(new GameThread());
		}
		executorService.shutdown();
	}
}
