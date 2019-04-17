package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午10:00:16 
 * @desc 
 **/
public class SynchronizedThread1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HasSelfPrivateNum obj = new HasSelfPrivateNum();
		ThreadA threadA = new ThreadA(obj);
		threadA.start();
		ThreadB threadB = new ThreadB(obj);
		threadB.start();
	}

}


class ThreadA extends Thread{
	private HasSelfPrivateNum obj;
	public ThreadA(HasSelfPrivateNum obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.addI("a");
	}
}

class ThreadB extends Thread{
	private HasSelfPrivateNum obj;
	public ThreadB(HasSelfPrivateNum obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.addI("b");
	}
}

class HasSelfPrivateNum{
	private int num = 0;
//	synchronized public void addI(String username){
	public void addI(String username){
		try{
			if(username.equals("a")){
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			}
			else {
				num = 200;
				System.out.println("b set over");
			}
			System.out.println(username + ":num = " + num);
		}catch(Exception e){
			
		}
	}
}