package ss10_DSA_DanhSach.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;
    public MyLinkedList() {

    }
    public void add(int index, E element){
        Node newNode = new Node(element);
        if(numNodes == 0 || head == null){
            head = newNode;
        }
        Node temp = head;
        int i = 0;
        while(i < index){
            temp = temp.getNext();
            i++;
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        numNodes++;
    }
    public void addFirst(E e){
        Node newNode = new Node(e);
        newNode.setNext(head);
        head = newNode;
        numNodes++;
    }
    public void addLast(E e){
        if(head == null){
            addFirst(e);
        }
        else{
            Node newNode = new Node(e);
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            numNodes++;
        }
    }
    public E remove(int index){
        Node bd = head;
        Node ba = head;
        if(index == 0){
            head = head.getNext();
            numNodes--;
            return (E)head.getData();
        }
        else{
            int i = 0;
            while(i < index-1){
                bd = bd.getNext();
                i++;
            }
            Node cur = bd.getNext();
            int j = 0;
            while(j < index+1){
                ba = ba.getNext();
                j++;
            }
            bd.setNext(ba);
            numNodes--;
            return (E)cur.getData();
        }
    }
    public boolean remove(Object e){
        Node temp = head;
        while(!temp.getNext().getData().equals(e)){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        numNodes--;
        return true;
    }
    public int size()  {
        return numNodes;
    }
    public boolean contains(E o) {
        Node temp = head;
        while(temp != null){
            if(temp.getData().equals(o)){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    public int indexOf(E o) {
        Node temp = head;
        int i = 0;
        while(i < numNodes){
            if(temp.getData().equals(o)){
                return i;
            }
            temp = temp.getNext();
            i++;
        }
        return -1;
    }
    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            cloneList.addLast((E) temp.getData());
            temp = temp.next;
        }
        return cloneList;
    }
    public boolean add(E e) {
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
            return true;
        }
        addLast(e);
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.getData());
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public E get(int i){
        Node temp = head;
        int j = 0;
        while(j < numNodes){
            temp = temp.getNext();
            j++;
            if(j == i){
                return (E) temp.getData();
            }
        }
        return null;
    }
    public E getFirst(){
        return (E) head.getData();
    }
    public E getLast(){
        Node temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        return (E)temp.getData();
    }
    public void clear(){
        head = null;
        numNodes = 0;
    }
}
