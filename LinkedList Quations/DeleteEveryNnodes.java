/*
 You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.
To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains two integer values 'M,' and 'N,' respectively. A single space will separate them.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5 

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
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
public class DeleteEveryNnodes {

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
    public static void print(Node<Integer>head){
        while(head != null){
            System.out.println(head.data+" ");
            head = head.next;
        }
    }

    public static Node<Integer> deleteNodes(Node<Integer>head,int m,int n){
       if(m == 0 || head == null){
        return null;
       }
       if(n == 0){
        return head;
       }

       Node<Integer>currentNode = head;
       Node<Integer>temp = null;

       while(currentNode != null){
        int take = 0;
        int skip = 0;
        while(currentNode != null && take < m){

            if(temp == null){
                temp = currentNode;
            }else{
                temp.next = currentNode;
                temp = currentNode;
            }
            
            currentNode = currentNode.next;
            take++;
        }

        while(currentNode != null && skip < n){
            currentNode = currentNode.next;
            skip++;
        }
        }
        if(temp != null){
            temp.next = null;
        }
        return head;
       }
    
    public static void main(String[] args) {
        Node<Integer>head = takeinput();
        Node<Integer>ans = deleteNodes(head, 0, 1);
        print(ans);
    }
}
