package thread;

public class Test {
	//�˷�ʽ����������Java�ĵ��̳��ԣ������ټ̳���������
		static class ExtendsThread extends Thread{

			@Override
			public void run() {
				System.out.println("extends run...");
			}
			
		}
		// �Ƽ����֣�java����ʵ�ֶ���ӿڣ�ֻ�ܼ̳�һ����
		static class RunnableThread implements Runnable{

			@Override
			public void run() {
				System.out.println("implements run...");
			}
			
		}
		

		public static void main(String[] args) {
			ExtendsThread thread1 = new ExtendsThread();
			thread1.start();
			
			Thread  thread2 = new Thread(new RunnableThread());
			thread2.start();
		}
}
