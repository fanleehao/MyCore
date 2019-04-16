package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月16日 下午9:06:29 
 * @desc 
 **/
public class MyCurrentThread extends Thread{
	
	public MyCurrentThread() {
		// TODO Auto-generated constructor stub
		System.out.println("Call constructor. " + Thread.currentThread().getName());
		//this始终都是当前对象
		System.out.println("this.name= " + this.getName());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Call run. " + Thread.currentThread().getName());
		System.out.println("this.name= " + this.getName());
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		MyCurrentThread myCurrentThread = new MyCurrentThread();
//		myCurrentThread.start(); 
		
		//run调用的是一个过程，所以线程还是主线程main
		myCurrentThread.run();
	}
}
