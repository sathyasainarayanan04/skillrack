class Solution {
    public int getDecimalValue(ListNode head) {
        String str = "";
        ListNode current = head;
        while(current!=null){
            str+=String.valueOf(current.val);
            current = current.next;
        }
        int decimal = Integer.parseInt(str,2);
        return decimal;
    }
}
