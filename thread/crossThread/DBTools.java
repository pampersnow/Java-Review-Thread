 package thread.crossThread;

/**
 * @author JYB
  *      使用wait和notify实现交叉执行示例
 */
public class DBTools {
	private volatile boolean isTurn = false;
	 
	synchronized public void bakupA(){
		try {
			while(this.isTurn){
				this.wait();
			}
			for(int i=0;i<5;i++){
				System.out.println("AAAAAA");
			}
			this.isTurn = true;
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void bakupB(){
		try {
			while(!this.isTurn){
				this.wait();
			}
			for(int i=0;i<5;i++){
				System.out.println("BBBBBB");
			}
			this.isTurn = false;
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	} 
}
