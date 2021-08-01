package no19.删除链表的倒数第N个节点;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head,mark=head;
        int i;
        for(i=0;mark!=null;i++){
            if(i>n) temp=temp.next;
            mark=mark.next;
        }
        if(i==n) head=head.next;
        else temp.next=temp.next.next;
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode ln=new ListNode(1,new ListNode(2,
                new ListNode(3,new ListNode(4,new ListNode(5)))));
        ln=solution.removeNthFromEnd(ln,5);
        while(ln!=null){
            System.out.print(ln.val+"\t");
            ln=ln.next;
        }
    }
}


