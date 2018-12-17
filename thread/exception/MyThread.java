package thread.exception;

public class MyThread extends Thread{
	//在一个线程组中如果其中一个线程执行报错并不影响其他线程的继续执行
	private String num;
	 
	public MyThread(ThreadGroup group,String name,String num) {
		super(group,name);
		this.num = num;
	}
  
	@SuppressWarnings("unused")
	@Override
	public void run() {
		int numInt = Integer.parseInt(num);
		while (this.isInterrupted() == false) {
			try {
				/*添加了一个sleep之后其他线程就不会终止了，因为run方法中如果有catch语句，
				 * public void uncaughtException(Thread t, Throwable e)方法不会执行
				 */
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("死循环中：" + Thread.currentThread().getName());
		}
	} 
	
/*	@SuppressWarnings("unused")
	@Override
	public void run() {
		int numInt = Integer.parseInt(num);
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("死循环执行中:"+Thread.currentThread().getName());
		}
	} */
}
