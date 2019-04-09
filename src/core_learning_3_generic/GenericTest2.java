package core_learning_3_generic;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月10日 下午10:19:26 
 */
public class GenericTest2 {
	public static void main(String[] args) {
		Box<Integer> box1 = new Box(123);
		Box<Double> box2 = new Box(12.5);
		//System.out.println(box2.getT());
		
		Box<String> box3 = new Box("Hello");
		List<Box> list = new ArrayList();
		list.add(box1);
		list.add(box2);
		list.add(box3);
		//list.add(123);    List加入<Box>后会出错
		
		for(int i = 0; i< list.size(); i++){
			Box<?> box = (Box<?>) list.get(i);
			System.out.println(box.getClass());
			System.out.println(box.getT());
		}


		//getUpperNumberData(box3);// 1 不符合边界
        getUpperNumberData(box1);    // 2
        getUpperNumberData(box2); // 3
		
	}
	public static void getData(Box<?> data) {
        System.out.println("data :" + data.getT());
    }
    
	//向下兼容，即为通配符的边界，extends换成super则为上界
    public static void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data :" + data.getT());
    } 
}

class Box<T>{
	private T t;
	public Box() {
		// TODO Auto-generated constructor stub
	}
	public Box(T t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}
	public T getT() {
		return t;
	}
}