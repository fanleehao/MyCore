package core_learning_4_class_and_object;

import com.sun.xml.internal.bind.v2.runtime.Name;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��11�� ����9:27:21 
 */
public class ObjectTest implements Cloneable{
	
	public String Name = "xu";
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object a = new Object();
		//����ͬ���е�������Է��ʡ�����ָ�������಻��ͬһ�����е�ʱ�򣬼̳��Ը���������ڲ��������������ߣ�Ϊ���������ʱ���ܷ��ʸ�����protected���εĳ�Ա������/��������
		//�������ڲ�������Ϊ���������ʱ�����ܷ��ʴ�protected���εĳ�Ա������super�ؼ��ֳ��⣩
		//Object b = a.super.clone();//  ����
		
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
