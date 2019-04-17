package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午10:59:55 
 * @desc synchronized锁重入
 *       重入锁：自己可以再次获得自己内部的对象锁
 **/
public class SynLockIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynLockInThread synLockInThread = new SynLockInThread();
		synLockInThread.start();
	}

}

class SynLockInThread extends Thread{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Service service = new Service();
		service.service1();
		
	}
}


class Service{
	synchronized public void service1(){
		System.out.println("Service 1");
		service2();
	}
	
	synchronized public void service2(){
		System.out.println("Service 2");
		service3();
	}
	
	synchronized public void service3(){
		System.out.println("Service 3");
	}
}