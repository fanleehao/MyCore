package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午10:37:04 
 * @desc 两个对象两个锁，由于操作不同资源，是异步进行的
 **/
public class TwoObjectTwoLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HasSelfPrivateNum obj1 = new HasSelfPrivateNum();
		HasSelfPrivateNum obj2 = new HasSelfPrivateNum();
		
		ThreadA threadA = new ThreadA(obj1);
		threadA.start();
		
		ThreadB threadB = new ThreadB(obj2);
		threadB.start();
	}

}
