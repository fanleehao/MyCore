package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午10:44:00 
 * @desc 实验：证明线程锁的是对象而不是类
 **/
public class SynchronizedMethodLockObject {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyObject object = new MyObject();
		ThreadAA threadAA = new ThreadAA(object);
		threadAA.setName("AA");
		ThreadBB threadBB = new ThreadBB(object);
		threadBB.setName("BB");
		
		threadAA.start();
		threadBB.start();
	}

}

class MyObject{
	synchronized public void methodA() {
		try {
			System.out.println("Begin methodA.." + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("End methodA.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	synchronized public void methodB() {
		try {
			System.out.println("Begin methodB.." + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("End methodB.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class ThreadAA extends Thread{
	private MyObject object;
	public ThreadAA(MyObject object) {
		// TODO Auto-generated constructor stu
		this.object = object;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		object.methodA();
	}
}

class ThreadBB extends Thread{
	private MyObject object;
	public ThreadBB(MyObject object) {
		// TODO Auto-generated constructor stu
		this.object = object;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		object.methodB();
	}
}