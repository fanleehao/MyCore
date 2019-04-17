package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午9:25:18 
 * @desc 
 **/
public class ThreadPriority extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("MyThread priority:" + this.getPriority());
		ThreadPriority t2 = new ThreadPriority();
		t2.start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPriority threadPriority = new ThreadPriority();
		threadPriority.start();
	}

}
