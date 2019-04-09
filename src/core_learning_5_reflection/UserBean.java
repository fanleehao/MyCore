package core_learning_5_reflection;
/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月11日 上午10:35:50 
 */
public class UserBean extends PersonBean implements User{

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	class B{
		
	}
	public String userName;
    protected int i;
    static int j;
    private int l;
    private long userId;
    public UserBean(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }
    public String getName() {
        return userName;
    }
    public long getId() {
        return userId;
    }
    @Invoke
    public static void staticMethod(String devName,int a) {
        System.out.printf("Hi %s, I'm a static method", devName);
    }
    @Invoke
    public void publicMethod() {
        System.out.println("I'm a public method");
    }
    @Invoke
    private void privateMethod() {
        System.out.println("I'm a private method");
    }
}




interface User{
	public void login();
}