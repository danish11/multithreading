package com.reentrantlock;

public class ReentrantLockTutorial {
public static void main(String[] args) throws InterruptedException {
	Runner runner = new Runner();
	
	Thread t1 = new Thread(new Runnable(){
		@Override
		public void run() {
			try {
				runner.firstRunner();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	Thread t2 = new Thread(new Runnable(){
		@Override
		public void run() {
			try {
				runner.secondRunner();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	runner.finished();
	
}
}
