package no23.合并K个升序链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp,temp2,result=l1;
        if(l1==null||l2==null)
            return l1==null?l2:l1;
        while(l1!=null&l2!=null){
            if(l1.val>l2.val){//只会出现在刚开始
                temp=l1;
                temp2=l2;
                l2=l2.next;
                l1=temp2;
                l1.next=temp;
                result=l1;
            }else if(l1.next==null||l1.next.val>l2.val){//l1<=l2且l1.next>l2
                temp=l2;
                l2=l2.next;
                temp.next=l1.next;
                l1.next=temp;
            }else
                l1=l1.next;
        }
        return result;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(ListNode ln:lists){
            result=mergeTwoLists(result,ln);
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode []lists={
                new ListNode(1,new ListNode(4,new ListNode(5))),
                new ListNode(1,new ListNode(3,new ListNode(4))),
                new ListNode(2,new ListNode(6))
        };
        ListNode result=solution.mergeKLists(lists);
        while(result!=null){
            System.out.print(result.val+"\t");
            result=result.next;
        }
    }
}


