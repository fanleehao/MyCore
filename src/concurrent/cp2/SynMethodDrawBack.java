package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 下午12:01:53 
 * @desc 实验--同步方法的缺陷，占用整个对象锁
 **/
public class SynMethodDrawBack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynMethodDrawBackTask task = new SynMethodDrawBackTask();
		
		SynMethodDrawBackThreadA threadA = new SynMethodDrawBackThreadA(task);
		threadA.start();
		SynMethodDrawBackThreadB threadB = new SynMethodDrawBackThreadB(task);
		threadB.start();
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		long beginT = SynMethodDrawBackUtils.beginT1;
		if(SynMethodDrawBackUtils.beginT2 < SynMethodDrawBackUtils.beginT1){
			beginT = SynMethodDrawBackUtils.beginT2;
		}
		long endT = SynMethodDrawBackUtils.endT1;
		if(SynMethodDrawBackUtils.endT2 > SynMethodDrawBackUtils.endT1){
			endT = SynMethodDrawBackUtils.endT2;
		}
		System.out.println("Cost.. = " + (endT - beginT) / 1000  + "s");
	}

}

class SynMethodDrawBackTask{
	private String data1;
	private String data2;
	
	synchronized public void doLongTimeTask(){
		try {
			System.out.println("bgein task...");
			Thread.sleep(3000);
			data1 = "长时间处理。值1 ThreadName = " + Thread.currentThread().getName();
			data2 = "长时间处理。值2 ThreadName = " + Thread.currentThread().getName();
			
			System.out.println(data1);
			System.out.println(data2);
			System.out.println("end task...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class SynMethodDrawBackUtils {
	public static long beginT1, beginT2;
	public static long endT1, endT2;
}

class SynMethodDrawBackThreadA extends Thread{
	
	private SynMethodDrawBackTask task;
	public SynMethodDrawBackThreadA(SynMethodDrawBackTask task) {
		// TODO Auto-generated constructor stub
		this.task = task;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SynMethodDrawBackUtils.beginT1 = System.currentTimeMillis();
		task.doLongTimeTask();
		SynMethodDrawBackUtils.endT1 = System.currentTimeMillis();
	}
}

class SynMethodDrawBackThreadB extends Thread{
	
	private SynMethodDrawBackTask task;
	public SynMethodDrawBackThreadB(SynMethodDrawBackTask task) {
		// TODO Auto-generated constructor stub
		this.task = task;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SynMethodDrawBackUtils.beginT2 = System.currentTimeMillis();
		task.doLongTimeTask();
		SynMethodDrawBackUtils.endT2 = System.currentTimeMillis();
	}
}
