 package thread;

/**
 * @author JYB
  *     ѭ������
 */
public class PopThread extends Thread{
	private MyBlockQueue stack;
	 
	public PopThread(MyBlockQueue stack) {
		super();
		this.stack = stack;
	}
 
	@Override
	public void run() {
		for(;;){
			stack.pop();
		}
	} 
}
