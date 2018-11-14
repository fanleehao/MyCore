package core_learning_7_serial;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月14日 下午4:33:59 
 */
public class ArrayListSerialization implements Serializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("aaa");
		arrayList.add("BBB");
		
		//序列化操作
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("temp"));
		objectOutputStream.writeObject(arrayList);
		objectOutputStream.close();
		
		//反序列化
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("temp"));
		ArrayList arrayList2 = (ArrayList) objectInputStream.readObject();
		System.out.println(arrayList2);
		
	}
}
