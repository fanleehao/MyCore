package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月16日 下午9:46:21 
 * @desc 
 **/
public class ThreadStop extends Thread {
	
	private SynchronizedObj obj;
	
	public ThreadStop(SynchronizedObj obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.printString("b", "bb");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SynchronizedObj obj = new SynchronizedObj();
			ThreadStop threadStop = new ThreadStop(obj);
			threadStop.start();
			Thread.sleep(1000);
			threadStop.stop();
			System.out.println(obj.getUsername() + " " + obj.getPassword());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}


class SynchronizedObj {
	private String username = "a";
	private String password = "aa";
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	synchronized public void printString(String username, String password) {
		try {
			this.username = username;
			Thread.sleep(100000);
			this.password = password;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}



