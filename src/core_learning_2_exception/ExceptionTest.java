package core_learning_2_exception;

import java.awt.image.RescaleOp;
import java.io.FileNotFoundException;
import java.io.IOException;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��10�� ����8:35:07 
 */
public class ExceptionTest {
	
	@SuppressWarnings("finally")
	int fun1() throws IOException{
		System.out.println("Ha");
//		Thread.sleep(3000);
		//throw new IOException();
		try {
			System.out.println("�Ŷ�");
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣");
			throw new IOException();    //������finally�е�returnʱ��catch���׳����쳣������
		}finally {
			System.out.println("12345");
			//return 1;
		}
	}
	/**
	 * ִ��˳������----����-----�жϣ���ת���쳣catch������match������ͬʱmatch����-------finally-----����
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		ExceptionTest test = new ExceptionTest();
		int res = 0;
		try {
			res = test.fun1();
			System.out.println();
		}catch(FileNotFoundException e){
			System.out.println("File");
		}catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("While catch the exception:" + res);
//			try {
//				throw new FileNotFoundException();
//			} catch (Exception e2) {
//				// TODO: handle exception
////				System.out.println("In inner catch..");
//			}finally {
//				System.out.println("In inner finally..");
//			}
		}finally {
			System.out.println("In finally...");
		}
	}

}

