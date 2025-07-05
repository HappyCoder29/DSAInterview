public class SingleLinkList <T>{
    public Node<T> head;
    public Node<T> tail;
    public int size;
    public SingleLinkList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data){
        Node<T> addNode = new Node<>(data);
        addNode.next = head;
        head = addNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }
    public void printList(){
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void printList(Node<T> node){
        Node<T> temp = node;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void addLast(T data){
        Node<T> addNode = new Node<>(data);
        if(tail == null){
            head = addNode;
            tail = addNode;
        }else{
            tail.next = addNode;
        }
        size++;
    }
    public boolean isEmpty(T data){
       return  head == null;
    }

    public T get(int index){
        if(index < 0 || head == null){
            return  null;
        }
        Node<T> temp = head;
        while( index  != 0){
            if(temp == null){
                return null;
            }
            temp = temp.next;
            index --;
        }
        return temp.data;
    }
    public boolean add(int index, T data){
        if(index < 0){
            return false;
        }
        Node<T> temp = head;
        while( index  != 1){
            if(temp == null){
                return false;
            }
            temp = temp.next;
            index --;
        }
        Node<T> addNode = new Node<>(data);
        addNode.next = temp.next;
        temp.next = addNode;
        size ++;
        return true;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public SingleLinkList<T> cloneList(){
        SingleLinkList<T> list = new SingleLinkList<>();
        if(head == null){
            return list;
        }
        list.head = new Node<>(head.data);
        Node<T> tempOld = head.next;
        Node<T> tempNew = list.head;
        while(tempOld != null){
            tempNew.next = tempOld.next;
            tempNew = tempNew.next;
            tempOld = tempOld.next;
        }
        list.tail = tempNew;
        list.size = size;
        return list;
    }
    public Node<T> getFirst(){
        return head;
    }
    public Node<T> getLast(){
        return tail;
    }

    public boolean set(int index, T data){
        if(index < 0){
            return false;
        }
        Node<T> temp = head;
        while( index  != 1){
            if(temp == null){
                return false;
            }
            temp = temp.next;
            index --;
        }
        temp.data = data;
        return true;
    }
    public void removeFirst(){
        if(head == null){
            return;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        temp = null;
        size --;
    }
    public void removeLast(){
        if(head == null || head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }
        Node<T> temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public boolean removeIndex(int index){
        if(index < 0){
            return false;
        }
        Node<T> temp = head;
        while( index  != 1){
            if(temp == null){
                return false;
            }
            temp = temp.next;
            index --;
        }
        Node<T> delete = temp.next;
        if(temp.next == tail){
            temp.next = null;
            tail = temp;
        }else{
            Node<T> delNode = temp.next;
            temp.next = delNode.next;
            delNode.next = null;
            delNode = null;
        }

        size --;
        return true;
    }

    public T[] toArray(){
        if(head == null){
            return (T[]) new Object[0];
        }
        T[] array = (T[]) new Object[size];
        Node<T> temp = head;
        int index = 0;
        while(temp != null){
            array[index] = temp.data;
            index ++;
            temp = temp.next;
        }
        return array;
    }

    public int indexOf(T data){
        if(head == null){
            return -1;
        }
        int index = 0;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public int LastIndexOf(T data){
        if(head == null){
            return -1;
        }
        int index = -1;
        int lastIndex = -1;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
               lastIndex = index;
            }
            index++;
            temp = temp.next;
        }
        return lastIndex;
    }
    public boolean contains(T data){
        if(head == null){
            return false;
        }
        int index = 0;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == data){
                return true;
            }
            index++;
            temp = temp.next;
        }
        return false;
    }

    public boolean remove(T data){
        if (head == null) {
            return false;
        }
        if(head == tail){
            if(head.data == data){
                head = null;
                tail = null;
                size = 0;
            }
            return true;
        }
        Node<T> temp = head;
        if(temp.data == data){
            temp = head.next;
            head.next = null;
            head = temp;
            return true;
        }
        while( temp.next != null){
            if(temp.next.data == data){
              break;
            }
            temp = temp.next;
        }
        Node<T> delete = temp.next;
        if(temp.next == tail){
            temp.next = null;
            tail = temp;
        }else{
            Node<T> delNode = temp.next;
            assert delNode != null;
            temp.next = delNode.next;
            delNode.next = null;
            delNode = null;
        }

        size --;
        return true;
    }
}
