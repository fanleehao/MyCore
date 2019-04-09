package core_learning_4_class_and_object;

import java.io.IOException;


/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月11日 上午8:30:20 
 */
public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub;
		String string = "ABC";
		String string2 = string;
		Class aClass = string.getClass();
		Class bClass = string2.getClass();
		//Exception exception = new IOException();
		
		//System.out.println(aClass.equals(bClass));
		//System.out.println(string.equals(string2));
		
		//System.out.println(Class.forName("ClassTest"));   //报错
		Object obj = aClass.newInstance();
		//obj = "gg";
		System.out.println(obj.getClass());
	}

}
