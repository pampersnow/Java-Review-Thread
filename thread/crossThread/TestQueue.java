package thread.crossThread;

public class TestQueue {
	public static void main(String[] args) {
		DBTools stack = new DBTools();
		
		for(int i=0;i<20;i++){
			PushThread push = new PushThread(stack);
			push.start();
			PopThread pop = new PopThread(stack);
			pop.start();
		}
		
	} 
}
