/*
 For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 4 5 2 -1
Sample Output 1 :
1 5 4 2 
Sample Input 2 :
2
1 11 3 6 8 0 9 -1
10 20 30 40 -1
Sample Output 2 :
1 11 3 9 6 8 0
10 20 30 40
 */

import java.util.Scanner;

class Node<t>{
    t data;
    Node<t> next;
    Node(t data){
        this.data = data;
        next = null;
    }
}

public class EvenAfterOddLinkedList{


    public static Node<Integer> takeinput(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data for Linklist = ");
        int data = s.nextInt();
        Node<Integer>head = null,tail = null;
        while(data != -1){
            Node<Integer>newhead = new Node<>(data);
            if(head == null){
                head = newhead;
                tail = newhead;
            }
            else{
               tail.next = newhead;
               tail = newhead;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static Node<Integer> EvenOddLinkedList(Node<Integer>head){
        Node<Integer>evenHead = null , evenTail = null;
        Node<Integer>oddHead = null , oddTail = null;

        while(head != null){
            if(head.data%2 == 0){
               if(evenHead == null && evenTail == null){
                evenHead = head;
                evenTail = head;
               }else{
                evenTail.next = head;
                evenTail = head;
               }
            }else{
                if(oddHead == null && oddTail == null){
                    oddHead = head;
                    oddTail = head; 
                }else{
                    oddTail.next = head;
                    oddTail = head;
                }
            }
            head = head.next;
        }
        
        if(head == null && evenHead != null){
            evenTail.next = null;
        }
        if(head == null && oddHead != null){
            oddTail.next = null;
        }
    
        if(evenHead == null){
            return oddHead;
        }else{
            if(oddHead == null){
                return evenHead;
            }else{

                oddTail.next = evenHead;
                return oddHead;
            }
        }
        
    }
    public static void print(Node<Integer>head){
        while(head != null){
            System.out.println(head.data+" ");
            head = head.next;
        }
    }


    public static void main(String[] args) {
        Node<Integer>head = takeinput();
        Node<Integer>ans = EvenOddLinkedList(head);
        print(ans);
    }

}
