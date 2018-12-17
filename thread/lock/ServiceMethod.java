package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 
 * 	JYB boolean tryLock(long timeout,TimeUnit unit)
 *         如果锁定给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定， 如：
 */
public class ServiceMethod {
	public ReentrantLock lock = new ReentrantLock();

	public Condition condition = lock.newCondition();

	public void awaitMethod() {
		try {
			if (lock.tryLock(3, TimeUnit.SECONDS)) {
				System.out.println(Thread.currentThread().getName() + "获得锁的时间：" + System.currentTimeMillis());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public void notifyMethod() {
		try {
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程等待condition");
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final ServiceMethod service = new ServiceMethod();

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "调用waitMethod时间：" + System.currentTimeMillis());
				service.awaitMethod();
			}
		};
		Thread threadA = new Thread(runnable);
		threadA.setName("A");
		threadA.start();
		Thread threadB = new Thread(runnable);
		threadB.setName("B");
		threadB.start();

	}
}
