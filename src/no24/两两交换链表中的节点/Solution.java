package no24.两两交换链表中的节点;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode swap(ListNode ln){
        ListNode temp=ln.next;
        if(temp==null) return ln;
        ln.next=temp.next;
        temp.next=ln;
        return temp;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode result = null,temp = null;
        for(int i=0;head!=null;i++){
            if(i==0) result=swap(head);
            else temp.next=swap(head);
            temp=head;
            head=head.next;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode ln1=new ListNode(1,new ListNode(2,
                new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode ln2=new ListNode(1);
        ListNode ln3=new ListNode();
        ListNode result=solution.swapPairs(ln1);
        while(result!=null){
            System.out.print(result.val+"\t");
            result=result.next;
        }
    }
}


