package thread.crossThread;

public class PopThread extends Thread{
	private DBTools db;
	 
	public PopThread(DBTools db) {
		super();
		this.db = db;
	}
 
	@Override
	public void run() {
		db.bakupA();
	}
}
