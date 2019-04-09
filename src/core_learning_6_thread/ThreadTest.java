package core_learning_6_thread;

import org.junit.Test;

import com.sun.accessibility.internal.resources.accessibility_ko;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��11�� ����11:15:33 
 */


public class ThreadTest {
	
	//�̳�thread
	@Test
	public void test1(){
		class A extends Thread{
			 @Override
	         public void run() {
	            System.out.println("A run..");
	         }
		}
		A a = new A();
		a.start();
	}
	//ʵ��Runable�ӿ�
	@Test
	public void test2(){
		class B implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("B run..");
			}
			
		}
		B b = new B();
		//Runableʵ������Ҫ��Thread���װ�����ִ��
        new Thread(b).start();
	}
	
	//�з���ֵ���߳�
    @Test
    public void test3() {
        Callable callable = new Callable() {
            int sum = 0;
            @Override
            public Object call() throws Exception {
                for (int i = 0;i < 5;i ++) {
                    sum += i;
                }
                return sum;
            }
        };
        //����Ҫ��FutureTask�������ܼ���Thread���췽��
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //�̳߳�ʵ��
    @Test
    public void test4() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //executeֱ��ִ���߳�
        executorService.execute(new Thread());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        });
        //submit�ύ�з��ؽ��������������󷵻ؽ����
        Future future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "a";
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();
        //�з���ֵ���߳��齫����ֵ�������
        for (int i = 0;i < 5;i ++ ) {
            final int finalI = i;
            Future future1 = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "res" + finalI;
                }
            });
            try {
                list.add((String) future1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
	
}






