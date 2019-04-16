package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月9日 下午5:04:26 
 * @desc 共享变量，操作count
 **/
public class ThreadWithShared extends Thread {
	
	private int count = 5;
	
	
	@Override
//	public void run() {
	synchronized public void run(){   //同步锁后，不会产生线程安全问题
		// TODO Auto-generated method stub
		super.run();
		count--;     
		System.out.println("由线程 " + Thread.currentThread().getName() + "计算，count = " + count);
	}

	
	public static void main(String[] args) {
		ThreadWithShared tShared = new ThreadWithShared();
		Thread aThread = new Thread(tShared, "A");
		Thread bThread = new Thread(tShared, "B");
		Thread cThread = new Thread(tShared, "C");
		Thread dThread = new Thread(tShared, "D");
		
		aThread.start();
		bThread.start();
		cThread.start();
		dThread.start();
		
		/**
		 * 一种运行结果：产生了非线程安全的情况，在某些JVM中，count--操作不是原子的（线程安全的）
		 * 由线程 A计算，count = 4
			由线程 D计算，count = 1
			由线程 C计算，count = 2
			由线程 B计算，count = 2
		 */
	}
}
