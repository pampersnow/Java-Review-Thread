package thread.exception;

public class MyThread extends Thread{
	//��һ���߳������������һ���߳�ִ�б�����Ӱ�������̵߳ļ���ִ��
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
				/*�����һ��sleep֮�������߳̾Ͳ�����ֹ�ˣ���Ϊrun�����������catch��䣬
				 * public void uncaughtException(Thread t, Throwable e)��������ִ��
				 */
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("��ѭ���У�" + Thread.currentThread().getName());
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
			System.out.println("��ѭ��ִ����:"+Thread.currentThread().getName());
		}
	} */
}
