package core_learning_1_callback;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月10日 下午5:34:19 
 */
public class Teacher implements Callback{
	private Student student;
	
	public Teacher(Student student) {
		// TODO Auto-generated constructor stub
		this.student = student;
	}
	
	void ask(Teacher teacher, Student student){
		new Thread(new Runnable() {
			public void run() {
				student.answer(teacher);
			}
		}).start();
		for (int i = 0; i < 4; i++) {
			System.out.println("等学生回答问题的时候老师玩了 " + i + "秒的手机");
		}
	}
	
	@Override
	public void tellAnswer(int res) {
		// TODO Auto-generated method stub
		System.out.println("The answer is:" + res);
	}
}

