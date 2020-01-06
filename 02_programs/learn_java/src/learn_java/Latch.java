package learn_java;

import java.util.concurrent.CountDownLatch;

class LockClass{
	private CountDownLatch latchCount = new CountDownLatch(2);
	
	public CountDownLatch getLatchCount() {
		return latchCount;
	}

	public void setLatchCount(CountDownLatch latchCount) {
		this.latchCount = latchCount;
	}

	public void lock() throws InterruptedException {
		latchCount.await();
	}
	
	public void unlock() {
		latchCount.countDown();
	}
	
	
}


public class Latch extends Thread{

	private LockClass lockclass;
//	private String name;
	
	Latch(LockClass lockclass, String name) {
		this.lockclass = lockclass;
		this.setName(name);
	}
	
	@Override
	public void run(){
		System.out.println(this.getName() + this.getId() + " Running01...");
		try {
			System.out.println(this.getName() + this.getId() + " beLock....");
			lockclass.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + this.getId() + " Running02....");
	}
	
	public void goon() {
		
		lockclass.unlock();
		System.out.println(this.getName() + this.getId() + " reLock....");
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockClass lockClass = new LockClass();
		
		Latch latch1 = new Latch(lockClass, "thread01_");
		latch1.start();
		
		Thread.sleep(10000);
		
		Latch latch2 = new Latch(lockClass, "thread02_");
		
		System.out.println(lockClass.getLatchCount().getCount());
		for(int i=0; i<lockClass.getLatchCount().getCount();) {
			latch2.goon();
		}
		System.out.println(lockClass.getLatchCount().getCount());
	}

}
