package core_learning_2_exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��10�� ����8:53:18 
 */
public class Father {
	void fun1() throws IOException{
		System.out.println("Father");
		throw new IOException();
	}
	public static void main(String[] args) {
		Father[] peo = new Father[2];
		peo[0] = new Father();
		peo[1] = new Son();
		
		for(Father i: peo){
			try {
				i.fun1();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Son extends Father{
	@Override
	void fun1() throws IOException {
		// TODO Auto-generated method stub
		super.fun1();
		//�ᷢ��������������׳�ͬ���������쳣
		//��������main�еĶ�̬���޷�ʵ��
		//throw new SQLException();
		throw new FileNotFoundException();
	}
}