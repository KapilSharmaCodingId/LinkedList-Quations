public class ReverseUsingRecursivelyLL {
   
    public static Node<Integer> reverseLLR(Node<Integer>head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer>tail = head.next;
        Node<Integer>smallHead = reverseLLR(head.next);
        tail.next = head;
        head.next = null;

        return smallHead;
    }
}
