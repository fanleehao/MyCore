package core_learning_3_generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月10日 下午9:37:56 
 */
public class GenericTest {
	
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList();
		List<Integer> integers = new ArrayList<>();
//		arrayList.add("aaaaa");
//		arrayList.add(100);
		
		Class arr = arrayList.getClass();
		Class inte = integers.getClass();
		
//		System.out.println(arr);
//		System.out.println(inte);
		

//		for (int i = 0; i < arrayList.size(); i++) {
//			String item = (String) arrayList.get(i);
//			System.out.println(item);
//		}
	}
	@Test
	public void run(){
//		A<Integer, String> a = new A(1);
//		a.test();
//		a.test2(2, "hello");
		printMsg1("aa","bb");
		printMsg2("aa", 235, "ccc");
	}
	
	public void printMsg1(String... msg) {
		for(String str: msg){
			System.out.println(str);
		}
	}
	
	public <T> void printMsg2(T... msg) {
		for(T t:msg){
			System.out.println(t);
		}
	}
	
	
	
}

class A <T, E>{
	//private static T var; 报错，静态变量只和类有关
	private T t;
	{
		//静态构造块
		T t1;
	}
	A(T t){
		this.t = t;
	}
	public void test() {
		System.out.println(this.t);
	}
	public void test2(T t, E e) {
		System.out.println(t);
		System.out.println(e);
	}
	
	
}










