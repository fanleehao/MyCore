package core_learning_4_class_and_object;

import com.sun.xml.internal.bind.v2.runtime.Name;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月11日 上午9:27:21 
 */
public class ObjectTest implements Cloneable{
	
	public String Name = "xu";
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object a = new Object();
		//“不同包中的子类可以访问”，是指当两个类不在同一个包中的时候，继承自父类的子类内部且主调（调用者）为子类的引用时才能访问父类用protected修饰的成员（属性/方法）。
		//在子类内部，主调为父类的引用时并不能访问此protected修饰的成员。！（super关键字除外）
		//Object b = a.super.clone();//  错误
		
		ObjectTest aTest = new ObjectTest();
		System.out.println(aTest.Name);
		ObjectTest bTest = (ObjectTest) aTest.clone();
		bTest.Name = "Fan";
		System.out.println(aTest.Name);
		System.out.println(bTest.Name);
		
		String aString = new String("AB");
		String bString = "AB";
		//String bString = aString.clone()
		System.out.println(aString.hashCode() + bString.hashCode());
		String cString = new String("AB");
		System.out.println(cString.hashCode());
		
	}

}
