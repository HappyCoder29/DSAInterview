public class DoubleLinkList <T>{

    public Node<T> head;
    public Node<T> tail;
    public int size;

    public DoubleLinkList(){
        head = null;
        tail = null;
        size = 0;
    }
    public void add(T data){
        Node<T> addNode = new Node<>(data);
        addNode.next = head;
        head.prev = addNode;
        head = addNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }


}
