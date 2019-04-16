package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月9日 下午4:35:10 
 * @desc 
 **/
public class MyThreadWithExtend extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("MyThreadWithExtend...");
	}
	
	public static void main(String[] args) {
		MyThreadWithExtend myThreadWithExtend = new MyThreadWithExtend();
		myThreadWithExtend.start();
		
		//多次调用start----异常：java.lang.IllegalThreadStateException
		//myThreadWithExtend.start();  
		
		
		System.out.println("调用结束");
		/**
		 * 运行结果：说明线程调用是异步的，并不一定遵循代码执行顺序
		 *  调用结束
		    MyThreadWithExtend...
		 */
	}
}
