package core_learning_2_exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��10�� ����9:12:19 
 */
public class Thread_Exception {
	@Test
	public void test(){
		go();
	}
	
	public void go() {
		//����3���߳�
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		//ִ��
		for (int i = 0; i < 3; i++) {
			int count = i;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			executorService.execute(new Runnable() {
				//ÿ���߳��׳��쳣ʱ�������໥Ӱ��
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					try {
						System.out.println("Start thread " + count);
						throw new Exception();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						System.out.println("In thread " + count + ":Wrong");
					}
				}
			});
		}
	}
}
