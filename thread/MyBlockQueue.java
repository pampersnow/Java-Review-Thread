package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JYB
  * 实现长度为1的阻塞队列
  * 出队列与入队列
 */
public class MyBlockQueue {
private List<String> list = new ArrayList<>();
	
	synchronized public void push(){
		try {
			if(this.list.size() == 1){
				this.wait();
			}
			list.add("object"+Math.random());
			this.notify();
			System.out.println("push list size is "+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public String pop(){
		String popValue = "";
		try {
			if(this.list.size() == 0){
				this.wait();
			}
			popValue = " "+list.get(0);
			System.out.println("the popValue is:"+popValue);
			list.remove(0);
			this.notify();
			System.out.println("pop list size is "+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return popValue;
	} 
}
