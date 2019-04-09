package core_learning_5_reflection;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月11日 上午10:16:11 
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
//				// 打印出了UserBean.java的所有方法以及父类的方法
//			}
			System.out.println("------独占方法------");

			for (Method method : c.getDeclaredMethods()) {
				// String name = method.getName();
				// System.out.println(name);
				//if (method.isAnnotationPresent(Invoke.class)) { // 判断是否被 @Invoke修饰
					
					if (Modifier.isStatic(method.getModifiers())) {
						// 如果是 static方法
						// 反射调用该方法
						// 类方法可以直接调用，不必先实例化
						System.out.println("HHHHH");
						method.invoke(null, "Helllo", 2);
					} else {
						// 如果不是类方法，需要先获得一个实例再调用方法
						// 传入构造方法需要的变量类型
						Class[] params = { String.class, long.class };
						// 获取该类指定类型的构造方法
						// 如果没有这种类型的方法会报错
						Constructor constructor = UserBean.class.getDeclaredConstructor(params); // 获取参数格式为 String,long
						// 通过构造方法的实例来进行实例化
						Object userBean = constructor.newInstance("wingjay", 11); // 利用构造函数进行实例化，得到
																				// Object
						if (Modifier.isPrivate(method.getModifiers())) {
							method.setAccessible(true); // 如果是 private 的方法，需要获取其调用权限
							// 通过该方法可以设置其可见或者不可见，不仅可以用于方法
						}					
						method.invoke(userBean); // 调用 method，无须参数	
					}
				}
			//}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
