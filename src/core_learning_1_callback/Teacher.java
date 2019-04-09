package core_learning_1_callback;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018??11??10?? ????5:34:19 
 */
public class Teacher implements Callback{
	private Student student;
	
	public Teacher(Student student) {
		// TODO Auto-generated constructor stub
		this.student = student;
	}
	
	void ask(final Teacher teacher, final Student student){
		new Thread(new Runnable() {
			public void run() {
				student.answer(teacher);
			}
		}).start();
		for (int i = 0; i < 4; i++) {
			System.out.println("??????????????????????? " + i + "??????");
		}
	}
	
	@Override
	public void tellAnswer(int res) {
		// TODO Auto-generated method stub
		System.out.println("The answer is:" + res);
	}
}

