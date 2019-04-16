package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月9日 下午4:44:55 
 * @desc 这种方法主要是适应单继承而生的，其实Thread的类也是实现
 *		 Runnable接口
 **/
public class MyThreadWithImplent implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("MyThreadWithImplent...");
	}

	public static void main(String[] args) {
		
		MyThreadWithImplent myThreadWithImplent = new MyThreadWithImplent();
		new Thread(myThreadWithImplent).start();
		System.out.println("调用结束。");
	}
}
