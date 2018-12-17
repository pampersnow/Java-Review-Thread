 package thread;

/**
 * @author JYB
  *     Ñ­»·³ö¶Ó
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
