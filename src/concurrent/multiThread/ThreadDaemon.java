package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午9:50:39 
 * @desc 
 **/
public class ThreadDaemon extends Thread {
	
	private int i = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			while(true){
				i++;
				System.out.println("i=" + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ThreadDaemon threadDaemon = new ThreadDaemon();
			//threadDaemon.setDaemon(true);  //取消设置守护线程，线程运行内容会继续打印
			threadDaemon.start();
			Thread.sleep(5000);
			System.out.println("Main 离开了，ThreadDeamon就不再计数了。。");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
