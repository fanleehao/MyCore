package concurrent.multiThread;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月9日 下午4:57:45 
 * @desc 非共享变量线程间的控制
 **/
public class ThreadWithUnshared extends Thread {
	
	private int count = 5;
	private String name;
	
	public ThreadWithUnshared(String name) {
		// TODO Auto-generated constructor stub
//		this.name = name;
		this.setName(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(count > 0){
			count --;
			System.out.println("由线程 " + Thread.currentThread().getName() + "计算 ,count = " + count);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadWithUnshared tUnsharedA = new ThreadWithUnshared("A");
		ThreadWithUnshared tUnsharedB = new ThreadWithUnshared("B");
		ThreadWithUnshared tUnsharedC = new ThreadWithUnshared("C");
		
		tUnsharedA.start();
		tUnsharedB.start();
		tUnsharedC.start();
		
		System.out.println("结束运行！");
		
	}

}
