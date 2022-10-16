import java.util.prefs.NodeChangeListener;

public class insertRecursive {
    
    public static Node<Integer> insert(Node<Integer>head,int pos,int elem){
        if(pos == 0){
            Node<Integer>newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }

        if(head == null){
            return head;
        }
        head.next = insert(head.next,pos-1,elem);
        return head;
    }
}
