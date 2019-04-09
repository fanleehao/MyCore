package core_learning_8_collection.list;

import java.util.Vector;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��14�� ����8:43:15 
 */
public class VectorTest {
	
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		vector.add(12);
		vector.addElement(48);
		//vector�ľ��󲿷ַ���ʹ����synchronized���Σ��̰߳�ȫ
		//���ݿ���ָ��������ÿ�ζ�һ����
		//����ÿ������һ��
		System.out.println(vector);
	}
}
