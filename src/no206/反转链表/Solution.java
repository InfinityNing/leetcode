package no206.反转链表;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode t1=head.next,t2=head.next;
        while(head!=null){
            if(t1==t2){
                head.next=null;
            }else{
                t1.next=head;
                head=t1;
                t1=t2;
            }
            if(t2==null) break;
            else t2=t2.next;
        }
        return head;
    }
}
