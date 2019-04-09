package core_learning_1_callback;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018Äê11ÔÂ10ÈÕ ÏÂÎç7:29:57 
 */
public class Tom implements Student{
	@Override
	public void answer(Teacher teacher) {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(3000);
			System.out.println("Work Out");
			teacher.tellAnswer(122);
		} catch(InterruptedException exception) {
			exception.printStackTrace();
		}
	}
}
