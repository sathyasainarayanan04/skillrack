class Solution {
    public ListNode findNthNode(ListNode head, int k){
        ListNode temp = head;
        for(int index=0;index<k;index++){
           temp = temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next!=null){
            length++;
            tail = tail.next;
        }
        if(k % length == 0)return head;
        k = k % length;
        tail.next = head;
        ListNode newLastNode = findNthNode(head,length-k-1);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }
}
