 package thread;

/**
 * @author JYB
 *	—≠ª∑»Î∂”
 */
public class PushThread extends Thread{
	private MyBlockQueue stack;
	 
	public PushThread(MyBlockQueue stack) {
		super();
		this.stack = stack;
	}
 
	@Override
	public void run() {
		for(;;){
			stack.push();
		}
	} 
}
