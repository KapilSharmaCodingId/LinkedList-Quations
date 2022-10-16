/*
  Given a singly linked list of integers, sort it using 'Merge Sort.'
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 
 */

public class MergeSortInLL {
    
    public static Node<Integer> sort(Node<Integer>head1,Node<Integer>head2){

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
          return head1;
        }
        Node<Integer>t1 = head1;
        Node<Integer>t2 = head2;
        Node<Integer>newhead = null,tail = null ;
        
        
          if(head1.data <= head2.data){
            newhead = t1;
            tail = t1;
            t1 = t1.next;
          }else{
            newhead = t2;
            tail = t2;
            t2 = t2.next;
          }
    
          while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
    
              tail.next = t1;
              tail = t1;
              t1 = t1.next; 
            }else{
              tail.next = t2;
              tail = t2;
              t2 = t2.next;
    
            }
          }
          if(t1 != null){
            tail.next = t1;
          }else{
            tail.next = t2;
          }
    
          return newhead;
      }
        
        public static Node<Integer> mid(Node<Integer>head){
       if(head == null){
        return head;
       }
        Node<Integer>fast = head,slow = head;
        while(fast.next != null && fast.next.next != null){
          fast =fast.next.next;
          slow = slow.next;
        }
        return slow;
      }
    
        public static Node<Integer> mergeSort(Node<Integer> head) {
            //Your code goes here
             if(head == null || head.next == null){
          return head;
        }
         Node<Integer>mid = mid(head);
        Node<Integer>half1 = head;
        Node<Integer>half2 = mid.next;
        mid.next = null;
        half1 = mergeSort(half1);
        half2 = mergeSort(half2);
        Node<Integer>finalHead = sort(half1,half2);
        return finalHead;
        }
    
}
