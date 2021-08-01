package no25.K个一组翻转链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode reverseK(ListNode head,ListNode next){
        ListNode p=next,temp;
        while(head!=next){
            temp=head.next;
            head.next=p;
            p=head;
            head=temp;
        }
        return p;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result=head,mark=head,temp;
        if(k==1) return head;
        for(int i=1;head!=null;i++){
            if(i%k==0){
                if(mark!=result){
                    temp=mark;
                    mark=mark.next;
                    temp.next=reverseK(temp.next,head.next);
                }
                else
                    result=reverseK(result,head.next);
                head=mark.next;
                continue;
            }
            head=head.next;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode ln1=new ListNode(1,new ListNode(2,
                new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode result=solution.reverseKGroup(ln1,2);
        while(result!=null){
            System.out.print(result.val+"\t");
            result=result.next;
        }
    }
}


