package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/** 
 * @author fanleehao
 * @date 创建时间：2019年4月9日 下午3:28:47 
 * @desc 
 **/
public class TestAutomic {
	public static void main(String[] args) {
		AtomicInteger aInteger = new AtomicInteger(10);
		System.out.println(aInteger);
		System.out.println(aInteger.get());
		System.out.println(aInteger.incrementAndGet());
		
		AtomicLong aLong = new AtomicLong(100);
		System.out.println(aLong.incrementAndGet());
	}
}
