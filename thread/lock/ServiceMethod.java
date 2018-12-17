package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 
 * 	JYB boolean tryLock(long timeout,TimeUnit unit)
 *         ������������ȴ�ʱ����û�б���һ���̱߳��֣��ҵ�ǰ�߳�δ���жϣ����ȡ�������� �磺
 */
public class ServiceMethod {
	public ReentrantLock lock = new ReentrantLock();

	public Condition condition = lock.newCondition();

	public void awaitMethod() {
		try {
			if (lock.tryLock(3, TimeUnit.SECONDS)) {
				System.out.println(Thread.currentThread().getName() + "�������ʱ�䣺" + System.currentTimeMillis());
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
			System.out.println("��" + lock.getWaitQueueLength(condition) + "���̵߳ȴ�condition");
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
				System.out.println(Thread.currentThread().getName() + "����waitMethodʱ�䣺" + System.currentTimeMillis());
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
