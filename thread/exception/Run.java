package thread.exception;

public class Run {
	
	public static void main(String[] args) {
		MyThreadGroup group = new MyThreadGroup("�ҵ��߳���");
		MyThread[] myThread = new MyThread[10];
		for (int i = 0; i < myThread.length; i++) {
			myThread[i] = new MyThread(group, " �߳� " + (i + 1), "1");
			myThread[i].start();
		}
 
		MyThread newT = new MyThread(group, "�����߳� ", "a");
		newT.start();
	} 
	
	
	//����߳�����һ���߳��쳣�������߳�Ҳ��ֹ
	/*public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("�Զ����߳���");
		MyThread[] myThread = new MyThread[10];
		for(int i=0;i<myThread.length;i++){
			myThread[i] = new MyThread(group,"�߳�"+(i+1),"1");
			myThread[i].start();
		}
		MyThread newT = new MyThread(group, "�����߳�", "a");
		newT.start();
	} */
}
