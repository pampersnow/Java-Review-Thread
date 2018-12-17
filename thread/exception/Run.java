package thread.exception;

public class Run {
	
	public static void main(String[] args) {
		MyThreadGroup group = new MyThreadGroup("我的线程组");
		MyThread[] myThread = new MyThread[10];
		for (int i = 0; i < myThread.length; i++) {
			myThread[i] = new MyThread(group, " 线程 " + (i + 1), "1");
			myThread[i].start();
		}
 
		MyThread newT = new MyThread(group, "报错线程 ", "a");
		newT.start();
	} 
	
	
	//如果线程组中一个线程异常，其他线程也终止
	/*public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("自定义线程组");
		MyThread[] myThread = new MyThread[10];
		for(int i=0;i<myThread.length;i++){
			myThread[i] = new MyThread(group,"线程"+(i+1),"1");
			myThread[i].start();
		}
		MyThread newT = new MyThread(group, "报错线程", "a");
		newT.start();
	} */
}
