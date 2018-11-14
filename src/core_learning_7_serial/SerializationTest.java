package core_learning_7_serial;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��14�� ����10:37:59 
 */
public class SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Test
	public void demo1(){
		A a = new A();
		a.i = 10;
		a.string = "Heel";
		FileInputStream filein = null;
		FileOutputStream fileout = null;
		
		try{
			//������д���ļ��������������������л�
			fileout = new FileOutputStream("temp");
			//����������ļ���
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileout);
			objectOutputStream.writeObject(a);
			fileout.close();
			
			//��ȡ
			filein = new FileInputStream("temp");
			//�Ӷ�������������ж�ȡ�������������л�
			ObjectInputStream objectInputStream = new ObjectInputStream(filein);
			A a2 = (A) objectInputStream.readObject();
			filein.close();
			
			System.out.println(a);
		} catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	
	
	@Test
	public void demo2() throws IOException, ClassNotFoundException{
		B b = new B();
		b.i = 20;
		b.string = "BBB";
		//��objд���ļ�
		FileOutputStream fileOutputStream = new FileOutputStream("temp2");
		ObjectOutputStream obj = new ObjectOutputStream(fileOutputStream);
		obj.writeObject(b);
		obj.close();
		fileOutputStream.close();
		
		//��ȡ
		FileInputStream fileInputStream = new FileInputStream("temp2");
		ObjectInputStream obj2 = new ObjectInputStream(fileInputStream);
		B b2 = (B) obj2.readObject();
		obj2.close();
		fileInputStream.close();
		
		
		//�����ΪB [i=0, string=null]
		System.out.println(b2);
	}
	
	

}

/**
 * 2018��11��14��
 * 1.ʹ��ʵ��Serializable�ӿ�������л�
 * 2.������ʹ��Externalizable�ӿ�
 * 3.����Externalizable�̳���Serializable���ýӿ��ж������������󷽷���writeExternal()��readExternal()��
 * ��ʹ��Externalizable�ӿ����������л��뷴���л���ʱ����Ҫ������Ա��дwriteExternal()��readExternal()������
 * ���û���������������ж������л�ʵ��ϸ�ڣ������������Ϊ��(����ֵΪĬ��)
 */
class A implements Serializable{
	int i;
	String string;
	@Override
	public String toString() {
		return "A [i=" + i + ", string=" + string + "]";
	}
}

class B implements Externalizable{
	
	int i;
	String string;
	//���뺬��һ��public���޲ι��캯��
	public B() {
		// TODO Auto-generated constructor stub
	}

	
	//д��˳��Ͷ�ȡ˳��Ҫһ�£����򱨴�
    //����д����ͬ���ͱ�����˳�򱣳�һ�¼��ɡ�
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		//��Ч
		//string = "BBBB";
		
		out.writeInt(88);
		out.writeChars(string);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		i = in.readInt();
		string = in.readLine();
		
	}

	@Override
	public String toString() {
		return "B [i=" + i + ", string=" + string + "]";
	}
	
}





