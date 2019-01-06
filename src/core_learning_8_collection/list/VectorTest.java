package core_learning_8_collection;

import java.util.Vector;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月14日 下午8:43:15 
 */
public class VectorTest {
	
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		vector.add(12);
		vector.addElement(48);
		//vector的绝大部分方法使用了synchronized修饰，线程安全
		//扩容可以指定定量，每次都一样；
		//否则每次扩容一倍
		System.out.println(vector);
	}
}
