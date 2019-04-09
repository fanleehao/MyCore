package core_learning_6_thread;

import org.junit.Test;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��11�� ����12:47:11 
 */
public class ThreadTest2 {
	//һ��ʼ�߳���init״̬������ʱ��terminated״̬
	class t implements Runnable {
	    private String name;
	    public t(String name) {
	        this.name = name;
	    }
	    @Override
	    public void run() {
	        System.out.println(name + " run...");
	    }
	}
	
	//����join�����߳������߳�����ʱ����waiting״̬
	@Test
	public void test1() throws InterruptedException {
	    Thread dad = new Thread(new Runnable() {
	        Thread son = new Thread(new t("son"));
	        @Override
	        public void run() {
	            System.out.println("dad init...");
	            son.start();
	            try {
	                //��֤���߳������������и��߳�
	                son.join();
	                System.out.println("dad run...");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    //����start���߳̽���runnable״̬���ȴ�ϵͳ����
	    dad.start();
	    //�ڸ��߳��ж����߳�ʵ��ʹ��join����֤���߳��ڸ��߳�֮ǰִ����

	}
	
	
	//����sleep
	@Test
	public void test2(){
	    Thread t1 = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("t1 run");
	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });

	    //���߳����ߡ�����time waiting״̬
	    try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    t1.start();
	}
	

	
	
	
	//�߳�2����blocked״̬��
	public static void main(String[] args) {
	    test4();
	    Thread.yield();//����runnable״̬
	}

	//����blocked״̬
	public static void test4() {
	    class A {
	        //�߳�1���ʵ�����Ժ��߳�2�޷����ʵ���������Խ���blocked״̬
	        synchronized void run() {
	            while (true) {
	            	
	                System.out.println("run");
	            }
	        }
	    }
	    final A a = new A();
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("t1 get lock");
	            a.run();
	        }
	    }).start();
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("t2 get lock");
	            a.run();
	        }
	    }).start();

	}
	
	
	//volatile��֤�߳̿ɼ���
	volatile static int flag = 1;
	//object��Ϊ�����������߳�ʹ��wait��notify����
	volatile static Object o = new Object();
	//����wait��notify
	//wait�����waiting״̬����notify����blocked�������ȴ����ͷţ�����runnable״̬����ȡ������
	public void test5() {
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	            //wait��notifyֻ����ͬ���������ʹ��
	            synchronized (o) {
	                while (true) {
	                    if (flag == 0) {
	                        try {
	                            Thread.sleep(2000);
	                            System.out.println("thread1 wait");
	                            //�ͷ������̹߳������object�ĵȴ����У�������������
	                            o.wait();
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                    System.out.println("thread1 run");
	                    System.out.println("notify t2");
	                    flag = 0;
	                    //֪ͨ�ȴ����е�һ���̻߳�ȡ��
	                    o.notify();
	                }
	            }
	        }
	    }).start();
	    //����ͬ��
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	            while (true) {
	                synchronized (o) {
	                    if (flag == 1) {
	                        try {
	                            Thread.sleep(2000);
	                            System.out.println("thread2 wait");
	                            o.wait();
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                    System.out.println("thread2 run");
	                    System.out.println("notify t1");
	                    flag = 1;
	                    o.notify();
	                }
	            }
	        }
	    }).start();
	}
	
}
