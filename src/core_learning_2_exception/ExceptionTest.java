package core_learning_2_exception;

import java.awt.image.RescaleOp;
import java.io.FileNotFoundException;
import java.io.IOException;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月10日 下午8:35:07 
 */
public class ExceptionTest {
	
	@SuppressWarnings("finally")
	int fun1() throws IOException{
		System.out.println("Ha");
//		Thread.sleep(3000);
		//throw new IOException();
		try {
			System.out.println("嗯额");
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("处理异常");
			throw new IOException();    //当出现finally中的return时，catch中抛出的异常将无用
		}finally {
			System.out.println("12345");
			//return 1;
		}
	}
	/**
	 * 执行顺序：正常----出错-----中断，跳转至异常catch，按序match，子类同时match父类-------finally-----结束
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

