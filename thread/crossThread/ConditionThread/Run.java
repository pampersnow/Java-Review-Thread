 package thread.crossThread.ConditionThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author JYB
  *  使用Condition实现线程顺序交叉执行
 */
public class Run {
volatile private static int nextRun = 1;
	
	private static Lock lock = new ReentrantLock();
	
	private static Condition condition1 = lock.newCondition();
	
	private static Condition condition2 = lock.newCondition();
	
	private static Condition condition3 = lock.newCondition();
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable(){
 
			@Override
			public void run() {
				try {
					lock.lock();
					while(nextRun != 1){
						condition1.await();
					}
					for(int i=0;i<3;i++){
						System.out.println("Thread1 "+(i+1));
					}
					nextRun = 2;
					condition2.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable(){
 
			@Override
			public void run() {
				try {
					lock.lock();
					while(nextRun != 2){
						condition2.await();
					}
					for(int i=0;i<3;i++){
						System.out.println("Thread2 "+(i+1));
					}
					nextRun = 3;
					condition3.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		Thread thread3 = new Thread(new Runnable(){
 
			@Override
			public void run() {
				try {
					lock.lock();
					while(nextRun != 3){
						condition3.await();
					}
					for(int i=0;i<3;i++){
						System.out.println("Thread3 "+(i+1));
					}
					nextRun = 1;
					condition1.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		Thread[] array1 = new Thread[5];
		Thread[] array2 = new Thread[5];
		Thread[] array3 = new Thread[5];
		
		for(int i=0;i<5;i++){
			array1[i] = new Thread(thread1);
			array2[i] = new Thread(thread2);
			array3[i] = new Thread(thread3);
			array1[i].start();
			array2[i].start();
			array3[i].start();
		}
	} 
}
