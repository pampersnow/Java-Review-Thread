package thread;

/**
 * @author JYB
  *         ���Ե���1��1��������������ģ�ͣ������1�Զ���߶�Զ࣬list.size��Ҫʹ��while�жϣ����������߳��޸�sizeֵ�Ե�ǰ�߳��޸�֪��
  *         ���������жϴ���Ȼ��notify�ĳ�notifyAll��ֹ�����̼߳���״̬��
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
