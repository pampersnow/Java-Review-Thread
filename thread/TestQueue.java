package thread;

/**
 * @author JYB
  *         测试的是1对1的生产者消费者模型，如果是1对多或者多对多，list.size需要使用while判断，否则当其他线程修改size值对当前线程无感知，
  *         导致条件判断错误，然后notify改成notifyAll防止出现线程假死状态。
 */
public class TestQueue {
	public static void main(String[] args) {
		MyBlockQueue stack = new MyBlockQueue();
		PushThread push = new PushThread(stack);
		PopThread pop = new PopThread(stack);

		push.start();
		pop.start();
	}
}
