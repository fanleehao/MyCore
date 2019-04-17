package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午11:15:58 
 * @desc 对象锁在出现异常时自动释放
 **/
public class ThrowExNoLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThrowExNoLockService service = new ThrowExNoLockService();
		try {
			ThrowExNoLockThreadA a = new ThrowExNoLockThreadA(service);
			a.setName("a");
			a.start();
			Thread.sleep(500);
			
			ThrowExNoLockThreadB b = new ThrowExNoLockThreadB(service);
			b.setName("b");
			b.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

class ThrowExNoLockService {
	synchronized public void testMethod(){
		if (Thread.currentThread().getName().equals("a")) {
			System.out.println("Thread Name = " + Thread.currentThread().getName() + 
					" run at. " + System.currentTimeMillis());
			int i = 1;
			while(i==1){
				if(("" + Math.random()).substring(0, 8).equals("0.123456")){
					System.out.println("Thread Name = " + Thread.currentThread().getName() +
							" run exTime. " + System.currentTimeMillis());
				}
				Integer.parseInt("a");
			}
		}
		else{
			System.out.println("Thread B run at. " + System.currentTimeMillis());
		}
	}
}

class ThrowExNoLockThreadA extends Thread{
	private ThrowExNoLockService service;

	public ThrowExNoLockThreadA(ThrowExNoLockService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.testMethod();
	}
}

class ThrowExNoLockThreadB extends Thread{
	private ThrowExNoLockService service;

	public ThrowExNoLockThreadB(ThrowExNoLockService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.testMethod();
	}
}