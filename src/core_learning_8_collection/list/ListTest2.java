package core_learning_8_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月14日 下午5:50:23 
 */
public class ListTest {
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList<>(100);
		//线程不同步
		//同步操作，可以
		List arrayList2 = (List) Collections.synchronizedList(new ArrayList());
		arrayList2.add(123);
		System.out.println(arrayList2);
		//添加元素时，首先判断索引是否合法，然后检测是否需要扩容，
		//先使用Arrays.copyOf,最后使用System.arraycopy方法来完成数组的复制
		arrayList.add(1);
		arrayList.add(2);
		//原数据向后移动
		arrayList.add(0, 10);
		arrayList.get(0);
		
		//ArrayList的默认容量，会随着扩容动态向新数组拷贝，可以预估的话，最好先给一个容量大小
		System.out.println(arrayList);
		int a = 10;
		
		
		
		
		//clear就是将所有元素置为null,等待GC收集垃圾
		arrayList.clear();
		
	}
}
