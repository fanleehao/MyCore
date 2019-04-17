package concurrent.cp2;
/** 
 * @author fanleehao
 * @date 创建时间：2019年4月17日 上午11:39:37 
 * @desc 同步不具有继承性
 **/
public class SynNotExtends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynNotExtendsSon son = new SynNotExtendsSon();
		SynNotExtendsA a = new SynNotExtendsA(son);
		a.setName("A");
		a.start();
		
		SynNotExtendsB b = new SynNotExtendsB(son);
		b.setName("B");
		b.start();
		
	}

}


class SynNotExtendsA extends Thread{
	private SynNotExtendsSon son;
	public SynNotExtendsA(SynNotExtendsSon son) {
		// TODO Auto-generated constructor stub
		this.son =son;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		son.service();
	}
}

class SynNotExtendsB extends Thread{
	private SynNotExtendsSon son;
	public SynNotExtendsB(SynNotExtendsSon son) {
		// TODO Auto-generated constructor stub
		this.son =son;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		son.service();
	}
}

class SynNotExtendsFather{
	synchronized public void service(){
		try {
			System.out.println("Father.. 下一步：sleep begin ThreadName = " + Thread.currentThread().getName() + 
					" time = " + System.currentTimeMillis());			
			Thread.sleep(5000);
			System.out.println("Father.. 下一步：sleep end ThreadName = " + Thread.currentThread().getName() + 
					" time = " + System.currentTimeMillis());	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

/**
 * @author fanleehao
 * @desc 同步想要在子类中也实现，必须重新添加synchronized修饰，否则只能是异步调用
 * 2019年4月17日
 */
class SynNotExtendsSon extends SynNotExtendsFather{
	@Override
	synchronized public void service(){
//	public void service(){   
		try {
			System.out.println("Son.. 下一步：sleep begin ThreadName = " + Thread.currentThread().getName() + 
					" time = " + System.currentTimeMillis());			
			Thread.sleep(5000);
			System.out.println("Son.. 下一步：sleep end ThreadName = " + Thread.currentThread().getName() + 
					" time = " + System.currentTimeMillis());	
			
			super.service();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}