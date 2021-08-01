package no2.两数相加;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean over10=false;
        int temp;
        ListNode result=new ListNode(),p=result;
        while(l1!=null||l2!=null||over10){
            temp=0;
            if(l1!=null) {
                temp+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                temp+=l2.val;
                l2=l2.next;
            }
            if(over10) {
                temp++;
                over10=false;
            }

            if(temp>9) {
                over10=true;
                temp-=10;
            }
            p.val=temp;
            if(l1!=null||l2!=null||over10) p=p.next=new ListNode();
        }
        return result;
    }
    public static ListNode build(int num[]){
        ListNode head=new ListNode(),p=head;
        for(int i=0;i<num.length;i++){
            p.val=num[i];
            if(i<num.length-1)p=p.next=new ListNode();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1=build(new int[]{9,9,9,9,9,9,9});
        ListNode l2=build(new int[]{9,9,9,9});
        Solution solution=new Solution();
        ListNode ln=solution.addTwoNumbers(l1,l2);
        while(ln!=null){
            System.out.println(ln.val);
            ln=ln.next;
        }
    }
}
