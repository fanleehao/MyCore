package core_learning;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018��11��10�� ����7:39:13 
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student tom = new Tom();
		Teacher teacher = new Teacher(tom);
		teacher.ask(teacher, tom);
		
	}

}
