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
 * @time   :2018年11月14日 上午10:37:59 
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
			//将对象写入文件————————序列化
			fileout = new FileOutputStream("temp");
			//输出到对象文件流
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileout);
			objectOutputStream.writeObject(a);
			fileout.close();
			
			//读取
			filein = new FileInputStream("temp");
			//从对象流输入对象中读取————反序列化
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
		//将obj写入文件
		FileOutputStream fileOutputStream = new FileOutputStream("temp2");
		ObjectOutputStream obj = new ObjectOutputStream(fileOutputStream);
		obj.writeObject(b);
		obj.close();
		fileOutputStream.close();
		
		//读取
		FileInputStream fileInputStream = new FileInputStream("temp2");
		ObjectInputStream obj2 = new ObjectInputStream(fileInputStream);
		B b2 = (B) obj2.readObject();
		obj2.close();
		fileInputStream.close();
		
		
		//结果将为B [i=0, string=null]
		System.out.println(b2);
	}
	
	

}

/**
 * 2018年11月14日
 * 1.使用实现Serializable接口完成序列化
 * 2.还可以使用Externalizable接口
 * 3.区别：Externalizable继承了Serializable，该接口中定义了两个抽象方法：writeExternal()与readExternal()。
 * 当使用Externalizable接口来进行序列化与反序列化的时候需要开发人员重写writeExternal()与readExternal()方法。
 * 如果没有在这两个方法中定义序列化实现细节，则输出的内容为空(属性值为默认)
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
	//必须含有一个public的无参构造函数
	public B() {
		// TODO Auto-generated constructor stub
	}

	
	//写入顺序和读取顺序要一致，否则报错。
    //可以写入多个同类型变量，顺序保持一致即可。
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		//无效
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





