package Swap_Nodes_in_Pairs;

/**
 * Created by Alay on 2016/6/11.
 */
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode r = null;

        if(p != null && p.next != null){
            r = p.next;
            p.next = r.next;
            r.next = p;
            head = r;
            p = p.next;
        }

        while(p != null && p.next != null){
            r = p.next;
            //交换后继节点
            p.next = r.next;
            r.next = p;
            //进行下次循环
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = null;
        head = swapPairs(head);
        System.out.println("123");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
