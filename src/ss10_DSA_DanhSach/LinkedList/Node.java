package ss10_DSA_DanhSach.LinkedList;

public class Node {
    public Node next;
    private Object data;
    public Node(Object data) {
        this.data = data;
    }
    public Object getData() {
        return data;
    }
    public void setNext(Node newNext) {
        next = newNext;
    }
    public Node getNext() {
        return next;
    }
}
