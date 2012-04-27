package com.game.grizzly.core.console;

public class Run {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new MainThread());
		thread.run();
	}

}

class MainThread implements Runnable {
	private void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	
	public void run() {
		threadMessage("Starting MessageLoop thread");

		Thread t = new Thread(new MessageLoop());
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");

		while (t.isAlive()) {
			threadMessage("Still waiting...");
			try {
				t.join(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		threadMessage("Finally!");
	}
	
}

class MessageLoop implements Runnable {
	
	private void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	
	public void run() {
		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
		"A kid will eat ivy too" };
		try {
			for (int i = 0; i < importantInfo.length; i++) {
				Thread.sleep(2000);
				threadMessage(importantInfo[i]);
			}
		} catch (InterruptedException e) {
			threadMessage("I wasn't done!");
		}
	}
}