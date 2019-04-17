package concurrent.cp2;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午10:59:55 
 * @desc synchronized锁重入
 *       重入锁：可以在继承关系中运用
 **/
public class SynLockIn2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynLockIn2Thread synLockIn2Thread = new SynLockIn2Thread();
		synLockIn2Thread.start();
	}

}

class Father{
	public int n = 10;
	synchronized public void methodInFather(){
		try{
			n--;
			System.out.println("Father.. n = " + n);
			Thread.sleep(100);
		}catch(Exception e){
			
		}
	}
}

class Son extends Father {
	synchronized public void methodInSon(){
		try {
			while (n > 0) {
				n--;
				System.out.println("Son.. n = " + n);
				Thread.sleep(100);
				this.methodInFather();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


class SynLockIn2Thread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Son son = new Son();
		son.methodInSon();
	}
}