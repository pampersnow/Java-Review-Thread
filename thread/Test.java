package thread;

public class Test {
	//此方式不够灵活，由于Java的单继承性，不能再继承其他类了
		static class ExtendsThread extends Thread{

			@Override
			public void run() {
				System.out.println("extends run...");
			}
			
		}
		// 推荐这种，java可以实现多个接口，只能继承一个类
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
