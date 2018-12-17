package thread.crossThread;

public class PushThread extends Thread{
	private DBTools db;
	 
	public PushThread(DBTools db) {
		super();
		this.db = db;
	}
 
	@Override
	public void run() {
		db.bakupB();
	}

}
