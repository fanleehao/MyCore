package core_learning_8_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��14�� ����5:50:23 
 */
public class ListTest {
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList<>(100);
		//�̲߳�ͬ��
		//ͬ������������
		List arrayList2 = (List) Collections.synchronizedList(new ArrayList());
		arrayList2.add(123);
		System.out.println(arrayList2);
		//���Ԫ��ʱ�������ж������Ƿ�Ϸ���Ȼ�����Ƿ���Ҫ���ݣ�
		//��ʹ��Arrays.copyOf,���ʹ��System.arraycopy�������������ĸ���
		arrayList.add(1);
		arrayList.add(2);
		//ԭ��������ƶ�
		arrayList.add(0, 10);
		arrayList.get(0);
		
		//ArrayList��Ĭ�����������������ݶ�̬�������鿽��������Ԥ���Ļ�������ȸ�һ��������С
		System.out.println(arrayList);
		int a = 10;
		
		
		
		
		//clear���ǽ�����Ԫ����Ϊnull,�ȴ�GC�ռ�����
		arrayList.clear();
		
	}
}
