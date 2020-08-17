/* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself. */

/* CODE */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head = new ListNode(0);             //creating head of linked list
        ListNode l3 = dummy_head;                          // making our new linked list l3 point to null or 0
        
        int carry = 0;                                     //carry check
        while (l1!=null || l2!=null){                      //check if end of linked list is not reached
            int l1_val = (l1!=null) ? l1.val : 0;          //take l1 value
            int l2_val = (l2!=null) ? l2.val : 0;          //take l2 value
            
            int sum = l1_val+l2_val+carry;                //get the sum of respective digits as well as carry
            carry = sum/10;                               //to get the digit to be carried over to next node
            int last_digit = sum%10;                      //to get our digit to be appended to l3 as sum result
                                                          //Previous step needed due to carry check
            
            
            ListNode new_node = new ListNode(last_digit);  //Creating node with the last_digit as it is now our final output to be chained to l3
            l3.next = new_node;                            //making our linked list l3 point to result node after each sum calculation
            
            if (l1!=null) l1 = l1.next;                    //Traversing l1
            if (l2!=null) l2 = l2.next;                    //traversing l2
            l3 = l3.next;                                  //Making l3 point to current node so that the next entry can be chained or appended to it
        }
        
        if(carry>0){
            
            ListNode new_node = new ListNode(carry);     //check for carry after last step
            l3.next = new_node;
            l3 = l3.next;
        }
        
       return dummy_head.next; 
    }
}
 
 
