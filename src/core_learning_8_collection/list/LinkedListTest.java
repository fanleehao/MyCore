package core_learning_8_collection.list;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年12月26日 上午9:08:09 
 */
public class LinkedListTest {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(23);
		System.out.println(list);
		Queue<Integer> queue = new ArrayDeque<>();
	}
}
