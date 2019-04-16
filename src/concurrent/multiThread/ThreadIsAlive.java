package concurrent.multiThread;

/**
 * @author fanleehao
 * @date 创建时间：2019年4月16日 下午9:15:11
 * @desc
 **/
public class ThreadIsAlive extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("run = " + this.isAlive());
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadIsAlive tIsAlive = new ThreadIsAlive();
		System.out.println("in main. " + tIsAlive.isAlive());
		tIsAlive.start();
		Thread.sleep(1000);
		System.out.println("end . " + tIsAlive.isAlive());
	}

}
