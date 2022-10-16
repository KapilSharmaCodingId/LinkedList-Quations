
/*
 You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space. 

The second line contains the integer value 'N'. It denotes the number of nodes to be moved from last to the front of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
0 <= N < M
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
2
1 2 3 4 5 -1
3
10 20 30 40 50 60 -1
5
Sample Output 1 :
3 4 5 1 2
20 30 40 50 60 10
Sample Input 2 :
1
10 6 77 90 61 67 100 -1
4
Sample Output 2 :
90 61 67 100 10 6 77 
 */
public class AppendLastNToFirst {
    

    public static int findlength(Node<Integer>head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		
        int len = findlength(head);
       int ans = len-n;
       if(head == null || head.next == null || n == 0){
        return head;
       }
       int count = 1;
       Node<Integer>temp = head;
       while(count != ans){
        temp = temp.next;
        count++;
       }
       Node<Integer>newhead = temp.next;
       temp.next = null;
       temp = newhead;
       while(temp.next != null){
        temp = temp.next;
       }
       temp.next = head;
       return newhead;
	}

}