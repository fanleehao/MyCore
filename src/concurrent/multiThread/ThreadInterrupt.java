package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月16日 下午9:29:27 
 * @desc 
 **/
public class ThreadInterrupt extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i = 0; i < 500000; i++)
			System.out.println(i);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
			ThreadInterrupt tInterrupt = new ThreadInterrupt();
			tInterrupt.start();
			Thread.sleep(1000);
			tInterrupt.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("main Interrupt.");
			e.printStackTrace();
		}

	}

}
