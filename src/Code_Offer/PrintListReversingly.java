package Code_Offer;

import java.util.ArrayList;
import java.util.Stack;

/** 
 * @author fanleehao
 * @date 创建时间：2019年2月27日 下午7:25:15 
 * @desc 
 **/

/**
 * public class ListNode { 
 * 		int val; ListNode next = null;
 * 		ListNode(int val) { this.val = val; } 
 * }
 */
public class PrintListReversingly {
	
	/**
	 * 迭代式，非递归
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        
        /*while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }         
        Collections.reverse(list);        //使用Collections的reverse方法，直接将list反转
        return list;*/
        Stack<Integer> s = new Stack<>();
        while(listNode != null){
            s.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while(!s.empty()){
            arrayList.add(s.pop());
        }
        return arrayList;
    }

	/**
	 * 递归式
	 * @param listNode
	 */
	public void solveRecursively(ListNode listNode){
		//ArrayList<Integer> list = new ArrayList<>();
		if (listNode != null) {
			if(listNode.next != null){
				solveRecursively(listNode.next);
			}
			System.out.println(listNode.val);
		}
		return;
	}

}
