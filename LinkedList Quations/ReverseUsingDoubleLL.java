class DoubleNode{
    Node<Integer> head;
    Node<Integer> tail;
}
public class ReverseUsingDoubleLL {
    
    public static DoubleNode reversDoubleNode(Node<Integer>head){
        if(head == null || head.next == null){
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }

        DoubleNode smallAns = reversDoubleNode(head.next);
        smallAns.tail.next = head;
        head.next = null;

        // return smallAns;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
        
    }
}
