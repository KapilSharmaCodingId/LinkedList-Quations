/*
 You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
 Output format :
For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
 */

public class PalindromeLinkedList {
    

    public static Node<Integer> reverse(Node<Integer> head) {
        //Your code goes here
            Node<Integer>current = head;
            Node<Integer>prev = null;
            while(current != null){
              Node<Integer>temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            return prev;
      }
  
      public static boolean isPalindrome(Node<Integer> head) {
          //Your code goes h
          if(head == null || head.next == null){
        return true;
      }
      Node<Integer>fast = head;
      Node<Integer>slow = head;
      while(fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
      }
      Node<Integer>secondhead = slow.next;
      slow.next = null;
      secondhead = reverse(secondhead);
      Node<Integer>firstSubList = secondhead;
      Node<Integer>secondSubList = head;
      while(firstSubList != null){
        if(firstSubList.data != secondSubList.data){
          return false;
        }
        firstSubList = firstSubList.next;
        secondSubList = secondSubList.next;
      }
      firstSubList = head;
      secondSubList = reverse(secondhead);
      while(firstSubList.next != null){
        firstSubList = firstSubList.next;
      }
      firstSubList.next = secondSubList;
      return true;
      }
}
