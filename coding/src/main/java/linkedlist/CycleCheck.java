package linkedlist;

public class CycleCheck {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fastCurrent = head.next;
        ListNode slowCurrent = head;
        while(fastCurrent != null){
            if(fastCurrent == slowCurrent) {
                return true;
            }
            slowCurrent = slowCurrent.next;
            fastCurrent = fastCurrent.next;
            if(fastCurrent == null){
                 return false;
            }else{
               fastCurrent = fastCurrent.next ;
            }
        }

        return false;

    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == head) return head;
        ListNode fastCurrent = head;
        ListNode slowCurrent = head;
        boolean fastIncrement = true;
        boolean firstPass = true;
        while(fastCurrent != null){
            if(!firstPass && fastCurrent == slowCurrent) {
                if(fastIncrement){
                fastIncrement =  false;
                slowCurrent = head;
                }else{
                    return fastCurrent;
                }
            }else{
                slowCurrent = slowCurrent.next;
                fastCurrent = fastCurrent.next;
            }

            firstPass = false;

            if(fastCurrent == null){
                 return null;
            }else{
               if(fastIncrement)fastCurrent = fastCurrent.next ;
            }
        }

        return null;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
