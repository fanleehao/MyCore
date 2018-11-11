package core_learning_5_reflection;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��11�� ����10:16:11 
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException{
		// Class<?> class1 = String.class;
		//
		// Constructor constructor = class1.getConstructor(class1.getClass());

		try {
			Class c = Class.forName("core_learning_5_reflection.UserBean");
//			for (Field field : c.getDeclaredFields()) {
//				// field.setAccessible(true);
//				//System.out.println(field);
//			}
//
//			for (Method method : c.getMethods()) {
//				// String name = method.getName();
//				// System.out.println(name);
//				// ��ӡ����UserBean.java�����з����Լ�����ķ���
//			}
			System.out.println("------��ռ����------");

			for (Method method : c.getDeclaredMethods()) {
				// String name = method.getName();
				// System.out.println(name);
				//if (method.isAnnotationPresent(Invoke.class)) { // �ж��Ƿ� @Invoke����
					
					if (Modifier.isStatic(method.getModifiers())) {
						// ����� static����
						// ������ø÷���
						// �෽������ֱ�ӵ��ã�������ʵ����
						System.out.println("HHHHH");
						method.invoke(null, "Helllo", 2);
					} else {
						// ��������෽������Ҫ�Ȼ��һ��ʵ���ٵ��÷���
						// ���빹�췽����Ҫ�ı�������
						Class[] params = { String.class, long.class };
						// ��ȡ����ָ�����͵Ĺ��췽��
						// ���û���������͵ķ����ᱨ��
						Constructor constructor = UserBean.class.getDeclaredConstructor(params); // ��ȡ������ʽΪ String,long
						// ͨ�����췽����ʵ��������ʵ����
						Object userBean = constructor.newInstance("wingjay", 11); // ���ù��캯������ʵ�������õ�
																				// Object
						if (Modifier.isPrivate(method.getModifiers())) {
							method.setAccessible(true); // ����� private �ķ�������Ҫ��ȡ�����Ȩ��
							// ͨ���÷�������������ɼ����߲��ɼ��������������ڷ���
						}					
						method.invoke(userBean); // ���� method���������	
					}
				}
			//}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
